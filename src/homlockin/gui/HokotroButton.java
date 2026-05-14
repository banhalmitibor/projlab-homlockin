package homlockin.gui;

import homlockin.*;
import java.awt.*;

/**
 * Hókotró vizuális megjelenítése a játéktáblán.
 */
public class HokotroButton extends JarmuUI {
    private Hokotro model;

    public HokotroButton(Hokotro h) {
        this.model = h;
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int[] xPoints = {getWidth() / 2, 5, getWidth() - 5};
        int[] yPoints = {5, getHeight() - 5, getHeight() - 5};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);

        g2.setColor(Color.PINK); // Spec snippet says PINK
        g2.fill(triangle);
        g2.setColor(Color.BLACK);
        g2.draw(triangle);

        g2.dispose();
    }

    public Hokotro getLogic() {
        return model;
    }
}
