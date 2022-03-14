import java.io.*;

public class LectureFichier {
    public String lireFichier(String nom) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nom));
        String word;
        word = reader.readLine();
        while(reader.read()!=1){
            word+=reader.readLine();
        }
        reader.close();
        return word;
    }
}