package com.techmonad.learning.lambda;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class LambdaExpression {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // print all list element
        //1
        list.forEach((Integer e) -> System.out.println(e));
        //2
        list.forEach((e) -> System.out.println(e));
        //3
        list.forEach(e -> System.out.println(e));
        //4
        list.forEach(System.out::println);

        //Get the sum of square of  all even numbers
        //1
        System.out.println(
                list.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, (total, e) -> total + e)
        );

        //2
        System.out.println(
                list.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum)
        );

        //2
        System.out.println(
                list.stream()
                        .filter(n -> n % 2 == 0)
                        .mapToInt(n -> n * n)
                        .sum()
        );


        // Get the square of all even numbers
        System.out.println(
                list.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .collect(toList())
        );
        
        // remove duplicates 
         List<Integer> list2 = Arrays.asList(1, 2, 2, 4, 3, 11,11,6);
        list2
            .stream()
            .collect(Collectors.groupingBy(Function.identity()))
            .values()
            .stream()
            .map(v -> v.stream().findFirst().get())
            .collect(Collectors.toList());

        //Word count
        String str = "This is sample for word word  count count";
        System.out.println(
                Arrays.stream(str.split(" +"))
                        .collect(groupingBy(a -> a, counting()))
        );
    }

}
