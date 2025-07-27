package src.controller;
import java.util.Scanner;

import src.model.Administrador;
import src.model.Filme;
import src.model.Pessoa;
import src.model.PessoaEstudante;
import src.model.PessoaIdoso;
import src.model.PessoaNormal;
import src.model.PessoaProfessor;
import src.model.Sessao;
import src.util.Contador;

public class Sistema {

    protected Pessoa[] clientes = new Pessoa[1000];
    Contador count = new Contador(0);

    protected Filme[] filmes = new Filme[10];
    Contador contadorFilmes = new Contador(0);

    protected Administrador[] admins = new Administrador[20];
    Contador contadorAdmins = new Contador(0);

    protected Sessao[] sessoes = new Sessao[20];
    Contador contadorSessoes = new Contador(0);



    Scanner input = new Scanner(System.in);

    public String menuInicial(){
        String menu = "\n=-=-=-=-=-=-=   MENU PRINCIPAL   =-=-=-=-=-=-=\n" +
                "1 - LOGIN CLIENTES;\n" +
                "2 - LOGIN ADMINISTRATIVO;\n" +
                "0 - SAIR;\n" +
                "ESCOLHA UMA OPÇÃO ACIMA:   ";

        return menu;
    }


    public void sistemaPrincipal(){
        int option;
        do {
            System.out.println(menuInicial());
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:{

                    System.out.println("\n\n ======== ÁREA DE LOGIN DO CLIENTE =======\n");
                    System.out.println("1 - CADASTRAR NOVO CLIENTE;");
                    System.out.println("2 - LOGAR COMO CLIENTE;");
                    System.out.println("3 - VOLTAR PRO MENU PRINCIPAL;");
                    System.out.print("ESCOLHA UMA OPÇÃO ACIMA:    ");
                    int opcaoCliente = Integer.parseInt(input.nextLine());

                    if(opcaoCliente == 1) {
                        System.out.print("Digite o seu nome:      ");
                        String nomeCliente = input.nextLine();

                        System.out.println("\nDigite a sua idade:     ");
                        int idade = Integer.parseInt(input.nextLine());

                        System.out.println("\nEscolha a sua categoria:  \n" +
                                "1 - Normal;\n" +
                                "2 - Estudante;\n" +
                                "3 - Idoso\n" +
                                "4 - Professor        ");
                        int categoria = Integer.parseInt(input.nextLine());

                        if(categoria <= 0 || categoria > 4) {
                            System.out.println("Erro! opção de categoria inválida!");
                            break;
                        }

                        System.out.println("Defina uma senha:   ");
                        String senha = input.nextLine();


                        if (categoria == 1) {
                            clientes[count.valor] = new PessoaNormal(nomeCliente, idade, senha);
                            count.valor++;


                        } else if (categoria == 2) {
                            clientes[count.valor] = new PessoaEstudante(nomeCliente, idade, senha);
                            count.valor++;

                        } else if (categoria == 3) {
                            clientes[count.valor] = new PessoaIdoso(nomeCliente, idade, senha);
                            count.valor++;

                        } else if (categoria == 4) {
                            clientes[count.valor] = new PessoaProfessor(nomeCliente, idade, senha);
                            count.valor++;

                        }

                        clientes[count.valor-1].sistemaClientes(filmes, contadorFilmes, sessoes, contadorSessoes);
                        break;

                    }

                    else if(opcaoCliente == 2){

                        System.out.print("\nDigite o seu nome:     ");
                        String nomeCliente = input.nextLine();

                        System.out.println("\nDigite a sua senha:     ");
                        String senhaCliente = input.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < count.valor; i++) {
                            if (clientes[i].getNome().equalsIgnoreCase(nomeCliente) && clientes[i].getSenha().equals(senhaCliente)) {
                                clientes[i].sistemaClientes(filmes, contadorFilmes, sessoes, contadorSessoes);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("\nNenhum cliente com esse nome ou senha!\n");
                            break;
                        }
                    }

                    else if(opcaoCliente == 3){
                        System.out.println("\nvoltando...\n");
                        break;
                    }

                    else{
                        System.out.println("\nErro! opção inválida!\n");
                    }
                    break;
                }

                case 2:{

                    System.out.println("\n\n=-=-=-= ÁREA DE LOGIN DO ADMINISTRADOR =-=-=-=");
                    System.out.println("1 - CADASTRAR NOVO ADM;");
                    System.out.println("2 - LOGAR COMO ADM;");
                    System.out.println("3 - VOLTAR PRO MENU PRINCIPAL;");
                    System.out.print("ESCOLHA UMA OPÇÃO ACIMA:      ");
                    int opcaoAdmin = Integer.parseInt(input.nextLine());

                    if(opcaoAdmin == 1){
                        System.out.println("Digite o seu nome: ");
                        String nomeAdm = input.nextLine();

                        System.out.println("Defina a sua senha: ");
                        String senhaAdm = input.nextLine();

                        admins[contadorAdmins.valor] = new Administrador(nomeAdm, senhaAdm);
                        contadorAdmins.valor++;

                        admins[contadorAdmins.valor-1].sistemaAdministrador(filmes, contadorFilmes, sessoes, contadorSessoes);
                        break;
                    }

                    else if(opcaoAdmin == 2){
                        System.out.println("Digite o seu nome: ");
                        String nomeAdm = input.nextLine();

                        System.out.println("Digite a sua senha: ");
                        String senhaAdm = input.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < contadorAdmins.valor; i++) {
                            if (admins[i].getNome().equalsIgnoreCase(nomeAdm) && admins[i].getSenha().equals(senhaAdm)) {
                                admins[i].sistemaAdministrador(filmes, contadorFilmes, sessoes, contadorSessoes);
                                encontrado = true;
                                break;
                            }
                            }
                        if (!encontrado) {
                                System.out.println("Nenhum administrador com esse nome ou senha!");
                                break;
                        }
                    }

                    else if(opcaoAdmin == 3){
                        System.out.println("\nvoltando...\n");
                        break;
                    }

                    else{
                        System.out.println("\nErro! opção inválida!");
                        break;
                    }
                    break;
                }
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
            }
        } while (option != 0);
    }


}
