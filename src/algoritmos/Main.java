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
                int[] vetor = gerar_vetor.gerar(tam, opcao);
                System.out.print("Selecione o algoritmo: 1 - Insertion / 2 - Bubble / 3 - Selection / 4 - Merge / 5 - Heap / 6 - Quick\n");
                opcao2 = sc.nextInt();
                switch (opcao2) {
                    case 1:
                        long tempoInicial = System.currentTimeMillis();
                        vetor = insertion_sort.ordenar(vetor);
                        long tempoGasto = System.currentTimeMillis() - tempoInicial;
                        imprime_vetor.imprime(vetor);
                        System.out.println("O método InsertionSort foi executado em " + tempoGasto + " ms");
                        break;

                    case 2:
                        long tempoInicial2 = System.currentTimeMillis();
                        vetor = bubble_sort.sort(vetor); // Adição aqui
                        long tempoGasto2 = System.currentTimeMillis() - tempoInicial2;
                        imprime_vetor.imprime(vetor);
                        System.out.println("O método BubbleSort foi executado em " + tempoGasto2 + " ms");
                        break;

                    case 3:
                        long tempoInicial3 = System.currentTimeMillis();
                        int[] copiaVetorSelection = Arrays.copyOf(vetor, vetor.length);
                        selection_sort.sort(copiaVetorSelection);
                        long tempoGasto3 = System.currentTimeMillis() - tempoInicial3;
                        imprime_vetor.imprime(copiaVetorSelection);
                        System.out.println("O método SelectionSort foi executado em " + tempoGasto3 + " ms");
                        break;

                    case 4:
                        long tempoInicial4 = System.currentTimeMillis();
                        int[] copiaVetorMerge = Arrays.copyOf(vetor, vetor.length);
                        merge_sort.ordenar(copiaVetorMerge, 0, copiaVetorMerge.length - 1);
                        long tempoGasto4 = System.currentTimeMillis() - tempoInicial4;
                        imprime_vetor.imprime(copiaVetorMerge);
                        System.out.println("O método MergeSort foi executado em " + tempoGasto4 + " ms");
                        System.out.println("Número de comparações: " + merge_sort.getContadorComparacao());
                        System.out.println("Número de atribuições: " + merge_sort.getContadorAtribuicao());
                        merge_sort.resetarContadores();
                        break;

                    case 5:
                        long tempoInicial5 = System.currentTimeMillis();
                        int[] copiaVetorHeap = Arrays.copyOf(vetor, vetor.length);
                        heap_sort.ordenar(copiaVetorHeap);
                        long tempoGasto5 = System.currentTimeMillis() - tempoInicial5;
                        imprime_vetor.imprime(copiaVetorHeap);
                        System.out.println("O método HeapSort foi executado em " + tempoGasto5 + " ms");
                        System.out.println("Número de comparações: " + heap_sort.getComparacoes());
                        System.out.println("Número de atribuições: " + heap_sort.getAtribuicoes());
                        break;

                    case 6:
                        long tempoInicial6 = System.currentTimeMillis();
                        int[] copiaVetorQuickInsertion = Arrays.copyOf(vetor, vetor.length);
                        quick_sort.ordenar(copiaVetorQuickInsertion, 0, copiaVetorQuickInsertion.length - 1);
                        long tempoGasto6 = System.currentTimeMillis() - tempoInicial6;
                        imprime_vetor.imprime(copiaVetorQuickInsertion);
                        System.out.println("O método QuickSort foi executado em " + tempoGasto6 + " ms");
                        System.out.println("Número de comparações: " + quick_sort.getComparacoes());
                        System.out.println("Número de atribuições: " + quick_sort.getAtribuicoes());
                        quick_sort.resetarContadores();
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