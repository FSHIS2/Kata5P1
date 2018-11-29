package kata5p1;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import static kata5p1.MailListReader.read;
public class Kata5P1 {

    public static void main(String[] args) throws SQLException {
        SelectApp app = new SelectApp();
        app.selectAll();
        createNewTable();
        String path = "email.txt";
        List <String> list = read(path);
        InsertData data = new InsertData();
        data.insert(list);
    }
    /**
     * This method creates a table
     * in a new database
     */
    public static void createNewTable(){
        String url = "jdbc:sqlite:email.db";
        String sql = "CREATE TABLE IF NOT EXISTS dir_email(\n"
                + "Id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "Mail text NOT NULL);";
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Table created");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
