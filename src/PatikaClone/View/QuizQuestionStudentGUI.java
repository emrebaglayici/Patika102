package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.*;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class QuizQuestionStudentGUI extends JFrame{
    private JPanel wrapper;
    private JTable tbl_quiz_content_student;
    private JLabel lbl_title;
    private JTextField fld_quiz_id;
    private JButton btn_answer_submit;
    private JTextField fld_answer;
    private DefaultTableModel mdl_student_quiz_list;
    private Object[] row_student_quiz_list;
    private final Quiz quiz;

    public QuizQuestionStudentGUI(Quiz quiz){
        this.quiz=quiz;
        add(wrapper);
        setSize(800,300);
        setLocation(
                Helper.screenCenterPoint("x",getSize()),
                Helper.screenCenterPoint("y",getSize())
        );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_title.setText(Quiz.getFetchByIdForTitle(quiz.getContent_id())+ "quiz questions");

        mdl_student_quiz_list=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_student_quiz_list={
                "Id","Content Title","Question"
        };

        mdl_student_quiz_list.setColumnIdentifiers(col_student_quiz_list);
        row_student_quiz_list=new Object[col_student_quiz_list.length];
        loadQuizModelByContentId(quiz.getContent_id());
        tbl_quiz_content_student.setModel(mdl_student_quiz_list);
        tbl_quiz_content_student.getTableHeader().setReorderingAllowed(false);

        tbl_quiz_content_student.getSelectionModel().addListSelectionListener(e->{
            try{
                String quiz_id=
                        tbl_quiz_content_student.getValueAt(
                                tbl_quiz_content_student.getSelectedRow(),0
                        ).toString();
                fld_quiz_id.setText(quiz_id);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        });

        tbl_quiz_content_student.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point=e.getPoint();
                int selected_row=tbl_quiz_content_student.rowAtPoint(point);
                tbl_quiz_content_student.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        btn_answer_submit.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_quiz_id)|| Helper.isFieldEmpty(fld_answer)){
                Helper.showMessage("fill");
            }else{
                int quiz_id=Integer.parseInt(fld_quiz_id.getText());
                String answer=fld_answer.getText();
                int content_id=Quiz.getFetchById(quiz_id).getContent_id();
                int course_id= Content.getFetch(content_id).getCourse_id();
                int user_id=Course.getFetchByCourseId(course_id).getUser_id();
                if (UserAnswer.add(quiz_id,answer,user_id)){
                    Helper.showMessage("done");
                    loadQuizModelByContentId(quiz.getContent_id());
                    fld_answer.setText(null);
                }

            }
        });
    }

    private void loadQuizModelByContentId(int content_id) {
        DefaultTableModel clearModel=(DefaultTableModel)
                tbl_quiz_content_student.getModel();
        clearModel.setRowCount(0);
        ArrayList<Quiz> quizzes=Quiz.getFetchByContentId(content_id);
        int i;
        for (Quiz obj:quizzes){
            i=0;
            row_student_quiz_list[i++]=obj.getId();
            row_student_quiz_list[i++]=Quiz.getFetchByIdForTitle(obj.getContent_id());
            row_student_quiz_list[i++]=obj.getQuestion();
            mdl_student_quiz_list.addRow(row_student_quiz_list);
        }
    }

}
