import java.util.Scanner;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String senha;

Scanner input = new Scanner(System.in);

    public Pessoa(String nome, int idade, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSenha() {
        return senha;
    }

    public String menuCliente(){
        String menu = "\n=-=-=-=-=-=-=   MENU DO CLIENTE   =-=-=-=-=-=-=\n" +
                "1 - VER FILMES EM CARTAZ;\n" +
                "2 - COMPRAR INGRESSOS;\n" +
                "0 - DESLOGAR;\n" +
                "ESCOLHA UMA DAS OPÇÕES ACIMA:  ";
        return menu;
    }

    public abstract double precoIngresso();

    public void sistemaClientes(Filme[] filmes, Contador contadorFilmes, Sessao[] sessoes, Contador contadorSessoes) {
        int optionCliente;

        do{
            System.out.println("Cliente logado! Nome : " + this.getNome());
            System.out.println(menuCliente());
            optionCliente = Integer.parseInt(input.nextLine());

            switch(optionCliente){

                case 1:{
                    System.out.println("\n    FILMES EM CARTAZ");
                    Filme.verFilmes(filmes, contadorFilmes);
                    break;
                }

                case 2: {
                    System.out.println("\n=-=-=-= COMPRANDO INGRESSO =-=-=-=\n\n");

                    if (contadorSessoes.valor == 0) {
                        System.out.println("\nDesculpe, sem sessões no momento...\n");
                        break;
                    } else {
                        Sessao.verSessoes(sessoes, contadorSessoes);
                        System.out.println("Digite o número correspondente a sessão que deseja comprar: ");
                        int numeroSessao = Integer.parseInt(input.nextLine());

                        String sessao = sessoes[numeroSessao - 1].escolherAssento();
                        if(sessao.equals("ERRO")){
                            break;
                        }
                        else {

                            System.out.println("\nIngresso para o filme: " + sessoes[numeroSessao - 1].filme + "    Assento: "+ sessao +
                                    "\nCom horário: " + sessoes[numeroSessao - 1].horario + " e preço no valor de R$ " + this.precoIngresso() +
                                    "\nPor favor, dirija-se ao caixa para o pagamento. Bom filme!\n");
                            break;
                        }
                    }
                }

            }

        } while (optionCliente != 0);

    }



}
