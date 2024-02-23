package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagementSystemGUI extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final JTextField nameInput;
    private final JTextField roleInput;

    public ManagementSystemGUI() {
        setTitle("Management System GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Role");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        nameInput = new JTextField();
        nameInput.setColumns(10);
        roleInput = new JTextField();
        roleInput.setColumns(10);

        JButton addButton = new JButton("Add User");
        JButton updateButton = new JButton("Update User");
        JButton deleteButton = new JButton("Delete User");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name: "));
        inputPanel.add(nameInput);
        inputPanel.add(new JLabel("Role: "));
        inputPanel.add(roleInput);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addUser() {
        String name = nameInput.getText();
        String role = roleInput.getText();
        tableModel.addRow(new Object[]{name, role});
        nameInput.setText("");
        roleInput.setText("");
    }


    private void updateUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String newRole = roleInput.getText();
            table.setValueAt(newRole, selectedRow, 1);
            roleInput.setText("");
        } else {
            showAlert("No user selected", "Please select a user to update.");
        }
    }

    private void deleteUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            showAlert("No user selected", "Please select a user to delete.");
        }
    }

    private void showAlert(String title, String content) {
        JOptionPane.showMessageDialog(this, content, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ManagementSystemGUI().setVisible(true);
            }
        });
    }
}
