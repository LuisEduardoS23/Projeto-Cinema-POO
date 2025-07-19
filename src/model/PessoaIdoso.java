package src.model;

public class PessoaIdoso extends Pessoa{
    private String categoria = "Idoso";
    private double desconto = 1;

    public PessoaIdoso(String nome, int idade, String senha) {
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
