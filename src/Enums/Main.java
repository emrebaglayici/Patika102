package Enums;

public class Main {
    public static void main(String[] args) {
        System.out.println(Day.MONDAY);
        System.out.println(Day.SUNDAY.ordinal());
        System.out.println(Day.FRIDAY.name());

        Day[] values=Day.values();
        for(Day a:values){
            System.out.println(a);
        }
        Day day=Day.valueOf("MONDAY");
        System.out.println(day);
    }
}
