import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {

    @Test
    public void TestProxy1(){
        OriginalInterface originalInterfaceImpl = new OriginalInterfaceImpl();

        OriginalInterface originalInterface = (OriginalInterface) Proxy.newProxyInstance(OriginalInterfaceImpl.class.getClassLoader(), OriginalInterfaceImpl.class.getInterfaces(), new InvocationHandler() {

            OriginalInterface o = originalInterfaceImpl;
            //sun.misc.ProxyGenerator.saveGeneratedFiles

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("start....");
//                method.invoke(proxy, args);//为什么会栈溢出，proxy方法中含有InvocationHandler.invoke(proxy,method,args);
                method.invoke(originalInterfaceImpl, args);
                System.out.println("finish....");
                return null;
            }
        });
        originalInterface.doSomeThing();
//        OriginalInterface originalInterface = new OriginalInterface$Proxy1(new InvocationHandler() {
//
//            OriginalInterface o = originalInterfaceImpl;
//
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("before....");
////                o.doSomeThing();
//                if( null != args && args.length > 0 ) {
//                    for (Object arg : args) {
//                        System.out.println("arg:" + arg);
//                    }
//                }
//                method.invoke(o, args);
//                System.out.println("after....");
//                return null;
//            }
//        });
//
//        originalInterface.returnString("haha");
    }

}

/**
 * 目标对象
 */
interface OriginalInterface {

    void doSomeThing();

    String returnString(String arg);

}

/**
 * 自己实现的类
 */
class OriginalInterfaceImpl implements OriginalInterface{

    @Override
    public void doSomeThing() {
        System.out.println("OriginalInterfaceImpl...");
    }

    @Override
    public String returnString(String arg) {
        System.out.println("OriginalInterfaceImpl..." + arg);
        return arg;
    }
}

/**
 * 动态代理生成的类
 */
class OriginalInterface$Proxy1 implements OriginalInterface {

    private InvocationHandler handler;

    OriginalInterface$Proxy1( InvocationHandler handler ) {
        this.handler = handler;
    }

    @Override
    public void doSomeThing() {
        try {
            handler.invoke(this, OriginalInterface.class.getMethod("doSomeThing"), null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public String returnString(String arg) {
        try {
            return (String) handler.invoke(this, OriginalInterface.class.getMethod("returnString", new Class[]{String.class}), new Object[]{arg});
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}