package homlockin.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Absztrakt osztály a járművek megjelenítéséhez.
 */
public abstract class JarmuUI extends JButton {
    protected UtszakaszUI jelenlegiUtszakasz;

    public JarmuUI() {
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
    }

    public void connectButtons(ActionListener e) {
        this.addActionListener(e);
    }

    public void setJelenlegiUtszakasz(UtszakaszUI u) {
        this.jelenlegiUtszakasz = u;
    }
}
