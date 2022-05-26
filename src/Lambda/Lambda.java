package Lambda;

import java.util.function.Consumer;

public class Lambda {
    /**
     * 람다식이란
     * - 익명함수
     * - 함수처럼 작성하지만 실행 시 익명 구현 객체를 생성하는 방식으로 구동
     *
     * 람다식을 쓰는 이유
     * - 코드가 간결해진다
     * - 필터링 및 매핑시 집계결과를 쉽게 가져올 수 있다
     * - 병렬처리, 이벤트처리등 함수형 프로그래밍에 유용하게 쓰인다
     *
     * 람다표현법
     * - (인자리스트) -> {바디}
     * - 인자리스트
     *   - 인자가 없을 떄: ()
     *   - 인자가 한개일 때: (a), a
     *   - 인자가 여러개일 때(인자 타입은 컴파일러가 추론 가능하여 생략가능하지만 명시할수도 있음): (a,b)
     * - 바디
     *   - 여러줄인경우 {}로 묶는다
     *   - 한줄일경우 {}를 생략 가능하며 return도 생략 가능하다
     */
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.run();
    }

    private void run() {
        /**
         * 변수 캡쳐 (Variable Capture)
         * - 로컬 변수 캡쳐
         *   - 아래 baseNum이 final이거나 effective final인 경우에만 참조가 가능하다
         * - effective final
         *   - 자바8부터 지원하며 사실상 final인 변수
         */
        int baseNum = 10; // effective final 이므로 final은 생략 가능하다


        /**
         * 로컬 클래스의 경우 Scope가 run 메서드랑 다르기 때문에 내부에서 baseNum 선언하여 사용 가능
         */
        class LocalClass {
            void printBaseNum() {
                int baseNum = 11;
                System.out.println(baseNum); // 11
            }
        }

        /**
         * 익명 클래스의 경우에도 Scope가 run 메서드랑 다르기 때문에 내부에서 baseNum 선언하여 사용 가능
         */
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer aa) {
                int baseNum = 11;
                System.out.println(baseNum); // 11
            }
        };

        /**
         * 람다의 경우 새로운 Scope를 만들지 않아 run 메서드랑 동일한 Scope라 baseNum 선언시 컴파일 오류 발생
         */
        Consumer<Integer> lambConsumer = i -> {
            // int baseNum = 11; // 오류
            System.out.println(baseNum);
        };
    }
}
