import java.util.ArrayList;
import java.util.List;

public class Tour extends Piece{


    public Tour() {
	    super('B',new Position("A1"));
    }

    public Tour(Position position, char couleur) {
	super(couleur, position);
    }

    @Override
    public String getType() {
        return "tour";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {

        /*

        * On veut stocker les positions de déplacements possibles de la pièce Tour
        * On boucle horizentalement selon les deux sens possibles de la Tour
        * On arrête la boucle dès que que La Tour croise une pièce ennemi ou alié
        * On Fait en sorte de ne prendre que des positions dont les valeurs vont de 0 à 7

        */

        ArrayList<Position> positions = new ArrayList<>();


        boolean boucle=true;
        for (int x=this.getPosition().getX()-1;boucle && x>=0;x--){

            if (plateau.getCase(new Position(x,getPosition().getY())) == null)
                positions.add(new Position(x,getPosition().getY()));
            else if (plateau.getCase(new Position(x,getPosition().getY())) != null
                    && plateau.getCase(new Position(x,getPosition().getY())).getCouleur() != getCouleur()){
                positions.add(new Position(x,getPosition().getY()));
                boucle=false;
            }
            else if (plateau.getCase(new Position(x,getPosition().getY())) != null
                    && plateau.getCase(new Position(x,getPosition().getY())).getCouleur() == getCouleur()){
                boucle=false;
            }

        }

        boucle=true;
        for (int x=this.getPosition().getX()+1;boucle && x<=7;x++){
            if (plateau.getCase(new Position(x,getPosition().getY())) == null)
                positions.add(new Position(x,getPosition().getY()));
            else if (plateau.getCase(new Position(x,getPosition().getY())) != null
                    && plateau.getCase(new Position(x,getPosition().getY())).getCouleur() != getCouleur()){
                positions.add(new Position(x,getPosition().getY()));
                boucle=false;
            }
            else if (plateau.getCase(new Position(x,getPosition().getY())) != null
                    && plateau.getCase(new Position(x,getPosition().getY())).getCouleur() == getCouleur()){
                boucle=false;
            }
        }

        /*
         * On boucle Verticalement selon les deux sens possibles de la Tour
         * On vérifie les même choses précedemments cités
         * On retourne les possitions possibles de la Tour*/

        boucle=true;
        for (int y=this.getPosition().getY()+1;boucle && y<=7;y++) {
            if (plateau.getCase(new Position(getPosition().getX(),y)) == null)
                positions.add(new Position(getPosition().getX(),y));
            else if (plateau.getCase(new Position(getPosition().getX(),y)) != null
                    && plateau.getCase(new Position(getPosition().getX(),y)).getCouleur() != getCouleur()){
                positions.add(new Position(getPosition().getX(),y));
                boucle=false;
            }
            else if (plateau.getCase(new Position(getPosition().getX(),y)) != null
                    && plateau.getCase(new Position(getPosition().getX(),y)).getCouleur() == getCouleur()){
                boucle=false;
            }

        }

        boucle=true;
        for (int y=this.getPosition().getY()-1;boucle && y>=0;y--){
            if (plateau.getCase(new Position(getPosition().getX(),y)) == null)
                positions.add(new Position(getPosition().getX(),y));
            else if (plateau.getCase(new Position(getPosition().getX(),y)) != null
                    && plateau.getCase(new Position(getPosition().getX(),y)).getCouleur() != getCouleur()){
                positions.add(new Position(getPosition().getX(),y));
                boucle=false;
            }
            else if (plateau.getCase(new Position(getPosition().getX(),y)) != null
                    && plateau.getCase(new Position(getPosition().getX(),y)).getCouleur() == getCouleur()){
                boucle=false;
            }
        }
        return positions;
    }


}
