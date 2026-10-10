import model.Fibonacci;
import java.util.Scanner;

void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Quantos números da série de Fibonacci deseja exibir? ");
    int n = sc.nextInt();

    if (n <= 0) {
        System.out.println("Erro: informe um valor maior que zero.");
        sc.close();
        return;
    }

    Fibonacci fib = new Fibonacci(n);
    long[] serie = fib.getSerie();

    System.out.print("[");
    for (int i = 0; i < serie.length; i++) {
        System.out.print(serie[i]);
        if (i < serie.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println("]");

    sc.close();
}
