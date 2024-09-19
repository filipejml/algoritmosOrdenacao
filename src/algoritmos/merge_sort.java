package algoritmos;

public class merge_sort {
    private static int contadorAtribuicao = 0; // Contador de operações de atribuição
    private static int contadorComparacao = 0; // Contador de operações de comparação

    public static int[] ordenar(int vetor[], int p, int u)
    {
        if (p < u) {
            int q = p + (u-p)/2;

            ordenar(vetor, p, q);
            ordenar(vetor, q + 1, u);

            merge(vetor, p, q, u);
        }
        return vetor;
    }

    public static int[] merge(int vetor[], int p, int q, int u){

        int n1 = q - p + 1;
        int n2 = u - q;

        int esq[] = new int[n1];
        int dir[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            esq[i] = vetor[p + i];
            contadorAtribuicao++;
        }
        for (int j = 0; j < n2; ++j) {
            dir[j] = vetor[q + 1 + j];
            contadorAtribuicao++;
        }

        int i = 0, j = 0;

        int k = p;
        while (i < n1 && j < n2) {
            contadorComparacao++;
            if (esq[i] <= dir[j]) {
                vetor[k] = esq[i];
                i++;
            } else {
                vetor[k] = dir[j];
                j++;
            }
            k++;
            contadorAtribuicao++;
        }

        while (i < n1) {
            vetor[k] = esq[i];
            i++;
            k++;
            contadorAtribuicao++;
        }

        while (j < n2) {
            vetor[k] = dir[j];
            j++;
            k++;
            contadorAtribuicao++;
        }
        return vetor;
    }

    public static int getContadorAtribuicao() {
        return contadorAtribuicao;
    }

    public static int getContadorComparacao() {
        return contadorComparacao;
    }

    public static void resetarContadores() {
        contadorAtribuicao = 0;
        contadorComparacao = 0;
    }
}
