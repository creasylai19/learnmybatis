package org.fenixsoft.clazz;

import org.apache.ibatis.reflection.property.PropertyNamer;
import org.junit.Test;

import java.lang.reflect.Method;

public class TestClass {

    private int m;

    public int inc() {
        return m + 1;
    }

    @Test
    public void testJava(){
//        String a = "01";
//        System.out.println(a.charAt(1));
//        System.out.println(PropertyNamer.methodToProperty("getAAbc"));
//        System.out.println(TestClass.class.isAssignableFrom(Object.class));
//        System.out.println(Object.class.isAssignableFrom(TestClass.class));
//
//        System.out.println(new ChildrenClass().add());
        StringBuilder sb = new StringBuilder();
        sb.append((String) null);
        System.out.println(sb.toString());


//        Method[] methods = ChildrenClass.class.getMethods();
//        for (Method method : methods) {
//            if ("methodOne".equals(method.getName())){
//                Class<?>[] classes = method.getParameterTypes();
//                for (Class<?> aClass : classes) {
//                    System.out.println(aClass);
//                }
//            }
////            System.out.println(method.getName());
//        }
    }
}