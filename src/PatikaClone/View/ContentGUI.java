package PatikaClone.View;

import PatikaClone.Helper.Config;
import PatikaClone.Helper.Helper;
import PatikaClone.Models.Content;
import PatikaClone.Models.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

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
    private JTextField fld_content_id;
    private JButton btn_content_delete;
    private JTextField fld_sh_content_desc;
    private JTextField fld_sh_content_title;
    private JButton btn_content_sh;
    private JTable tbl_content_list;
    private JScrollPane scrl_content_list;
    private JTextField textField1;
    private DefaultTableModel mdl_content_list;
    private Object[] row_content_list;
    private final Course course;

    public ContentGUI(Course course){
        this.course=course;
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x",getSize()),
                Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        lbl_content_name.setText(this.course.getName()+" content");

        mdl_content_list=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                if (column==0)
                    return false;
                return super.isCellEditable(row,column);
            }
        };
        Object[] col_content_list={
                "Id","Course Id","Title","Description","Youtube Link"
        };
        mdl_content_list.setColumnIdentifiers(col_content_list);
        row_content_list=new Object[col_content_list.length];
        loadContentModel();

        tbl_content_list.setModel(mdl_content_list);
        tbl_content_list.getTableHeader().setReorderingAllowed(false);

        tbl_content_list.getSelectionModel().addListSelectionListener(e->{
            try{
                String select_course_id=tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),0).toString();
                fld_content_id.setText(select_course_id);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        });

        btn_content_add.addActionListener(e->{
            if (Helper.isFieldEmpty(fld_content_title)||Helper.isFieldEmpty(fld_content_desc)
            ||Helper.isFieldEmpty(fld_content_link)){
                Helper.showMessage("fill");
            }else{
                int course_id=course.getId();
                String title=fld_content_title.getText();
                String desc=fld_content_desc.getText();
                String link=fld_content_link.getText();
                if (Content.add(course_id,title,desc,link)){
                    Helper.showMessage("done");
                    loadContentModel();
                    fld_content_title.setText(null);
                    fld_content_desc.setText(null);
                    fld_content_link.setText(null);
                }
            }
        });

        btn_content_delete.addActionListener(e->{
            if (Helper.isFieldEmpty(fld_content_id)){
                Helper.showMessage("fill");
            }else{
                if (Helper.confirm("sure")){
                    int content_id=Integer.parseInt(fld_content_id.getText());
                    if (Content.delete(content_id)){
                        Helper.showMessage("done");
                        loadContentModel();
                        fld_content_id.setText(null);
                    }else{
                        Helper.showMessage("error");
                    }
                }
            }
        });
        btn_content_sh.addActionListener(e->{
            String content_desc= fld_sh_content_desc.getText();
            String content_title=fld_sh_content_title.getText();
            String query=Content.searchQuery(content_desc,content_title);
            loadContentModel(Content.searchContentList(query));

        });
    }

    private void loadContentModel() {
        DefaultTableModel clearmodel=(DefaultTableModel) tbl_content_list.getModel();
        clearmodel.setRowCount(0);
        for (Content c:Content.getList()){
            int i=0;
            row_content_list[i++]=c.getId();
            row_content_list[i++]=c.getCourse_id();
            row_content_list[i++]=c.getTitle();
            row_content_list[i++]=c.getDescription();
            row_content_list[i++]=c.getLink();
            mdl_content_list.addRow(row_content_list);
        }
    }
    private void loadContentModel(ArrayList<Content> list) {
        DefaultTableModel clearmodel=(DefaultTableModel) tbl_content_list.getModel();
        clearmodel.setRowCount(0);
        for (Content c:list){
            int i=0;
            row_content_list[i++]=c.getId();
            row_content_list[i++]=c.getCourse_id();
            row_content_list[i++]=c.getTitle();
            row_content_list[i++]=c.getDescription();
            row_content_list[i++]=c.getLink();
            mdl_content_list.addRow(row_content_list);
        }
    }

}
