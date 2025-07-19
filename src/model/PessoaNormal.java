package src.model;

public class PessoaNormal extends Pessoa{
    private String categoria = "Normal";
    private double desconto = 0.0;

    public PessoaNormal(String nome, int idade, String senha) {
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
