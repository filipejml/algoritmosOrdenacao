package algoritmos;

public class MergeSort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static ResultadoOrdenacao ordenar(int[] vetor) {
        comparacoes = 0;
        atribuicoes = 0;

        long tempoInicial = System.nanoTime();
        ordenarVetor(vetor, 0, vetor.length - 1);
        long tempoMs = (System.nanoTime() - tempoInicial) / 1_000_000;

        return new ResultadoOrdenacao(vetor, tempoMs, comparacoes, atribuicoes, "MergeSort");
    }

    private static void ordenarVetor(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;

            ordenarVetor(vetor, inicio, meio);
            ordenarVetor(vetor, meio + 1, fim);

            merge(vetor, inicio, meio, fim);
        }
    }

    private static void merge(int[] vetor, int inicio, int meio, int fim) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; ++i) {
            esquerda[i] = vetor[inicio + i];
            atribuicoes++;
        }
        for (int j = 0; j < tamanhoDireita; ++j) {
            direita[j] = vetor[meio + 1 + j];
            atribuicoes++;
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            comparacoes++;
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
            atribuicoes++;
        }

        while (i < tamanhoEsquerda) {
            vetor[k] = esquerda[i];
            i++;
            k++;
            atribuicoes++;
        }

        while (j < tamanhoDireita) {
            vetor[k] = direita[j];
            j++;
            k++;
            atribuicoes++;
        }
    }
}
