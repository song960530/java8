package lambda;

import other.Greeting;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        /**
         * 스태틱 메서드 참조
         * - 타입::스태틱 메서드
         */
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("MJ"));

        /**
         * 특정 객체의 인스턴스 메서드 참조
         * - 객체 레퍼런스::인스턴스 메서드
         */
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("MJ"));

        /**
         * 생성자 참조
         * - 타입::new
         */
        Supplier<Greeting> newGreeting1 = Greeting::new;
        Greeting greeting1 = newGreeting1.get();
        System.out.println(greeting1);

        /**
         * 생성자 참조
         * - 타입::new
         */
        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting greeting2 = newGreeting2.apply("MJ");
        System.out.println(greeting2);

        /**
         * 임의 객체의 인스턴스 메서드 참조
         * - 타입::인스턴스 메서드
         */
        String[] names = {"b", "c", "a"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("names = " + Arrays.toString(names));
    }
}
