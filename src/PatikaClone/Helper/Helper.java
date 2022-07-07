package PatikaClone.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout(){
        for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
    public static int screenCenterPoint(String axis, Dimension size) {
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point=0;
        }
        return point;
    }
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
    public static void showMessage(String str){
        optionPaneTR();
        String msg;
        String title;
        switch (str){
            case "fill":
                msg="Please fill all fields";
                title="Error occurred";
                break;
            case "done":
                msg="Success.";
                title="Result";
                break;
            case "error":
                msg="Error occurred";
                title="Error !";
            case "sameusername":
                msg="This username is taken";
                title="Error";
            default:
                msg=str;
                title="Message";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }

    public static boolean confirm(String str) {
        optionPaneTR();
        String msg;
        switch (str){
            case "sure":
                msg="Are you sure ?";
                break;
            default:
                msg=str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Last Call ?",JOptionPane.YES_NO_OPTION)==0;
    }
}
