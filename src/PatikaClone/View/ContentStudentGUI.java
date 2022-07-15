package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Content;
import PatikaClone.Models.ContentReview;
import PatikaClone.Models.Course;
import PatikaClone.Models.Quiz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ContentStudentGUI extends JFrame {

    private JPanel wrapper;
    private JTable tbl_sudent_content;
    private JLabel lbl_course_title;
    private JButton btn_see_quiz;
    private JButton btn_comment_submit;
    private JTextField fld_comment;

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
        lbl_course_title.setText(course.getName()+" content");
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



        btn_see_quiz.addActionListener(e -> {
            int selected_id=
                    Integer.parseInt(tbl_sudent_content.getValueAt(
                            tbl_sudent_content.getSelectedRow(),0
                    ).toString());
            QuizQuestionStudentGUI quizQuestionStudentGUI
                    =new QuizQuestionStudentGUI(Quiz.getFetch(selected_id));
            quizQuestionStudentGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadStudentContentModel();
                }
            });
        });
        btn_comment_submit.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_comment)){
                Helper.showMessage("fill");
            }else{
                int content_id=Integer.parseInt(tbl_sudent_content.getValueAt(
                        tbl_sudent_content.getSelectedRow(),0
                ).toString());
                String comment=fld_comment.getText();
                if(ContentReview.add(content_id,comment)){
                    Helper.showMessage("done");
                    loadStudentContentModel();
                    fld_comment.setText(null);
                }
            }
        });
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
