package org.example;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout()); // Use a layout manager to arrange components

        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        this.add(compressButton);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        this.add(decompressButton);

        this.setSize(500, 200); // Adjust the size as needed
        this.getContentPane().setBackground(Color.BLUE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Action performed logic here
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
                System.out.println(file);
                try{
                    compressor.method(file);
                }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
                System.out.println(file);
                try{
                    decompressor.method(file);
                }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
