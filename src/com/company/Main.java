package com.company;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.IntStream;

public class Main
{
    // Создать массив, содержащий 10 первых нечетных чисел, следующих после введенного с клавиатуры числа.
    // Элементы массива вывести в консоль, разделяя точкой с запятой.
    public static void ArrayOddNumbers()
    {
        int[] array = new int[10];
        for(int i = 0; i < 10; i++)
        {
            array[i] = 2*i+1;
            System.out.print(array[i]+"; ");
        }
        System.out.println();
    }

    // Найти наименьший элемент массива, введенного с клавиатуры,
    // вывести наименьшее и наибольшее числа, а также их позиции в массиве.
    // Поменять в массиве, введенном с клавиатуры, наибольший и наименьший элементы массива местами.
    public static void MaxToMinElements()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++)
        {
            array[i] = input.nextInt();
        }

        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();

        int minPos = 0, maxPos = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == min)
                minPos = i;
            else if (array[i] == max)
                maxPos = i;
        }
        System.out.println("Min element = " + min + ", position = " + minPos);
        System.out.println("Max element = " + max + ", position = " + maxPos);

        int temp = array[maxPos];
        array[maxPos] = array[minPos];
        array[minPos] = temp;
        
        System.out.println("Массив после перестановки минимальных и максимальных значений местами: ");
        for (int item: array)
        {
            System.out.print(item + "; ");
        }
        System.out.println();
    }

    // Найти среднее арифметическое всех элементов каждой строки двухмерного массива,
    // введенного с клавиатуры. Вывести в консоль результаты.
    public static void Matrix()
    {
        int avg = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int row = input.nextInt();
        System.out.println("Введите количество столбцов: ");
        int column = input.nextInt();
        int[][] array = getMatrix(System.in, column, row);

        for (int[] line : array)
        {
            System.out.println(Arrays.toString(line));
        }

        System.out.println("Среднее арифметическое каждой строки: ");
        for (int i = 0; i < row; i++)
        {
            int temp = 0;
            for (int j = 0; j < column; j++)
                temp += array[i][j];
            avg = temp / column;
            System.out.print(avg + "; ");
        }
    }


    static int[][] getMatrix(InputStream is, int x, int y)
    {
        int[][] array = new int[y][];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < y; i++) {
            array[i] = new int[x];
            for (int j = 0; j < x; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        return array;
    }

    public static void main(String[] args)
    {
        ArrayOddNumbers();
        MaxToMinElements();
        Matrix();
    }
}