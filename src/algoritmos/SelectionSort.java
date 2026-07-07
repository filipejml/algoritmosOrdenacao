package algoritmos;

public class SelectionSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenarComResultado(int[] vetor) {
        long tempoInicial = System.currentTimeMillis();
        sort(vetor);
        long tempoMs = System.currentTimeMillis() - tempoInicial;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "SelectionSort");
    }

    public static void sort(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;
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

    public static long getComparacoes() {
        return comparacoes;
    }

    public static long getAtribuicoes() {
        return atribuicoes;
    }
}
