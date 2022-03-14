import java.io.*;
import java.nio.ReadOnlyBufferException;

public class CopieFichierTexte {

  /**
   * nom des fichiers source et destination
   */
  private String source;
  private String destination;

  /**
   * constructeur
   **/
  public CopieFichierTexte(String s, String d) {
    this.source = s;
    this.destination = d;
  }

  /**
   * effectue une copie caractère par caractère
   */
  public void copierLignes() throws IOException {
    BufferedReader fileS = new BufferedReader(new FileReader(getSource()));
    BufferedWriter fileD = new BufferedWriter(new FileWriter(getDestination()));
    String ligne = fileS.readLine();
    while (ligne != null) {
      fileD.write(ligne);
      System.out.println(ligne);
      fileD.newLine();
      ligne = fileS.readLine();
    }
    fileD.close();
    fileS.close();
  }

  /**
   * effectue une copie ligne par ligne
   */
  public void copierCaracteres() throws IOException {
    BufferedReader fileS = new BufferedReader(new FileReader(getSource()));
    BufferedWriter fileD = new BufferedWriter(new FileWriter(getDestination()));
    int ligne = fileS.read();
    while (ligne != -1) {
      fileD.write(ligne);
      System.out.println(ligne);
      ligne = fileS.read();
    }
    fileD.close();
    fileS.close();
  }

  /**
   * Getter pour la source
   * @return la source de copie du fichier
   */
  public String getSource() {
    return this.source;
  }

  /**
   * Getter pour la destination
   * @return la destination de copie du fichier
   */
  public String getDestination() {
    return this.destination;
  }

  /**
   * main permettant de tester que les copies fonctionnent bien
   */
  public static void main(String[] args) {
    try {
      CopieFichierTexte file = new CopieFichierTexte("file1.txt", "file2.txt");
      file.copierLignes();
    } catch (IOException a) {
      System.out.println("erreur a l'ouverture des flux");
    } catch (NullPointerException b) {
      System.out.println("erreur lors des lectures/ecritures");
    }
    }
  }