import java.util.ArrayList;

public abstract class Piece {

    // Attributs de la classe Piece
    private char couleur;
    private Position position;


    // Constructeur par défaut
    public Piece(){
        this.couleur ='B';
        this.position = new Position("A2");
    }

    // Constructeur par copie
    public Piece(Piece p){
        this.couleur= p.couleur;
        this.position= new Position(p.position);
    }

    //  Constructeur prenant le type, une couleur et une position sous la forme de deux entiers
    public Piece(char couleur,int x,int y){

        if (couleur =='B' || couleur =='N') {
            this.couleur = couleur;
            this.position = new Position(x, y);
        }
        else
            System.out.println("Erreur type couleur");
    }

    //  Constructeur prenant le type, une couleur et un objet position
    public Piece(char couleur, Position position) {

        if (couleur =='B' || couleur =='N') {
            this.couleur = couleur;
            this.position = new Position(position);
        }
        else
            System.out.println("Erreur type couleur");
    }

    // constructeur prenant en paramètre le type, une couleur, une position sous la forme d’une chaine de caractère

    public Piece(char couleur, String position) {

        if (couleur =='B' || couleur =='N') {
            this.couleur = couleur;
            this.position = new Position(position);
        }
        else
            System.out.println("Erreur type couleur");
    }

    // Méthode abstract Méthode
    public abstract String getType();


    public char getCouleur() {
        return couleur;
    }

    public void setCouleur(char couleur) {
        if (couleur =='B' || couleur =='N') {
            this.couleur = couleur;
        }
        else
            System.out.println("Erreur type couleur");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = new Position(position);
    }

    // Méthode GetNomCourt
    public String getNomCourt(){

        String first = ""+getType().charAt(0);
        char second = getType().charAt(1);

        return first.toUpperCase()+""+second+""+this.couleur;
    }

    // Méthode GetNomLong
    public String getNomLong(){
        return getType()+"_"+this.couleur;
    }



    // Méthode equals de la classe Piece
    public boolean equals(Object obj){
    	if(this == obj)
    	    return true;
    	if( !(obj instanceof Piece))
    	    return false;
    	Piece p = (Piece)(obj);

        if(this.couleur != p.couleur)
            return false;
        if(this.position != p.position)
            return false;
        return true;
    }

    //Méthode toString
    @Override
    public String toString() {
        String data;
        if (this.couleur == 'N')
            data = "noir";
        else
            data = "blanc";
        return ""+getType()+" "+data+" en "+position;
    }

    //Méthode abstraite
    public abstract ArrayList<Position> getDeplacementPossible(Plateau plateau);

}
