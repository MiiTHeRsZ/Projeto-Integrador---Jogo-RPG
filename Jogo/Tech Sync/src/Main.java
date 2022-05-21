//Importe das bibliotéca
import java.util.*;

public class Main {
    //Declaração de variáveis
    static String optionMenu, optionGame, history;
    static boolean menu = true, jogar = false;

    //Instanciamento de objetos
    static Scanner input = new Scanner(System.in);

    //Função principal, onde o programa se iniciará
    public static void main(String[] args) throws InterruptedException {
        //Inicialização do menu
        Menu();

        while(jogar){
            //Introdução
            history = "\n\n~~TECH SYNC~~";
            texting(history);

            //Primeira fase
            history = "\n\nAo acordar, deparei-me com um lugar estranho. Tudo parecia antigo e ultrapassado e apesar de parecer acabado,\nnão conseguia sentir dor nenhuma... Na verdade, não sentia nada, não conseguia sequer lembrar de onde vim,\ncomo apareci aqui e nem para onde eu tinha que ir. A única motivação que eu tinha parecia martelar por dentro\nda minha memória, como coordenadas que me levariam para algum lugar importante e, por instinto, decidi que\nseguiria o caminho designado.\n";
            texting(history);
            //Chamando o menu para que seja verificado se deseja jogar novamente ou encerrar o programa
            Menu();
        }
        
        
        history = "\nObrigado por jogar :D\n";
        
    }

    public static boolean Menu() throws InterruptedException {
        //Inicio do jogo - MENU
        history ="Bem vindo ao Tech Sync\nJogo RPG Textual hambientado em um mundo futurista\n\n*INSTRUÇÃO para uso geral, ao escolher a opção desejada ignore qualquer acentuação e letra maiúscula,\npor exemplo, em 'Instruções' escreva 'intrucoes'!*";
        texting(history);
        do{
            history ="\n    MENU\n---Jogar---\n--Tutorial--\n--Créditos--\n---Sair---\n";
            texting(history);
            System.out.print("Opção: ");
            optionMenu = input.next();

            switch(optionMenu){
                //Inicio do jogo - HISTÓRIA
                case "Jogar":
                case "jogar":
                    jogar = true;
                    menu = false;
                    
                    break;
                //Tutorial de como o jogador deve seguir no jogo
                case "Tutorial":
                case "tutorial":
                    history = "\nVocê começará como (LORE),\nao passo que você/seu personagem percorre pela história serão mostradas opções de ações possíveis,\né preferível que ao escolher um opção ela seja digitada ignorando sua acentuação e escrita totalmente em letras minúsculas,\n(MECANICA DE JOGO),\n(RECOMPENSA FINAL).\n\nEsperamos mesmo que se divirtão e aprendam jogando este jogo feito com o máximo de cuidado e atenção que essas poucas pessoas puderam tudo de si,\nAgradecemos e let's bora!\n";
                    break;
                //Responsáveis pelo projeto
                case "Creditos":
                case "creditos":
                    history = "\n~Le pika/DEV: Gusta;p\n~Le carregado/escritor: Lucky*_*\n";
                    do{
                        history = "\nDeseja voltar ao Menu? ";
                        optionMenu = input.next();
                        if(optionMenu.equalsIgnoreCase("Sim")){
                            menu = true;
                            break;
                        }else if(optionMenu.equalsIgnoreCase("Nao")){
                            menu = false;
                            break;
                        }else{
                            history = "Digite somente Sim ou Não");
                        }
                    }while(!optionMenu.equalsIgnoreCase("Sim") || !optionMenu.equalsIgnoreCase("Nao"));
                    break;
                case "Sair":
                case "sair":
                    history = "\n\nEsperamos que tenha se divertido!");
                    jogar = false;
                    menu = false;
                    break;
                default:
                    history = "\nComando inválido ou digitado de maneira errada, como intruido pode ignorar qualquer acentuação e letras maiusculas,\npor exemplo, ao invés de escrever 'Instruções' escreva 'intrucoes'!\n";
            }
        }while(menu);
        return jogar;
    }

    public static void Player(){

    }

    public static void texting(String history) throws InterruptedException{
        for(int i = 0; i < history.length(); i++){
            Thread.sleep(80);
            System.out.print(history.charAt(i));
        }
    }
}