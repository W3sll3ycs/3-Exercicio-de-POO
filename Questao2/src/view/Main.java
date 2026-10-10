import model.MegaSena;

void main(String[] args) {
    MegaSena jogo = new MegaSena();
    jogo.lerNumeros();

    int[] numeros = jogo.getNumerosOrdenados();

    System.out.println("\nNúmeros em ordem crescente:");
    for (int i = 0; i < numeros.length; i++) {
        System.out.printf("%02d ", numeros[i]);
    }
    System.out.println();
}

