package TugasStudiKasus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputForm extends JPanel {
    private JTextField nameField;
    private JTextField amountField;
    private JTextArea notesArea;
    private JRadioButton depositButton;
    private JRadioButton withdrawButton;
    private JCheckBox notifyCheckBox;
    private JComboBox<String> accountTypeCombo;
    private JTable transactionTable;
    private DefaultTableModel tableModel;

    public InputForm() {
        setLayout(new BorderLayout());

        // Panel Form Input
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        nameField = new JTextField();
        amountField = new JTextField();
        notesArea = new JTextArea(3, 20);
        
        // Panel Tipe Transaksi
        JPanel transactionTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        depositButton = new JRadioButton("Deposit");
        withdrawButton = new JRadioButton("Withdraw");
        ButtonGroup bg = new ButtonGroup();
        bg.add(depositButton);
        bg.add(withdrawButton);

        transactionTypePanel.add(depositButton);
        transactionTypePanel.add(withdrawButton);

        notifyCheckBox = new JCheckBox("Warga Negara Asing");
        accountTypeCombo = new JComboBox<>(new String[]{"Premium", "Executive", "Business"});

        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Jumlah:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Catatan:"));
        inputPanel.add(new JScrollPane(notesArea));
        inputPanel.add(new JLabel("Tipe Transaksi:"));
        inputPanel.add(transactionTypePanel);
        inputPanel.add(notifyCheckBox);
        inputPanel.add(new JLabel("Tipe Akun:"));
        inputPanel.add(accountTypeCombo);

        // Panel Tabel Transaksi
        String[] columnNames = {"Nama", "Jumlah", "Catatan", "Tipe Transaksi", "Tipe Akun"};
        tableModel = new DefaultTableModel(columnNames, 0);
        transactionTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(transactionTable);

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Tambah");
        JButton updateButton = new JButton("Perbarui");
        JButton deleteButton = new JButton("Hapus");

        addButton.addActionListener(e -> addTransaction());
        updateButton.addActionListener(e -> updateTransaction());
        deleteButton.addActionListener(e -> deleteTransaction());

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Menambahkan panel ke frame
        add(inputPanel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addTransaction() {
        String name = nameField.getText();
        String amount = amountField.getText();
        String notes = notesArea.getText();
        String transactionType = depositButton.isSelected() ? "Deposit" : "Withdraw";
        String accountType = (String) accountTypeCombo.getSelectedItem();

        tableModel.addRow(new Object[]{name, amount, notes, transactionType, accountType});
        clearFields();
    }

    private void updateTransaction() {
        int selectedRow = transactionTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.setValueAt(nameField.getText(), selectedRow, 0);
            tableModel.setValueAt(amountField.getText(), selectedRow, 1);
            tableModel.setValueAt(notesArea.getText(), selectedRow, 2);
            tableModel.setValueAt(depositButton.isSelected() ? "Deposit" : "Withdraw", selectedRow, 3);
            tableModel.setValueAt(accountTypeCombo.getSelectedItem(), selectedRow, 4);
            clearFields();
        }
    }

    private void deleteTransaction() {
        int selectedRow = transactionTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }

    private void clearFields() {
        nameField.setText("");
        amountField.setText("");
        notesArea.setText("");
        depositButton.setSelected(false);
        withdrawButton.setSelected(false);
        accountTypeCombo.setSelectedIndex(0);
    }
}
