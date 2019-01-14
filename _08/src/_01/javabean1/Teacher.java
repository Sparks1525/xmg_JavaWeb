package _01.javabean1;

public class Teacher {
    private Long id;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getUserAge1(){
        return age;
    }


    public int getUserAge2(int uage){
        return uage;
    }

    public String getUserAge21(String uage){
        return uage;
    }

    public void getUserAge3(int uage){

    }

    public void getUserAge4(){

    }

    public void setUserAge5(int age){
        this.age = age;
    }

    public void setUserAge6(){

    }

    public void setUserAge7(){

    }

    public void setUserAge8(int age){

    }
}
