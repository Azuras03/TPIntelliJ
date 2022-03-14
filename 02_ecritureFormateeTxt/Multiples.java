import java.io.*;

public class Multiples {

  /** le reel dont on veut les multiples */
  private double val;

  /** constructeur qui prend le reel en paramètre */
  public Multiples(double v) {
    this.val=v;
  }
  
  /** methode en charge de creer et de remplir le fichier */
  public void remplirFichier(String source,int facteurMultiple) throws IOException {
    PrintWriter sourceCSV= new PrintWriter(new FileWriter(source));
    double valeuraftercomma;
    for(int i=1;i<=facteurMultiple;i++){
      sourceCSV.printf("%d;%2.3f\n", i, (this.getVal()*i));
    }
    sourceCSV.close();
  }

  public double getVal(){
    return this.val;
  }
  /** 
   * main permettant de tester votre méthode 
   */
  public static void main(String[] args) {
    try {
      Multiples mult = new Multiples(Integer.parseInt(args[0]));
      mult.remplirFichier("Destination.csv",Integer.parseInt(args[1]));
    }
    catch(ArrayIndexOutOfBoundsException b){
      b.printStackTrace();
    }
    catch (IOException a) {
      System.out.println("Mauvais format des paramètres passés (reel, entier, String)");
    }
    catch (NullPointerException b) {
      System.out.println("probleme a l'ouverture du fichier");
    }
  }
}
