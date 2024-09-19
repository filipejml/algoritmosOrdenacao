package algoritmos;

public class quick_sort {
    private static long comparacoes = 0;
    private static long atribuicoes = 0;

    public static int[] trocar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        atribuicoes += 3;  // Três atribuições foram feitas
        return arr;
    }

    public static int particionar(int[] arr, int baixo, int alto) {
        int pivo = arr[alto];
        int i = (baixo - 1);

        for (int j = baixo; j <= alto - 1; j++) {
            comparacoes++;
            if (arr[j] < pivo) {
                i++;
                trocar(arr, i, j);
            }
        }
        trocar(arr, i + 1, alto);
        return (i + 1);
    }

    public static void insercao(int[] vetor, int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            int j = i;
            while (j > inicio && vetor[j - 1] > vetor[j]) {
                trocar(vetor, j, j - 1);
                j = j - 1;
            }
        }
    }

    public static int[] QuickInsertionSort(int[] vetor, int inicio, int fim) {
        while (inicio < fim) {
            if (fim - inicio < 50) {
                insercao(vetor, inicio, fim);
                break;
            } else {
                int pivo = particionar(vetor, inicio, fim);

                if (pivo - inicio < fim - pivo) {
                    QuickInsertionSort(vetor, inicio, pivo - 1);
                    inicio = pivo + 1;
                } else {
                    QuickInsertionSort(vetor, pivo + 1, fim);
                    fim = pivo - 1;
                }
            }
        }
        return vetor;
    }

    public static int[] ordenar(int[] arr, int baixo, int alto) {
        atribuicoes = 0;
        comparacoes = 0;
        QuickInsertionSort(arr, baixo, alto);
        return arr;
    }

    public static long getComparacoes() {
        return comparacoes;
    }

    public static long getAtribuicoes() {
        return atribuicoes;
    }

    public static void resetarContadores() {
        comparacoes = 0;
        atribuicoes = 0;
    }
}
