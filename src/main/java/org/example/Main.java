package org.example;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;
/*
    Создать свой Java Maven проект;
    Добавьте зависимость commons-math3 (предназначена для решения математических задач) и изучить интерфейс библиотеки.
    Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
    Создать коллекцию из числовых элементов.
    С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение, сумму и среднее арифметическое.
    Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса ArithmeticUtils найти:
    Н-факториал числа N.
    Наименьшее общее частное двух чисел
    Наибольший общий делитель двух чисел
    Проверить, что число N это степень двойки
 */
public class Main {

    static double[] numberList = new double[]{6d, 4d, 12d, 16d, 100d};

    public static void main(String[] args) {

        System.out.println(CombinatoricsUtils.factorial(3));
        System.out.println(ArithmeticUtils.factorial(3));   // устаревший метод для вычисления факториала
        System.out.println(ArithmeticUtils.lcm(2, 3));
        System.out.println(ArithmeticUtils.gcd(2, 3));
        System.out.println(ArithmeticUtils.isPowerOfTwo(2));
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(numberList);
        System.out.println(descriptiveStatistics.getMean());

    }
}
