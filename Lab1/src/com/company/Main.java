package com.company;
import java.sql.SQLOutput;
import java.util.Scanner;



public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //ex1(); ex2(); ex3(); ex4(15);
        //ex5();
        //ex6();
        ex7();

    }


    public static void ex1() {

        System.out.println("Numarul pentru exercitiul 1 = ");
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++)
            if (i % 2 == 0) {
                System.out.println(i);
            }
    }
    public static void ex2() {
        System.out.println("Cele doua numere pentru exercitiul 2 = ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if(a > b) {
            System.out.println(a);
        }
        else{
            System.out.println(b);
        }
    }

    public static void ex3() {
        System.out.println("Numarul pentru exercitiul 3 = ");
        int n = scanner.nextInt();
        int fact = 1;
        for(int i = 1; i <= n; i++)
            fact *= i;
        System.out.println(fact);

    }

    public static void ex4(int n) {
        int suma = 0;
        for(int i = 2; i <= n; i++)
            if( i%5 == 0 || i%3 == 0 )
            {
                suma += i;
            }
        System.out.println(suma);
    }

    public static void ex5(){
        System.out.println("Cate numere vom citi ? ");
        int n = scanner.nextInt();
        int []pare, impare;
        pare = new int [n];
        impare = new int [n];
        int j = 0, k = 0;
        for(int i = 0; i < n; i++)
        {
            System.out.println("Urmatorul numar = ");
            int nr = scanner.nextInt();
            if(nr%2 == 0) {
                pare[j] = nr;
                j++;
            }
            else{
                impare[k] = nr;
                k++;
            }
        }
        System.out.println("Numere pare: ");
        for(int i = 0; i < j; i++)
            System.out.print(pare[i] + "  ");
        System.out.println();
        for(int i = 0; i < k; i++)
            System.out.print(impare[i] + "  ");

    }

    public static void ex6(){
        int ok = 1;
        int suma = 0;
        int nr = 0;
        System.out.println("Introduceti notele: ");
        while(ok == 1)
        {
            int n = scanner.nextInt();
            if(n == -1){
                ok = 0;
            }
            else{
                suma += n;
                nr += 1;
            }
        }

        System.out.println(suma/nr);
    }

    public static void ex7(){
        int f0 = 0;
        int f1 = 1;
        int rez = 0;
        System.out.println("Introduceti n-ul pentru Fibonacci: ");
        int n = scanner.nextInt();

        if(n <= 0) {
            rez = 0;
            System.out.println(rez);
        }
        else if(n == 1){
            rez = 1;
            System.out.println(0 + " " + 1);
        }
        else{
            System.out.print(0 + " " + 1 + " ");
            for(int i = 2; i <= n; i++) {
                rez = f1 + f0;
                f0 = f1;
                f1 = rez;
                System.out.print(rez + " ");
            }
        }

        System.out.println();
        System.out.println("Al " + n + "-lea numar este " + rez);

    }
}





