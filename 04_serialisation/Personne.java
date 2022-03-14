import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Personne {
  /** attribut de personne **/
  private String prenom, nom;
  private Date naissance;

  /** constructeur de personne */
  public Personne(String p, String n, Date d) throws IOException {
    this.prenom = p;
    this.nom = n;
    this.naissance = new Date(d);
    String nom = n + " "+ p+".dat";
    BufferedWriter file = new BufferedWriter(new FileWriter(nom));
    file.write("Prenom = "+p+"\nNom = "+n);
    file.close();
  }

  /** setNom */
  public void setNom(String n){
    this.nom = n;
  }
}
