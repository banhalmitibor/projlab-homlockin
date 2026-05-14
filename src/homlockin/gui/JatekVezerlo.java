package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

/**
 * A játék vezérléséért felelős osztály.
 */
public class JatekVezerlo implements ActionListener {
    private Varos v;
    private Tabla t;
    private Menu m;
    private Jatekos kivalasztottJatekos;
    private Jarmu kivalasztottJarmu;
    private Timer jatekTimer;
    private int tickSzamlalo;
    private int autoCounter;
    private int hokotroCounter;
    private final Random random = new Random();
    private String pendingHokotroNev;

    public JatekVezerlo() {
        this.v = Main.varos;
        this.m = new Menu();
        this.t = new Tabla();
        m.connectButtons(this);
        tickSzamlalo = 0;
        autoCounter = 1;
        hokotroCounter = 1;
    }

    public void start() {
        m.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.startsWith("VBT_")) {
            int jarmuIndex = Integer.parseInt(cmd.substring(4));
            jarmuMegnyomva(jarmuIndex);
        } else if (cmd.startsWith("JBT_")) {
            int jatekosIndex = Integer.parseInt(cmd.substring(4));
            jatekosMegnyomva(jatekosIndex);
        } else if (cmd.equals("HKBBT")) {
            hokotroVasarlasMegnyomva();
        } else if (cmd.equals("BKBT")) {
            biokerozinVasarlasMegnyomva();
        } else if (cmd.equals("SBT")) {
            soVasarlasMegnyomva();
        } else if (cmd.equals("ZBT")) {
            zuzalekVasarlasMegnyomva();
        } else if (cmd.equals("FBBT_hanyo")) {
            hanyofejVasarlasMegnyomva();
        } else if (cmd.equals("FBBT_sopro")) {
            soprofejVasarlasMegnyomva();
        } else if (cmd.equals("FBBT_jegtoro")) {
            jegtorofejVasarlasMegnyomva();
        } else if (cmd.equals("FBBT_soszoro")) {
            soszorofejVasarlasMegnyomva();
        } else if (cmd.equals("FBBT_sarkany")) {
            sarkanyfejVasarlasMegnyomva();
        } else if (cmd.equals("UJBT")) {
            ujJatekMegnyomva();
        } else if (cmd.equals("LBBT")) {
            ranglistaMegnyomva();
        } else if (cmd.startsWith("UTSZ_")) {
            int utszakaszIndex = Integer.parseInt(cmd.substring(5));
            utszakaszMegnyomva(utszakaszIndex);
        }
    }

    private void jarmuMegnyomva(int jarmuIndex) {
        List<JarmuUI> displayed = t.getJarmuvek();
        if (jarmuIndex < 0 || jarmuIndex >= displayed.size()) return;
        JarmuUI selected = displayed.get(jarmuIndex);
        if (selected instanceof HokotroButton) {
            kivalasztottJarmu = ((HokotroButton) selected).getLogic();
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
            updatePenz();
        } else if (selected instanceof BuszButton) {
            kivalasztottJarmu = ((BuszButton) selected).getLogic();
            t.getStatuszPanel().update(null);
        } else if (selected instanceof AutoButton) {
            kivalasztottJarmu = ((AutoButton) selected).getLogic();
            t.getStatuszPanel().update(null);
        }
    }

    private void jatekosMegnyomva(int jatekosIndex) {
        List<Jatekos> jList = new ArrayList<>(Main.jatekosok.values());
        if (jatekosIndex < jList.size()) {
            kivalasztottJatekos = jList.get(jatekosIndex);
            t.getJatekosPanel().highlightJatekos(jatekosIndex);
            updatePenz();
            if (kivalasztottJatekos instanceof TakaritoJatekos) {
                List<Hokotro> hokotrok = ((TakaritoJatekos) kivalasztottJatekos).getHokotroi();
                if (!hokotrok.isEmpty()) {
                    kivalasztottJarmu = hokotrok.get(0);
                    t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
                } else {
                    kivalasztottJarmu = null;
                    t.getStatuszPanel().update(null);
                }
            } else if (kivalasztottJatekos instanceof BuszvezetoJatekos) {
                kivalasztottJarmu = ((BuszvezetoJatekos) kivalasztottJatekos).getVezeti();
                t.getStatuszPanel().update(null);
            }
        }
    }

    private void hokotroVasarlasMegnyomva() {
        if (kivalasztottJatekos instanceof TakaritoJatekos) {
            String name = JOptionPane.showInputDialog(t, "Hókotró neve:", "hk" + hokotroCounter);
            if (name != null) {
                pendingHokotroNev = name.trim();
                if (!pendingHokotroNev.isEmpty()) {
                    JOptionPane.showMessageDialog(t, "Válassz ki egy útszakaszt, ahova le szeretnéd rakni az új hókotrót.");
                    hokotroCounter++;
                }
            }
        }
    }

    private void biokerozinVasarlasMegnyomva() {
        if (kivalasztottJarmu instanceof Hokotro) {
            setBoltVasarlo();
            Main.bolt.biokerozinVasarol((Hokotro) kivalasztottJarmu);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
            updatePenz();
        }
    }

    private void soVasarlasMegnyomva() {
        if (kivalasztottJarmu instanceof Hokotro) {
            setBoltVasarlo();
            Main.bolt.sotVasarol((Hokotro) kivalasztottJarmu);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
            updatePenz();
        }
    }

    private void zuzalekVasarlasMegnyomva() {
        if (kivalasztottJarmu instanceof Hokotro) {
            setBoltVasarlo();
            Main.bolt.zuzalekotVasarol((Hokotro) kivalasztottJarmu);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
            updatePenz();
        }
    }

    private void hanyofejVasarlasMegnyomva() { buyFej(new Hanyofej()); }
    private void soprofejVasarlasMegnyomva() { buyFej(new Soprofej()); }
    private void jegtorofejVasarlasMegnyomva() { buyFej(new Jegtorofej()); }
    private void soszorofejVasarlasMegnyomva() { buyFej(new Soszorofej()); }
    private void sarkanyfejVasarlasMegnyomva() { buyFej(new Sarkanyfej()); }

    private void buyFej(HokotroFej fej) {
        if (kivalasztottJarmu instanceof Hokotro) {
            setBoltVasarlo();
            Main.bolt.hokotroFejetVasarol((Hokotro) kivalasztottJarmu, fej);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
            updatePenz();
        }
    }

    private void utszakaszMegnyomva(int index) {
        if (index < 0 || index >= t.getSzakaszok().size()) return;
        Utszakasz target = t.getSzakaszok().get(index).getLogic();
        if (pendingHokotroNev != null && kivalasztottJatekos instanceof TakaritoJatekos) {
            TakaritoJatekos tj = (TakaritoJatekos) kivalasztottJatekos;
            Hokotro hk = Main.bolt.hokotrotVasarol(pendingHokotroNev, tj, target);
            if (hk != null) {
                Main.varos.addJarmu(hk);
                Main.jarmuvek.put(pendingHokotroNev, hk);
                kivalasztottJarmu = hk;
                t.getStatuszPanel().update(hk);
                updatePenz();
                t.frissit();
            } else {
                JOptionPane.showMessageDialog(t, "Nincs elég pénz új hókotróra.");
            }
            pendingHokotroNev = null;
            return;
        }

        if (kivalasztottJarmu != null) {
            kivalasztottJarmu.getUtvonala().clear();
            kivalasztottJarmu.getUtvonala().addUtszakasz(target);
            t.frissit();
        }
    }

    private void ujJatekMegnyomva() {
        ujJatek();
    }

    private void ranglistaMegnyomva() {
        new Ranglista().setVisible(true);
    }

    private void ujJatek() {
        if (jatekTimer != null) {
            jatekTimer.stop();
        }
        Main.processCommand("init palya.txt");
        this.v = Main.varos;
        this.kivalasztottJarmu = null;
        this.kivalasztottJatekos = null;
        this.pendingHokotroNev = null;
        this.tickSzamlalo = 0;

        UIManager.put("OptionPane.background", new Color(144, 238, 144));
        UIManager.put("Panel.background", new Color(144, 238, 144));

        String teamName = JOptionPane.showInputDialog(m, "Csapatnév:", "homlockin");
        if (teamName == null) return;
        
        String pCountStr = JOptionPane.showInputDialog(m, "Játékosok száma:", "2");
        if (pCountStr == null) return;
        int pCount = Integer.parseInt(pCountStr);

        t.getJatekosPanel().clear();
        for (int i = 0; i < pCount; i++) {
            JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
            panel.setBackground(new Color(144, 238, 144));
            JTextField nameField = new JTextField("Jatekos" + (i+1));
            String[] options = {"Takarító", "Buszvezető"};
            JComboBox<String> typeBox = new JComboBox<>(options);
            
            panel.add(new JLabel("Neve:"));
            panel.add(nameField);
            panel.add(new JLabel("Típusa:"));
            panel.add(typeBox);

            int result = JOptionPane.showConfirmDialog(m, panel, (i+1) + ". Játékos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result != JOptionPane.OK_OPTION) return;

            String name = nameField.getText();
            String type = (String) typeBox.getSelectedItem();
            
            if (type.equals("Takarító")) {
                TakaritoJatekos tj = new TakaritoJatekos(name);
                tj.setBolt(Main.bolt);
                Main.varos.addJatekos(tj);
                Main.jatekosok.put(name, tj);
                t.getJatekosPanel().addJatekos(name, "Takarító", i);
                Utszakasz start = findFreeStartUtszakasz();
                if (start != null) {
                    String hkId = "hk_" + name;
                    Hokotro hk = Main.bolt.hokotrotVasarol(hkId, tj, start);
                    if (hk != null) {
                        Main.varos.addJarmu(hk);
                        Main.jarmuvek.put(hkId, hk);
                    }
                }
            } else {
                Utszakasz v1 = findFreeStartUtszakasz();
                if (v1 == null) v1 = Main.utszakaszok.values().iterator().next();
                Utszakasz v2 = v1.getKovetkezok().isEmpty() ? v1 : v1.getKovetkezok().get(0);
                BuszvezetoJatekos bj = new BuszvezetoJatekos(name, v1, v2);
                Main.varos.addJatekos(bj);
                Main.jatekosok.put(name, bj);
                Busz b = new Busz(name, bj);
                b.setAllRajta(v1);
                bj.setVezeti(b);
                Main.varos.addJarmu(b);
                Main.jarmuvek.put(name, b);
                t.getJatekosPanel().addJatekos(name, "Buszvezető", i);
            }
        }

        t.initPalya(this);
        t.getJatekosPanel().connectButtons(this);
        m.setVisible(false);
        t.setVisible(true);
        t.frissit();
        inditAutomatikusJatekot();
    }

    private void setBoltVasarlo() {
        if (kivalasztottJatekos instanceof TakaritoJatekos) {
            Main.bolt.setVasarol((TakaritoJatekos) kivalasztottJatekos);
            return;
        }
        if (kivalasztottJarmu instanceof Hokotro) {
            for (Jatekos j : Main.jatekosok.values()) {
                if (j instanceof TakaritoJatekos && ((TakaritoJatekos) j).getHokotroi().contains(kivalasztottJarmu)) {
                    Main.bolt.setVasarol((TakaritoJatekos) j);
                    return;
                }
            }
        }
    }

    private void updatePenz() {
        if (kivalasztottJatekos instanceof TakaritoJatekos) {
            t.getStatuszPanel().updatePenz(((TakaritoJatekos) kivalasztottJatekos).getPenz());
        } else {
            t.getStatuszPanel().updatePenz(0);
        }
    }

    private Utszakasz findFreeStartUtszakasz() {
        for (Utszakasz u : Main.utszakaszok.values()) {
            if (u.getJarmu() == null && u.jarhato()) {
                return u;
            }
        }
        return null;
    }

    private void inditAutomatikusJatekot() {
        jatekTimer = new Timer(1000, e -> {
            tickSzamlalo++;
            if (tickSzamlalo % 4 == 0) {
                inditAutot();
            }
            if (tickSzamlalo % 6 == 0) {
                Main.varos.havazas();
            }
            Main.varos.leptet();
            t.frissit();
            updatePenz();

            if (Main.varos.jatekVegeEllenorzes()) {
                ((Timer) e.getSource()).stop();
                t.jatekVege();
            }
        });
        jatekTimer.start();
    }

    private void inditAutot() {
        Utszakasz start = findAutoStart();
        if (start == null) return;

        String id = "auto" + autoCounter++;
        Auto a = new Auto(id);
        a.setAllRajta(start);
        Utvonal utvonal = generalAutoUtvonal(start);
        if (utvonal.getKivantUtszakasz() == null) {
            start.setJarmu(null);
            return;
        }
        a.setUtvonala(utvonal);
        Main.varos.addJarmu(a);
        Main.jarmuvek.put(id, a);
    }

    private Utszakasz findAutoStart() {
        Set<Utszakasz> nonEntry = new HashSet<>();
        for (Utszakasz u : Main.utszakaszok.values()) {
            nonEntry.addAll(u.getKovetkezok());
        }
        for (Utszakasz u : Main.utszakaszok.values()) {
            if (!nonEntry.contains(u) && u.getJarmu() == null && u.jarhato()) {
                return u;
            }
        }
        return findFreeStartUtszakasz();
    }

    private Utvonal generalAutoUtvonal(Utszakasz start) {
        Utvonal utvonal = new Utvonal();
        Utszakasz current = start;
        Set<Utszakasz> visited = new HashSet<>();
        visited.add(start);

        for (int i = 0; i < 16; i++) {
            List<Utszakasz> kov = current.getKovetkezok();
            if (kov.isEmpty()) break;
            Utszakasz next = null;
            List<Utszakasz> candidates = new ArrayList<>();
            for (Utszakasz k : kov) {
                if (!visited.contains(k)) candidates.add(k);
            }
            if (!candidates.isEmpty()) {
                next = candidates.get(random.nextInt(candidates.size()));
            } else {
                next = kov.get(random.nextInt(kov.size()));
            }
            utvonal.addUtszakasz(next);
            current = next;
            if (!visited.add(next)) break;
        }

        return utvonal;
    }
}
