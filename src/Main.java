public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Anna")
                .setSurname("Volf")
                .setAge(23)
                .setAddress("Moscow")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Jany")
                .setSurname("Volf")
                .setAge(1)
                .build();
        Person  grandFather= new PersonBuilder()
                .setName("Katya")
                .setSurname("Volf")
                .setAge(48)
                .setAddress("Germany")
                .build();
        System.out.println("At " + mom + "Have a son , " + son);
        grandFather.happyBirthday();
        mom.happyBirthday();

        System.out.println("At " + mom + " there is a mother, " + grandFather);
        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
//            e.printStackTrace();
            System.out.println("");
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.println("");
        }
    }
}