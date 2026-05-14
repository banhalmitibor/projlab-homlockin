package homlockin.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Ez az osztály lesz felelős a főmenü megalkotásáért.
 */
public class Menu extends JFrame {
    private JButton ujJatekButton;
    private JButton ranglistaButton;
    private Image backgroundImage;

    public Menu() {
        setTitle("Homlockin - Havas Kaland");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);

        try {
            backgroundImage = ImageIO.read(new File("fomenu.png"));
        } catch (IOException e) {}

        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPanel.setLayout(new GridBagLayout());

        ujJatekButton = createStyledButton("New Game!");
        ujJatekButton.setActionCommand("UJBT");
        
        ranglistaButton = createStyledButton("Scoreboard");
        ranglistaButton.setActionCommand("LBBT");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(ujJatekButton, gbc);
        gbc.gridy = 1;
        contentPanel.add(ranglistaButton, gbc);

        add(contentPanel);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setForeground(new Color(0, 191, 255));
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 0, 139), 3),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        return button;
    }

    public void connectButtons(ActionListener e) {
        ujJatekButton.addActionListener(e);
        ranglistaButton.addActionListener(e);
    }
}
