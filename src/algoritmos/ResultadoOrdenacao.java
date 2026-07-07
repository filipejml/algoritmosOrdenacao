package algoritmos;

public class ResultadoOrdenacao {
    private final int[] vetorOrdenado;
    private final long tempoMs;
    private final long comparacoes;
    private final long atribuicoes;
    private final String nomeAlgoritmo;

    public ResultadoOrdenacao(int[] vetorOrdenado, long tempoMs, long comparacoes, long atribuicoes, String nomeAlgoritmo) {
        this.vetorOrdenado = vetorOrdenado;
        this.tempoMs = tempoMs;
        this.comparacoes = comparacoes;
        this.atribuicoes = atribuicoes;
        this.nomeAlgoritmo = nomeAlgoritmo;
    }

    public int[] getVetorOrdenado() {
        return vetorOrdenado;
    }

    public long getTempoMs() {
        return tempoMs;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getAtribuicoes() {
        return atribuicoes;
    }

    public String getNomeAlgoritmo() {
        return nomeAlgoritmo;
    }
}
