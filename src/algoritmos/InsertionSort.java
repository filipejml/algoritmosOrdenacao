package algoritmos;

public class InsertionSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static int[] ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

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

        return vetor;
    }

    public static long getComparacoes() {
        return comparacoes;
    }

    public static long getAtribuicoes() {
        return atribuicoes;
    }
}
