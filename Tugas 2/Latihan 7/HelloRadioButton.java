import java.awt.event.*;
import javax.swing.*;

public class HelloRadioButton extends JFrame {

    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nama input
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 20, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 40, 350, 30);

        // Nomor HP input
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 80, 350, 10);

        JTextField textHP = new JTextField();
        textHP.setBounds(15, 100, 350, 30);

        // Jenis Kelamin radio buttons
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 140, 350, 10);

        JRadioButton radioMale = new JRadioButton("Laki-Laki");
        radioMale.setBounds(15, 160, 100, 30);

        JRadioButton radioFemale = new JRadioButton("Perempuan");
        radioFemale.setBounds(120, 160, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        // Warga Negara Asing checkbox
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 200, 200, 30);

        // Simpan button
        JButton button = new JButton("SIMPAN");
        button.setBounds(120, 240, 100, 40);

        // Output area
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 290, 350, 150);
        txtOutput.setEditable(false);

        // ActionListener for the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Getting user input values
                String nama = textField.getText();
                String nomorHP = textHP.getText();
                String jenisKelamin = radioMale.isSelected() ? "Laki-Laki" : "Perempuan";
                String wnaStatus = checkBoxWNA.isSelected() ? "Ya" : "Bukan";

                // Displaying the input in the output area
                txtOutput.append("Nama   : " + nama + "\n");
                txtOutput.append("Nomor HP : " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA : " + wnaStatus + "\n");
                txtOutput.append("===========================================\n");

                // Clearing input fields
                textField.setText("");
                textHP.setText("");
                genderGroup.clearSelection();
                checkBoxWNA.setSelected(false);
            }
        });

        // Adding components to the frame
        this.add(labelInput);
        this.add(textField);
        this.add(labelHP);
        this.add(textHP);
        this.add(labelGender);
        this.add(radioMale);
        this.add(radioFemale);
        this.add(checkBoxWNA);
        this.add(button);
        this.add(txtOutput);

        // Frame settings
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloRadioButton h = new HelloRadioButton();
                h.setVisible(true);
            }
        });
    }
}
