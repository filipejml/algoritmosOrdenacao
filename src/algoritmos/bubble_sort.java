package algoritmos;

public class bubble_sort {
    public static int[] sort(int [] vetor) {
        long comparacoes = 0;
        long atribuicoes = 0;

        for(int i = 0; i < vetor.length; i++) {
            for(int j = 0; j < vetor.length - 1 - i; j++) {
                comparacoes++;
                if(vetor[j] > vetor[j+1]) {
                    int chave = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = chave;
                    atribuicoes += 3;
                }
            }
        }

        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de atribuições: " + atribuicoes);

        return vetor;
    }
}
