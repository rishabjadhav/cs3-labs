import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FunctionalProgramming {
    public static void main(String[]args) {
        //1
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)); //for more odd numbers
        List<String> letters = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));

        //2
        letters.forEach(n -> System.out.println(n));
        //n iterates throughout all indexes of letters as a part of the lambda operand
        //and n becomes an object of its respective index within the letters arraylist
        System.out.println();

        //3
        numbers.removeIf((Integer n) -> n % 2 == 0);
        //removeIf only removes the Integer n at index n if it is even
        //or if the boolean operator returns true

        //4
        numbers.stream().filter(n -> n % 2 == 1).count();
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        //5
        letters.stream().filter(n -> letters.equals("a"));
        System.out.println();

        //6
        numbers.stream().map(n -> n * 2);

        //7
        /*
        nums.stream().map(a -> a * a + 10).filter(a -> a % 10 != 5 && a % 10 != 6).collect(Collectors.toList());
         */

        //8
        List<Double> taxes = new ArrayList<>(Arrays.asList(12.97, 13.00, 194.95, 20.99));
        taxes.stream().map(n -> n + (n * 0.12));

        //9
        numbers.stream().reduce((n1, n2) -> (n1 + n2));

        //10
        List<Double> taxesDupe = new ArrayList<>(Arrays.asList(14.00, 9.99, 19.02, 29.32));
        taxes.stream().map(n -> n + (n * 0.12));

        //11
        numbers.stream().max((n1, n2) -> (n1 + n2));

        //12
        List<Person> people = new ArrayList<>();
        people.add(new Person("Albert",   16));
        people.add(new Person("Bob",   45));
        people.add(new Person("Charlie",    65));
        people.add(new Person("Diane",  23));
        people.add(new Person("Edgar", 4));

        people.stream().mapToInt(n -> people.indexOf(n));

    }
    public static class Person {
        String name;
        int age;

        Person(String name, int age) { this.name = name; this.age  = age; }

        @Override
        public String toString() { return this.name + ", " + this.age; }

        int getAge() { return this.age; }
    }

}
