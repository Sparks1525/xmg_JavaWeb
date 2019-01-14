package test;

import dao.impl.ProductDAOImpl;

public class Test {
    @org.junit.Test
    public void test1(){
        ProductDAOImpl dao = new ProductDAOImpl();
        System.out.println(dao.list());
    }
}
