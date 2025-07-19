public class Filme {
    private String titulo;
    private int duracao;
    private String genero;

    public Filme(String titulo, int duracao, String genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public static void verFilmes(Filme[] filmes, Contador contadorFilmes) {
        if (contadorFilmes.valor == 0 ) {
            System.out.println("\nNenhum filme em cartaz no momento...\n\n");
        } else {
            for (int i = 0; i < contadorFilmes.valor; i++) {
                System.out.println( i+1 +"  Filme: " + filmes[i].getTitulo() + "    duração: " + filmes[i].getDuracao() + "    gênero: " + filmes[i].getGenero());
            }
        }
    }
    }

