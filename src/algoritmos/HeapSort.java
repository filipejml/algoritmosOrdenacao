package algoritmos;

public class HeapSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

        long tempoInicial = System.nanoTime();
        ordenarVetor(vetor);
        long tempoMs = (System.nanoTime() - tempoInicial) / 1_000_000;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "HeapSort");
    }

    private static void ordenarVetor(int[] vetor) {
        int tamanho = vetor.length;

        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(vetor, tamanho, i);
        }

        for (int i = tamanho - 1; i > 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            atribuicoes += 3;

            heapify(vetor, i, 0);
        }
    }

    private static void heapify(int[] vetor, int tamanho, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < tamanho) {
            comparacoes++;
            if (vetor[esquerda] > vetor[maior]) {
                maior = esquerda;
            }
        }

        if (direita < tamanho) {
            comparacoes++;
            if (vetor[direita] > vetor[maior]) {
                maior = direita;
            }
        }

        if (maior != i) {
            int troca = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = troca;
            atribuicoes += 3;

            heapify(vetor, tamanho, maior);
        }
    }
}
