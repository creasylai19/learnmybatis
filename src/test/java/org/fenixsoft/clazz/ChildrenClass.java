package org.fenixsoft.clazz;

public class ChildrenClass extends ParentClass {

    @Override
    public ParentClass add() {
        return new ParentClass();
    }

    public static void methodOne(String a, Integer b, ParentClass c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
