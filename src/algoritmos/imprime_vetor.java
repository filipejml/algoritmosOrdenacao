package algoritmos;

public class imprime_vetor {
    public static void imprime(int vetor[])
    {
        int n = vetor.length;
        for (int i = 0; i < n; i++)
            System.out.print(vetor[i] + " ");
        System.out.println();
    }
}
