package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignUpGUI extends JFrame {
    private JTextField fld_name;
    private JTextField fld_uname;
    private JPasswordField fld_pass;
    private JPanel wrapper;
    private JPanel wtop;
    private JButton btn_sign_up;

    public SignUpGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterPoint(
                "x",getSize()
        ),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_sign_up.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_name)||
            Helper.isFieldEmpty(fld_uname)||Helper.isFieldEmpty(fld_pass)){
                Helper.showMessage("fill");
            }else{
//                ArrayList<User> userList=User.getList();
//                for (User u:userList){
//                    if(u.getUsername().equals(fld_uname.getText())){
//                        Helper.showMessage("Please type another username");
//                    }
//                }
//                User user=User.getFetch()
                User.signUp(fld_name.getText(),fld_uname.getText(),
                        fld_pass.getText());
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        SignUpGUI signUpGUI=new SignUpGUI();
    }
}
