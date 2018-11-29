package kata5p1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    /**
     * The method read() discards invalid emails
     * @param filename is a txt file
     * that contains valid and invalid emails
     * @return a new list of valid emails
     */
    public static List <String> read(String filename){
         List <String> list = new ArrayList <>();
         try{
             BufferedReader input =
                     new BufferedReader(new FileReader(filename));
             String token = "";
             while((token = input.readLine()) != null){
                 if(token.contains("@")){
                     list.add(token);
                 }
             }
             input.close();
         }catch(FileNotFoundException ex){
             System.out.println("Fichero no encontrado");
         }catch(IOException ex){
             System.out.println("Error al leer fichero");
        }
        return list;
    }
}
