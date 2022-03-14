import java.io.*;
import java.nio.Buffer;

public class MultiplesBin {

  /** le reel dont on veut les multiples */
  private double val;

  /** constructeur qui prend le reel en paramètre */
  public MultiplesBin(double v) {
    this.val=v;
  }


  /** methode en charge de creer et de remplir le fichier */
  public void remplirFichier(String source,int facteurMultiple) throws IOException {
    DataOutputStream sauce= new DataOutputStream(new FileOutputStream(source));
    double valeuraftercomma;
    for(int i=1;i<=facteurMultiple;i++){
      //sauce.printf("%d;%2.3f\n", i, (this.getVal()*i));
      sauce.writeInt(i);
      sauce.writeDouble(this.getVal()*i);
      sauce.writeChars("\n");
    }
    sauce.close();
  }

  public static void extraireFichier(String destination) throws IOException{
    DataInputStream fo = new DataInputStream(new FileInputStream(destination));
      int number;
      double numbah;
      boolean bon = false;
      while(!bon){
        try{
        number=fo.readInt();
        bon =(number==-1);
        System.out.println(number);
        numbah=fo.readDouble();
        bon =(number==-1);
        System.out.println(number);
        }
        catch(EOFException a){
          System.out.println("Fin du fichier ! hehe");
          System.exit(0);
        }
      }
  }

  public double getVal(){
    return this.val;
  }

  /** 
   * main permettant de tester votre méthode 
   */
  public static void main(String[] args) {
    try {
      MultiplesBin mult = new MultiplesBin((Integer.parseInt(args[0])));
      mult.remplirFichier("Fichier.bin",Integer.parseInt(args[1]));
      extraireFichier("Fichier.bin");
    }
    catch (NumberFormatException a) {
      System.out.println("Mauvais format des paramètres passés (reel, entier, String)");
    }
    catch (IOException b) {
      System.out.println("probleme a l'ouverture du fichier");
    }
  }
}
