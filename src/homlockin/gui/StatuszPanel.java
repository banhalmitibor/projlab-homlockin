package homlockin.gui;

import homlockin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A képernyő jobb oldalán megjelenő információs sáv.
 */
public class StatuszPanel extends JPanel {
    private JLabel bioKerozinLabel;
    private JLabel soLabel;
    private JLabel zuzalekLabel; // Added based on mockup even if not explicit in text
    private JLabel fejLabel;
    private JLabel penzLabel; // Added based on text "jobb felső sarkában mindig ... pénzmennyisége"

    private JButton hokotroButton;
    private JButton biokerozinButton;
    private JButton soButton;
    private JButton zuzalekButton;
    private JButton hanyofejButton;
    private JButton soprofejButton;
    private JButton jegtorofejButton;
    private JButton soszorofejButton;
    private JButton sarkanyfejButton;

    public StatuszPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(0, 191, 255));
        setPreferredSize(new Dimension(250, 0));

        penzLabel = new JLabel("Pénz: 0");
        penzLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(penzLabel);

        add(Box.createVerticalStrut(20));

        bioKerozinLabel = new JLabel("Kerozin: -");
        soLabel = new JLabel("Só: -");
        zuzalekLabel = new JLabel("Zúzalék: -");
        fejLabel = new JLabel("Fej: -");

        add(bioKerozinLabel);
        add(soLabel);
        add(zuzalekLabel);
        add(fejLabel);

        add(Box.createVerticalStrut(20));

        hokotroButton = new JButton("Új hókotró");
        hokotroButton.setActionCommand("HKBBT");

        biokerozinButton = new JButton("Biokerozin");
        biokerozinButton.setActionCommand("BKBT");

        soButton = new JButton("Só");
        soButton.setActionCommand("SBT");

        zuzalekButton = new JButton("Zúzalék");
        zuzalekButton.setActionCommand("ZBT");
        
        hanyofejButton = new JButton("Hányófej");
        hanyofejButton.setActionCommand("FBBT_hanyo");
        
        soprofejButton = new JButton("Söprőfej");
        soprofejButton.setActionCommand("FBBT_sopro");
        
        jegtorofejButton = new JButton("Jégtörőfej");
        jegtorofejButton.setActionCommand("FBBT_jegtoro");
        
        soszorofejButton = new JButton("Sószórófej");
        soszorofejButton.setActionCommand("FBBT_soszoro");
        
        sarkanyfejButton = new JButton("Sárkányfej");
        sarkanyfejButton.setActionCommand("FBBT_sarkany");

        add(hokotroButton);
        add(biokerozinButton);
        add(soButton);
        add(zuzalekButton);
        add(hanyofejButton);
        add(soprofejButton);
        add(jegtorofejButton);
        add(soszorofejButton);
        add(sarkanyfejButton);
    }

    public void update(HokotroInfo hk) {
        if (hk != null) {
            bioKerozinLabel.setText("Kerozin: " + hk.getBiokerozin());
            soLabel.setText("Só: " + hk.getSo());
            zuzalekLabel.setText("Zúzalék: " + hk.getZuzalek());
            fejLabel.setText("Fej: " + hk.getFej());
        } else {
            bioKerozinLabel.setText("Kerozin: -");
            soLabel.setText("Só: -");
            zuzalekLabel.setText("Zúzalék: -");
            fejLabel.setText("Fej: -");
        }
    }

    public void updatePenz(int penz) {
        penzLabel.setText("Pénz: " + penz);
    }

    public void connectButtons(ActionListener e) {
        hokotroButton.addActionListener(e);
        biokerozinButton.addActionListener(e);
        soButton.addActionListener(e);
        zuzalekButton.addActionListener(e);
        hanyofejButton.addActionListener(e);
        soprofejButton.addActionListener(e);
        jegtorofejButton.addActionListener(e);
        soszorofejButton.addActionListener(e);
        sarkanyfejButton.addActionListener(e);
    }
}
