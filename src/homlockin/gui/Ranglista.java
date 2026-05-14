package homlockin.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

/**
 * Az elmentett korábbi pontszámok megjelenítése táblázatos formában.
 */
public class Ranglista extends JFrame {
    private JTable lista;
    private JScrollPane sp;

    public Ranglista() {
        setTitle("Scoreboard");
        setSize(450, 600);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(144, 238, 144)); // Green
        mainPanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 8)); // Thick brown border

        JLabel titleLabel = new JLabel("SCOREBOARD", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Csapat", "Pontszám"}, 0);
        lista = new JTable(model);
        lista.setBackground(new Color(144, 238, 144));
        lista.setRowHeight(40);
        lista.setFont(new Font("Arial", Font.BOLD, 18));
        lista.setTableHeader(null); // No header as in image
        lista.setShowGrid(false);
        lista.setIntercellSpacing(new Dimension(0, 10));

        sp = new JScrollPane(lista);
        sp.setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        mainPanel.add(sp, BorderLayout.CENTER);

        JButton closeButton = new JButton("BEZÁR");
        closeButton.setFont(new Font("Arial", Font.BOLD, 20));
        closeButton.setBackground(new Color(60, 179, 113)); // Darker green
        closeButton.setForeground(Color.BLACK);
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 3));
        closeButton.addActionListener(e -> setVisible(false));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        loadData(model);
    }

    private void loadData(DefaultTableModel model) {
        try {
            File f = new File("ranglista.txt");
            if (f.exists()) {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        model.addRow(new Object[]{parts[0], parts[1]+" pont"});
                    }
                }
                sc.close();
            }
        } catch (Exception e) {}
    }
}
