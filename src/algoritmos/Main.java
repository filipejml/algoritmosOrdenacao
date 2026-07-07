package algoritmos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int LIMITE_IMPRESSAO_VETOR = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            opcao = lerInteiro(sc, menuTipoVetor());

            if (opcao == 0) {
                System.out.println("Programa encerrado.");
            } else if (opcao == 1 || opcao == 2 || opcao == 3) {
                int tam = lerInteiroPositivo(sc, "Qual o tamanho do vetor?");
                int[] vetor = GeradorVetor.gerar(tam, opcao);

                int opcaoAlgoritmo = lerInteiro(sc, menuAlgoritmos());
                ResultadoOrdenacao resultado = executarAlgoritmo(opcaoAlgoritmo, vetor);

                if (resultado != null) {
                    imprimirResultado(resultado);
                } else {
                    System.out.println("Opção inválida!");
                }
            } else {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static String menuTipoVetor() {
        return "\nEscolha o tipo de vetor:\n"
                + "0 - Sair\n"
                + "1 - Crescente\n"
                + "2 - Decrescente\n"
                + "3 - Aleatório";
    }

    private static String menuAlgoritmos() {
        return "\nSelecione o algoritmo:\n"
                + "1 - Insertion Sort\n"
                + "2 - Bubble Sort\n"
                + "3 - Selection Sort\n"
                + "4 - Merge Sort\n"
                + "5 - Heap Sort\n"
                + "6 - Quick Sort";
    }

    private static int lerInteiro(Scanner sc, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }

            System.out.println("Entrada inválida. Digite um número inteiro.");
            sc.next();
        }
    }

    private static int lerInteiroPositivo(Scanner sc, String mensagem) {
        while (true) {
            int valor = lerInteiro(sc, mensagem);
            if (valor > 0) {
                return valor;
            }

            System.out.println("Entrada inválida. Digite um número maior que zero.");
        }
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
