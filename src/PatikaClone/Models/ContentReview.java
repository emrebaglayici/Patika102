package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;
import PatikaClone.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContentReview {
    private int id;
    private int content_id;
    private String comment;
    private Content content;

    public ContentReview(int id, int content_id, String comment) {
        this.id = id;
        this.content_id = content_id;
        this.comment = comment;
        this.content=Content.getFetch(content_id);
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static boolean add(int content_id, String comment) {
        String query="INSERT INTO content_review(content_id,comment) VALUES(?,?)";
        try {
            PreparedStatement preparedStatement= DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,content_id);
            preparedStatement.setString(2,comment);

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
}
