package algoritmos;

import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao, opcao2, tam;
        do {
            System.out.print("Qual a opção? 1 - Crescente / 2 - Decrescente / 3 - Aleatório\n"); // Caso queira sair do programa digite número diferente de 1, 2 e 3.
            opcao = sc.nextInt();
            if (opcao == 1 || opcao == 2 || opcao == 3) {
                System.out.print("Qual o tamanho do vetor?\n");
                tam = sc.nextInt();
                int[] vetor = GeradorVetor.gerar(tam, opcao);
                System.out.print("Selecione o algoritmo: 1 - Insertion / 2 - Bubble / 3 - Selection / 4 - Merge / 5 - Heap / 6 - Quick\n");
                opcao2 = sc.nextInt();
                switch (opcao2) {
                    case 1:
                        long tempoInicial = System.currentTimeMillis();
                        vetor = InsertionSort.ordenar(vetor);
                        long tempoGasto = System.currentTimeMillis() - tempoInicial;
                        ImprimeVetor.imprime(vetor);
                        System.out.println("O método InsertionSort foi executado em " + tempoGasto + " ms");
                        break;

                    case 2:
                        long tempoInicial2 = System.currentTimeMillis();
                        vetor = BubbleSort.sort(vetor); // Adição aqui
                        long tempoGasto2 = System.currentTimeMillis() - tempoInicial2;
                        ImprimeVetor.imprime(vetor);
                        System.out.println("O método BubbleSort foi executado em " + tempoGasto2 + " ms");
                        break;

                    case 3:
                        long tempoInicial3 = System.currentTimeMillis();
                        int[] copiaVetorSelection = Arrays.copyOf(vetor, vetor.length);
                        SelectionSort.sort(copiaVetorSelection);
                        long tempoGasto3 = System.currentTimeMillis() - tempoInicial3;
                        ImprimeVetor.imprime(copiaVetorSelection);
                        System.out.println("O método SelectionSort foi executado em " + tempoGasto3 + " ms");
                        break;

                    case 4:
                        long tempoInicial4 = System.currentTimeMillis();
                        int[] copiaVetorMerge = Arrays.copyOf(vetor, vetor.length);
                        MergeSort.ordenar(copiaVetorMerge, 0, copiaVetorMerge.length - 1);
                        long tempoGasto4 = System.currentTimeMillis() - tempoInicial4;
                        ImprimeVetor.imprime(copiaVetorMerge);
                        System.out.println("O método MergeSort foi executado em " + tempoGasto4 + " ms");
                        System.out.println("Número de comparações: " + MergeSort.getContadorComparacao());
                        System.out.println("Número de atribuições: " + MergeSort.getContadorAtribuicao());
                        MergeSort.resetarContadores();
                        break;

                    case 5:
                        long tempoInicial5 = System.currentTimeMillis();
                        int[] copiaVetorHeap = Arrays.copyOf(vetor, vetor.length);
                        HeapSort.ordenar(copiaVetorHeap);
                        long tempoGasto5 = System.currentTimeMillis() - tempoInicial5;
                        ImprimeVetor.imprime(copiaVetorHeap);
                        System.out.println("O método HeapSort foi executado em " + tempoGasto5 + " ms");
                        System.out.println("Número de comparações: " + HeapSort.getComparacoes());
                        System.out.println("Número de atribuições: " + HeapSort.getAtribuicoes());
                        break;

                    case 6:
                        long tempoInicial6 = System.currentTimeMillis();
                        int[] copiaVetorQuickInsertion = Arrays.copyOf(vetor, vetor.length);
                        QuickSort.ordenar(copiaVetorQuickInsertion, 0, copiaVetorQuickInsertion.length - 1);
                        long tempoGasto6 = System.currentTimeMillis() - tempoInicial6;
                        ImprimeVetor.imprime(copiaVetorQuickInsertion);
                        System.out.println("O método QuickSort foi executado em " + tempoGasto6 + " ms");
                        System.out.println("Número de comparações: " + QuickSort.getComparacoes());
                        System.out.println("Número de atribuições: " + QuickSort.getAtribuicoes());
                        QuickSort.resetarContadores();
                        break;

                    // Restante dos casos permanece igual
                    // ...
                    default:
                        System.out.println("Opcao invalida!");
                }
            }
        } while (opcao > 0 && opcao < 4);
    }
}
