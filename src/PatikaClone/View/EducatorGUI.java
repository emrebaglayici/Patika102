package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Course;
import PatikaClone.Models.Educator;
import PatikaClone.Models.User;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JTable tbl_educator_courses;
    private JLabel lbl_welcome;

    private DefaultTableModel mdl_educator_course_list;
    private Object[] row_educator_course_list;
    private User user;
    private JPopupMenu contentMenu;
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


        contentMenu=new JPopupMenu();
        JMenuItem contentDetails=new JMenuItem("Content Details");
        contentMenu.add(contentDetails);
        contentDetails.addActionListener(e->{
            String course_name= (String) tbl_educator_courses.getValueAt(tbl_educator_courses.getSelectedRow(),0);
            if(Course.getCourseByName(course_name)!=-1){
                int select_id=Course.getCourseByName(course_name);
                ContentGUI contentGUI=new ContentGUI(Course.getFetchById(select_id));
                contentGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadEducatorModel();
                    }
                });
            }



        });
        tbl_educator_courses.setComponentPopupMenu(contentMenu);

        tbl_educator_courses.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point=e.getPoint();
                int selected_row=tbl_educator_courses.rowAtPoint(point);
                tbl_educator_courses.setRowSelectionInterval(selected_row,selected_row);
            }
        });

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
