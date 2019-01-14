package _01.javabean1;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {
	public static void main(String[] args) throws Exception {
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