package org.example;

import java.util.Scanner;

public class App
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main( String[] args ) throws NotTriangleException {
        System.out.println("-----------------------------------------------------------------------------------------------\n" +
                           "    Задание 1.\n" +
                           "    Напишите функцию, вычисляющую площадь треугольника по трём сторонам (int a, int b, int c).\n" +
                           "    Разместите класс с функцией в src/main/java.\n" +
                           "-----------------------------------------------------------------------------------------------\n");

        Triangle triangle = InputTriangle();
        System.out.println(triangle);

        try {
            System.out.println("\nПлощадь треугольника равна: " + ANSI_GREEN + triangle.areaTriangle() + ANSI_RESET +"\n");
        }
        catch (NotTriangleException e){
            System.out.println("\n" + ANSI_RED + e.getMessage() + ANSI_RESET + "\n");
        }

//        System.out.println(new Triangle(19,4,16).areaTriangle());

    }

    public static Triangle InputTriangle(){

        int[] side = new int[3];

        boolean aOk = false;
        boolean bOk = false;
        boolean cOk = false;

        Scanner scanner = new Scanner(System.in);

        while(!aOk){
            System.out.println("Введите длину стороны " + ANSI_CYAN + "a" + ANSI_RESET + " треугольника: ");
            try{
                side[0] = Integer.parseInt(scanner.next());

                if(side[0] > 0){
                    aOk = true;
                }
                else {
                    System.out.println(ANSI_RED + "Длина стороны треугольника может принимать только положительное числовое значение" + ANSI_RESET);
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage() + ANSI_RED + " Длина стороны треугольника может принимать только положительное числовое значение" + ANSI_RESET);
            }
        }

        while(!bOk){
            System.out.println("Введите длину стороны " + ANSI_CYAN + "b" + ANSI_RESET + " треугольника: ");
            try{
                side[1] = Integer.parseInt(scanner.next());

                if(side[1] > 0){
                    bOk = true;
                }
                else {
                    System.out.println(ANSI_RED + "Длина стороны треугольника может принимать только положительное числовое значение" + ANSI_RESET);
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage() + ANSI_RED + " Длина стороны треугольника может принимать только положительное числовое значение" + ANSI_RESET);
            }
        }

        while(!cOk){
            System.out.println("Введите длину стороны " + ANSI_CYAN + "c" + ANSI_RESET + " треугольника: ");
            try{
                side[2] = Integer.parseInt(scanner.next());

                if(side[2] > 0){
                    cOk = true;
                }
                else {
                    System.out.println(ANSI_RED + "Длина стороны треугольника может принимать только положительное числовое значение" + ANSI_RESET);
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage() + ANSI_RED + " Длина стороны треугольника может принимать только положительное числовое значение" + ANSI_RESET);
            }
        }
        return new Triangle(side[0], side[1], side[2]);
    }
}
