package org.fenixsoft.clazz;

public class ChildrenClass extends ParentClass {

    @Override
    public ParentClass add() {
        return new ParentClass();
    }
}
