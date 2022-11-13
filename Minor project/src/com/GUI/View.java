package com.GUI;

import com.codefile.Compress;
import com.codefile.Decompress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class View extends JFrame implements ActionListener {
    JButton compressFile;
    JButton decompressFile;

    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressFile=new JButton("Select the file to compress");
        compressFile.addActionListener(this);
        compressFile.setBounds(20,250,200,30);

        decompressFile=new JButton("Select the file to decompress");
        decompressFile.addActionListener(this);
        decompressFile.setBounds(250,250,200,30);

        this.add(compressFile);
        this.add(decompressFile);

        this.getContentPane().setBackground(Color.white);
        this.setSize(500,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   //need to override the existing actionPerformed
        if(e.getSource() == compressFile){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
                try{
                    Compress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource() == decompressFile){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
                try{
                    Decompress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }
    public static void main(String[] args){
        View view= new View();
        view.setVisible(true);
    }

}
