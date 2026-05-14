package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A játék vezérléséért felelős osztály.
 */
public class JatekVezerlo implements ActionListener {
    private Varos v;
    private Tabla t;
    private Menu m;
    private Jatekos kivalasztottJatekos;
    private Jarmu kivalasztottJarmu;

    public JatekVezerlo() {
        this.v = Main.varos;
        this.m = new Menu();
        this.t = new Tabla();
        m.connectButtons(this);
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
        // A spec szerint a járműveket is indexeljük vagy azonosítjuk
        // Egyelőre a kiválasztott járművet állítjuk be.
        // Mivel a JarmuUI-ra kattintunk, az actionCommand-ba tettük az indexet.
    }

    private void jatekosMegnyomva(int jatekosIndex) {
        List<Jatekos> jList = new ArrayList<>(Main.jatekosok.values());
        if (jatekosIndex < jList.size()) {
            kivalasztottJatekos = jList.get(jatekosIndex);
            t.getJatekosPanel().highlightJatekos(jatekosIndex);
            t.getStatuszPanel().updatePenz(kivalasztottJatekos instanceof TakaritoJatekos ? ((TakaritoJatekos)kivalasztottJatekos).getPenz() : 0);
        }
    }

    private void hokotroVasarlasMegnyomva() {
        if (kivalasztottJatekos instanceof TakaritoJatekos) {
            String name = JOptionPane.showInputDialog(t, "Hókotró neve:");
            if (name != null) {
                // Következő útszakaszra kattintással helyeződik le (spec szerint)
                // Egyelőre az első szabad útszakaszra tesszük.
                Utszakasz start = Main.utszakaszok.values().iterator().next();
                Hokotro hk = Main.bolt.hokotrotVasarol(name, (TakaritoJatekos) kivalasztottJatekos, start);
                if (hk != null) {
                    Main.varos.addJarmu(hk);
                    Main.jarmuvek.put(name, hk);
                    t.frissit();
                }
            }
        }
    }

    private void biokerozinVasarlasMegnyomva() {
        if (kivalasztottJarmu instanceof Hokotro) {
            Main.bolt.biokerozinVasarol((Hokotro) kivalasztottJarmu);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
        }
    }

    private void soVasarlasMegnyomva() {
        if (kivalasztottJarmu instanceof Hokotro) {
            Main.bolt.sotVasarol((Hokotro) kivalasztottJarmu);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
        }
    }

    private void zuzalekVasarlasMegnyomva() {
        if (kivalasztottJarmu instanceof Hokotro) {
            Main.bolt.zuzalekotVasarol((Hokotro) kivalasztottJarmu);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
        }
    }

    private void hanyofejVasarlasMegnyomva() { buyFej(new Hanyofej()); }
    private void soprofejVasarlasMegnyomva() { buyFej(new Soprofej()); }
    private void jegtorofejVasarlasMegnyomva() { buyFej(new Jegtorofej()); }
    private void soszorofejVasarlasMegnyomva() { buyFej(new Soszorofej()); }
    private void sarkanyfejVasarlasMegnyomva() { buyFej(new Sarkanyfej()); }

    private void buyFej(HokotroFej fej) {
        if (kivalasztottJarmu instanceof Hokotro) {
            Main.bolt.hokotroFejetVasarol((Hokotro) kivalasztottJarmu, fej);
            t.getStatuszPanel().update((Hokotro) kivalasztottJarmu);
        }
    }

    private void utszakaszMegnyomva(int index) {
        Utszakasz target = t.getSzakaszok().get(index).getLogic();
        if (kivalasztottJarmu != null) {
            kivalasztottJarmu.getUtvonala().addUtszakasz(target);
            // Ha busz, akkor léptethetjük is? Vagy külön gomb??
            // Spec szerint: "útvonalat beállítani a járműnek egy célútszakaszra kattintással"
        }
    }

    private void ujJatekMegnyomva() {
        ujJatek();
    }

    private void ranglistaMegnyomva() {
        new Ranglista().setVisible(true);
    }

    private void ujJatek() {
        // Inicializálás palya.txt-ből
        Main.processCommand("palya palya.txt");
        
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
            } else {
                Utszakasz v1 = Main.utszakaszok.values().iterator().next();
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
    }
}
