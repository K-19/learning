package builder;

public class Main {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 0)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();
    }
}
