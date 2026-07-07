package algoritmos;

public class QuickSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

        long tempoInicial = System.nanoTime();
        quickInsertionSort(vetor, 0, vetor.length - 1);
        long tempoMs = (System.nanoTime() - tempoInicial) / 1_000_000;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "QuickSort");
    }

    private static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        atribuicoes += 3;
    }

    private static int particionar(int[] vetor, int baixo, int alto) {
        int pivo = vetor[alto];
        int i = baixo - 1;

        for (int j = baixo; j <= alto - 1; j++) {
            comparacoes++;
            if (vetor[j] < pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, alto);
        return i + 1;
    }

    private static void insercao(int[] vetor, int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            int j = i;
            while (j > inicio && vetor[j - 1] > vetor[j]) {
                comparacoes++;
                trocar(vetor, j, j - 1);
                j = j - 1;
            }
        }
    }

    private static void quickInsertionSort(int[] vetor, int inicio, int fim) {
        while (inicio < fim) {
            if (fim - inicio < 50) {
                insercao(vetor, inicio, fim);
                break;
            }

            int pivo = particionar(vetor, inicio, fim);

            if (pivo - inicio < fim - pivo) {
                quickInsertionSort(vetor, inicio, pivo - 1);
                inicio = pivo + 1;
            } else {
                quickInsertionSort(vetor, pivo + 1, fim);
                fim = pivo - 1;
            }
        }
    }
}
