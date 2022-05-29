package interfaces;

public interface Bar extends Foo {

    /**
     * Foo 인터페이스의 printNameUpperCase 메서드(기본 메서드)를 제공하고싶지 않을 땐
     * 아래와 같이 다시 추상메서드로 선언해주면 Foo의 메서드를 제공하지 않게할 수 있다
     */
    void printNameUpperCase();
}
