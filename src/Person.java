import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public Person(String name, String surname) {
       this.name = name;
       this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }
    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.address = city;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = city;
    }
    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address !=null && !address.isEmpty();
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if(hasAge()){
            age = OptionalInt.of(age.getAsInt()+1);
        }
    }



    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address).setAge(0);
    }

    @Override
    public String toString () {
        return String.format("%s %s (age:%s city:%s)",
                name,
                surname,
                (age.isPresent() ? age.getAsInt() : "unknown"),
                (!address.isEmpty() ? address : "unknown"));

    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, surname, age, address);
    }
}