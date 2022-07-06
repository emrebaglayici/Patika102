package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;
import PatikaClone.Helper.Helper;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String type;

    public User(Integer id, String name, String username,String password, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password=password;
        this.type = type;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList(){
        ArrayList<User> arrayList=new ArrayList<>();
        String query="SELECT * FROM user";
        User obj;
        try {
            Statement statement= DbConnector.getInstance().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                obj=new User();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setUsername(resultSet.getString("uname"));
                obj.setPassword(resultSet.getString("pass"));
                obj.setType(resultSet.getString("type"));
                arrayList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public static boolean add(String name,String username,String password,String type){

        String query="INSERT INTO user(name,uname,pass,type) VALUES(?,?,?,?)";
        User findUser=User.getFetch(username);
        if (findUser!=null){
            Helper.showMessage("This username is taken");
            return false;
        }
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,type);

            int response=preparedStatement.executeUpdate();
            if(response==-1){
                Helper.showMessage("error");
            }
            return response!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return true;
    }
    public static User getFetch(String uname){
        User obj=null;
        String query="SELECT * FROM user WHERE uname=?";
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1,uname);
            ResultSet  resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                obj=new User();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setUsername(resultSet.getString("uname"));
                obj.setPassword(resultSet.getString("pass"));
                obj.setType(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return obj;
    }

    public static boolean delete(int id){
        String query="DELETE FROM user WHERE id= ?";
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean update(int id,String name,String uname,String password,String type){
        String query="UPDATE user SET name=?,uname=?,pass=?,type=? WHERE id=?";
        User findUser=User.getFetch(uname);
        if (findUser!=null && findUser.getId()!=id){
            Helper.showMessage("This username is taken");
            return false;
        }
        for(User obj:getList()){
            if(!obj.getType().equals(type)){
                Helper.showMessage("Type geçerli değil");
                return false;
            }
        }
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,uname);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,type);
            preparedStatement.setInt(5,id);
            return preparedStatement.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static ArrayList<User> searchUserList(String query){
        ArrayList<User> userList=new ArrayList<>();
        User obj;
        try {
            Statement statement= DbConnector.getInstance().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                obj=new User();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setUsername(resultSet.getString("uname"));
                obj.setPassword(resultSet.getString("pass"));
                obj.setType(resultSet.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static String searchQuery(String name,String uname,String type){
        String query="SELECT * FROM user WHERE uname LIKE '%{{uname}}%' AND name LIKE '%{{name}}%'";
        query=query.replace("{{uname}}",uname);
        query=query.replace("{{name}}",name);
        if(!type.isEmpty()){
            query+= " AND type='{{type}}'";
            query=query.replace("{{type}}",type);

        }

        return query;
    }

}
