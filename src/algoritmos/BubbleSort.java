package algoritmos;

public class BubbleSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

        long tempoInicial = System.currentTimeMillis();
        ordenarVetor(vetor);
        long tempoMs = System.currentTimeMillis() - tempoInicial;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "BubbleSort");
    }

    private static void ordenarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    int chave = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = chave;
                    atribuicoes += 3;
                }
            }
        }
    }
}
