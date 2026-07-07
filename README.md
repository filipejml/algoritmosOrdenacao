# Algoritmos de Ordenação (Java)

Projeto didático que implementa vários algoritmos de ordenação em Java e mede tempo de execução, comparações e atribuições.

## Conteúdo
- Implementações em src/algoritmos/:
  - Main.java - ponto de entrada que permite escolher o tipo de vetor e o algoritmo.
  - GeradorVetor.java - gera vetores (crescente, decrescente, aleatório).
  - InsertionSort.java, BubbleSort.java, SelectionSort.java, MergeSort.java, HeapSort.java, QuickSort.java - algoritmos de ordenação.
  - ResultadoOrdenacao.java - representa o resultado de uma execução, com vetor ordenado, tempo, comparações, atribuições e nome do algoritmo.
  - ImprimeVetor.java - utilitário para imprimir vetores.

Veja o ponto de entrada em [src/algoritmos/Main.java](src/algoritmos/Main.java#L1).

## Requisitos
- JDK 8 ou superior instalado.

## Compilar e executar (linha de comando)
No diretório raiz do projeto, execute pelo PowerShell:

```powershell
powershell -ExecutionPolicy Bypass -File .\compilar.ps1
powershell -ExecutionPolicy Bypass -File .\executar.ps1
```

Ou pelo Prompt de Comando:

```bat
compilar.bat
executar.bat
```

Também é possível executar manualmente:

```bash
javac -encoding UTF-8 -d out src/algoritmos/*.java
java -cp out algoritmos.Main
```

Explicação:
- O comando `javac` compila todas as classes do pacote para a pasta `out`.
- O comando `java` executa a classe `algoritmos.Main`.
- Os scripts verificam se o `javac` está disponível no `PATH` ou em `JAVA_HOME\bin`.

## Uso
Ao executar, o programa pede três entradas principais:

1. Tipo de vetor:
   - 0 - Sair
   - 1 - Crescente
   - 2 - Decrescente
   - 3 - Aleatório

Use `0 - Sair` nesse menu para encerrar o programa.

2. Tamanho do vetor: informe um número inteiro maior que zero (ex.: 1000).

3. Seleção do algoritmo:
   - 1 - Insertion Sort
   - 2 - Bubble Sort
   - 3 - Selection Sort
   - 4 - Merge Sort
   - 5 - Heap Sort
   - 6 - Quick Sort

Entradas não numéricas são rejeitadas com uma mensagem de erro, sem encerrar o programa.

O programa imprime o vetor ordenado apenas quando ele tem até 100 elementos. Para vetores maiores, a impressão é omitida para evitar lentidão e excesso de saída. O programa sempre mostra o tempo de execução em milissegundos, o total de comparações e o total de atribuições. A medição usa `System.nanoTime()` e converte o resultado para milissegundos na saída.

## Observações
- Para vetores grandes, prefira algoritmos O(n log n) (Merge, Heap, Quick).
- Todos os algoritmos expõem o mesmo método público: `ordenar(int[] vetor)`, retornando um `ResultadoOrdenacao`.
- Os algoritmos retornam um `ResultadoOrdenacao` para padronizar vetor ordenado, tempo, comparações, atribuições e nome do algoritmo.

## Sugestões
- Executar testes automatizados e medir medições médias para comparar algoritmos.
- Integrar um script para executar benchmarks com vários tamanhos e gerar CSVs.

---
Projeto criado para fins educacionais - análises e experimentos com algoritmos de ordenação.
