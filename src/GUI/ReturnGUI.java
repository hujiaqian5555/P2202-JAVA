package GUI;

import fun.Window;

import javax.swing.*;

public class ReturnGUI {

    private JPanel returnpanel;
    private JButton 归还Button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public static void show() {

        JFrame frame = new JFrame("ReturnGUI");
        frame.setContentPane(new ReturnGUI().returnpanel);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }


}
