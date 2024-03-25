import java.util.Scanner;

import static java.lang.System.out;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String calc (String input) throws Exception {
        //при вводе данных определяем положение операндов
        int cnt=0; // устанавливаем значение переменной cnt (количество операндов)
        int operindex=-1;
        for (int a=0; a<input.length()&& cnt<2;a++){
            if ((input.charAt(a)=='+') || (input.charAt(a)=='-') || (input.charAt(a)=='*') || (input.charAt(a)=='/')) {
                cnt++;
                operindex=a;
                }
        }
        if(cnt<1) { //если операнд не найден то cnt присваивается значение '0'
            // если больше 1 операнда, то присваивается значение этого действия
            // если cnt не равна 1, то срабатывает новое условие:
            throw new Exception("символ операции не найден, выберите операцию: Сложение, вычитание, умножение или Деление");        }
        else if (cnt> 1) {
            throw new Exception("Вы ввели более 1 символа операции (+,-,*,/)");
        }
        String leftArg = input.substring(0, operindex).trim();              // Определяем значения левого и правого аргумента
        String rightArg = input.substring(operindex + 1).trim();  // относительно операнда
        if (leftArg.matches("[\\d]{1,2}") && rightArg.matches("[\\d]{1,2}")) { //проверяем соответствует ли регулярному выражению левый и правый аргумент согласно маске и так же в одной системе счисления
        } else {
            throw new Exception("Слева и справа должны быть арабские цифры одновременно в диапозоне от 1 до 10");
        }
        String oper = input.substring(operindex, operindex + 1); // Определяем тип переменной
        int leftNum =  Integer.parseInt(leftArg);
        int rightNum = Integer.parseInt(rightArg);
        if (leftNum < 1 ||  leftNum > 10 || rightNum < 1 || rightNum > 10) { //проверяем диапазон вводимых аргументов слева и справа должны быть от 1 до 10
            throw new Exception("Числа нужно вводить в диапазоне от 1 до 10");
        }
        int result = 0; //производим вычисление
        switch (oper) {
            case "+":
                result = leftNum + rightNum;
                break;
            case "-":
                result = leftNum - rightNum;
                break;
            case "*":
                result = leftNum * rightNum;
                break;
            case "/":
                result = leftNum / rightNum;
                break;
        }
        return "Ответ (В арабской системе исчисления):" + result; //выводим результат в арабской системе исчисления
    }
    public static void main(String[] args) {
        // Выводим результат в консоль
        System.out.println("Введите выражение используя числа от 1 до 10");
        String expr = new Scanner(System.in).nextLine();
        try {
            System.out.println(calc(expr));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

