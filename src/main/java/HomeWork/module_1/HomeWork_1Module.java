package HomeWork.module_1;

public class HomeWork_1Module {

    static void sum(int a, int b) {
        int result = 0;
        while (a < b) {
            if (a % 3 == 0 || a % 5 == 0)
                result += a;
            a++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        int result = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                result += i;
        }
        System.out.println(result);


        sum(0, 1000);
    }
}
