package mybootapp;

public class HelloWorld {


    public static void main(String[] args){
        System.out.println("HelLo les étudiants !");
        Test test1 = new Test();
        Test test2 = new Test(25);

        System.out.println(test1.augmenterNb(30));
        System.out.println(test2.augmenterNb());


        Carre carre = new Carre(10);
        System.out.println(carre.perimetre());

        Rectangle rectangle = new Rectangle(2,3);
        System.out.println(rectangle.perimetre());
    }
}
