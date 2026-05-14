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
        setResizable(false);
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
        GridBagConstraints gbc = new GridBagConstraints();

        ujJatekButton = createStyledButton("New Game!");
        ujJatekButton.setActionCommand("UJBT");
        
        ranglistaButton = createStyledButton("Scoreboard");
        ranglistaButton.setActionCommand("LBBT");

        gbc.weighty = 1.0;  
        gbc.weightx = 0.5;   
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST; 
        gbc.insets = new Insets(40, 50, 0, 0); 
        contentPanel.add(ujJatekButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(40, 0, 0, 70); 
        contentPanel.add(ranglistaButton, gbc);

        add(contentPanel);
    }

        private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        
        button.setForeground(new Color(0, 0, 0, 0)); 
        
        button.setPreferredSize(new Dimension(380, 120)); 
        
        return button;
    }
    

    public void connectButtons(ActionListener e) {
        ujJatekButton.addActionListener(e);
        ranglistaButton.addActionListener(e);
    }
}
