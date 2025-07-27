package src.model;
import java.util.Scanner;

import src.util.Contador;

public class Administrador {
    private String nome;
    private String senha;

    Scanner input = new Scanner(System.in);

    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String menuAdministrador(){
        String menu = "\n=-=-=-=-=-=-=   MENU DO ADMINISTRADOR   =-=-=-=-=-=-=\n" +
                "1 - VER FILMES EM CARTAZ;\n" +
                "2 - CADASTRAR NOVO FILME;\n" +
                "3 - REMOVER FILME DE CARTAZ;\n" +
                "4 - VER SESSÕES;\n" +
                "5 - CADASTRAR SESSÃO;\n" +
                "6 - REMOVER SESSÃO;\n" +
                "0 - DESLOGAR;\n" +
                "ESCOLHA UMA DAS OPÇÕES ACIMA:  ";
        return menu;
    }

    public void sistemaAdministrador(Filme[] filmes, Contador contadorFilmes, Sessao[] sessoes, Contador contadorSessoes){
        int optionAdministrador;

        do{
            System.out.println("\n\nAdministrador logado! Nome : " + this.getNome());
            System.out.println(menuAdministrador());
            optionAdministrador = Integer.parseInt(input.nextLine());

            switch(optionAdministrador) {


                case 1:{
                    Filme.verFilmes(filmes, contadorFilmes);
                    break;
                }

                case 2: {
                    System.out.println("\n    CADASTRANDO NOVO FILME\n");

                    System.out.println("Digite o nome do filme: ");
                    String nome = input.nextLine();

                    System.out.println("Digite o duração do filme: ");
                    int duracao = Integer.parseInt(input.nextLine());

                    System.out.println("Digite o gênero do filme: ");
                    String genero = input.nextLine();

                    filmes[contadorFilmes.valor] = new Filme(nome, duracao, genero);
                    contadorFilmes.valor++;

                    System.out.println("\nFilme cadastrado com sucesso!\n");
                    break;
                }

                case 3:{
                    System.out.println("\n    REMOVER FILME DE CARTAZ\n");

                    if (contadorFilmes.valor == 0 ) {
                        System.out.println("Nenhum filme no sistema...\n\n");
                    }
                    else {
                        for (int i = 0; i < contadorFilmes.valor; i++) {
                            System.out.println( i +" - Filme: " + filmes[i].getTitulo() + "    duração: " + filmes[i].getDuracao() + "    gênero: " + filmes[i].getGenero());
                        }
                        System.out.println("Escolha o filme acima que deseja remover: ");
                        int filmeRemovido = Integer.parseInt(input.nextLine());

                        for (int j = filmeRemovido; j < contadorFilmes.valor-1; j++) {
                            filmes[j] = filmes[j+1];
                        }
                        System.out.println("\nFilme removido com sucesso!\n");
                        contadorFilmes.valor--;
                        break;
                    }
                }

                case 4:{
                    Sessao.verSessoes(sessoes, contadorSessoes);
                    break;
                }

                case 5:{
                    System.out.println("=-=- CADASTRANDO SESSÃO -=-=");
                    System.out.println("Escolha o filme para a sessão: ");
                    Filme.verFilmes(filmes, contadorFilmes);
                    System.out.println("Escolha um filme: ");
                    int filme = Integer.parseInt(input.nextLine());
                    if(filme <= 0 || filme > filmes.length) {
                        System.out.println("Opção Inválida!\n");
                        break;
                    }
                    else {

                        System.out.print("\nEscolha uma sala (1, 2, 3, 4, 5):   ");
                        int sala = Integer.parseInt(input.nextLine());

                        System.out.print("\nDigite o horário da sessão (Digite no formato hh:mm) :  ");
                        String horario = input.nextLine();

                        boolean conflito = false;

                        for (int i = 0; i < contadorSessoes.valor; i++) {
                            if (sessoes[i].numeroSala == sala && sessoes[i].horario.equalsIgnoreCase(horario)) {
                                conflito = true;
                            }
                        }
                        if (conflito) {
                            System.out.println("\nERRO! A sala " + sala + " já tem uma outra sessão neste horário!\n");
                            break;
                        } else {
                            sessoes[contadorSessoes.valor] = new Sessao(horario, filmes[filme - 1].getTitulo(), sala);
                            contadorSessoes.valor++;

                            System.out.println("\nSessão cadastrada com sucesso!\n");
                            break;
                        }
                    }
                }

                case 6:{
                    System.out.println("\n    REMOVER SESSÃO\n");

                    if (contadorSessoes.valor == 0 ) {
                        System.out.println("Nenhuma sessão no sistema...\n\n");
                    }
                    else {
                            Sessao.verSessoes(sessoes, contadorSessoes);
                        }
                        System.out.println("Escolha a sessão acima que deseja remover: ");
                        int sessaoRemovida = Integer.parseInt(input.nextLine());

                        for (int j = sessaoRemovida -1; j < contadorSessoes.valor-1; j++) {
                            sessoes[j] = sessoes[j+1];
                        }
                        System.out.println("\nSessão removida com sucesso!\n");
                        contadorSessoes.valor--;
                        break;
                    }


                case 0:{
                    break;
                }
            }

        } while (optionAdministrador != 0);
    }

}
