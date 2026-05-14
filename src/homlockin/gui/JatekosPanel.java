package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A játékosok, és az pénzük megjelenítéséért felelős osztály.
 */
public class JatekosPanel extends JPanel {
    private List<JButton> jatekosok;

    public JatekosPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(30, 144, 255));
        setPreferredSize(new Dimension(0, 80));
        jatekosok = new ArrayList<>();
    }

    public void addJatekos(String nev, String tipus, int index) {
        JButton b = new JButton("<html>" + nev + "<br><small>" + tipus + "</small></html>");
        b.setActionCommand("JBT_" + index);
        b.setPreferredSize(new Dimension(100, 60));
        jatekosok.add(b);
        add(b);
    }

    public void connectButtons(ActionListener e) {
        for (JButton b : jatekosok) {
            b.addActionListener(e);
        }
    }

    public void highlightJatekos(int index) {
        for (int i = 0; i < jatekosok.size(); i++) {
            if (i == index) {
                jatekosok.get(i).setEnabled(false); // Spec says "ki lesz szürkítve"
            } else {
                jatekosok.get(i).setEnabled(true);
            }
        }
    }

    public void clear() {
        jatekosok.clear();
        removeAll();
    }
}
