package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.*;
import fun.*;
public class UserGUI {
    private JButton exitButton;
    private JPanel user;
    private JPanel avatar;
    private JLabel username;
    private JTabbedPane tabbedPane1;
    private JButton BorrowButton;
    private JButton ReturnButton;
    private JTabbedPane tabbedPane2;
    public UserGUI(){
        BorrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowGUI.show();
            }
        });
        ReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnGUI.show();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public static void show() {
        JFrame frame = new JFrame("userGUI");
        frame.setContentPane(new UserGUI().user);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }



}
