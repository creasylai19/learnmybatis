package org.mybatis.example.utils;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class ExampleObjectFactory extends DefaultObjectFactory {

    public Object create(Class type) {
        System.out.println("ExampleObjectFactory.create--" + type.getSimpleName());
        return super.create(type);
    }

    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        System.out.println("ExampleObjectFactory.createWithArgs--" + type.getSimpleName());
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    public void setProperties(Properties properties) {
        System.out.println("ExampleObjectFactory---setProperties：" + properties);
        super.setProperties(properties);
    }

    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}
