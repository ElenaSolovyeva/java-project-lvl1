package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.printf("Hello, %s!", userName);
        System.out.println();
    };




}
