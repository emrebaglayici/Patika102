package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Patika;
import PatikaClone.Models.Student;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane pnl_patika_list;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JLabel lbl_welcome;
    private JTable tbl_enrolled_list;
    private DefaultTableModel mdl_enrolled_patika_list;

    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private Object[] row_enrolled_list;
    private final Student student;
    private JPopupMenu enrollMenu;

    public StudentGUI(Student student) {
        this.student = student;

        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        lbl_welcome.setText("Welcome " + student.getName());

        mdl_patika_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_patika_list = {
                "ID", "Patika Name"
        };

        mdl_patika_list.setColumnIdentifiers(col_patika_list);

        row_patika_list = new Object[col_patika_list.length];
        loadPatikaModel();
        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        //End//



        //Start
        enrollMenu=new JPopupMenu();
        JMenuItem addMenu=new JMenuItem("Add");
        enrollMenu.add(addMenu);
        addMenu.addActionListener(e->{
            int select_id=
                    Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(),0).toString());
            if(!Patika.checkStudentAlreadyRegister(student.getId(),select_id)){
                if(Patika.registerCourse(student.getId(),
                        select_id,Patika.getFetch(select_id).getName(),student.getName())){

                    Helper.showMessage("done");
                    loadRefreshEnrolledPatikaModel(student.getId());
                }else{
                    Helper.showMessage("error");
                }
            }else{
                Helper.showMessage("You already register this patika.");
            }

        });

        mdl_enrolled_patika_list=new DefaultTableModel();
        Object[] col_enrolled_list={
                "ID","Patika Name"
        };
        mdl_enrolled_patika_list.setColumnIdentifiers(col_enrolled_list);
        row_enrolled_list=new Object[col_enrolled_list.length];
        loadStudentEnrolledPatikaModel(student.getId());
        tbl_enrolled_list.setModel(mdl_enrolled_patika_list);
        tbl_patika_list.setComponentPopupMenu(enrollMenu);
        tbl_enrolled_list.getTableHeader().setReorderingAllowed(false);



        tbl_patika_list.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point=e.getPoint();
                int selected_row=tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });



    }

    private void loadRefreshEnrolledPatikaModel(int id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_enrolled_list.getModel();
        clearModel.setRowCount(0);
        ArrayList<Patika> enrolled_list=Patika.getEnrolledList(id);
        int i;
        for (Patika obj:enrolled_list){
            i=0;
            row_enrolled_list[i++]=obj.getId();
            row_enrolled_list[i++]=obj.getName();
            mdl_enrolled_patika_list.addRow(row_enrolled_list);
        }
    }


    private void loadStudentEnrolledPatikaModel(int student_id) {
        int i = 0;
        for (Patika obj : Patika.getEnrolledList(student_id)) {
            i = 0;
            row_enrolled_list[i++] = obj.getId();
            row_enrolled_list[i++] = obj.getName();
            mdl_enrolled_patika_list.addRow(row_enrolled_list);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);

        for (Patika obj : Patika.getList()) {
            int i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }


}
