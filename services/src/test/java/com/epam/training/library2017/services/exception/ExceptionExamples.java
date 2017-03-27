package com.epam.training.library2017.services.exception;

public class ExceptionExamples {

    public static void main(String[] args) {
        test1();
        System.out.print(true);
    }

    private static void test1() {
        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() throws Exception {
        test3();
    }

    private static void test3() throws Exception {
        boolean isAllOk = false;
        Object ojb = null;
        if (isAllOk) {
            System.out.println("OK!");
        } else {
            // ojb.getClass();

            throw new Exception();
        }

    }
}
