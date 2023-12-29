import java.util.ArrayList;
import java.util.List;

public class Roi extends Piece{

    public Roi() {
        super('B',new Position("A1"));
    }

    public Roi(Position position,char couleur) {
        super(couleur,position);
    }

    @Override
    public String getType() {
        return "roi";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        ArrayList<Position> positions = new ArrayList<>();

        /*

         * On veut stocker les positions de déplacements possibles du Roi
         * Pour chaque cas on vérifie avec la fonction bounds,
         * si les positions x et y sont ou pas dans l'intervalle de 0 à 7
         * On boucle pour exclure les positions possible  qui sont déjà occupé par des pièces de même type
         * On retourne les possitions possibles

         */

        if (bounds(this.getPosition().getX()-1,this.getPosition().getY()+1))
             positions.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()+1));
        if (bounds(this.getPosition().getX(),this.getPosition().getY()+1))
             positions.add(new Position(this.getPosition().getX(),this.getPosition().getY()+1));
        if (bounds(this.getPosition().getX()+1,this.getPosition().getY()+1))
             positions.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()+1));
        if (bounds(this.getPosition().getX()+1,this.getPosition().getY()))
             positions.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()));

        if (bounds(this.getPosition().getX()+1,this.getPosition().getY()-1))
             positions.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()-1));
        if (bounds(this.getPosition().getX(),this.getPosition().getY()-1))
             positions.add(new Position(this.getPosition().getX(),this.getPosition().getY()-1));
        if (bounds(this.getPosition().getX()-1,this.getPosition().getY()-1))
             positions.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()-1));
        if (bounds(this.getPosition().getX()-1,this.getPosition().getY()))
             positions.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()));


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
