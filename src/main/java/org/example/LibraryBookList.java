package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibraryBookList {
    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Daftar Buku Perpustakaan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Data awal untuk tabel
        String[][] data = {
                {"1", "Naruto", "Masashi Kishimoto", "1999"},
                {"2", "One Piece", "Eiichiro Oda", "1997"},
                {"3", "Attack on Titan", "Hajime Isayama", "2009"},
                {"4", "Demon Slayer", "Koyoharu Gotouge", "2016"},
                {"5", "Jujutsu Kaisen", "Gege Akutami", "2018"}
        };
        String[] columns = {"ID Buku", "Judul", "Penulis", "Tahun"};

        // Membuat tabel
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        // ScrollPane agar tabel bisa discroll
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel untuk input buku baru
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Menambah jarak/padding pada panel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField idField = new JTextField(20);
        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField yearField = new JTextField(20);

        panel.add(new JLabel("ID Buku:"));
        panel.add(idField);
        panel.add(new JLabel("Judul:"));
        panel.add(titleField);
        panel.add(new JLabel("Penulis:"));
        panel.add(authorField);
        panel.add(new JLabel("Tahun:"));
        panel.add(yearField);

        // Tombol untuk menambahkan buku ke tabel
        JButton addButton = new JButton("Tambah Buku");
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(addButton);
        frame.add(panel, BorderLayout.NORTH);

        // Aksi ketika tombol ditekan
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String year = yearField.getText();

            // Validasi agar semua field terisi
            if (id.isEmpty() || title.isEmpty() || author.isEmpty() || year.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Semua field harus diisi!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Menambah baris baru ke tabel
            model.addRow(new Object[]{id, title, author, year});

            // Mengosongkan kembali input
            idField.setText("");
            titleField.setText("");
            authorField.setText("");
            yearField.setText("");
        });

        // Menampilkan frame
        frame.setVisible(true);
    }
}
