package PatikaClone.View;

import PatikaClone.Helper.Helper;

import javax.swing.*;
import java.awt.*;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    public OperatorGUI(){
        add(wrapper);
        setSize(1000,500);
        int x= Helper.screenCenterPoint("x",getSize());
        int y=Helper.screenCenterPoint("y",getSize());


    }
}
