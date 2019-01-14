package _01.javabean1;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class JavaBeanTest1 {


    @Test
    public void test1() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Teacher.class, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd);
        }
    }

    @Test
    public void test2() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor pd : pds) {
            System.out.println(pd);
        }

        System.out.println("-------------------------------------");

        for (PropertyDescriptor pd : pds) {
            String name = pd.getName();
            if ("id".equals(name)) {
                pd.setValue(name, 1L);
            }
            Object value = pd.getValue(name);
            System.out.println("name:" + name + ",value:" + value);
        }

        System.out.println("-------------------------------------");
        for (PropertyDescriptor pd : pds) {
            Object readMethod = pd.getReadMethod();
            Object writeMethod = pd.getWriteMethod();
            System.out.println("readMethod:" + readMethod + "........writeMethod:" + writeMethod);
        }

        System.out.println("-------------------------------------");
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getPropertyType());
        }
    }

    @Test
    public void test3() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class, Object.class);
        Object object = beanInfo.getBeanDescriptor().getBeanClass();
        System.out.println(((Class) object).getSimpleName());
    }



    @Test
    public void test4() throws Exception {


        Person p = new Person(123L, "乔峰", 32);
        Map<String, Object> map = bean2map(p);
        System.out.println(map);

        Person obj = map2bean(map, Person.class);
        System.out.println(obj);
    }

    private static <T>T map2bean(Map<String, Object> map, Class<T> type)
            throws Exception {
		/*
		bean类必须有公共无参的构造方法才能使用此方法
		否则报 java.lang.InstantiationException 异常
		 */
        T obj = type.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            Object value  = map.get(propertyName);
            pd.getWriteMethod().invoke(obj, value);
        }
        return obj;
    }

    public static Map<String, Object> bean2map(Object bean) throws Exception {
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(),
                Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            Object propertyValue = pd.getReadMethod().invoke(bean);
            map.put(propertyName, propertyValue);
        }
        return map;
    }


}
