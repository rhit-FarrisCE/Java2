package Exercize_7;

import java.lang.reflect.*;

public class RunSimpleTests {
    public static void main(String[] args) throws Exception {
        String className = (args.length > 0) ? args[0] : "Exercize_7.ExampleCode1";
        int passed = 0, failed = 0;
        for (Method m : Class.forName(className).getMethods()) {
            if (m.isAnnotationPresent(SimpleTest.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}

