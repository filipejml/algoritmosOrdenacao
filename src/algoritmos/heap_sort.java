package algoritmos;

public class heap_sort {
        private static int comparacoes = 0;
        private static int atribuicoes = 0;

        public static int[] ordenar(int arr[]) {
            int N = arr.length;

            for (int i = N / 2 - 1; i >= 0; i--) {
                heapify(arr, N, i);
            }

            for (int i = N - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, i, 0);
            }
            return arr;
        }

        public static int getComparacoes() {
            return comparacoes;
        }

        public static int getAtribuicoes() {
            return atribuicoes;
        }

        public static void resetarContadores() {
            comparacoes = 0;
            atribuicoes = 0;
        }
        public static int[] heapify(int arr[], int N, int i) {
            int maior = i;
            int esquerda = 2 * i + 1;
            int direita = 2 * i + 2;

            if (esquerda < N) {
                comparacoes++;
                if (arr[esquerda] > arr[maior])
                    maior = esquerda;
            }

            if (direita < N) {
                comparacoes++;
                if (arr[direita] > arr[maior])
                    maior = direita;
            }

            if (maior != i) {
                int troca = arr[i];
                arr[i] = arr[maior];
                arr[maior] = troca;
                atribuicoes += 3;

                heapify(arr, N, maior);
            }
            return arr;
        }
}
