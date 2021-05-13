package com.company;

public class Task3
{
    public static void main(String[] args)
    { }
    //1.Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1,
    // либо 2 различных решения для действительных значений x.
    // учитывая a, b и c, вы должны вернуть число решений в уравнение
    public static int boxSeq(int a, int b,int c)
    {
        if(a == 0)
        {
            System.out.println("а не должно равняться нулю");
            return -1;
        }
        int D = b*b - 4*a*c;
        if(D < 0)
            System.out.println("0");
        if(D == 0)
            System.out.println("1");
        if(D > 0)
            System.out.println("2");
        return 0;
    }

    //2.Напишите функцию, которая возвращает позицию второго вхождения
    // "zip" в строку, или -1, если оно не происходит по крайней мере
    // дважды. Ваш код должен быть достаточно общим, чтобы передать все
    // возможные случаи, когда "zip" может произойти в строке
    public static int findZip(String str)
    {
        int zip = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'z' && str.charAt(i+1) == 'i' && str.charAt(i+2) == 'p')
            {
                zip++;
                if(zip == 2)
                {
                    System.out.println(i);
                    return 0;
                }
            }
        }
        System.out.println(-1);
        return -1;
    }

    //3.Создайте функцию, которая проверяет, является ли целое число
    // совершенным числом или нет. Совершенное число - это число,
    // которое можно записать как сумму его множителей, исключая само число
    public static void checkPerfect(int num)
    {
        int sum = 0;
        for(int i = 1; i < num; i++)
            if(num % i == 0)
                sum += i;
        if(sum == num)
            System.out.println("true");
        else
            System.out.println("false");
    }

    //4.Создайте функцию, которая принимает строку и возвращает новую строку с
    // заменой ее первого и последнего символов, за исключением трех условий:
    //– Если длина строки меньше двух, верните "несовместимо".".
    //– Если первый и последний символы совпадают, верните "два-это пара."
    public static void flipEndChars(String str)
    {
        if(str.length() < 2)
            System.out.println("Слишком короткая строка");
        else if(str.charAt(0) == str.charAt(str.length()-1))
            System.out.println("Символы одинаковые");
        else
            System.out.println(str.charAt(str.length()-1) + str.substring(1,str.length()-1) + str.charAt(0));
    }

    //5.Создайте функцию, которая определяет, является ли строка допустимым
    //шестнадцатеричным кодом. Шестнадцатеричный код должен начинаться с
    // фунтового ключа # и иметь длину ровно 6 символов. Каждый символ должен
    // быть цифрой от 0-9 или буквенным символом от A-F. все буквенные символы
    // могут быть прописными или строчными
    public static int Hex(String str)
    {
        char alf[] = {'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'};
        if(str.charAt(0) != '#')
            System.out.println("false");
        else if (str.length() != 7)
            System.out.println("false");
        else
            for(int i = 1; i < str.length(); i++)
                if (Character.isDigit(str.charAt(i)))
                    continue;
                else
                    for(int j = 0; j < 12;j++)
                    {
                        if(str.charAt(i) == alf[j])
                            break;
                        if(j == 11)
                        {
                            System.out.println("false");
                            return -1;
                        }
                    }

        System.out.println("true");
        return 0;
    }

    //6.Напишите функцию, которая возвращает true, если два массива имеют
    // одинаковое количество уникальных элементов, и false в противном случае
    public static void same(int[] arr1, int[] arr2)
    {
        int sum1 = 0, sum2 = 0;
        int[] arrT1 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for(int i = 0; i < arr1.length; i++)
            for(int j = 0; j < 10; j++)
            {
                if(arr1[i] == arrT1[j])
                    break;
                if(j == 9)
                {
                    arrT1[arr1[i]] = arr1[i];
                    sum1++;
                }
            }

        int[] arrT2 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        for(int i = 0; i < arr2.length; i++)
            for(int j = 0; j < 10; j++)
            {
                if(arr2[i] == arrT2[j])
                    break;
                if(j == 9)
                {
                    arrT2[arr2[i]] = arr2[i];
                    sum2++;
                }
            }

        if(sum1 == sum2)
            System.out.println("true");
        else
            System.out.println("false");
    }

    //7.Число Капрекара-это положительное целое число, которое после возведения в
    // квадрат и разбиения на две лексикографические части равно сумме двух полученных новых чисел:
    //– Если количество цифр квадратного числа четное, то левая и правая части
    // будут иметь одинаковую длину.
    //– Если количество цифр квадратного числа нечетно, то правая часть будет
    // самой длинной половиной, а левая-самой маленькой или равной нулю, если количество цифр равно 1.
    //– Учитывая положительное целое число n, реализуйте функцию, которая возвращает true,
    //если это число Капрекара, и false, если это не так
    public static void isKaprekar(int num)
    {
        int sum = 0;
        int square = num*num;
        String Num = Integer.toString(square), A = "", B = "";

        if(Num.length() == 1)
            sum = square;

        for(int i = 0; i < Num.length(); i++)
        {
            if(i < Num.length() / 2)
                A += Num.charAt(i);
            else
                B += Num.charAt(i);
        }
        sum = Integer.valueOf(A,10) + Integer.valueOf(B,10);

        if(sum == num)
            System.out.println("true");
        else
            System.out.println("false");
    }

    //8.Напишите функцию, которая возвращает самую длинную последовательность
    // последовательных нулей в двоичной строке
    public static void longestZero(String num)
    {
        String str = "", pStr = "";
        int sum = 0, pSum = 0;

        for(int i = 0; i < num.length(); i++)
            if(num.charAt(i) == '0')
            {
                for(int j = i; j < num.length(); j++)
                {
                    if(num.charAt(j) == '1')
                        break;
                    pStr += num.charAt(j);
                    pSum++;
                    i++;
                }
                if(pSum > sum)
                {
                    sum = pSum;
                    str = pStr;
                }
                pSum = 0;
                pStr = "";
            }

        System.out.println(str);
    }

    //9.Если задано целое число, создайте функцию, которая возвращает
    // следующее простое число. Если число простое, верните само число
    public static int nextPrime(int num)
    {
        for (int i = 2; i < num; i++)
        {
            if(i == num - 1 && num % i != 0)
            {
                System.out.println(num);
                return 1;
            }
            if(num % i == 0)
                break;
        }

        int K = 0;
        for (int i = num+1; K == 0 ; i++)
            for (int j = 2; j < i; j++)
            {
                if (j == i - 1 && i % j != 0)
                {
                    K = i;
                }
                if (i % j == 0)
                    break;
            }

        System.out.println(K);
        return 0;
    }

    //10.Учитывая три числа, x, y и z, определите, являются ли они ребрами
    //прямоугольного треугольника
    public static int rightTriangle(int a, int b, int c)
    {
        if (a > b && a > c)
            if (a*a == b*b + c*c)
                System.out.println("true");
            else
                return 0;
        if (b > a && b > c)
            if (b*b == a*a + c*c)
                System.out.println("true");
            else
                return 0;
        if (c > b && c > a)
            if (c*c == b*b + a*a)
                System.out.println("true");
            else
                return 0;

        System.out.println("false");
        return -1;
    }

}
