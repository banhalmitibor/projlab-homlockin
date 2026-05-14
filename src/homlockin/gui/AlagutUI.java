package homlockin.gui;

import homlockin.*;
import java.awt.*;

/**
 * Alagút megjelenítése.
 */
public class AlagutUI extends UtszakaszUI {
    public AlagutUI(Alagut a) {
        super(a);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        // Alagút specifikus vizuális elem: pl. vastagabb sötét keret
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
