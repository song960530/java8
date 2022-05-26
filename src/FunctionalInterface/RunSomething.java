package FunctionalInterface;

/**
 * @FunctionalInterface
 * 함수형 인터페이스는 추상 메서드를 딱 하나만 가지고 있어야 한다
 */
@FunctionalInterface
public interface RunSomething {
    void doIt();

    static void printName() {
        System.out.println("Song");
    }
}
