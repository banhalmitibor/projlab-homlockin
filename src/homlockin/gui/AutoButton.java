package homlockin.gui;

import homlockin.*;
import java.awt.*;

/**
 * Az autó megjelenítése a pályán (kör).
 */
public class AutoButton extends JarmuUI {
    private Auto model;

    public AutoButton(Auto a) {
        this.model = a;
        setEnabled(false); // Spec says "azonnal hatástalanítjuk a gombot"
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.RED);
        g2.fillOval(5, 5, getWidth() - 10, getHeight() - 10);
        g2.setColor(Color.BLACK);
        g2.drawOval(5, 5, getWidth() - 10, getHeight() - 10);

        g2.dispose();
    }

    public Auto getLogic() {
        return model;
    }
}
