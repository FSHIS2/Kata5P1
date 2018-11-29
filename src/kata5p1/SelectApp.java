package kata5p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    private Connection connect(){
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * The method selectAll() shows registers
     * of the table PEOPLE that is contained
     * in Kata5.db
     * @throws SQLException 
     */
    public void selectAll() throws SQLException{
        String sql = "SELECT * FROM PEOPLE";
        try(Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("Name") + "\t" +
                rs.getString("Apellidos") + "\t" +
                rs.getString("Departamento") + "\t");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
