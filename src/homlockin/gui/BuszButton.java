package homlockin.gui;

import homlockin.*;
import java.awt.*;

/**
 * A busz grafikus reprezentációja.
 */
public class BuszButton extends JarmuUI {
    private Busz model;

    public BuszButton(Busz b) {
        this.model = b;
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(30, 144, 255)); // Dodgy Blue for Bus
        g2.fillRect(5, 5, getWidth() - 10, getHeight() - 10);
        g2.setColor(Color.BLACK);
        g2.drawRect(5, 5, getWidth() - 10, getHeight() - 10);

        g2.dispose();
    }

    public Busz getLogic() {
        return model;
    }
}
