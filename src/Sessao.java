package src;
import java.util.Scanner;

public class Sessao {
    String horario;
    String filme;
    int numeroSala;
    String[][] assentos = {
            {"A_01", "A_02", "A_03", "A_04", "A_05", "A_06", "A_07", "A_08", "A_09", "A_10"},
            {"B_01", "B_02", "B_03", "B_04", "B_05", "B_06", "B_07", "B_08", "B_09", "B_10"},
            {"C_01", "C_02", "C_03", "C_04", "C_05", "C_06", "C_07", "C_08", "C_09", "C_10"},
            {"D_01", "D_02", "D_03", "D_04", "D_05", "D_06", "D_07", "D_08", "D_09", "D_10"},
            {"E_01", "E_02", "E_03", "E_04", "E_05", "E_06", "E_07", "E_08", "E_09", "E_10"},
            {"F_01", "F_02", "F_03", "F_04", "F_05", "F_06", "F_07", "F_08", "F_09", "F_10"},
            {"G_01", "G_02", "G_03", "G_04", "G_05", "G_06", "G_07", "G_08", "G_09", "G_10"},
            {"H_01", "H_02", "H_03", "H_04", "H_05", "H_06", "H_07", "H_08", "H_09", "H_10"},
            {"I_01", "I_02", "I_03", "I_04", "I_05", "I_06", "I_07", "I_08", "I_09", "I_10"},
            {"J_01", "J_02", "J_03", "J_04", "J_05", "J_06", "J_07", "J_08", "J_09", "J_10"},
            {"K_01", "K_02", "K_03", "K_04", "K_05", "K_06", "K_07", "K_08", "K_09", "K_10"},
            {"L_01", "L_02", "L_03", "L_04", "L_05", "L_06", "L_07", "L_08", "L_09", "L_10"},
            {"M_01", "M_02", "M_03", "M_04", "M_05", "M_06", "M_07", "M_08", "M_09", "M_10"},
            {"N_01", "N_02", "N_03", "N_04", "N_05", "N_06", "N_07", "N_08", "N_09", "N_10"},
            {"O_01", "O_02", "O_03", "O_04", "O_05", "O_06", "O_07", "O_08", "O_09", "O_10"},
            {"P_01", "P_02", "P_03", "P_04", "P_05", "P_06", "P_07", "P_08", "P_09", "P_10"},
            {"Q_01", "Q_02", "Q_03", "Q_04", "Q_05", "Q_06", "Q_07", "Q_08", "Q_09", "Q_10"},
            {"R_01", "R_02", "R_03", "R_04", "R_05", "R_06", "R_07", "R_08", "R_09", "R_10"},
            {"S_01", "S_02", "S_03", "S_04", "S_05", "S_06", "S_07", "S_08", "S_09", "S_10"},
            {"T_01", "T_02", "T_03", "T_04", "T_05", "T_06", "T_07", "T_08", "T_09", "T_10"}
    };


    Scanner input = new Scanner(System.in);


    public Sessao(String horario, String filme, int numeroSala) {
        this.horario = horario;
        this.filme = filme;
        this.numeroSala = numeroSala;
    }

    public String getHorario() {
        return horario;
    }

    public String getFilme() {
        return filme;
    }

    public int getNumeroSala() {
        return numeroSala;
    }



    public static void verSessoes(Sessao[] sessoes, Contador contadorSessoes){
        if (contadorSessoes.valor == 0) {
            System.out.println("\nNenhuma sessão cadastrada no momento...\n");
        }
        else{
            for (int i = 0; i < contadorSessoes.valor;i++){
                System.out.println("Sessão 0" + (i+1) + ":  " + sessoes[i].getFilme() + " - " + sessoes[i].getHorario() + ". Sala: " + sessoes[i].getNumeroSala());
            }
        }
    }

    public String escolherAssento(){
        System.out.println("=-=-=-= ASSENTOS DISPNÍVEIS =-=-=-=\n");
        System.out.println("XXXX --> Assento Vendido;");
        System.out.println("LETRA_NÚMERO --> Assento Disponível.\n\n");

        for (int i = 0; i < 19; i++) {
            System.out.print("|");
            for (int j = 0; j < 10; j++) {
                System.out.print(assentos[i][j] + " | ");
            }
            System.out.print("\n");
        }

        System.out.print("\nEscolha um assento ( DIGITE EXATAMENTE COMO ESTÁ! Ex: A_08 ): ");
        String assentoEscolhido = input.nextLine();
        boolean assentoValido = false;
        String copiaAssento = "";

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 10; j++) {
                if (assentoEscolhido.equalsIgnoreCase(assentos[i][j])){
                    System.out.println("\nAssento "+ this.assentos[i][j] +" Selecionado com sucesso!\n");
                    assentoValido = true;
                    copiaAssento = this.assentos[i][j];
                    this.assentos[i][j] = "XXXX";
                }
            }
        }
        if (!assentoValido) {
            System.out.println("Erro! o assento selecionado é inválido ou está ocupado...");
            return "ERRO";
        }
        else{
            return copiaAssento;
        }
    }


}
