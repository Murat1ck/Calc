
import java.util.InputMismatchException;
import java.util.Scanner;


import static javax.swing.UIManager.getString;

public class calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char
        char[] under_char = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = toNumber(stable00);
        number2 = toNumber(string03);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            System.out.println("---Результат для римских цифр----");
            String resultRoman = convertation(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        result = calculated(number1, number2, operation);
        System.out.println("--Результат для арабских цифр----");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static String convertation(int numArabian) {
        return getString(numArabian);
    }


    private static int toNumber(String number) {
        return Integer.parseInt(number);
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}


