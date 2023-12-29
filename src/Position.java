public class Position {

    // Attributs de la classe Positions
    private int x;
    private int y;

    // Constructeur Par Défaut
    public Position() {
        this.x=0;
        this.y=0;
    }

    // Constructeur Par Copie
    public  Position(Position p){
        this.x= p.x;
        this.y= p.y;
    }

    // Constructeur Avec deux entiers en paramètres
    public Position(int x, int y) {
        if(x<0 || x>7 || y<0 || y>7)
            System.out.println("Les valeurs de x et y doivent être compris entre 0 et 7");
        else{
            this.x = x;
            this.y = y;
        }
    }


    // Constructeur prenant une chaîne de caractère en paramètre
    public Position(String position){

	// Vérification de la chaine de caractères
	char c1 = position.charAt(0);
	char c2 = position.charAt(1);
	this.x = (int)((c1)-65);
	this.y = (int)((c2)-'1');

    }
    
    // Getters et Setters de la classe position
    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x<0 || x>7 )
            System.out.println("Les valeurs de x doivent être compris entre 0 et 7");
        else{
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y<0 || y>7 )
            System.out.println("Les valeurs de x doivent être compris entre 0 et 7");
        else{
            this.y = y;
        }
    }

    // Method equals de la classe Position
    /*public boolean equals(Position p){
        if(this.x != p.x)
            return false;
        if(this.y != p.y)
            return false;
        return true;
    }*/
    public boolean equals(Object obj){
    	if(this == obj)
    	    return true;
    	if( !(obj instanceof Position))
    	    return false;
    	Position p = (Position)(obj);

	    if(this.x != p.x)
            return false;
        if (this.y != p.y)
            return false;
        return true;
    }
    
    
    // Convertion
    public String convert(int x, int y){
        char data;
        if(x>=0 || x<=7){
            data = (char) (x + 65);
            return ""+data+""+(y+1);
        }

        return null;
    }

    //Methode ToString de la classe Position
    @Override
    public String toString() {
        return "{"+
                this.convert(this.x, this.y)+
                '}';
    }

}
