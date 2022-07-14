package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;
import PatikaClone.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private int course_id;
    private String title;
    private String description;
    private String link;

    private Course course;

    public Content(int id, int course_id, String title, String description, String link) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.course = Course.getFetchById(course_id);

    }

    public Content() {
    }

    public static ArrayList<Content> getList(){
        ArrayList<Content> contents=new ArrayList<>();
        String query="SELECT * FROM content";
        Content obj;
        try {
            Statement statement= DbConnector.getInstance().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                obj=new Content();
                int id=resultSet.getInt("id");
                int course_id=resultSet.getInt("course_id");
                String title=resultSet.getString("title");
                String description=resultSet.getString("description");
                String link=resultSet.getString("link");
                obj=new Content(id,course_id,title,description,link);
                contents.add(obj);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return contents;
    }

    public static boolean add(int course_id, String title, String desc, String link) {
        String query="INSERT INTO content(course_id,title,description,link) VALUES(?,?,?,?)";
        Content findTitle=Content.getFetch(title);
        if(findTitle!=null){
            Helper.showMessage("This content title already used.");
            return false;
        }
        try {
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,course_id);
            pr.setString(2,title);
            pr.setString(3,desc);
            pr.setString(4,link);
            int response=pr.executeUpdate();
            if (response==-1){
                Helper.showMessage("error");
            }
            return response!=-1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    private static Content getFetch(String title) {
        Content obj=null;
        String query="SELECT * FROM content WHERE title=?";
        try{
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(query);
            pr.setString(1,title);
            ResultSet resultSet= pr.executeQuery();
            if(resultSet.next()){
                obj=new Content(
                        resultSet.getInt("id"),
                        resultSet.getInt("course_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("link")
                );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static boolean delete(int id) {
        String query="DELETE FROM content WHERE id=?";
        try {
            PreparedStatement preparedStatement=DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;

    }

    private static ArrayList<Content> getListByCourseId(int course_id) {
        ArrayList<Content> contents=new ArrayList<>();
        Content obj;
        try{
            Statement statement=DbConnector.getInstance().createStatement();
            ResultSet resultSet= statement.executeQuery(
                    "SELECT * FROM content WHERE course_id="+course_id
            );
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int courseId=resultSet.getInt("course_id");
                String title=resultSet.getString("title");
                String desc=resultSet.getString("description");
                String link=resultSet.getString("link");
                obj=new Content(id,courseId,title,desc,link);
                contents.add(obj);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return contents;
    }

    public static String searchQuery(String content_desc, String content_title) {
        String query="SELECT * FROM content WHERE description LIKE '%{{description}}%' AND title LIKE '%{{title}}%'";
        query=query.replace("{{description}}",content_desc);
        query=query.replace("{{title}}",content_title);
        return query;
    }

    public static ArrayList<Content> searchContentList(String query) {
        ArrayList<Content> contents=new ArrayList<>();
        Content obj;
        try {
            Statement statement=DbConnector.getInstance().createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                obj=new Content();
                obj.setId(resultSet.getInt("id"));
                obj.setCourse_id(resultSet.getInt("course_id"));
                obj.setTitle(resultSet.getString("title"));
                obj.setDescription(resultSet.getString("description"));
                obj.setLink(resultSet.getString("link"));
                contents.add(obj);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return contents;
    }

    public static boolean addQuiz(int content_id, String question) {
        String query="INSERT INTO quiz (content_id,question) VALUES(?,?)";
        Quiz findQuestion=Quiz.getFetch(question);
        if(findQuestion!=null){
            Helper.showMessage("This question was added before.");
            return false;
        }
        try {
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            pr.setString(2,question);
            return pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public static Content getFetch(int contentId) {
        Content obj=null;
        String query="SELECT * FROM content WHERE id=?";
        try {
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,contentId);
            ResultSet resultSet=pr.executeQuery();
            if(resultSet.next()){
                obj=new Content(resultSet.getInt("id"),
                        resultSet.getInt("course_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("link"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
