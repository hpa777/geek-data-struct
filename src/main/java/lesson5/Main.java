package lesson5;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(pow(3, -5));

        TestBackpack testBackpack = new TestBackpack(6);
        testBackpack.addBackpackItem(new BackpackItem("Книга", 1, 600));
        testBackpack.addBackpackItem(new BackpackItem("Бинокль", 2, 5000));
        testBackpack.addBackpackItem(new BackpackItem("Аптечка", 4, 1500));
        testBackpack.addBackpackItem(new BackpackItem("Ноутбук", 2, 40000));
        testBackpack.addBackpackItem(new BackpackItem("Котелок", 1, 500));
        List<BackpackItem> result = testBackpack.findOptimalSet();
        System.out.println(result);
    }

    private static double pow(int num, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return num;
        }
        if (exp < 0) {
            return 1 / pow(num, Math.abs(exp));
        }
        return num * pow(num, --exp);
    }






}
