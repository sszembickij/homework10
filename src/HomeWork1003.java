/*Создать генератор паролей, который будет генерировать случайные пароли
по следующим правилам:
Пароль состоит из 8 символов
В пароле допускаются только латинские большие и маленькие буквы, цифры и
символ подчеркивания
Пароль обязательно должен содержать Большие и маленькие буквы и цифры*/

import java.util.Random;

public class HomeWork1003 {
    public static void main(String[] args) {
        char[] charArray = new char[1 + 10 + 26 + 26];
        setCharArray(charArray);
        System.out.println(setPassword(charArray));
    }

    public static String setPassword(char[] array) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            password.append(array[random.nextInt(array.length)]);
        }
        return password.toString();
    }

    public static void setCharArray(char[] arr) {
        int count = 0;
        for (int i = '0'; i <= 'z'; i++) {
            if (i == '_'
                    || i >= '0' && i <= '9'
                    || i >= 'A' && i <= 'Z'
                    || i >= 'a' && i <= 'z') {
                arr[count] = (char) i;
                count++;
            }
        }
    }
}
