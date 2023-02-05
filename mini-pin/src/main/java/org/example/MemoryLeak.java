/**
 * mini-pin
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/10/27
 **/
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MemoryLeak {
    private static List<Main.Person> persons = new ArrayList<>();

    private static void func() {
        for (int i = 0; i < 100_000; ++i) {
            persons.add(new Main.Person(UUID.randomUUID().toString(), UUID.randomUUID().toString(), i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt());

        func();
        while (true) {}
        // while (true) {
        //     System.out.println(2 * 2);
        // }
    }
}
