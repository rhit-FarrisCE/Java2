package Exercize_7;

public class ExampleCode1 {
    @SimpleTest
    public static void testMethod1() {
    }

    @SimpleTest
    public static void testMethod2() {
        throw new RuntimeException("testMethod2 should fail");
    }

    @SimpleTest
    public static void testMethod3() {
        int x = 5/0;
    }
}
