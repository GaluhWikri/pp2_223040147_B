import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

public class HelloRadioButton extends JFrame {

    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat MenuBar dan Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Nama 
        JLabel labelInput = new JLabel("Nama :");
        labelInput.setBounds(15, 20, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 40, 350, 30);

        // Nomor HP 
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 80, 350, 10);

        JTextField textHP = new JTextField();
        textHP.setBounds(15, 100, 350, 30);

        // Jenis Kelamin 
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 140, 350, 10);

        JRadioButton radioMale = new JRadioButton("Laki-Laki");
        radioMale.setBounds(15, 160, 100, 30);

        JRadioButton radioFemale = new JRadioButton("Perempuan");
        radioFemale.setBounds(120, 160, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        // Jenis Tabungan 
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(15, 200, 350, 10);

        String[] jenisTabungan = {"Tabungan Biasa", "Tabungan Haji", "Tabungan Pendidikan", "Tabungan Nikah"};
        JList<String> listTabungan = new JList<>(jenisTabungan);
        listTabungan.setBounds(15, 220, 150, 73);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransaksi.setBounds(200, 200, 200, 10);

        // JSlider untuk frekuensi transaksi
        JSlider sliderTransaksi = new JSlider(0, 100, 50); // min, max, initial value
        sliderTransaksi.setBounds(200, 220, 150, 50);
        sliderTransaksi.setMajorTickSpacing(20);
        sliderTransaksi.setMinorTickSpacing(5);
        sliderTransaksi.setPaintTicks(true);
        sliderTransaksi.setPaintLabels(true);

        // Password dan Confirm Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 300, 100, 10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 320, 150, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(200, 300, 150, 10);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 320, 150, 30);

        // Tanggal Lahir Spinner (Day, Month, Year)
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 360, 150, 10);

        JLabel labelTanggal = new JLabel("Tanggal");
        labelTanggal.setBounds(15, 380, 100, 10);

        SpinnerModel dayModel = new SpinnerNumberModel(1, 1, 31, 1); // Spinner untuk hari (1-31)
        JSpinner spinnerDay = new JSpinner(dayModel);
        spinnerDay.setBounds(15, 400, 50, 30);

        JLabel labelBulan = new JLabel("Bulan");
        labelBulan.setBounds(80, 380, 100, 10);

        // Spinner untuk bulan
        SpinnerModel monthModel = new SpinnerListModel(new String[] {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
        });
        JSpinner spinnerMonth = new JSpinner(monthModel);
        spinnerMonth.setBounds(80, 400, 100, 30);

        JLabel labelTahun = new JLabel("Tahun");
        labelTahun.setBounds(200, 380, 100, 10);

        // Spinner untuk tahun
        SpinnerModel yearModel = new SpinnerNumberModel(2023, 1900, Calendar.getInstance().get(Calendar.YEAR), 1);
        JSpinner spinnerYear = new JSpinner(yearModel);
        spinnerYear.setBounds(200, 400, 70, 30);

        // Warga Negara Asing checkbox
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 450, 200, 30);

        // Simpan button
        JButton button = new JButton("SIMPAN");
        button.setBounds(120, 490, 100, 40);

        // Output area
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 540, 350, 150);
        txtOutput.setEditable(false);

        // ActionListener 
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String nomorHP = textHP.getText();
                String jenisKelamin = radioMale.isSelected() ? "Laki-Laki" : "Perempuan";
                String jenisTabunganSelected = listTabungan.getSelectedValue();
                int frekuensiTransaksi = (int) sliderTransaksi.getValue();
                String wnaStatus = checkBoxWNA.isSelected() ? "Ya" : "Bukan";

                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String passwordMatch = password.equals(confirmPassword) ? "Cocok" : "Tidak Cocok";

                int selectedDay = (int) spinnerDay.getValue();
                String selectedMonth = (String) spinnerMonth.getValue();
                int selectedYear = (int) spinnerYear.getValue();

                // Displaying input
                txtOutput.append("Nama   : " + nama + "\n");
                txtOutput.append("Nomor HP : " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("Jenis Tabungan : " + jenisTabunganSelected + "\n");
                txtOutput.append("Frekuensi Transaksi : " + frekuensiTransaksi + " kali per bulan\n");
                txtOutput.append("WNA : " + wnaStatus + "\n");
                txtOutput.append("Tanggal Lahir : " + selectedDay + " " + selectedMonth + " " + selectedYear + "\n");
                txtOutput.append("Password Match : " + passwordMatch + "\n");
                txtOutput.append("===========================================\n");

                // Reset input 
                textField.setText("");
                textHP.setText("");
                genderGroup.clearSelection();
                listTabungan.clearSelection();
                checkBoxWNA.setSelected(false);
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        // ActionListener reset menu item
        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all inputs and output
                textField.setText("");
                textHP.setText("");
                genderGroup.clearSelection();
                listTabungan.clearSelection();
                checkBoxWNA.setSelected(false);
                passwordField.setText("");
                confirmPasswordField.setText("");
                txtOutput.setText("");
            }
        });

        // ActionListener exit menu item
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
        this.add(labelTabungan);
        this.add(listTabungan);
        this.add(labelTransaksi);
        this.add(sliderTransaksi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(labelTanggal);
        this.add(spinnerDay);
        this.add(labelBulan);
        this.add(spinnerMonth);
        this.add(labelTahun);
        this.add(spinnerYear);
        this.add(checkBoxWNA);
        this.add(button);
        this.add(txtOutput);

        // Frame settings
        this.setSize(400, 750);
        this.setLayout(null);
    }

    // Main method
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloRadioButton h = new HelloRadioButton();
                h.setVisible(true);
            }
        });
    }
}
