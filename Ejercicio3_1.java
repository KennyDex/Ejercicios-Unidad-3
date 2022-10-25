public class Ejercicio3_1 {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;
        int n = 100;
        int cur = 92;
        for (int i = 0; i < 5; i++){
            int next = (a * cur + b) % n;
            cur = next;
            System.out.println(next);
        }
    }
}
