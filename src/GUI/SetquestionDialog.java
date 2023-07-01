package GUI;

import javax.swing.*;
import java.awt.event.*;

public class SetquestionDialog extends JDialog {
    private JPanel contentPane;
    private JButton back;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public SetquestionDialog() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(back);
        setLocationRelativeTo(LoginGUI.frame);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               okButton();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }



    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    private void okButton(){
        RegisterDialog dialog = new RegisterDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
        this.setVisible(false);
    }
}
