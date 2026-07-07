package algoritmos;

public class SelectionSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

        long tempoInicial = System.currentTimeMillis();
        ordenarVetor(vetor);
        long tempoMs = System.currentTimeMillis() - tempoInicial;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "SelectionSort");
    }

    private static void ordenarVetor(int[] vetor) {
        int tamanho = vetor.length;

        for (int i = 0; i < tamanho; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < tamanho; j++) {
                comparacoes++;
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            int temp = vetor[i];
            vetor[i] = vetor[indiceMenor];
            vetor[indiceMenor] = temp;
            atribuicoes += 3;
        }
    }
}
