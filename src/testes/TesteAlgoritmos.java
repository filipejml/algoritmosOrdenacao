package testes;

import algoritmos.BubbleSort;
import algoritmos.HeapSort;
import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import algoritmos.QuickSort;
import algoritmos.ResultadoOrdenacao;
import algoritmos.SelectionSort;

import java.util.Arrays;

public class TesteAlgoritmos {
    private interface Ordenador {
        ResultadoOrdenacao ordenar(int[] vetor);
    }

    private static class AlgoritmoTeste {
        private final String nome;
        private final Ordenador ordenador;

        private AlgoritmoTeste(String nome, Ordenador ordenador) {
            this.nome = nome;
            this.ordenador = ordenador;
        }
    }

    private static class CasoTeste {
        private final String nome;
        private final int[] vetor;

        private CasoTeste(String nome, int[] vetor) {
            this.nome = nome;
            this.vetor = vetor;
        }
    }

    public static void main(String[] args) {
        AlgoritmoTeste[] algoritmos = {
                new AlgoritmoTeste("InsertionSort", InsertionSort::ordenar),
                new AlgoritmoTeste("BubbleSort", BubbleSort::ordenar),
                new AlgoritmoTeste("SelectionSort", SelectionSort::ordenar),
                new AlgoritmoTeste("MergeSort", MergeSort::ordenar),
                new AlgoritmoTeste("HeapSort", HeapSort::ordenar),
                new AlgoritmoTeste("QuickSort", QuickSort::ordenar)
        };

        CasoTeste[] casos = {
                new CasoTeste("vazio", new int[]{}),
                new CasoTeste("tamanho 1", new int[]{7}),
                new CasoTeste("ja ordenado", new int[]{1, 2, 3, 4, 5}),
                new CasoTeste("reverso", new int[]{5, 4, 3, 2, 1}),
                new CasoTeste("com repetidos", new int[]{4, 2, 4, 1, 2, 1}),
                new CasoTeste("aleatorio", new int[]{17, 3, 42, 8, 23, 4, 15, 16})
        };

        int total = 0;
        for (AlgoritmoTeste algoritmo : algoritmos) {
            for (CasoTeste caso : casos) {
                validarOrdenacao(algoritmo, caso);
                total++;
            }
        }

        System.out.println("Todos os testes passaram: " + total + " verificacoes.");
    }

    private static void validarOrdenacao(AlgoritmoTeste algoritmo, CasoTeste caso) {
        int[] entrada = Arrays.copyOf(caso.vetor, caso.vetor.length);
        int[] esperado = Arrays.copyOf(caso.vetor, caso.vetor.length);
        Arrays.sort(esperado);

        ResultadoOrdenacao resultado = algoritmo.ordenador.ordenar(entrada);
        int[] obtido = resultado.getVetorOrdenado();

        if (!Arrays.equals(esperado, obtido)) {
            throw new AssertionError(
                    algoritmo.nome + " falhou no caso " + caso.nome
                            + ". Esperado: " + Arrays.toString(esperado)
                            + ". Obtido: " + Arrays.toString(obtido)
            );
        }
    }
}
