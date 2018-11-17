package guichat;

import javax.swing.*;
import java.awt.*;

public class guiChat {
    guiChat() {
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenu m11 = new JMenu("Open");
        JMenu m12 = new JMenu("Save as:");
        m1.add(m11);
        m1.add(m12);

        JMenu m111 = new JMenu("Disk");
        m11.add(m111);

        // Create panel at the bottom for adding components
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JTextField textField = new JTextField(10);
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(send);
        panel.add(textField);
        panel.add(reset);

        // Text area at center
        JTextArea textArea = new JTextArea();

        // Adding components to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new guiChat();
    }
                     }
