package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private int content_id;
    private String question;

    private Content content;
    public Quiz(int id, int content_id, String question) {
        this.id = id;
        this.content_id = content_id;
        this.question = question;
        this.content=Content.getFetch(content_id);
    }

    public Quiz() {

    }

    public static Quiz getFetch(String question) {
        Quiz obj=null;
        String query="SELECT * FROM quiz WHERE question=?";
        try {
            PreparedStatement preparedStatement= DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1,question);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                obj=new Quiz();
                obj.setId(resultSet.getInt("id"));
                obj.setContent_id(resultSet.getInt("content_id"));
                obj.setQuestion(resultSet.getString("question"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return obj;
    }

    public static String getFetchByIdForTitle(int content_id) {
        Content obj=null;
        String query="SELECT * FROM content WHERE id=?";
        try {
            PreparedStatement preparedStatement= DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,content_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                obj=new Content();
                obj.setId(resultSet.getInt("id"));
                obj.setCourse_id(resultSet.getInt("course_id"));
                obj.setTitle(resultSet.getString("title"));
                obj.setDescription(resultSet.getString("description"));
                obj.setLink(resultSet.getString("link"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return obj.getTitle();
    }

    public static ArrayList<Quiz> getFetchByContentId(int content_id) {
        ArrayList<Quiz> quizzes=new ArrayList<>();
        Quiz obj;
        try {
            Statement statement=DbConnector.getInstance().createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM quiz WHERE content_id="+content_id);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int contentId=resultSet.getInt("content_id");
                String question=resultSet.getString("question");
                obj=new Quiz(id,contentId,question);
                quizzes.add(obj);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return quizzes;
    }

    public static Quiz getFetch(int contentId) {
        Quiz obj=null;
        String sql="SELECT * FROM quiz WHERE content_id=?";
        try {
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(sql);
            pr.setInt(1,contentId);
            ResultSet resultSet=pr.executeQuery();
            if (resultSet.next()){
                obj=new Quiz(
                        resultSet.getInt("id"),
                        resultSet.getInt("content_id"),
                        resultSet.getString("question")
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }
    public static Quiz getFetchById(int id) {
        Quiz obj=null;
        String sql="SELECT * FROM quiz WHERE id=?";
        try {
            PreparedStatement pr=DbConnector.getInstance().prepareStatement(sql);
            pr.setInt(1,id);
            ResultSet resultSet=pr.executeQuery();
            if (resultSet.next()){
                obj=new Quiz(
                        resultSet.getInt("id"),
                        resultSet.getInt("content_id"),
                        resultSet.getString("question")
                );
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

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
