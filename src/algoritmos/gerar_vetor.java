package algoritmos;

import java.util.Random;

public class gerar_vetor {
    public static int[] gerar(int tam, int t) {
        int [] vetor = new int[tam];
        if(t==1) {
            for(int i=0;i<tam;i++) {
                vetor[i] = i;
            }
        } else if(t==2) {
            for(int i=0;i<tam;i++) {
                vetor[i] = tam-i;
            }
        } else if(t==3) {
            Random rand = new Random();
            for(int i=0;i<tam;i++) {
                int numero = rand.nextInt(tam);
                vetor[i] = numero;
            }
        }
        for(int i=0;i<vetor.length;i++) {
            System.out.println(vetor[i]);
        }
        System.out.println("***********");
        return vetor;
    }
}
