package model;
import java.util.Arrays;
import java.util.Scanner;

public class MegaSena {
    private static final int QUANTIDADE = 6;
    private static final int MIN = 1;
    private static final int MAX = 60;

    private int[] numeros;
    private int preenchidos;

    public MegaSena() {
        this.numeros = new int[QUANTIDADE];
        this.preenchidos = 0;
    }

    public void lerNumeros() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite " + QUANTIDADE + " números diferentes entre " + MIN + " e " + MAX + ".");

        while (preenchidos < QUANTIDADE) {
            System.out.print("Número " + (preenchidos + 1) + ": ");
            int numero = sc.nextInt();

            if (numero < MIN || numero > MAX) {
                System.out.println("Erro: o número deve estar entre " + MIN + " e " + MAX + ".");
            } else if (contem(numero)) {
                System.out.println("Erro: o número " + numero + " já foi digitado.");
            } else {
                numeros[preenchidos] = numero;
                preenchidos++;
            }
        }

        sc.close();
    }

    private boolean contem(int valor) {
        for (int i = 0; i < preenchidos; i++) {
            if (numeros[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public int[] getNumerosOrdenados() {
        int[] copia = Arrays.copyOf(numeros, preenchidos);
        Arrays.sort(copia);
        return copia;
    }
}