package CommonDesignPatterns.Singleton;

public class DemoSingleThread {
    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance("Foo");
        Singleton anotherSingleton=Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
