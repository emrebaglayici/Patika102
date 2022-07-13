package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Course;

import javax.swing.*;

public class ContentGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_content_name;
    private JTextField fld_content_title;
    private JTextField fld_content_desc;
    private JTextField fld_content_link;
    private JLabel lbl_title;
    private JLabel lbl_desc;
    private JLabel lbl_link;
    private JPanel pnl_left;
    private JButton btn_content_add;
    private JTextField fld_course_id;
    private JButton btn_content_delete;
    private JTextField fld_sh_course_name;
    private JTextField fld_sh_content_title;
    private JButton btn_content_sh;
    private JTable tbl_content_list;
    private JScrollPane scrl_content_list;
    private final Course course;

    public ContentGUI(Course course){
        this.course=course;
        add(wrapper);
        setSize(500, 500);
        setLocation(Helper.screenCenterPoint("x",getSize()),
                Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        lbl_content_name.setText(this.course.getName()+" content");
    }
}
