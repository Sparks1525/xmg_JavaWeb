package _01.javabean1;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String name;
    private int age;

    public Person(){}

    public Person(Long id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
