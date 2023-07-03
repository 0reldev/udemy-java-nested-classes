package dev.lpa.burger;

public class Store {

    public static void main(String[] args) {

        Meal regularMeal = new Meal();
        System.out.println(regularMeal);
//        coke
//        burger        regular $5,00
//        drink           coke $1,50
//        side          fries $2,00
//        Total due:$8,50

        Meal usRegularMeal = new Meal(0.68);
        System.out.println(usRegularMeal);
//        coke
//        burger        regular $3,40
//        drink           coke $1,02
//        side          fries $1,36
//        Total due:$5,78
    }
}
