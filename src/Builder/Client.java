package Builder;

public class Client {
    public static void main(String[] args) {
        Person person=new Person.Builder().name("Emre").surname("Bağlayici").address(
                "İzmir"
        ).build();
        System.out.println(person);

    }
}
