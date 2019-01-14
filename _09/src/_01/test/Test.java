package _01.test;

import _01.dao.impl.StudentDAOImpl;

public class Test {

    @org.junit.Test
    public void test1(){

        StudentDAOImpl dao = new StudentDAOImpl();
        System.out.println(dao.list());
    }
}
