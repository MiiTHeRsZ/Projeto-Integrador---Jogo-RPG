//Importe das bibliotéca
import java.util.*;

public class Main {
    //Função principal, onde o programa se iniciará
    public static void main(String[] args) {
        //Declaração de variáveis
        String optionMenu, optionGame;

        //Instanciamento de objetos
        Scanner input = new Scanner(System.in);

        //Inicio do jogo - MENU
        System.out.println("Bem vindo ao Tech Sync\nJogo RPG Textual hambientado em um mundo futurista\n\n*INSTRUÇÃO para uso geral, ao escolher a opção desejada ignore qualquer acentuação e letra maiúscula,\npor exemplo, em 'Instruções' escreva 'intrucoes'!*");
        do{
            System.out.println("\n    MENU\n---Jogar---\n--Tutorial--\n--Créditos--\n---Sair---");
            System.out.print("Opção: ");
            optionMenu = input.next();

            switch(optionMenu){
                //Inicio do jogo - HISTÓRIA
                case "Jogar":
                case "jogar":
                    
                    break;
                //Tutorial de como o jogador deve seguir no jogo
                case "Tutorial":
                case "tutorial":
                    System.out.println("\nVocê começará como (LORE),\nao passo que você/seu personagem percorre pela história serão mostradas opções de ações possíveis,\né preferível que ao escolher um opção ela seja digitada ignorando sua acentuação e escrita totalmente em letras minúsculas,\n(MECANICA DE JOGO),\n(RECOMPENSA FINAL).\n\nEsperamos mesmo que se divirtão e aprendam jogando este jogo feito com o máximo de cuidado e atenção que essas poucas pessoas puderam tudo de si,\nAgradecemos e let's bora!");
                    break;
                //Responsáveis pelo projeto
                case "Creditos":
                case "creditos":
                    System.out.println("\n~Le pika/DEV: Gusta;p\n~Le carregado/escritor: Lucky*_*");
                    do{
                        System.out.print("\nDeseja voltar ao Menu? ");
                        optionMenu = input.next();
                        if(optionMenu.equalsIgnoreCase("Sim")){
                            optionMenu = "Menu";
                            break;
                        }else if(optionMenu.equalsIgnoreCase("Nao")){
                            optionMenu = "";
                            break;
                        }else{
                            System.out.println("Digite somente Sim ou Não");
                        }
                    }while(!optionMenu.equalsIgnoreCase("Sim") || !optionMenu.equalsIgnoreCase("Nao"));
                    break;
                case "Sair":
                case "sair":
                    System.out.println("\n\nEsperamos que tenha se divertido!");
                    optionMenu = "";
                    break;
                default:
                    System.out.println("\nComando inválido ou digitado de maneira errada, como intruido pode ignorar qualquer acentuação e letras maiusculas,\npor exemplo, ao invés de escrever 'Instruções' escreva 'intrucoes'!");
            }
        }while(optionMenu.equalsIgnoreCase("Menu"));
        
        System.out.println("\nObrigado por jogar :D");

        //Finalização de objetos
        input.close();
        //teste
    }
}