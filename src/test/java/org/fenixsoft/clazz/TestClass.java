package org.fenixsoft.clazz;

import org.apache.ibatis.reflection.property.PropertyNamer;
import org.junit.Test;

public class TestClass {

    private int m;

    public int inc() {
        return m + 1;
    }

    @Test
    public void testJava(){
        String a = "01";
        System.out.println(a.charAt(1));
        System.out.println(PropertyNamer.methodToProperty("getAAbc"));
        System.out.println(TestClass.class.isAssignableFrom(Object.class));
        System.out.println(Object.class.isAssignableFrom(TestClass.class));

        System.out.println(new ChildrenClass().add());
    }
}