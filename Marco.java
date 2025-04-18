import java.util.ArrayList;

public class Marco {
    private string nom;
    public Zone position;
    private int energie;
    private int intelligence;
    private int sante;
    private int vitesse;
    private int force;
    public int pointDeVie;
    private List<Objet> inventaire;
    private boolean catalyseurTrouve;
    priate planete positionActuelle;


    public Marco() {
        this.nom="Marco";
        this.energie = 100;
        this.pointDeVie = 4;
        this.intelligence = 50;
        this.force=50;
        this.inventaire = new ArrayList<>();
        this.catalyseurTrouve = false;
    }
    public void seDeplacer(planete destination){
        if(this.energie>20) {
            this.positionActuelle = destination;
            this.energie -= 20;
            System.out.println("Marco s'est déplacé vers " + destination.getNom());
        }else{
            System.out.println("Pas assez d'énergie pour se déplacer !");

        }
    }
    public void utiliserUnObjet (Objet objet){
        if(inventaire.contains(objet)){
            if(objet.isEstCatalyseur()){
                this.catalyseurTrouve=true;
                System.out.println("Le catalyseur de vie a été activé!");
            }else{
                this.energie+=30;
                this.sante +=20;
                System.out.println("Marco a utilisé" + objet.getNom());
            }
            inventaire.remove(objet);
        }else{
            System.out.println("Vous n'avez pas cet objet dans votre inventaire !");
        }
    }

    public void resoudreEnigme(Enigme enigme , String reponse){
        if (enigme.verifierSolution(reponse)) {
            this.intelligence +=10;
            System.out.println("Bravo!Enigme résolue! Intelligence augmentée.")
        }else{
            this.sante-=15;
            System.out.println("Mauvaise réponse ! Santé diminuée");
        }
    }

    //Getters et setters


    public int getSante() {
        return sante;
    }

    public string getNom() {
        return nom;
    }
}
