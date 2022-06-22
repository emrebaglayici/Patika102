import java.util.Scanner;

public class Grades {
    public static double avgCalc(int[] array){
        double avg=0.0;
        for(int i:array){
            avg+=i;
        }
        return avg/ array.length;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] grades=new int[5];
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
        double avg=avgCalc(grades);
        if(avg>=55){
            System.out.println("Geçtiniz, ortalamanız : "+avg);
        }else{
            System.out.println("Kaldınız, ortalamanız : "+avg);
        }


    }
}
