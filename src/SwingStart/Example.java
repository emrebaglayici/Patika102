package SwingStart;

import javax.swing.*;
import java.awt.*;

public class Example extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;

    public Example() {
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        setContentPane(wrapper);
        setSize(400,300);
        setTitle("Uygulama Adı : ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x=(Toolkit.getDefaultToolkit().getScreenSize().width-getSize().width)/2;
        int y=(Toolkit.getDefaultToolkit().getScreenSize().height-getSize().height)/2;
        setLocation(x,y);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(fld_username.getText().isEmpty() || fld_password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill in the blanks","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
