import java.util.ArrayList;

public class Reine extends Piece{


    public Reine() {
        super('B',new Position("A1"));
    }

    public Reine(Position position, char couleur) {
        super(couleur,position);
    }

    @Override
    public String getType() {
        return "reine";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {

        /*
         *  */

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

        int nbrXmax=(7-this.getPosition().getX());
        int nbrYmax=(7-this.getPosition().getY());

        int x = getPosition().getX();
        int y = getPosition().getY();

        // Positions Ligne Haute Droite
        if (nbrXmax<nbrYmax){

            boucle=true;

            for (int nbr=1;boucle && nbr<=nbrXmax;nbr++){

                if (plateau.getCase(new Position(x+nbr,y+nbr))==null)
                    positions.add(new Position(x+nbr,y+nbr));
                else if (plateau.getCase(new Position(x+nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y+nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x+nbr,y+nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x+nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y+nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else if (nbrXmax>nbrYmax){
            boucle=true;

            for (int nbr=1;boucle && nbr<=nbrYmax;nbr++){

                if (plateau.getCase(new Position(x+nbr,y+nbr))==null)
                    positions.add(new Position(x+nbr,y+nbr));
                else if (plateau.getCase(new Position(x+nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y+nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x+nbr,y+nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x+nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y+nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else {

            boucle=true;

            for (int nbr=1;boucle && nbr<=nbrXmax;nbr++){

                if (plateau.getCase(new Position(x+nbr,y+nbr))==null)
                    positions.add(new Position(x+nbr,y+nbr));
                else if (plateau.getCase(new Position(x+nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y+nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x+nbr,y+nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x+nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y+nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }

        //Positions Ligne Haute Gauche
        if (this.getPosition().getX()>nbrYmax){
            boucle=true;
            for (int nbr=1;boucle && nbr<=nbrYmax;nbr++){
                if (plateau.getCase(new Position(x-nbr,y+nbr))==null)
                    positions.add(new Position(x-nbr,y+nbr));
                else if (plateau.getCase(new Position(x-nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y+nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x-nbr,y+nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x-nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y+nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else if (this.getPosition().getX()<nbrYmax){
            boucle=true;
            for (int nbr=1;boucle && nbr<=this.getPosition().getX();nbr++){
                if (plateau.getCase(new Position(x-nbr,y+nbr))==null)
                    positions.add(new Position(x-nbr,y+nbr));
                else if (plateau.getCase(new Position(x-nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y+nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x-nbr,y+nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x-nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y+nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else {

            boucle=true;
            for (int nbr=1;boucle && nbr<=this.getPosition().getX();nbr++){
                if (plateau.getCase(new Position(x-nbr,y+nbr))==null)
                    positions.add(new Position(x-nbr,y+nbr));
                else if (plateau.getCase(new Position(x-nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y+nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x-nbr,y+nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x-nbr,y+nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y+nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }

        }

        //Positions Ligne Basse Gauche
        if (this.getPosition().getX()<this.getPosition().getY()){
            boucle=true;

            for (int nbr=1;boucle && nbr<=this.getPosition().getX();nbr++){
                if (plateau.getCase(new Position(x-nbr,y-nbr))==null)
                    positions.add(new Position(x-nbr,y-nbr));
                else if (plateau.getCase(new Position(x-nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y-nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x-nbr,y-nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x-nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y-nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else if (this.getPosition().getX()>this.getPosition().getY()){
            boucle=true;

            for (int nbr=1;boucle && nbr<=this.getPosition().getY();nbr++){
                if (plateau.getCase(new Position(x-nbr,y-nbr))==null)
                    positions.add(new Position(x-nbr,y-nbr));
                else if (plateau.getCase(new Position(x-nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y-nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x-nbr,y-nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x-nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y-nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else {
            boucle=true;

            for (int nbr=1;boucle && nbr<=this.getPosition().getX();nbr++){
                if (plateau.getCase(new Position(x-nbr,y-nbr))==null)
                    positions.add(new Position(x-nbr,y-nbr));
                else if (plateau.getCase(new Position(x-nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y-nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x-nbr,y-nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x-nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x-nbr,y-nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }


        }

        //Positions Ligne Basse Droite
        if (nbrXmax<this.getPosition().getY()){
            boucle=true;

            for (int nbr=1;boucle && nbr<=nbrXmax;nbr++){
                if (plateau.getCase(new Position(x+nbr,y-nbr))==null)
                    positions.add(new Position(x+nbr,y-nbr));
                else if (plateau.getCase(new Position(x+nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y-nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x+nbr,y-nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x+nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y-nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }

        }
        else if (nbrXmax>this.getPosition().getY()){
            boucle=true;

            for (int nbr=1;boucle && nbr<=getPosition().getY();nbr++){
                if (plateau.getCase(new Position(x+nbr,y-nbr))==null)
                    positions.add(new Position(x+nbr,y-nbr));
                else if (plateau.getCase(new Position(x+nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y-nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x+nbr,y-nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x+nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y-nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }
        }
        else {

            boucle=true;

            for (int nbr=1;boucle && nbr<=nbrXmax;nbr++){
                if (plateau.getCase(new Position(x+nbr,y-nbr))==null)
                    positions.add(new Position(x+nbr,y-nbr));
                else if (plateau.getCase(new Position(x+nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y-nbr)).getCouleur() != getCouleur()){
                    positions.add(new Position(x+nbr,y-nbr));
                    boucle=false;
                }
                else if (plateau.getCase(new Position(x+nbr,y-nbr)) != null
                        && plateau.getCase(new Position(x+nbr,y-nbr)).getCouleur() == getCouleur())
                    boucle=false;
            }

        }


        return positions;
    }
}
