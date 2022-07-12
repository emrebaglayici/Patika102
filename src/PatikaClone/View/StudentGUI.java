package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Patika;
import PatikaClone.Models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        //Continue here
        enrollMenu=new JPopupMenu();
        JMenuItem addMenu=new JMenuItem("Add");
        enrollMenu.add(addMenu);
        addMenu.addActionListener(e->{

        });

        mdl_enrolled_patika_list=new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }

        };
        Object[] col_enrolled_list={
                "ID","Patika Name"
        };
        mdl_enrolled_patika_list.setColumnIdentifiers(col_enrolled_list);

        row_enrolled_list=new Object[col_enrolled_list.length];
        loadStudentPatikaModel(student.getId());

        tbl_enrolled_list.setModel(mdl_enrolled_patika_list);
        tbl_enrolled_list.getTableHeader().setReorderingAllowed(false);
//        tbl_enrolled_list.getColumnModel().getColumn(0).setMaxWidth(75);




    }

    private void loadStudentPatikaModel(int student_id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        ArrayList<Patika> usersPatikas = new ArrayList<>();
        usersPatikas.add(Patika.getFetch(student_id));
//        Patika usersPatikas=Patika.getFetch(student_id);
        int i = 0;
        for (Patika obj : Patika.getList()) {
            i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Patika obj : Patika.getList()) {
            i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }


}
