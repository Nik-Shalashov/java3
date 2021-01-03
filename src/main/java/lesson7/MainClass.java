package lesson7;

import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {

    public static void main(String[] args) {

        TestClass testClass = new TestClass();
        Class<?> classTests = null;
        try {
            classTests = Class.forName("lesson7.TestClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        start(classTests, testClass);
    }

    private static void start(Class<?> classTests, TestClass testClass) {

        Method[] methods = classTests.getDeclaredMethods();

        checkingForCountOFBeforeAndAfterSuit(methods);
        try {
            beforeSuite(methods, testClass);
            startTesting(methods, testClass);
            afterSuite(methods, testClass);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void afterSuite(Method[] methods, TestClass testClass) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                System.out.println(method);
                method.setAccessible(true);
                method.invoke(testClass);
            }
        }
    }

    private static void startTesting(Method[] methods, TestClass testClass) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < 10; i++) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    if (method.getAnnotation(Test.class).priority() == (i + 1)){
                        System.out.println("Priority " + method.getAnnotation(Test.class).priority());
                        System.out.println(method);
                        method.setAccessible(true);
                        method.invoke(testClass);
                    }
                }
            }
        }
    }

    private static void beforeSuite(Method[] methods, TestClass testClass) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                System.out.println(method);
                method.setAccessible(true);
                method.invoke(testClass);
            }
        }
    }

    private static void checkingForCountOFBeforeAndAfterSuit(Method[] methods) {

        int countOfBeforeSuite = 0;
        int countOfAfterSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) countOfBeforeSuite += 1;
            if (method.isAnnotationPresent(AfterSuite.class)) countOfAfterSuite += 1;
            if (countOfAfterSuite > 1 || countOfBeforeSuite > 1) throw new RuntimeException("Методов BeforeSuite или AfterSuite больше 1");
        }
    }


}
