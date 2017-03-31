package com.epam.training.library2017.services.exception;

import java.io.IOException;

public class ExceptionExamples {

    public static void main(String[] args) {
        test1();
        System.out.print("completed");
    }

    private static void test1() {
        try {
            test2();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            // e.printStackTrace();

            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("after exception\n\n\n\n");
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

            throw new NullPointerException();
        }

    }
}
