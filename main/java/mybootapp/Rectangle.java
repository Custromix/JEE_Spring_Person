package mybootapp;

public class Rectangle {

    private final int largeur, longeur;

    public Rectangle(int largeur, int longeur) {
        this.largeur = largeur;
        this.longeur = longeur;
    }

    public int perimetre(){
        return largeur *2 + longeur *2;
    }
}
