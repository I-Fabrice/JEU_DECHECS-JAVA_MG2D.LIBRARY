import MG2D.Couleur;
import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.geometrie.*;
import MG2D.geometrie.Point;

import java.awt.*;
import java.util.ArrayList;

public class MainGraphique {


    public static void main(String[] args) throws Exception {

        /*
            * On récupère les évenements de clic
            * On crée deux nouvelles instances ArrayList de type Carre et Cercle pour faire des cercles dans les carrés de la fenetre
            * On veut boucler pour savoir si une partie est terminée ou non
            * On veut passer la main pour faire en sorte que le jeu se déroule à tour de rôle
            * On veut pouvoir déplacer un pièce d'un point A à un point B

         */

        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre("JEU D'ÉCHECS",800,800);

        Souris s = fenetre.getSouris();
        ArrayList<Carre> carreList = new ArrayList<>();
        ArrayList<Cercle> cercleList = new ArrayList<>();

        boolean firstClick = true;
        boolean bou=true;
        boolean passerLaMainAuxBlancs=true;
        char couleur='B';

        Position from = new Position();
        Position to;


        /*
           * On crée un tableau sur la fenetre à partir de l'objet plateau
           * On rajoute chaque pièce de l'échiquier

        */

        for (int y=0;y<8;y++){
            for (int x=0;x<8;x++){
                if(((x+y)%2)==0){
                    carreList.add(new Carre(new Couleur(Color.DARK_GRAY.darker()),new Point(x*100,y*100),100,true));
                    fenetre.ajouter(new Carre(new Couleur(Color.DARK_GRAY.darker()),new Point(x*100,y*100),100,true));
                }
                else{
                    carreList.add(new Carre(new Couleur(Color.LIGHT_GRAY.darker()),new Point(x*100,y*100),100,true));
                    fenetre.ajouter(new Carre(new Couleur(Color.LIGHT_GRAY.darker()),new Point(x*100,y*100),100,true));
                }
            }
        }


        for (Piece piece :plateau.getTableau() ) {
            Texture texture = new Texture("./images/"+piece.getNomLong()+".png",
                    new Point(piece.getPosition().getX()*100,piece.getPosition().getY()*100),100,100);
            fenetre.ajouter(texture);

        }

        fenetre.rafraichir();


        while (bou){

            try {
                Thread.sleep(10);
            }catch (Exception e){}

            try {

                /*
                * On cherche à savoir s'il y a échec et mat des deux côtés
                * On affiche les déplacments possibles lors du premier clic
                * On déplace la pièce lors du deuxième clic et on passe la main à l'adversaire
                * On s'assure de bien supprimer les déplacements possibles dans chaque cas*/

                if (plateau.estEchec('B') || plateau.estEchec('N')){
                    System.out.println("Échec et Mat !!!!");
                    if (plateau.estEchec('B')){
                        System.out.println("Félicitations au joueur noir ");
                    }
                    else if (plateau.estEchec('N')){
                        System.out.println("Félicitations au joueur blanc ");
                    }

                    bou=false;
                }
                else {
                    if (firstClick){
                        if (s.getClicGauche()) {

                            Point p = s.getPosition();
                            int X = p.getX();
                            int Y = p.getY();


                            X = X / 100;
                            Y = Y / 100;

                            from = new Position(X,Y);


                                if (plateau.getCase(new Position(X, Y)) != null) {
                                    if (passerLaMainAuxBlancs && plateau.getCase(from).getCouleur()==couleur || !passerLaMainAuxBlancs && plateau.getCase(from).getCouleur()==couleur ) {
                                        for (Position pos : plateau.getCase(new Position(X, Y)).getDeplacementPossible(plateau)
                                        ) {

                                            for (Carre carre : carreList
                                            ) {
                                                if (carre.getA().getX() == pos.getX() * 100 && carre.getA().getY() == pos.getY() * 100) {
                                                    cercleList.add(new Cercle(Couleur.ROUGE, carre));
                                                    fenetre.ajouter(new Cercle(Couleur.ROUGE, carre));
                                                }
                                                fenetre.rafraichir();
                                            }
                                            fenetre.rafraichir();
                                        }
                                        firstClick = false;
                                    }
                                }




                            fenetre.rafraichir();

                        }
                    }
                    if (!firstClick) {
                        if (s.getClicGauche()) {

                            Point p = s.getPosition();
                            int X = p.getX();
                            int Y = p.getY();


                            X = X / 100;
                            Y = Y / 100;

                            to = new Position(X,Y);


                            for (Position dp : plateau.getCase(new Position(from.getX(), from.getY())).getDeplacementPossible(plateau)){
                                if (dp.getX()==X && dp.getY()==Y){
                                    if ((from.getX() + from.getY()) % 2 == 0) {
                                        fenetre.ajouter(new Carre(new Couleur(Color.DARK_GRAY.darker()), new Point(from.getX() * 100, from.getY() * 100), 100, true));
                                    } else {
                                        fenetre.ajouter(new Carre(new Couleur(Color.LIGHT_GRAY.darker()), new Point(from.getX() * 100, from.getY() * 100), 100, true));
                                    }

                                    if ((to.getX() + to.getY()) % 2 == 0) {
                                        fenetre.ajouter(new Carre(new Couleur(Color.DARK_GRAY.darker()), new Point(to.getX() * 100, to.getY() * 100), 100, true));
                                    } else {
                                        fenetre.ajouter(new Carre(new Couleur(Color.LIGHT_GRAY.darker()), new Point(to.getX() * 100, to.getY() * 100), 100, true));
                                    }

                                    if (plateau.deplacer(from, to)) {
                                        fenetre.ajouter(new Texture("./images/" + plateau.getCase(new Position(to.getX(), to.getY())).getNomLong() + ".png", new Point(plateau.getCase(new Position(to.getX(), to.getY())).getPosition().getX() * 100, plateau.getCase(new Position(to.getX(), to.getY())).getPosition().getY() * 100), 100, 100));
                                    }

                                    if (passerLaMainAuxBlancs){
                                        passerLaMainAuxBlancs=false;
                                        couleur='N';
                                    }
                                    else {
                                        passerLaMainAuxBlancs=true;
                                        couleur='B';
                                    }

                                }

                            }


                            for (Cercle cercle : cercleList
                            ) {
                                fenetre.supprimer(cercle);
                            }
                            fenetre.rafraichir();

                            fenetre.rafraichir();

                            firstClick=true;
                        }
                    }

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


}


