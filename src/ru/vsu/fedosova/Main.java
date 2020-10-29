package ru.vsu.fedosova;

import java.util.Locale;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        int h = readSize("height (must be h >= 4; even) ");
        int w = readSize("width (must be w >= 3) ");

        printShape(h, w);
    }

    public static int readSize(String size)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s: ", size);
        return scanner.nextInt();
    }

    public static void printShape(int h, int w)
    {
        printOutsideString(w);
        printInside(h - 2, w);
        printOutsideString(w);
    }

    public static void printOutsideString(int w)
    {
        System.out.print('*');
        for (int i = 1; i < w - 1; i++)
        {
            System.out.print('-');
        }
        System.out.println('*');
    }

    public static void printInside(int h, int w)
    {
        for (int i = 0; i < h; i++)
        {
            printRow(w, i, h);
        }
    }

    private static void printRow(int w, int i, int h)
    {
        System.out.print('|');
        for (int j = 1; j < w - 1; j++)
        {
            System.out.print(getSymbol(i, h, j));
        }
        System.out.println('|');
    }

    public static char getSymbol(int i, int h, int j)
    {
        if (i < h / 2) {
            if ((j % 2 == 1 && i % 2 == 0) || (j % 2 == 0 && i % 2 == 1)) {
                return '\\';
            }
        } else {
            if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                return '/';
            }
        }
        return ' ';
    }
}
