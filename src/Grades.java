import java.util.Scanner;

public class Grades<T extends Number>{
    public static void main(String[] args) {
        Grades obj=new Grades();
        Scanner scanner=new Scanner(System.in);
        Integer[] grades=new Integer[5];
        String[] classNames={
                "Matematik",
                "Kimya",
                "Fizik",
                "Tarih",
                "Müzik"
        };
        for (int i = 0; i < grades.length ; i++) {
            System.out.print((classNames[i])+" notu giriniz :");
            int input=scanner.nextInt();
            if(input<0 || input>100){
                while ((input<0 || input>100)){
                    System.out.println("Yanlış not aralığı yeniden giriniz : ");
                    input=scanner.nextInt();
                }
            }else{
                grades[i]=input;
            }

        }

        Double avg=obj.avg(grades);
        printResult(avg);


    }
    public static void printResult(Double avg){
        if(avg>=55){
            System.out.println("Geçtiniz, ortalamanız : "+avg);
        }else{
            System.out.println("Kaldınız, ortalamanız : "+avg);
        }
    }

    public Double avg(T[] grades) {
        if(grades.length==0){
            return 0.0;
        }
        Double avg=0.0;
        for (int i = 0; i < grades.length; i++) {
            avg+=grades[i].doubleValue();
        }
        return avg/ grades.length;
    }

}
