public class PessoaEstudante extends Pessoa{
    private String categoria = "Estudante";
    private double desconto = 0.5;

    public PessoaEstudante(String nome, int idade, String senha) {
        super(nome, idade, senha);
    }

    public double getDesconto() {
        return desconto;
    }

    public String getCategoria() {
        return categoria;
    }

    public double precoIngresso(){
        double preco = 25 * (1-desconto);
        return preco;
    }
}
