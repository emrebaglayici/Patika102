package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Educator;
import PatikaClone.Models.Operator;
import PatikaClone.Models.Student;
import PatikaClone.Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JButton btn_login;
    private JButton btn_sign_up;

    public LoginGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)){
                Helper.showMessage("fill");
            }else {
                User u= User.getFetch(fld_user_uname.getText(),fld_user_pass.getText());
                if(u==null){
                    Helper.showMessage("User not found");
                }else{
                    switch (u.getType()){
                        case "operator":
                            OperatorGUI operatorGUI=new OperatorGUI((Operator) u);
                            break;
                        case "educator":
                            EducatorGUI educatorGUI=new EducatorGUI((Educator) u);
                            break;
                        case "student":
                            StudentGUI studentGUI=new StudentGUI((Student) u);
                            break;

                    }
                    dispose();

                }
            }
        });
        btn_sign_up.addActionListener(e -> {
            dispose();
            SignUpGUI signUpGUI=new SignUpGUI();

        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI loginGUI=new LoginGUI();
    }
}
