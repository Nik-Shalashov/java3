package lesson7;

import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

public class TestClass {

    public TestClass() {
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Start tests!");
    }

    /*@BeforeSuite
    public void beforeSuite2() {
        System.out.println("Start tests!");
    }*/

    @AfterSuite
    public void afterSuite() {
        System.out.println("Tests end!");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test #1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test #2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test #3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Test #4");
    }

    @Test(priority = 5)
    public void test5() {
        System.out.println("Test #5");
    }

    @Test(priority = 6)
    public void test6() {
        System.out.println("Test #6");
    }

    @Test(priority = 7)
    public void test7() {
        System.out.println("Test #7");
    }

    @Test(priority = 8)
    public void test8() {
        System.out.println("Test #8");
    }

    @Test(priority = 9)
    public void test9() {
        System.out.println("Test #9");
    }

    @Test(priority = 10)
    public void test10() {
        System.out.println("Test #10");
    }

    @Test
    public void test11() {
        System.out.println("Test #11");
    }

    @Test(priority = 1)
    public void test12() {
        System.out.println("Test #12");
    }

    @Test(priority = 4)
    public void test13() {
        System.out.println("Test #13");
    }

}
