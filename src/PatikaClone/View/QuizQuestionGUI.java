package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Content;
import PatikaClone.Models.Quiz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class QuizQuestionGUI extends JFrame {
    private JPanel wrapper;
    private JTable tbl_quiz;
    private JLabel lbl_content_title;
    private DefaultTableModel mdl_quiz_list;
    private Object[] row_quiz_list;
//    private final Content content;
    private final Quiz quiz;
    public QuizQuestionGUI(Quiz quiz){
        this.quiz=quiz;
        add(wrapper);
        setSize(800,300);
        setLocation(Helper.screenCenterPoint("x",getSize()), Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_content_title.setText(Quiz.getFetchByIdForTitle(quiz.getContent_id())+" quiz questions");

        mdl_quiz_list=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_quiz_list={
                "ID","Content Title","Question"
        };

        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);
        row_quiz_list=new Object[col_quiz_list.length];
        loadQuizModelByContentId(quiz.getContent_id());
        tbl_quiz.setModel(mdl_quiz_list);
        tbl_quiz.getTableHeader().setReorderingAllowed(false);

    }

    private void loadQuizModelByContentId(int content_id) {
        DefaultTableModel clearModel=(DefaultTableModel)
                tbl_quiz.getModel();
        clearModel.setRowCount(0);
        ArrayList<Quiz> quizzes=Quiz.getFetchByContentId(content_id);
        int i;
        for (Quiz obj:quizzes){
            i=0;
            row_quiz_list[i++]=obj.getId();
            row_quiz_list[i++]=Quiz.getFetchByIdForTitle(obj.getContent_id());
            row_quiz_list[i++]=obj.getQuestion();
            mdl_quiz_list.addRow(row_quiz_list);
        }


    }
}
