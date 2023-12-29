import java.util.ArrayList;

public class PionNoir extends Pion{

    public PionNoir() {
        super(new Position("A1"),'B');
    }

    public PionNoir(Position position) {
        super(position,'N');
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau plateau) {
        ArrayList<Position> positions = new ArrayList<>();

        int x = getPosition().getX();
        int y = getPosition().getY();

        if (y == 6) {
            if (getPosition().getX() >= 0 || getPosition().getX() <= 7) {
                if (bounds(x,y-1)){
                    if (plateau.getCase(new Position(x, y-1)) == null)
                        positions.add(new Position(x, y-1));
                }
                if (bounds(x,y-2)){
                    if (plateau.getCase(new Position(x, y-2)) == null)
                        positions.add(new Position(x, y-2));
                }
                return prendrePieceDiagonalement(positions, plateau);
            }
        }
        else {
            if (bounds(x,y-1)){
                if (plateau.getCase(new Position(x, y-1)) == null)
                    positions.add(new Position(x, y-1));
            }
            return prendrePieceDiagonalement(positions, plateau);
        }

        return positions;
    }

    public ArrayList<Position> prendrePieceDiagonalement(ArrayList<Position> positions, Plateau plateau) {

        int x = getPosition().getX();
        int y = getPosition().getY();

        for (Piece piece : plateau.getTableau()) {

            if (piece.getCouleur() != this.getCouleur()){

                if (piece.getPosition().getX() == x+1){
                    if (piece.getPosition().getY() == y-1)
                        positions.add(new Position(x+1,y-1));
                }

                if (piece.getPosition().getX() == x-1){
                    if (piece.getPosition().getY() == y-1)
                        positions.add(new Position(x-1,y-1));
                }
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
