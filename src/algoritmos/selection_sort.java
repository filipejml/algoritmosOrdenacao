package algoritmos;

public class selection_sort {

    public static void sort(int[] vetor) {
        int comparacaoSelection = 0;
        int atribuiSelection = 0;
        int tamanho = vetor.length;

        for (int i = 0; i < tamanho; i++) {
            // Encontra o índice do menor elemento restante na lista
            int indiceMenor = i;
            for (int j = i + 1; j < tamanho; j++) {
                comparacaoSelection++;
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Troca o elemento mínimo encontrado com o elemento na posição i
            int temp = vetor[i];
            vetor[i] = vetor[indiceMenor];
            vetor[indiceMenor] = temp;
            atribuiSelection += 3; // Contabiliza as atribuições (troca de elementos)
        }

        // Imprime o número de comparações e atribuições
        System.out.println("Número de comparações: " + comparacaoSelection);
        System.out.println("Número de atribuições: " + atribuiSelection);
    }
}
