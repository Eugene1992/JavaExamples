package iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Zoo<Cat> zoo = new Zoo<>(5);
        zoo.add(new Cat("Murzik1"));
        zoo.add(new Cat("Murzik2"));
        zoo.add(new Cat("Murzik3"));
//        zoo.push(new Dog());

        for (Cat animal : zoo) {
            animal.speak();
        }

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Barsik"));
    }
}
