package algoritmos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int LIMITE_IMPRESSAO_VETOR = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao, opcao2, tam;

        do {
            System.out.print("Qual a opção? 1 - Crescente / 2 - Decrescente / 3 - Aleatório\n");
            opcao = sc.nextInt();

            if (opcao == 1 || opcao == 2 || opcao == 3) {
                System.out.print("Qual o tamanho do vetor?\n");
                tam = sc.nextInt();
                int[] vetor = GeradorVetor.gerar(tam, opcao);

                System.out.print("Selecione o algoritmo: 1 - Insertion / 2 - Bubble / 3 - Selection / 4 - Merge / 5 - Heap / 6 - Quick\n");
                opcao2 = sc.nextInt();

                ResultadoOrdenacao resultado = executarAlgoritmo(opcao2, vetor);

                if (resultado != null) {
                    imprimirResultado(resultado);
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } while (opcao > 0 && opcao < 4);
    }

    private static ResultadoOrdenacao executarAlgoritmo(int opcao, int[] vetor) {
        int[] copiaVetor = Arrays.copyOf(vetor, vetor.length);

        switch (opcao) {
            case 1:
                return InsertionSort.ordenar(copiaVetor);
            case 2:
                return BubbleSort.ordenar(copiaVetor);
            case 3:
                return SelectionSort.ordenar(copiaVetor);
            case 4:
                return MergeSort.ordenar(copiaVetor);
            case 5:
                return HeapSort.ordenar(copiaVetor);
            case 6:
                return QuickSort.ordenar(copiaVetor);
            default:
                return null;
        }
    }

    private static void imprimirResultado(ResultadoOrdenacao resultado) {
        imprimirVetorSeForPequeno(resultado.getVetorOrdenado());
        System.out.println("O método " + resultado.getNomeAlgoritmo() + " foi executado em " + resultado.getTempoMs() + " ms");
        System.out.println("Número de comparações: " + resultado.getComparacoes());
        System.out.println("Número de atribuições: " + resultado.getAtribuicoes());
    }

    private static void imprimirVetorSeForPequeno(int[] vetor) {
        if (vetor.length <= LIMITE_IMPRESSAO_VETOR) {
            ImprimeVetor.imprime(vetor);
            return;
        }

        System.out.println("Vetor ordenado omitido por ter " + vetor.length + " elementos.");
    }
}
