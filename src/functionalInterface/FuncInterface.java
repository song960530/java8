package functionalInterface;

import java.util.function.*;

public class FuncInterface {
    public static void main(String[] args) {

        // 익명 내부 클래스 방식 - 이전에 사용하였던 방법
        RunSomething runSomething1 = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello1");
            }
        };
        runSomething1.doIt();

        // 람다식 표현 - 함수형 인터페이스를 인라인으로 표현
        RunSomething runSomething2 = () -> System.out.println("hello2");
        runSomething2.doIt();

        /**
         * 함수형 프로그래밍
         * - 대입문이 없는 프로그래밍이며, 가독성을 높이고 유지보수를 용이하게 해준다
         *
         * - 순수 함수
         *   - 사이드 이펙트가 없어야한다. (함수 밖에 있는 값을 변경하지 않는다)
         *   - 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다)
         * - 고차 함수
         *   - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수 있다
         * - 불변성
         *   - 함수형 프로그래밍은 외부의 영향을 받지 않아야 하기 때문에 변경 가능한 상태를 불변 상태로 만들어야한다
         */

        /**
         * Function<T, R>
         * - T 타입을 받아 R타입으로 리턴하는 함수 인터페이스
         *   - 실행: R apply(T t)
         *   - 조합: compose, andThen
         */
        Function<Integer, Integer> plus10 = i -> i + 10;
        Function<Integer, Integer> multipl2 = i -> i * 2;
        System.out.println(plus10.apply(10)); // 단순 실행
        System.out.println(plus10.compose(multipl2).apply(20)); // compose 를 활용한 조합
        System.out.println(multipl2.andThen(plus10).apply(20)); // andThen 를 활용한 조합

        /**
         * BiFunction<T, U, R>
         * - T, U 타입을 받아 R 타입으로 리턴하는 함수 인터페이스
         *   - 실행: R apply(T t, U u)
         */
        BiFunction<Integer, Integer, Integer> plus = (i1, i2) -> i1 + i2;
        System.out.println(plus.apply(10, 40));

        /**
         * Consumer<T>
         * - T 타입을 받고 리턴이 없는 함수 인터페이스
         *   - 실행: void Accept(T t)
         *   - 조합: andThen
         */
        Consumer<Integer> printNum = num -> System.out.println(num);
        printNum.accept(50);

        /**
         * Supplier<T>
         * - T 타입을 리턴하는 함수 인터페이스
         */
        Supplier<Integer> getNum = () -> 50;
        getNum.get();

        /**
         * Predicate<T>
         * - T 타입을 받아 boolean 리턴하는 함수 인터페이스
         *   - 실행: boolean test(T t)
         */
        Predicate<Integer> is50 = num -> {
            if (num == 50)
                return true;
            return false;
        };
        System.out.println(is50.test(50));

        /**
         * UnaryOperator<T>
         * - Function<T, R>의 특수한 형태, T 타입을 받아 T 타입을 리턴하는 함수 인터페이스
         */
        UnaryOperator<Integer> sameReturn = i -> i;
        System.out.println(sameReturn.apply(50));

        /**
         * BinaryOperator<T>
         * - BiFunction<T, U, R>의 특수한 형태, T타입 2개를 입력받아 T 타입을 리턴하는 함수 인터페이스
         */
        BinaryOperator<Integer> binaryOperator = (i1, i2) -> i1 + i2;
        System.out.println(binaryOperator.apply(10, 40));
    }
}
