package algoritmos;

public class BubbleSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static int[] sort(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

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

        return vetor;
    }

    public static long getComparacoes() {
        return comparacoes;
    }

    public static long getAtribuicoes() {
        return atribuicoes;
    }
}
