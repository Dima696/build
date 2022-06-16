import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {





    @org.junit.jupiter.api.Test
    void addHappyBirthday () {
        Person person = new PersonBuilder()
                .setName("Anna")
                .setSurname("Volf")
                .setAge(23)
                .setAddress("Moscow")
                .build();
        Person person1 = new PersonBuilder()
                .setName("Anna")
                .setSurname("Volf")
                .setAge(24)
                .setAddress("Moscow")
                .build();
        person.happyBirthday();

        assertEquals(person1, person);


    }



}