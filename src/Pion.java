import java.util.ArrayList;

public abstract class Pion extends Piece{


    public Pion() {
        super('B',new Position("A1"));
    }

    public Pion(Position position,char couleur) {
        super(couleur,position);
    }

    @Override
    public String getType() {
        return "pion";
    }

    @Override
    public abstract ArrayList<Position> getDeplacementPossible(Plateau plateau);
}
