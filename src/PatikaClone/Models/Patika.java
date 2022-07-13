package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static boolean checkStudentAlreadyRegister(int student_id,int patika_id) {
        for (Patika p:Patika.getEnrolledList(student_id)){
            if(p.getId()==patika_id)
                return true;
        }
        return false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Patika> getList() {
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM patika");
            while (resultSet.next()) {
                obj = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
                patikaList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patikaList;
    }

    public static ArrayList<Patika> getEnrolledList(int user_id){
        ArrayList<Patika> enrolled=new ArrayList<>();
        Patika obj;
        try {
            Statement statement=DbConnector.getInstance().createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM enrolled_user WHERE user_id="+user_id);
            while (resultSet.next()){
                obj=new Patika(resultSet.getInt("patika_id"),resultSet.getString("patika_name"));
                enrolled.add(obj);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return enrolled;
    }

    public static ArrayList<Patika> getEnrolledListByName(String user_name){
        ArrayList<Patika> enrolled=new ArrayList<>();
        Patika obj;
        try {
            Statement statement=DbConnector.getInstance().createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM enrolled_user WHERE user_name="+user_name);
            while (resultSet.next()){
                obj=new Patika(
                        resultSet.getInt("patika_id"),
                        resultSet.getString("patika_name"));
                enrolled.add(obj);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return enrolled;
    }

    public static boolean add(String name) {
        String query = "INSERT INTO patika (name) VALUES(?)";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean registerCourse(int user_id,
                                         int patika_id,String patika_name,
                                         String user_name) {
        String query="INSERT INTO enrolled_user (user_id,patika_id,patika_name,user_name) VALUES(?,?,?,?)";
        try{
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,patika_id);
            pr.setString(3,patika_name);
            pr.setString(4,user_name);
            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();;
        }
        return true;
    }

    public static boolean update(int id, String name) {
        String query = "UPDATE patika SET name = ? WHERE id=?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Patika getFetch(int id) {
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE id=?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                obj = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }





    public static Patika getFetch(String name) {
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE name=?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                obj = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM patika WHERE id=?";
        ArrayList<Course> courseList=Course.getList();
        for (Course obj:courseList){
            if(obj.getPatika().getId()==id){
                Course.delete(obj.getId());
            }
        }
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
