package PatikaClone.Models;

import PatikaClone.Helper.DbConnector;
import PatikaClone.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAnswer {
    private int id;
    private int user_id;
    private int quiz_id;
    private String answer;

    private User user;
    private Quiz quiz;

    public UserAnswer(int id, int user_id, int quiz_id, String answer) {
        this.id = id;
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.answer = answer;
        this.user=User.getFetch(user_id);
        this.quiz=Quiz.getFetchById(quiz_id);
    }


    public static boolean add(int quiz_id, String answer,int user_id) {
        String query="INSERT INTO user_answer(user_id,quiz_id,answer) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement= DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,quiz_id);
            preparedStatement.setString(3,answer);

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
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

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
