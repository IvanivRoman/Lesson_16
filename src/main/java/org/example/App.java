package org.example;

import java.util.List;

public class App {

    public static List<Person> selectAdultWomen(List<Person> list) {
        return list.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 60)
                .filter(x -> x.getSex() == Sex.WOMAN)
                .toList();
    }

    public static double averageMenAge(List<Person> list) {
        return Math.floor(list.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(-1));
    }

    public static int countAdults(List<Person> list) {
        return (int) list.stream().
                filter(x -> (x.getAge() >= 18 && x.getAge() <= 60 && x.getSex() == Sex.MAN) ||
                        (x.getAge() >= 18 && x.getAge() <= 55 && x.getSex() == Sex.WOMAN)).
                count();
    }

    public static void main(String[] args) {
        List<Person> humans = List.of(new Person("Teodor", 16, Sex.MAN),
                new Person("Piter", 23, Sex.MAN),
                new Person("Olena", 42, Sex.WOMAN),
                new Person("Ivan Ivanovich", 69, Sex.MAN),
                new Person("Vasuluna", 17, Sex.WOMAN),
                new Person("Christine", 25, Sex.WOMAN),
                new Person("Nazar", 16, Sex.MAN),
                new Person("Oleg", 37, Sex.MAN),
                new Person("Gordon", 27, Sex.MAN));

        for (Person p : selectAdultWomen(humans)) {
            System.out.println(p);
        }

        System.out.println(countAdults(humans));

        System.out.println("Average mens age is: " + averageMenAge(humans));
    }
}