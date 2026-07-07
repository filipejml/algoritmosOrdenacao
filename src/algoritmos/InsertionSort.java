package algoritmos;

public class InsertionSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

        long tempoInicial = System.currentTimeMillis();
        ordenarVetor(vetor);
        long tempoMs = System.currentTimeMillis() - tempoInicial;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "InsertionSort");
    }

    private static void ordenarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            int j = i;
            while (j > 0 && vetor[j - 1] > vetor[j]) {
                comparacoes++;

                int chave = vetor[j];
                vetor[j] = vetor[j - 1];
                vetor[j - 1] = chave;
                atribuicoes += 3;

                j = j - 1;
            }
        }
    }
}
