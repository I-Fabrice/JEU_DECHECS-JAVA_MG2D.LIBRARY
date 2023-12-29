import java.util.ArrayList;

public class Plateau {

    // Attributs de la classe Plateau
    public ArrayList<Piece> tableau;

    // Constructeur par défaut
    public Plateau(){
	tableau = new ArrayList<Piece>();
	
	    this.tableau.add(new Tour(new Position(0,0),'B'));
        this.tableau.add(new Cavalier(new Position(1,0),'B'));
        this.tableau.add(new Fou(new Position(2,0),'B'));
        this.tableau.add(new Reine(new Position(3,0),'B'));
        this.tableau.add(new Roi(new Position(4,0),'B'));
        this.tableau.add(new Fou(new Position(5,0),'B'));
        this.tableau.add(new Cavalier(new Position(6,0),'B'));
        this.tableau.add(new Tour(new Position(7,0),'B'));
        this.tableau.add(new Tour(new Position(0,7),'N'));
        this.tableau.add(new Cavalier(new Position(1,7),'N'));
        this.tableau.add(new Fou(new Position(2,7),'N'));
        this.tableau.add(new Roi(new Position(3,7),'N'));
        this.tableau.add(new Reine(new Position(4,7),'N'));
        this.tableau.add(new Fou(new Position(5,7),'N'));
        this.tableau.add(new Cavalier(new Position(6,7),'N'));
        this.tableau.add(new Tour(new Position(7,7),'N'));
               
        for(int x = 0 ; x<8; x++){
	        this.tableau.add(new PionBlanc(new Position(x,1)));
            this.tableau.add(new PionNoir(new Position(x,6)));
	    }
  

    }


    /*public Plateau(){
        tableau = new ArrayList<Piece>();

        this.tableau.add(new Tour(new Position(5,5),'B'));

        this.tableau.add(new Roi(new Position(4,0),'B'));
        this.tableau.add(new Roi(new Position(3,7),'N'));

        this.tableau.add(new Tour(new Position(7,7),'N'));
    }*/

    // Getters & Setters
    public ArrayList<Piece> getTableau() {
	return tableau;
    }

    public void setTableau(ArrayList<Piece> tableau) {
	this.tableau = tableau;
    }

    // Méthode getCase avec un objet de type position
    public Piece getCase(Position position){
	     for (Piece data : this.getTableau() ) {
	        if(position.getX()==data.getPosition().getX() && position.getY()==data.getPosition().getY())
		        return data;
	     }
	      return null;
    }

    // Méthode getCase avec deux entiers en paramètres
    public Piece getCase(int x, int y){
        for (Piece data : this.getTableau() ) {
            if(x==data.getPosition().getX() && y==data.getPosition().getY())
                return data;
        }
        return null;
    }

    // Méthode getCase avec une chaine de caractère en paramètre
    public Piece getCase(String position){
        Position position1 = new Position(position);
        return getCase(position1);
    }

    // ToString de la classe Plateau

    @Override
    public String toString() {

	int x=-1;
	for (Piece data  : this.tableau
	     ) {
	    if(x==7){
		System.out.println("");
		x=-1;
	    }
	    if (data==null){
		System.out.print("null");
	    }
	    else {
		System.out.print(data.getNomCourt());
	    }
	    x++;
	}


	return "";
    }

    // Méthode getPiecesBlanches
    public ArrayList<Piece> getPiecesBlanches(ArrayList<Piece> tableau){
	ArrayList<Piece> PieceBlanche= new ArrayList<>();
	for (Piece data : tableau
	     ) {
	    if(data.getCouleur()=='B')
		  PieceBlanche.add(data);
	}

	return PieceBlanche;
    }

    // Méthode getPiecesNoires
    public ArrayList<Piece> getPiecesNoires(ArrayList<Piece> tableau){
	ArrayList<Piece> PieceNoires= new ArrayList<>();
	for (Piece data : tableau
	     ) {
	    if(data.getCouleur()=='N')
		  PieceNoires.add(data);
	}

	return PieceNoires;
    }


    //Méthode déplacer pièce
    public boolean deplacer(Position from, Position to){

        if (getCase(from)!=null){
            Piece piece = getCase(from);
            ArrayList<Position> positions = piece.getDeplacementPossible(this);

            for (Position position : positions){
                if (position.getX()==to.getX() && position.getY()==to.getY()){


                    for (int i=0;i<this.getTableau().size();i++){

                        if (this.getTableau().get(i).getPosition().getX()==to.getX() && this.getTableau().get(i).getPosition().getY()==to.getY()){
                            this.tableau.remove(this.getTableau().get(i));
                        }
                    }

                    for (int i=0;i<this.getTableau().size();i++){

                        if (this.getTableau().get(i).getPosition().getX()==piece.getPosition().getX() && this.getTableau().get(i).getPosition().getY()==piece.getPosition().getY()){
                            this.tableau.get(i).setPosition(to);
                        }
                    }

                        return true;
                }
            }

        }


        return false;
    }

    //Méthode estEchec
    public boolean estEchec(char couleur){
        if ((getRoi(couleur)).getCouleur()=='N'){
            for (Piece piece : getPiecesBlanches(this.getTableau())
                 ) {
                for (Position position : piece.getDeplacementPossible(this)
                     ) {
                    if (position.getX()==getRoi(couleur).getPosition().getX() && position.getY()==getRoi(couleur).getPosition().getY()){
                        return true;
                    }
                }
            }
        }
        else if ((getRoi(couleur)).getCouleur()=='B'){
            for (Piece piece : getPiecesNoires(this.getTableau())
            ) {
                for (Position position : piece.getDeplacementPossible(this)
                     ) {
                    if (position.getX()==getRoi(couleur).getPosition().getX() && position.getY()==getRoi(couleur).getPosition().getY()){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //Méthode getRoi
    public Piece getRoi(char couleur){
        for (Piece piece :this.getTableau()
             ) {
            if (piece.getType().equals("roi") && piece.getCouleur()==couleur){
                return piece;
            }
        }
        return null;
    }

}
