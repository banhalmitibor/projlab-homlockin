package homlockin.gui;

import homlockin.*;
import java.awt.*;

/**
 * Busz végállomás megjelenítése.
 */
public class BuszVegallomasUI extends UtszakaszUI {
    public BuszVegallomasUI(Utszakasz u) {
        super(u);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        // Végállomás specifikus vizuális elem: sárga keret
        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
