package homlockin.gui;

import homlockin.*;
import java.awt.*;

/**
 * Híd megjelenítése.
 */
public class HidUI extends UtszakaszUI {
    public HidUI(Hid h) {
        super(h);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        // Híd specifikus vizuális elem: pl. barna keret
        g2.setColor(new Color(139, 69, 19));
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
