package GUI;

import javax.swing.*;
import java.awt.event.*;

import fun.*;

public class RegisterDialog extends JDialog {
    private JPanel contentPane;
    private JButton nextButton;
    private JButton cancelButton;
    private JTextField username;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField phone;

    public RegisterDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(nextButton);
        setLocationRelativeTo(LoginGUI.frame);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
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

    private void onOK() {
        String username = this.username.getText();
        String pass1 = String.valueOf(this.passwordField1.getPassword());
        System.out.println(pass1);
        String pass2 = String.valueOf(this.passwordField2.getPassword());
        String phone = this.phone.getText();
        String haveerro = RegisterFUN.Register(username,pass1,pass2,phone);

        if (haveerro.equals("")){
            this.setVisible(false);
            JBDC_User.addUserData(username,pass1,phone);
            SetquestionDialog dialog = new SetquestionDialog();
            dialog.pack();
            dialog.setVisible(true);
            System.exit(0);
        }else {
            JOptionPane.showMessageDialog(this,haveerro);
        }

    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public static void main(String[] args) {
        RegisterDialog dialog = new RegisterDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public RegisterDialog(String username,String pass1,String pass2,String phone){
        this.username.setText(username);
        this.passwordField1.setText(pass1);
        this.passwordField2.setText(pass2);
        this.phone.setText(phone);
    }
}
