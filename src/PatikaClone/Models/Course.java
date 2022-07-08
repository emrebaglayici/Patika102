package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;
import PatikaClone.Helper.Helper;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int patika_id;
    private String name;
    private String lang;

    private Patika patika;
    private User educator;

    public Course(int id, int user_id, int patika_id, String name, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.lang = lang;
        this.patika=Patika.getFetch(patika_id);
        this.educator=User.getFetch(user_id);
    }

    public static ArrayList<Course> getList() {
        ArrayList<Course> courseList=new ArrayList<>();
        Course obj;
        try {
            Statement statement= DbConnector.getInstance().createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM course");
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int user_id=resultSet.getInt("user_id");
                int patika_id=resultSet.getInt("patika_id");
                String name=resultSet.getString("name");
                String lang=resultSet.getString("lang");
                obj=new Course(id,user_id,patika_id,name,lang);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseList;
    }

    public static boolean add(int user_id,int patika_id,String name,String lang) {
        String query="INSERT INTO course (user_id,patika_id,name,lang) VALUES(?,?,?,?)";
        try{
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,patika_id);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,lang);
            return preparedStatement.executeUpdate()!=-1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    public static ArrayList<Course> getListByUser(int user_id) {
        ArrayList<Course> courseList=new ArrayList<>();
        Course obj;
        try {
            Statement statement= DbConnector.getInstance().createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM course WHERE user_id="+user_id);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int userID=resultSet.getInt("user_id");
                int patika_id=resultSet.getInt("patika_id");
                String name=resultSet.getString("name");
                String lang=resultSet.getString("lang");
                obj=new Course(id,user_id,patika_id,name,lang);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseList;
    }

    public static boolean delete(int id){
        String query="DELETE FROM course WHERE id= ?";
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,id);

            return preparedStatement.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean update(int id,int user_id,int patika_id,String course_name,String progLang,String patikaName,String educatorName){

        String query="UPDATE course SET user_id=?,patika_id=?,name=?,lang=? WHERE id=?";
        String query2="UPDATE patika SET name=? WHERE id=?";
        String query3="UPDATE user SET name=? WHERE id=?";
//        Course findCourse=Course.getFetch(id);
//        if (findUser!=null && findUser.getId()!=id){
//            Helper.showMessage("This username is taken");
//            return false;
//        }
//        for(Patika obj:Patika.getList()){
//            if(!findPatika.getName().equals(patika)){
//                Helper.showMessage("Invalid Patika Name");
//                return false;
//            }
//
//        }
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            PreparedStatement preparedStatement2=DbConnector.getInstance().prepareStatement(query2);
            PreparedStatement preparedStatement3=DbConnector.getInstance().prepareStatement(query3);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,patika_id);
            preparedStatement.setString(3,course_name);
            preparedStatement.setString(4,progLang);
            preparedStatement.setInt(5,id);
            preparedStatement2.setString(1,patikaName);
            preparedStatement2.setInt(2,patika_id);
            preparedStatement3.setString(1,educatorName);
            preparedStatement3.setInt(2,user_id);
            return preparedStatement.executeUpdate()!=-1 &&
                    preparedStatement2.executeUpdate()!=-1 &&
                    preparedStatement3.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }


}
