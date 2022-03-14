import java.io.*;

public class Grep {
    /** Nom du fichier a ouvrir. */
    private String nomFichier;

    /** Mot recherche. */
    private String motCherche;

    /** BufferedReader correspondant a nomfich. */
    private BufferedReader src;

    public String getNomFichier() {
        return nomFichier;
    }

    public String getMotCherche() {
        return motCherche;
    }

    public BufferedReader getSrc() {
        return src;
    }

    /**
     * Constructeur de la classe Grep. Initialise certains attributs,
     * ouvre le fichier et crée le BufferedReader correspondant
     *
     * @param nom nom du fichier a lire
     * @param mot mot recherche dans le fichier
     * @exception FileNotFoundException fichier non trouvé
     *
     **/
    public Grep(String nom, String mot) throws FileNotFoundException {
        this.nomFichier=nom;
        this.motCherche=mot;
        this.src=new BufferedReader(new FileReader(nom));
    }
    

    /**
     * methode traiterFichier qui traite le fichier
     * - lit les lignes une par une et les numerote
     * - si le mot est présent dans la ligne en cours
     *      - affiche le fichier traité
     *      - affiche le numero de ligne
     *      - affiche le caractère ou se trouve le mot
     *      - affiche la ligne elle-meme
     *  @exception IOException erreur de lecture
     */
    public void traiterFichier() throws IOException{
        String ligne = this.src.readLine();
        int result = ligne.indexOf(ligne);
        int i = 1;
        while (ligne != null){
                result = ligne.indexOf(this.motCherche);
                i++;
                if (result!=-1){
                    System.out.println(this.nomFichier+" : ("+i+";"+result+") "+ligne);
                }
            ligne = this.src.readLine();
        }
    }

    /**
     * la methode close ferme le BufferedReader correspondant 
     * au fichier.
     **/
    public void close() throws IOException{
        this.src.close();
    }

    /*****************************************************
     * Gestion du lancement / partie Main
     * Methodes statiques
     *****************************************************/
public static void main(String[] args){
    if (args.length<2){
        System.out.println("Dommage, trop grand.");
        System.exit(1);
    }
    mainReal(args);
}
    /**
     * la methode statique lireFichier
     * - cree un objet Grep à partir d'un nom de fichier et du mot recherché
     * - utilise cet objet Grep pour parcourir le fichier et réaliser les impressions demandées
     * - ne pas oublier de fermer le flux
     * Cette méthode doit signaler les noms de fichier inexistants
     *
     * @param nom nom du fichier à analyser
     * @param mot mot recherche
     * @exception IOException exception liée aux entrées/sorties
     */
    public static void lireFichier(String nom, String mot) throws IOException{
        Grep fichierRecherche = new Grep(nom, mot);
        fichierRecherche.traiterFichier();
        fichierRecherche.close();
    }



    /**
     * Methode statique main.
     * - analyse la ligne de commande (variable args)
     * - appelle la methode litFichier sur chacun des noms de fichiers fournis en argument.
     *
     * @param args ligne de commandes
     */
    public static void mainReal(String[] args){
        for(int i =1;i<args.length;i++){
        try{
            lireFichier(args[i], args[0]);
        }
        catch (FileNotFoundException a){
            System.out.println("Le fichier "+args[i]+" n'existe pas");
        }
        catch (IOException a){
            System.out.println("Cela ne fonctionne pas...");
        }
    }
    }
}
