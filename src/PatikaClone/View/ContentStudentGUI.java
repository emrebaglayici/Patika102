package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Content;
import PatikaClone.Models.Course;
import PatikaClone.Models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ContentStudentGUI extends JFrame {

    private JPanel wrapper;
    private JTable tbl_sudent_content;
    private JLabel lbl_course_title;

    private final Course course;
    private DefaultTableModel mdl_content_student_list;
    private Object[] row_student_content_list;

    public ContentStudentGUI(Course course){
        this.course=course;
        add(wrapper);
        setSize(1000,500);
        setLocation(
                Helper.screenCenterPoint("x",getSize()),
                Helper.screenCenterPoint("y",getSize())
        );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        lbl_course_title.setText(" content");
        mdl_content_student_list=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                if (column==0)
                    return false;
                return super.isCellEditable(row,column);
            }
        };

        Object[] col_student_content_list={
                "Id","Course Id","Title","Description","Youtube Link"
        };
        mdl_content_student_list.setColumnIdentifiers(col_student_content_list);
        row_student_content_list=new Object[col_student_content_list.length];
        loadStudentContentModel();

        tbl_sudent_content.setModel(mdl_content_student_list);
        tbl_sudent_content.getTableHeader().setReorderingAllowed(false);
    }

    private void loadStudentContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_sudent_content.getModel();
        clearModel.setRowCount(0);
        for (Content c:Content.getList()){
            int i=0;
            row_student_content_list[i++]=c.getId();
            row_student_content_list[i++]=c.getCourse_id();
            row_student_content_list[i++]=c.getTitle();
            row_student_content_list[i++]=c.getDescription();
            row_student_content_list[i++]=c.getLink();
            mdl_content_student_list.addRow(row_student_content_list);
        }
    }
}
