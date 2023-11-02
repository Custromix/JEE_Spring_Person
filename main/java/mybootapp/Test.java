package mybootapp;

public class Test {

    private int nb = 5;
    public static int alpha = 10;

    public Test(){
        System.out.println("Constructeur 1");
        System.out.println(nb);
    }

    public Test(int nb){
        System.out.println("Constucteur 2");
        System.out.println(this.nb);
        this.nb = nb;
        System.out.println(this.nb);
    }

    public int augmenterNb(){
        return ++nb;
    }

    public int augmenterNb(int nb){
        this.nb += nb;
        return this.nb;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}
