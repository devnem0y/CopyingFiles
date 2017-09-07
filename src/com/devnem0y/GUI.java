package com.devnem0y;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.Timer;

public class GUI implements ActionListener{

    private JFrame windows, show;
    private JButton btnRun, btnChooser, btnOk;
    private JTextField path;

    private boolean running = true;

    public GUI() {
        createWindows();
    }

    private void createWindows() {
        windows = new JFrame("Copying files to project");
        windows.setLayout(new FlowLayout());
        windows.setSize(300, 118);
        windows.setResizable(false);
        windows.setLocationRelativeTo(null);
        windows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windows.setVisible(true);
        addElements(windows);
    }

    private void addElements(JFrame frame) {
        btnRun = new JButton("Run");
        btnChooser = new JButton("Browse...");
        JLabel labelPath = new JLabel("Path to project directory");
        path = new JTextField(17);
        path.setEnabled(false);
        frame.add(labelPath);
        frame.add(path);
        frame.add(btnChooser);
        frame.add(btnRun);
        btnRun.addActionListener(this);
        btnChooser.addActionListener(this);
    }

    public void run() {
        while (running) {
            if (Objects.equals(path.getText(), "")) {
                btnRun.setEnabled(false);
            } else btnRun.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRun) {
            String mPath = path.getText();
            new Copying(mPath);
            windows.setVisible(false);
            windows.dispose();
            running = false;
            try {
                Thread.sleep(2000);
                createShow();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnChooser) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            int response = chooser.showOpenDialog(windows);
            if (response == JFileChooser.APPROVE_OPTION) {
                path.setText(chooser.getSelectedFile().toString());
            }
        } else if (e.getSource() == btnOk) {
            show.dispose();
            System.exit(0);
        }
    }

    private void createShow() {
        show = new JFrame();
        show.setLayout(new FlowLayout());
        btnOk = new JButton("Ok");
        JLabel label = new JLabel("Done!");
        show.add(label);
        show.add(btnOk);
        btnOk.addActionListener(this);
        show.setSize(90, 70);
        show.setResizable(false);
        show.setLocationRelativeTo(null);
        show.setUndecorated(true);
        show.setVisible(true);
    }
}
