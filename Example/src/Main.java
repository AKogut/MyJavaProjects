import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
            try{
                File file = new File ("google.bat");
                if(!file.exists())
                    file.createNewFile();
                
                PrintWriter pw = new PrintWriter(file);
                pw.println("start www.google.com");
                pw.println("exit");
                pw.close();
                
            }catch(IOException e){
                System.out.print("Error" + e);
            }
    }
    
}
