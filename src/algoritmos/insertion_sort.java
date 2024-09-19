package algoritmos;

public class insertion_sort {
    public static int[] ordenar(int[] vetor) {
        long comparacoes = 0;
        long atribuicoes = 0;

        for (int i = 0; i < vetor.length; i++) {
            int j = i;
            while (j > 0 && vetor[j - 1] > vetor[j]) {
                // Incrementa o contador de comparações
                comparacoes++;

                // Troca os elementos e incrementa o contador de atribuições
                int chave = vetor[j];
                vetor[j] = vetor[j - 1];
                vetor[j - 1] = chave;
                atribuicoes += 3; // Três atribuições na troca

                j = j - 1;
            }
        }

        // Imprime os contadores ou utilize conforme necessário
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Atribuições: " + atribuicoes);

        return vetor;
    }
}
