import java.util.ArrayList;

public class Cavalier extends Piece{

    public Cavalier() {
	super('B',new Position("A1"));
    }

    public Cavalier(Position position,char couleur) {
	super(couleur, position);
    }

    @Override
    public String getType() {
        return "cavalier";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {

        ArrayList<Position> positions = new ArrayList<>();

        /*

        * On veut stocker les positions de déplacements possibles du Cavalier
        * Pour chaque cas on vérifie avec la fonction bounds,
        * si les positions x et y sont ou pas dans l'intervalle de 0 à 7
        * On boucle pour exclure les positions possible  qui sont déjà occupé par des pièces de même type
        * On retourne les possitions possibles

        */

        int one = 1;
        int two = 2;

        if (bounds(this.getPosition().getX()+two,this.getPosition().getY()+one))
            positions.add(new Position(this.getPosition().getX()+two,this.getPosition().getY()+one));

        if (bounds(this.getPosition().getX()+two,this.getPosition().getY()-one))
            positions.add(new Position(this.getPosition().getX()+two,this.getPosition().getY()-one));

        if (bounds(this.getPosition().getX()-two,this.getPosition().getY()+one))
            positions.add(new Position(this.getPosition().getX()-two,this.getPosition().getY()+one));

        if (bounds(this.getPosition().getX()-two,this.getPosition().getY()-one))
            positions.add(new Position(this.getPosition().getX()-two,this.getPosition().getY()-one));

        if (bounds(this.getPosition().getX()-one,this.getPosition().getY()-two))
            positions.add(new Position(this.getPosition().getX()-one,this.getPosition().getY()-two));

        if (bounds(this.getPosition().getX()+one,this.getPosition().getY()-two))
            positions.add(new Position(this.getPosition().getX()+one,this.getPosition().getY()-two));

        if (bounds(this.getPosition().getX()-one,this.getPosition().getY()+two))
            positions.add(new Position(this.getPosition().getX()-one,this.getPosition().getY()+two));

        if (bounds(this.getPosition().getX()+one,this.getPosition().getY()+two))
            positions.add(new Position(this.getPosition().getX()+one,this.getPosition().getY()+two));

        for (Piece data : plateau.getTableau()
        ) {
            if (data.getCouleur()==this.getCouleur()){
                positions.removeIf(pos -> data.getPosition().getX() == pos.getX() && data.getPosition().getY() == pos.getY());
            }
        }
        return positions;
    }

    public boolean bounds(int x,int y){
        if(x<0 || x>7 || y<0 || y>7)
            return false;
        else
            return true;
    }
}
