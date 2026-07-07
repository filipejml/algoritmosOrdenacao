# Algoritmos de Ordenação (Java)

Projeto didático que implementa vários algoritmos de ordenação em Java e mede tempo de execução, comparações e atribuições.

## Conteúdo
- Implementações em src/algoritmos/:
  - Main.java - ponto de entrada que permite escolher o tipo de vetor e o algoritmo.
  - gerar_vetor.java - gera vetores (crescente, decrescente, aleatório).
  - insertion_sort.java, bubble_sort.java, selection_sort.java, merge_sort.java, heap_sort.java, quick_sort.java - algoritmos de ordenação.
  - imprime_vetor.java - utilitário para imprimir vetores.

Veja o ponto de entrada em [src/algoritmos/Main.java](src/algoritmos/Main.java#L1).

## Requisitos
- JDK 8 ou superior instalado.

## Compilar e executar (linha de comando)
No diretório raiz do projeto, execute:

```bash
javac -d out src/algoritmos/*.java
java -cp out algoritmos.Main
```

Explicação:
- O comando `javac` compila todas as classes do pacote para a pasta `out`.
- O comando `java` executa a classe `algoritmos.Main`.

## Uso
Ao executar, o programa pede três entradas principais:

1. Tipo de vetor:
   - 1 - Crescente
   - 2 - Decrescente
   - 3 - Aleatório

2. Tamanho do vetor: informe um número inteiro (ex.: 1000).

3. Seleção do algoritmo:
   - 1 - Insertion Sort
   - 2 - Bubble Sort
   - 3 - Selection Sort
   - 4 - Merge Sort (mostra comparações e atribuições)
   - 5 - Heap Sort (mostra comparações e atribuições)
   - 6 - Quick Sort (mostra comparações e atribuições)

O programa imprime o vetor ordenado e o tempo de execução em milissegundos.

## Observações
- Para vetores grandes, prefira algoritmos O(n log n) (Merge, Heap, Quick).
- Os contadores de comparações/atribuições são exibidos apenas para alguns algoritmos que os implementam.

## Sugestões
- Executar testes automatizados e medir medições médias para comparar algoritmos.
- Integrar um script para executar benchmarks com vários tamanhos e gerar CSVs.

---
Projeto criado para fins educacionais — análises e experimentos com algoritmos de ordenação.
