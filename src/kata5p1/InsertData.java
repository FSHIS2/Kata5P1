package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertData {
    private Connection connect() throws SQLException{
        String url = "jdbc:sqlite:email.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * This method inserts a list of valid emails
     * in email.db
     * @param list of emails 
     */
    public void insert(List <String> list){
        String sql = "INSERT INTO dir_email(Mail) VALUES(?)";
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for(String email:list){
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }
            System.out.println("Emails has been inserted");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
