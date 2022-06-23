package Generics;

public class ArrayUtil {
    public static  <T> boolean arrayContains(T[] array,T element){
        for (T item:array){
            if(item!=null && item.equals(element))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] array={1,2,3,4,5};
        System.out.println(arrayContains(array,4));
    }
}
