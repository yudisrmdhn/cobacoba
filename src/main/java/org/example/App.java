package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Membuat JFrame sebagai jendela utama
        JFrame frame = new JFrame("Password Validation");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Menambahkan label untuk keterangan
        JLabel label = new JLabel("Enter PIN (6 digits only):");
        frame.add(label);

        // Membuat JPasswordField untuk input PIN
        JPasswordField passwordField = new JPasswordField(10);
        frame.add(passwordField);

        // Membuat tombol untuk validasi
        JButton button = new JButton("Validate");
        frame.add(button);

        // Menambahkan ActionListener untuk proses validasi
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil input PIN dari JPasswordField
                String password = new String(passwordField.getPassword());

                // Validasi PIN
                if (password.length() == 6) {
                    JOptionPane.showMessageDialog(frame,
                            "PIN is valid",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "PIN must contain digits only (6 letters or symbols)",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                passwordField.setText("");
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }
}