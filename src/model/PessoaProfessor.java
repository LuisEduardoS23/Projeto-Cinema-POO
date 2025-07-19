package src.model;

public class PessoaProfessor extends Pessoa{
    private String categoria = "Professor";
    private double desconto = 0.3;

    public PessoaProfessor(String nome, int idade, String senha) {
        super(nome,idade, senha);
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
