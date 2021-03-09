package com.company;

public class Person {
    private String name ;
    private String surname;
    private int age;
    private long identityNumber;
    private Type type;

    public Person() {
        this.name = "No name";
        this.surname = "No surname";
        this.age = 0;
        this.identityNumber = 0;
        this.type = Type.NONE;
    }

    public Person(String name, String surname, int age, long identityNumber, Type type) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.identityNumber = identityNumber;
        this.type = type;
    }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getIdentityNumber() {
            return identityNumber;
        }

        public void setIdentityNumber(long identityNumber) {
            this.identityNumber = identityNumber;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", identityNumber=" + identityNumber +
                ", type='" + type + '\'' +
                '}';
    }
}
