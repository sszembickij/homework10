/*Написать метод.
Входящий параметр:
Строка со словами разделенными пробелом которые состоят из больших и маленьких букв.
Метод должен вернуть ту же строку в которой первая буква в каждом слове большая, а остальные маленькие
Например:
Test test tESt => Test Test Test*/

public class HomeWork1002 {
    public static void main(String[] args) {
        String string = "Saaa gGhj jhgfF SSSm Shh";

        System.out.println(fomatSrting(string));

    }

    private static String fomatSrting(String string) {
        StringBuilder result = new StringBuilder();
        String[] arrString = string.split("\\s+");
        for (int i = 0; i < arrString.length; i++) {
            result.append(arrString[i].substring(0, 1).toUpperCase()).append(arrString[i].substring(1).toLowerCase());
            result.append(" ");
        }
        return result.toString().trim();
    }
}