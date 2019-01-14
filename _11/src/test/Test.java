package test;

import dao.impl.ProductDAOImpl;

public class Test {

    @org.junit.Test
    public void test1(){
        ProductDAOImpl productDAO = new ProductDAOImpl();
        System.out.println(productDAO.list());
    }
}
