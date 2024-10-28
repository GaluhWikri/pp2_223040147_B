package TugasStudiKasus;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Buku Tabungan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menambahkan JMenuBar dengan menu "Keluar"
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem exitItem = new JMenuItem("Keluar");

        exitItem.addActionListener(e -> System.exit(0));

        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Menampilkan InputForm langsung di MainFrame
        InputForm inputForm = new InputForm();
        add(inputForm, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
