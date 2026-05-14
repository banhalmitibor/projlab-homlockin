package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A város grafikus megjelenítése.
 */
public class Tabla extends JFrame {
    private List<UtszakaszUI> szakaszok;
    private List<JarmuUI> jarmuvek;
    private StatuszPanel sp;
    private JatekosPanel jp;
    private JPanel térképPanel;

    public Tabla() {
        setTitle("Homlockin - Játékmező");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        szakaszok = new ArrayList<>();
        jarmuvek = new ArrayList<>();

        térképPanel = new JPanel(null);
        térképPanel.setBackground(new Color(144, 238, 144)); // Match the mockup green
        térképPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 3));
        
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
        szakaszok.clear();
        jarmuvek.clear();
        térképPanel.removeAll();

        int x = 20, y = 20;
        int cellSize = 80;
        int count = 0;

        for (Utszakasz u : Main.utszakaszok.values()) {
            UtszakaszUI uUI;
            if (u instanceof Alagut) uUI = new AlagutUI((Alagut) u);
            else if (u instanceof Hid) uUI = new HidUI((Hid) u);
            else uUI = new UtszakaszUI(u);

            uUI.setBounds(x, y, cellSize, cellSize);
            uUI.setActionCommand("UTSZ_" + count);
            uUI.connectButtons(listener);
            szakaszok.add(uUI);
            térképPanel.add(uUI);

            x += cellSize + 20;
            count++;
            if (count % 8 == 0) {
                x = 20;
                y += cellSize + 40;
            }
        }
        térképPanel.setPreferredSize(new Dimension(1000, y + 200));
        sp.connectButtons(listener);
    }

    public void frissit() {
        // Frissítjük a járműveket az útszakaszokon
        for (UtszakaszUI uUI : szakaszok) {
            uUI.setJarmuRajta(null);
            Jarmu j = uUI.getLogic().getJarmu();
            if (j != null) {
                JarmuUI jUI = null;
                if (j instanceof Hokotro) jUI = new HokotroButton((Hokotro) j);
                else if (j instanceof Busz) jUI = new BuszButton((Busz) j);
                else if (j instanceof Auto) jUI = new AutoButton((Auto) j);

                if (jUI != null) {
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
}
