package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Az útszakasz megjelenítéséért felelős osztály.
 */
public class UtszakaszUI extends JButton {
    protected JarmuUI jarmuRajta;
    protected JPanel hoSzint;
    protected JPanel jegSzint;
    protected Utszakasz model;

    public UtszakaszUI(Utszakasz u) {
        this.model = u;
        this.hoSzint = new JPanel();
        this.jegSzint = new JPanel();
        setContentAreaFilled(false);
    }

    public void connectButtons(ActionListener e) {
        this.addActionListener(e);
    }

    public void setJarmuRajta(JarmuUI j) {
        this.jarmuRajta = j;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // Alap útszakasz rajzolása (sötétszürke négyzet)
        g2.setColor(new Color(64, 64, 64));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.BLACK);
        g2.drawRect(0, 0, getWidth(), getHeight());

        // Hószint és Jégszint oszlopok a széleken
        int maxH = getHeight() - 10;
        
        // Hó (bal oldalon)
        int hoH = (model.getHo() != null) ? Math.min(model.getHo().getMennyiseg() * 10, maxH) : 0;
        g2.setColor(Color.WHITE);
        g2.fillRect(2, getHeight() - hoH - 5, 10, hoH);

        // Jég (jobb oldalon)
        int jegH = (model.getJeg() != null) ? Math.min(model.getJeg().getMennyiseg() * 10, maxH) : 0;
        if (model.getZuzalek() != null && model.getZuzalek().vanZuzalek()) {
            g2.setColor(Color.GRAY); // Elszürkül ha zúzalékolva van
        } else {
            g2.setColor(new Color(173, 216, 230)); // Világoskék jég
        }
        g2.fillRect(getWidth() - 12, getHeight() - jegH - 5, 10, jegH);

        g2.dispose();
    }

    public Utszakasz getLogic() {
        return model;
    }
}
