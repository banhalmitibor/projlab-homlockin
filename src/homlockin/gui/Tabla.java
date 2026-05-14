package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 * A város grafikus megjelenítése.
 */
public class Tabla extends JFrame {
    private List<UtszakaszUI> szakaszok;
    private List<JarmuUI> jarmuvek;
    private StatuszPanel sp;
    private JatekosPanel jp;
    private JPanel térképPanel;
    private ActionListener listener;
    private Map<Utszakasz, UtszakaszUI> uiByLogic;

    public Tabla() {
        setTitle("Homlockin - Játékmező");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        szakaszok = new ArrayList<>();
        jarmuvek = new ArrayList<>();

        térképPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawConnections((Graphics2D) g);
            }
        };
        térképPanel.setBackground(new Color(144, 238, 144)); // Match the mockup green
        térképPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 3));
        uiByLogic = new HashMap<>();
        
        JScrollPane scrollPane = new JScrollPane(térképPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        sp = new StatuszPanel();
        sp.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(139, 69, 19)));
        add(sp, BorderLayout.EAST);

        jp = new JatekosPanel();
        jp.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, new Color(139, 69, 19)));
        add(jp, BorderLayout.SOUTH);
    }

    public void initPalya(ActionListener listener) {
        this.listener = listener;
        szakaszok.clear();
        jarmuvek.clear();
        uiByLogic.clear();
        térképPanel.removeAll();

        int cellSize = 80;
        int count = 0;
        Map<Utszakasz, Integer> levels = computeLevels();
        Map<Integer, List<Utszakasz>> grouped = new TreeMap<>();

        for (Utszakasz u : Main.utszakaszok.values()) {
            grouped.computeIfAbsent(levels.getOrDefault(u, 0), x -> new ArrayList<>()).add(u);
        }
        for (List<Utszakasz> group : grouped.values()) {
            group.sort(Comparator.comparing(Utszakasz::getName));
        }

        for (Map.Entry<Integer, List<Utszakasz>> entry : grouped.entrySet()) {
            int level = entry.getKey();
            List<Utszakasz> group = entry.getValue();
            int x = 40 + level * 170;
            int y = 40;
            for (Utszakasz u : group) {
            UtszakaszUI uUI;
            if (u instanceof Alagut) uUI = new AlagutUI((Alagut) u);
            else if (u instanceof Hid) uUI = new HidUI((Hid) u);
            else uUI = new UtszakaszUI(u);

            uUI.setBounds(x, y, cellSize, cellSize);
            uUI.setActionCommand("UTSZ_" + count);
            uUI.connectButtons(listener);
            szakaszok.add(uUI);
            uiByLogic.put(u, uUI);
            térképPanel.add(uUI);

                y += cellSize + 45;
                count++;
            }
        }
        int width = Math.max(1000, grouped.size() * 200 + 120);
        int maxRows = grouped.values().stream().mapToInt(List::size).max().orElse(1);
        int height = Math.max(700, maxRows * 130 + 120);
        térképPanel.setPreferredSize(new Dimension(width, height));
        sp.connectButtons(listener);
        térképPanel.revalidate();
        térképPanel.repaint();
    }

    public void frissit() {
        jarmuvek.clear();
        // Frissítjük a járműveket az útszakaszokon
        for (UtszakaszUI uUI : szakaszok) {
            uUI.removeAll();
            uUI.setJarmuRajta(null);
            Jarmu j = uUI.getLogic().getJarmu();
            if (j != null) {
                JarmuUI jUI = null;
                if (j instanceof Hokotro) jUI = new HokotroButton((Hokotro) j);
                else if (j instanceof Busz) jUI = new BuszButton((Busz) j);
                else if (j instanceof Auto) jUI = new AutoButton((Auto) j);

                if (jUI != null) {
                    jUI.setActionCommand("VBT_" + jarmuvek.size());
                    if (listener != null) jUI.connectButtons(listener);
                    jUI.setBounds(15, 15, 50, 50); // Belső pozíció az UtszakaszUI-ban
                    uUI.add(jUI);
                    uUI.setJarmuRajta(jUI);
                    jarmuvek.add(jUI);
                }
            }
            uUI.repaint();
        }
        sp.repaint();
        jp.repaint();
        repaint();
    }

    public void jatekVege() {
        JOptionPane.showMessageDialog(this, "A játéknak vége lett!");
    }

    public StatuszPanel getStatuszPanel() { return sp; }
    public JatekosPanel getJatekosPanel() { return jp; }
    public List<UtszakaszUI> getSzakaszok() { return szakaszok; }
    public List<JarmuUI> getJarmuvek() { return jarmuvek; }

    private Map<Utszakasz, Integer> computeLevels() {
        Map<Utszakasz, Integer> inDegree = new LinkedHashMap<>();
        Map<Utszakasz, Integer> level = new HashMap<>();
        Queue<Utszakasz> q = new ArrayDeque<>();

        for (Utszakasz u : Main.utszakaszok.values()) {
            inDegree.put(u, 0);
        }
        for (Utszakasz u : Main.utszakaszok.values()) {
            for (Utszakasz kov : u.getKovetkezok()) {
                inDegree.put(kov, inDegree.getOrDefault(kov, 0) + 1);
            }
        }

        for (Utszakasz u : Main.utszakaszok.values()) {
            if (inDegree.getOrDefault(u, 0) == 0) {
                level.put(u, 0);
                q.add(u);
            }
        }
        if (q.isEmpty() && !Main.utszakaszok.isEmpty()) {
            Utszakasz first = Main.utszakaszok.values().iterator().next();
            level.put(first, 0);
            q.add(first);
        }

        while (!q.isEmpty()) {
            Utszakasz cur = q.poll();
            int curLevel = level.getOrDefault(cur, 0);
            for (Utszakasz next : cur.getKovetkezok()) {
                int nextLevel = curLevel + 1;
                if (!level.containsKey(next) || level.get(next) < nextLevel) {
                    level.put(next, nextLevel);
                }
                inDegree.put(next, inDegree.getOrDefault(next, 0) - 1);
                if (inDegree.get(next) <= 0) {
                    q.add(next);
                }
            }
        }

        int maxLevel = level.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        for (Utszakasz u : Main.utszakaszok.values()) {
            if (!level.containsKey(u)) {
                maxLevel++;
                level.put(u, maxLevel);
            }
        }
        return level;
    }

    private void drawConnections(Graphics2D g2) {
        g2 = (Graphics2D) g2.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (UtszakaszUI fromUI : szakaszok) {
            Utszakasz from = fromUI.getLogic();
            for (Utszakasz to : from.getKovetkezok()) {
                UtszakaszUI toUI = uiByLogic.get(to);
                if (toUI != null) {
                    drawArrow(g2, fromUI, toUI, Color.BLACK);
                }
            }
            if (from.getJobbUt() != null) {
                UtszakaszUI toUI = uiByLogic.get(from.getJobbUt());
                if (toUI != null) {
                    drawArrow(g2, fromUI, toUI, new Color(139, 69, 19));
                }
            }
        }
        g2.dispose();
    }

    private void drawArrow(Graphics2D g2, UtszakaszUI from, UtszakaszUI to, Color color) {
        int x1 = from.getX() + from.getWidth() / 2;
        int y1 = from.getY() + from.getHeight() / 2;
        int x2 = to.getX() + to.getWidth() / 2;
        int y2 = to.getY() + to.getHeight() / 2;

        g2.setColor(color);
        g2.setStroke(new BasicStroke(2f));
        g2.drawLine(x1, y1, x2, y2);

        double angle = Math.atan2(y2 - y1, x2 - x1);
        int arrowLength = 12;
        int xArrow1 = (int) (x2 - arrowLength * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - arrowLength * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (x2 - arrowLength * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - arrowLength * Math.sin(angle + Math.PI / 6));

        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(x2, y2);
        arrowHead.addPoint(xArrow1, yArrow1);
        arrowHead.addPoint(xArrow2, yArrow2);
        g2.fillPolygon(arrowHead);
    }
}
