package interfaces;

public interface Foo {
    void printName();

    String getName();

    /**
     * 기본 메서드 (Default Methods)
     *
     * 인터페이스에 선언이 아닌 구현체를 제공함으로 써 구현클래스에 영향을 주지 않고 새로운 기능을 추가제공할 수 있다
     * 하지만 어떤 사이드 이펙트가 발생하는지 예측이 불가능하니 아래와 같이 어노테이션을 통해 어떤 메서드인지 설명을 해주면 좋다
     *
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    /**
     * 스태틱 메서드
     *
     * 해당 타입 관련 유틸리티 메서드를 제공하고 싶을 때 스태틱 메서드를 통해 제공할 수 있다
     * ex) Foo.pringHello()
     */
    static void printHello() {
        System.out.println("Hello");
    }
}
