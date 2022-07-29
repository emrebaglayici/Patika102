package Builder;

public class Person {
    private String name;
    private String surname;
    private String address;

    public Person(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;

    }

    public String getName(String name) {
        return name;
    }

    public String getSurname(String surname) {
        return surname;
    }

    public String getAddress(String address) {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String surname;
        private String address;

        public Builder() {

        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
