package model;

public class Fibonacci {
    private int n;
    private long[] serie;

    public Fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O valor de n deve ser maior que zero.");
        }
        this.n = n;
        this.serie = new long[n];
        gerar();
    }

    private void gerar() {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                serie[i] = 0;
            } else if (i == 1) {
                serie[i] = 1;
            } else {
                serie[i] = serie[i - 1] + serie[i - 2];
            }
        }
    }

    public long[] getSerie() {
        return serie.clone();
    }

    public int getN() {
        return n;
    }
}