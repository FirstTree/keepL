package com.wenyiguai.keepl.lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Create by FirsTree on 2018-5-21
 */
public class SimpleDemo {

    public static void main(String[] args) {

        SimpleDemo tester = new SimpleDemo();

        new Thread( () -> System.out.println("It's Lambda express!")).start();
        Runnable r = () -> System.out.println("hello world");
        r.run();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("===================================="+multiplication.operation(2,3));

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);

        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        nums.stream().filter(num -> num != null).count();

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
