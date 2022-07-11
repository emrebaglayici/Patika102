package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Course;
import PatikaClone.Models.Educator;
import PatikaClone.Models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JTable tbl_educator_courses;
    private JLabel lbl_welcome;

    private DefaultTableModel mdl_educator_course_list;
    private Object[] row_educator_course_list;
    private User user;
    private final Educator educator;

    public EducatorGUI(Educator educator){
        this.educator=educator;
        add(wrapper);
        setSize(700,700);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        lbl_welcome.setText("Welcome "+educator.getName());

        mdl_educator_course_list=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                if (column==0)
                    return false;
                return super.isCellEditable(row,column);
            }
        };
        Object[] col_educator_course_list={
                "Course Name","Language"
        };
       mdl_educator_course_list.setColumnIdentifiers(col_educator_course_list);
       row_educator_course_list=new Object[col_educator_course_list.length];
      loadEducatorModel();
       tbl_educator_courses.setModel(mdl_educator_course_list);
       tbl_educator_courses.getTableHeader().setReorderingAllowed(false);


    }

    private void loadEducatorModel() {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_educator_courses.getModel();
        clearModel.setRowCount(0);
        for (Course obj:Course.getListByUser(educator.getId())){
            int i=0;
            row_educator_course_list[i++]=obj.getName();
            row_educator_course_list[i++]=obj.getLang();
            mdl_educator_course_list.addRow(row_educator_course_list);
        }
    }

}
