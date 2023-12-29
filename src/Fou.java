import java.util.ArrayList;

public class Fou extends Piece{

    public Fou() {
        super('B',new Position("A1"));
    }

    public Fou(Position position,char couleur) {
        super(couleur,position);
    }

    @Override
    public String getType() {
        return "fou";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {

        /*

         * On veut stocker les positions de déplacements possibles de la pièce Tour
         * On boucle diagonalement selon les quatre sens possibles du Fou
         * On arrête la boucle dès que que le Fou croise une pièce ennemi ou alié
         * On Fait en sorte de ne prendre que des positions dont les valeurs vont de 0 à 7,
         * En définissant les variables nbrXmax et nbrYmax

         */

        ArrayList<Position> positions = new ArrayList<>();

        int nbrXmax=(7-this.getPosition().getX());
        int nbrYmax=(7-this.getPosition().getY());

        int x = getPosition().getX();
        int y = getPosition().getY();

        // Positions Ligne Haute Droite
        if (nbrXmax<nbrYmax){

            boolean boucle=true;

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
            boolean boucle=true;

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

            boolean boucle=true;

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
            boolean boucle=true;
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
            boolean boucle=true;
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

            boolean boucle=true;
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
            boolean boucle=true;

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
            boolean boucle=true;

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
            boolean boucle=true;

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
            boolean boucle=true;

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
            boolean boucle=true;

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

            boolean boucle=true;

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
