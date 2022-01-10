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
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число: ");
        int one = input.nextInt();
        int[] array = new int[10];
        array[0] = one + (one & 1) ^ 1;
        for (int i = 1; i < 10; i++)
        {
            array[i] = array[i-1] + (array[i-1] & 1) ^ 1;;
        }
        for (int i = 0; i < 10; i++)
            System.out.print(array[i]+"; ");
        System.out.println();
    }

    // Найти наименьший элемент массива, введенного с клавиатуры,
    // вывести наименьшее и наибольшее числа, а также их позиции в массиве.
    // Поменять в массиве, введенном с клавиатуры, наибольший и наименьший элементы массива местами.
    public static <var> void MaxToMinElements()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();
        double array[] = new double[size];
        System.out.println("Введите элементы массива (дробные через ,): ");
        for (int i = 0; i < size; i++)
        {
            array[i] = input.nextDouble();
//            System.out.print(array[i]+"; ");
        }

//        double min = Arrays.stream(array).min().getAsDouble();
//        double max = Arrays.stream(array).max().getAsDouble();
        double min = array[0];
        double max = array[0];
        for (double num : array)
        {
            if (num < min)
                min = num;
            else if (num > max)
                max = num;
        }

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

        double temp = array[maxPos];
        array[maxPos] = array[minPos];
        array[minPos] = temp;
        
        System.out.println("Массив после перестановки минимальных и максимальных значений местами: ");
        for (double item: array)
        {
            System.out.print(item + "; ");
        }
        System.out.println();
    }

    // Найти среднее арифметическое всех элементов каждой строки двухмерного массива,
    // введенного с клавиатуры. Вывести в консоль результаты.
    public static void Matrix()
    {
        double avg = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int row = input.nextInt();
        System.out.println("Введите количество столбцов: ");
        int column = input.nextInt();
        double[][] array = getMatrix(System.in, column, row);

        for (double[] line : array)
        {
            System.out.println(Arrays.toString(line));
        }

        System.out.println("Среднее арифметическое каждой строки: ");
        for (int i = 0; i < row; i++)
        {
            double temp = 0;
            for (int j = 0; j < column; j++)
                temp += array[i][j];
            avg = temp / column;
            System.out.print(avg + "; ");
        }
    }


    static double[][] getMatrix(InputStream is, int x, int y)
    {
        double[][] array = new double[y][];
        System.out.println("Введите матрицу: ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < y; i++) {
            array[i] = new double[x];
            for (int j = 0; j < x; j++) {
                array[i][j] = scanner.nextDouble();
            }
        }

        return array;
    }

    public static void main(String[] args)
    {
//        ArrayOddNumbers();
//        MaxToMinElements();
        Matrix();
    }
}
