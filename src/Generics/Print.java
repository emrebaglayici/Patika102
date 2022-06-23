package Generics;

public class Print {

    public static <T,U> void printArray(T[] array,U[] array2) {
        for (T i : array) {
            System.out.println(i);
        }
        for (U i:array2){
            System.out.println(i);
        }
    }
}
