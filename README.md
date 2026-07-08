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
- O comando `javac` precisa estar disponível no `PATH` ou em `JAVA_HOME\bin`.

### Corrigindo `javac nao encontrado`
Esse erro indica que o Java Runtime está instalado, mas o compilador do JDK não está disponível no terminal.

Instale um JDK, por exemplo Temurin, Oracle JDK, Microsoft Build of OpenJDK ou outro JDK compatível. Depois configure uma destas opções:

1. Defina `JAVA_HOME` apontando para a pasta do JDK, por exemplo:

```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
```

2. Ou adicione diretamente a pasta `bin` do JDK ao `PATH`.

Para verificar se ficou correto:

```powershell
javac -version
java -version
```

Se `javac -version` responder uma versão, os scripts `compilar`, `executar` e `testar` já devem funcionar.

## Compilar e executar (linha de comando)
No diretório raiz do projeto, execute pelo PowerShell:

```powershell
powershell -ExecutionPolicy Bypass -File .\compilar.ps1
powershell -ExecutionPolicy Bypass -File .\executar.ps1
powershell -ExecutionPolicy Bypass -File .\testar.ps1
```

Ou pelo Prompt de Comando:

```bat
compilar.bat
executar.bat
testar.bat
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

## Testes
Os testes automatizados ficam em `src/testes/TesteAlgoritmos.java`.

Eles validam todos os algoritmos com vetores:
- vazio;
- tamanho 1;
- já ordenado;
- reverso;
- com repetidos;
- aleatório.

Para executar:

```powershell
powershell -ExecutionPolicy Bypass -File .\testar.ps1
```

Ou:

```bat
testar.bat
```

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
