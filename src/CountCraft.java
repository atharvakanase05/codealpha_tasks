import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountCraft extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JButton countButton;
    private JButton reloadButton;
    private JLabel resultLabel;

    public CountCraft() {
        setTitle("CountCraft - Word Counter(Atharva Kanase)");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout manager
        setLayout(new BorderLayout(20, 20));

        //  The Container panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(45, 52, 54));

        // Add the heading label
        JLabel heading = new JLabel("CountCraft", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(Color.WHITE);
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Text area for input Box
        textArea = new JTextArea(10, 30);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setBackground(new Color(33, 47, 60));
        textArea.setForeground(Color.WHITE);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        textArea.setCaretColor(Color.WHITE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // The Result label
        resultLabel = new JLabel("Word Count: 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(new Color(241, 196, 15));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // The Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(45, 52, 54));

        // The Count button
        countButton = new JButton("Count Words");
        countButton.setFont(new Font("Arial", Font.BOLD, 18));
        countButton.setBackground(new Color(52, 152, 219));
        countButton.setForeground(Color.WHITE);
        countButton.setFocusPainted(false);
        countButton.setPreferredSize(new Dimension(150, 40));
        countButton.addActionListener(this);

        // The Reload button 
        reloadButton = new JButton("Reload");
        reloadButton.setFont(new Font("Arial", Font.BOLD, 18));
        reloadButton.setBackground(new Color(57, 153, 24));
        reloadButton.setForeground(Color.WHITE);
        reloadButton.setFocusPainted(false);
        reloadButton.setPreferredSize(new Dimension(150, 40));
        reloadButton.addActionListener(this);

        // Add components to button panel
        buttonPanel.add(countButton);
        buttonPanel.add(reloadButton);

        // Add components to the main panel
        panel.add(heading);
        panel.add(scrollPane);
        panel.add(buttonPanel);
        panel.add(resultLabel);

        // Add main panel to frame
        add(panel, BorderLayout.CENTER);

        // Set the frame properties
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText().trim();
            if (text.isEmpty()) {
                resultLabel.setText("Word Count: 0");
            } else {
                String[] words = text.split("\\s+");
                resultLabel.setText("Word Count: " + words.length);
            }
        } else if (e.getSource() == reloadButton) {
            textArea.setText(""); 
            resultLabel.setText("Word Count: 0"); 
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CountCraft().setVisible(true);
        });
    }
}

