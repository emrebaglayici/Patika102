package Database;

import java.sql.*;

public class DBConn {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/university";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "123456";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
//        String sql="SELECT * FROM student";
//        String insertSql = "INSERT INTO student (student_name,student_class) VALUES('Senol',4)";
//        String prSql = "INSERT INTO student (student_name,student_class) VALUES(?,?)";
//        String update="UPDATE student SET student_name='Elif' WHERE student_id=2";
//        String updatePr="UPDATE student SET student_name=? WHERE student_id=?";
//        String sql="DELETE FROM student WHERE student_id=4";
//        String prSql="DELETE FROM student WHERE student_id=?";



        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO student (student_name,student_class) VALUES(?,?)");
            preparedStatement.setString(1,"John");
            preparedStatement.setInt(2,1);
            preparedStatement.executeUpdate();

            if(true)
                throw new SQLException();

            preparedStatement.setString(1,"Doe");
            preparedStatement.setInt(2,4);
            preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();
            connection.close();
//            Statement statement= connection.createStatement();
//            statement.executeUpdate(sql);
//            PreparedStatement preparedStatement= connection.prepareStatement(prSql);
//            preparedStatement.setInt(1,3);
//            preparedStatement.executeUpdate();
//            Statement statement=connection
//                    .createStatement();
//            statement.executeUpdate(update);
//            PreparedStatement pr= connection.prepareStatement(updatePr);
//            pr.setInt(2,1);
//            pr.setString(1,"Mehmet");
//            pr.executeUpdate();
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(prSql);
//            preparedStatement.setString(1,"Kamil");
//            preparedStatement.setInt(2,1);
//            preparedStatement.executeUpdate();
//            Statement statement = connection.createStatement();
//            System.out.println(statement.executeUpdate(insertSql));
//            ResultSet data=statement.executeQuery(sql);
//            while (data.next()){
//                System.out.println("Id : "+data.getInt("student_id"));
//                System.out.println("Name : "+data.getString("student_name"));
//                System.out.println("Class : "+data.getInt("student_class"));
//                System.out.println("--------------");
//            }
//            preparedStatement.close();
        } catch (SQLException e) {
            if(connection!=null){
                try {
                    connection.rollback();
                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
            }
            System.out.println(e.getMessage());
        }
    }
}
