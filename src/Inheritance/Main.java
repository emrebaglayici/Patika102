package Inheritance;

public class Main {
    public static void main(String[] args) {
        //Employee employee1=
          //      new Employee("emre","baglayici",
            //            "05347887878","emrebaglayici1@gmail.com");

        //Academician academician1=
                //new Academician("uras","tos","0547892604",
                        //"urastos@gmail.com","SEPROGRAM","CHEF");

        Instructor instructor1=
                new Instructor("uras","tos","0547892604",
                "urastos@gmail.com",
                "SEPROGRAM","CHEF",101);

        //instructor1.in("12.00");


        //Employee e1=new Academician("uras","tos","0547892604",
                //"urastos@gmail.com","SEPROGRAM","CHEF");


        //Employee[] employees={employee1,academician1,instructor1,e1};
        //Employee.loginUsers(employees);
        instructor1.teach("10.00");

    }
}
