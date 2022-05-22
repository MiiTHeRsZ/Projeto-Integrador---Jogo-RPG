//Importe das bibliotéca
import java.util.*;

public class Main {
    //Declaração de variáveis
    static String optionMenu, optionGame, optionMenuAtk, history;
    static boolean menu = true, play = false, menuAtk, sonicAtkS = false, frozenAtkS = false, enemyAtkS;
    static int sleepTime, life, damage = 10, armor, cooldown, sonicAtk = 20, sonicAtkCD = 2, frozenAtk = 10, frozenAtkCD = 4, enemyLife, enemyDamage;

    //Instanciamento de objetos
    static Scanner input = new Scanner(System.in);

    //Função principal, onde o programa se iniciará
    public static void main(String[] args) throws InterruptedException {
        //Inicialização do menu
        Menu();

        //Inicialização do game
        while(play){
            //Introdução
            history = "\n\n~~TECH SYNC~~";
            texting(history, 50);

            //Primeira fase
            history = "\n\nAo acordar, deparei-me com um lugar estranho. Tudo parecia antigo e ultrapassado e apesar de parecer acabado,\nnão conseguia sentir dor nenhuma... Na verdade, não sentia nada, não conseguia sequer lembrar de onde vim,\ncomo apareci aqui e nem para onde eu tinha que ir. A única motivação que eu tinha parecia martelar por dentro\nda minha memória, como coordenadas que me levariam para algum lugar importante e, por instinto, decidi que\nseguiria o caminho designado.\n";
            texting(history, 50);

            
            //Chamando o menu para que seja verificado se deseja jogar novamente ou encerrar o programa
            Menu();
        }
        
        //Fim
        history = "\nObrigado por jogar :D\n";
        texting(history, 50);
    }

    //Menu
    public static boolean Menu() throws InterruptedException {
        //Inicio do jogo
        history = "Bem vindo ao Tech Sync\nJogo RPG Textual hambientado em um mundo futurista\n\n*INSTRUÇÃO para uso geral, ao escolher a opção desejada ignore qualquer acentuação, por exemplo,\nem 'Instruções' escreva 'intrucoes'!*\n";
        texting(history, 35);
        do{
            history = "\n    MENU\n---Jogar---\n--Tutorial--\n--Créditos--\n---Sair---\nOpção: ";
            texting(history, 35);
            optionMenu = input.next();

            switch(optionMenu){
                //Inicio do jogo - HISTÓRIA
                case "Jogar":
                case "jogar":
                    play = true;
                    menu = false;
                    
                    break;
                //Tutorial de como o jogador deve seguir no jogo
                case "Tutorial":
                case "tutorial":
                    history = "\nVocê começará como (LORE),\nao passo que você/seu personagem percorre pela história serão mostradas opções de ações possíveis,\né preferível que ao escolher uma opção você a digite ignorando sua acentuação,\n(MECANICA DE JOGO),\n(RECOMPENSA FINAL).\n\nEsperamos mesmo que se divirtão e aprendam jogando este jogo feito com o máximo de cuidado e atenção que essas poucas\npessoas puderam dar,\nAgradecemos muito e let's bora!\n";
                    texting(history, 40);
                    do{
                        history = "\nDeseja voltar ao Menu? ";
                        texting(history, 35);
                        optionMenu = input.next();
                        if(optionMenu.equalsIgnoreCase("Sim")){
                            menu = true;
                            break;
                        }else if(optionMenu.equalsIgnoreCase("Nao")){
                            menu = false;
                            break;
                        }else{
                            history = "Digite somente Sim ou Não\n";
                            texting(history, 35);
                        }
                    }while(!optionMenu.equalsIgnoreCase("Sim") || !optionMenu.equalsIgnoreCase("Nao"));
                    break;
                //Responsáveis pelo projeto
                case "Creditos":
                case "creditos":
                    history = "\n~Le pika/DEV: Gusta;p\n~Le DEV/Writer: Lucky*_*\n";
                    texting(history, 35);
                    do{
                        history = "\nDeseja voltar ao Menu? ";
                        texting(history, 35);
                        optionMenu = input.next();
                        if(optionMenu.equalsIgnoreCase("Sim")){
                            menu = true;
                            break;
                        }else if(optionMenu.equalsIgnoreCase("Nao")){
                            menu = false;
                            break;
                        }else{
                            history = "Digite somente Sim ou Não\n";
                            texting(history, 35);
                        }
                    }while(!optionMenu.equalsIgnoreCase("Sim") || !optionMenu.equalsIgnoreCase("Nao"));
                    break;
                case "Sair":
                case "sair":
                    history = "\n\nEsperamos que tenha se divertido!\n";
                    texting(history, 50);
                    play = false;
                    menu = false;
                    break;
                default:
                    history = "\nComando inválido ou digitado de maneira errada, como instruido pode ignorar qualquer acentuação e letras maiusculas,\npor exemplo, ao invés de escrever 'Instruções' escreva 'intrucoes'!\n";
                    texting(history, 50);
            }
        }while(menu);
        return play;
    }

    //Estatisticas do Player
    public static void Player(int life, int damage, int armor, int cooldown){
        if(sonicAtkCD == 0){
            
        }
    }

    //Estatisticas do Boss
    public static void Boss(int enemyLife, int enemyDamage){

    }

    //Imprime o texto de forma mais lenta, carácter por carácter, como se estivesse sendo digitado em tempo real
    public static void texting(String history, int sleepTime) throws InterruptedException{
        for(int i = 0; i < history.length(); i++){
            Thread.sleep(sleepTime);
            System.out.print(history.charAt(i));
        }
    }

    //Menu de Ataques
    public static void MenuAtk() throws InterruptedException {
        history = "\nMenu de Ataque\n\n~Atacar~\n~Defender~\n~Correr~\n\nOpção: ";
        texting(history, 35);
        optionMenuAtk = input.nextLine();
        switch(optionMenuAtk){
            //Ataques possíveis
            case "Atacar":
            case "atacar":
                //Caso esteja no segundo Boss
                if(sonicAtkS || !frozenAtkS){
                    do{
                        history = "\nMenu de Ataque\n\n~Atacar~\n~Ataque Sônico~\n\nOpção: ";
                        texting(history, 35);
                        optionMenuAtk = input.nextLine();
                        if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                            enemyLife -= damage;
                            menuAtk = true;
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                            enemyLife -= (damage / 2 + sonicAtk);
                            menuAtk = true;
                        }else{
                            history = "\nComando inválido ou digitado de maneira errada!\n";
                            texting(history, 35);
                            menuAtk = false;
                        }
                    }while(!menuAtk);
                //Caso esteja no terceiro Boss
                }else if(sonicAtkS && frozenAtkS){
                    do{
                        history = "\nMenu de Ataque\n\n~Atacar~\n~Ataque Sônico~\n~Ataque de Gelo~\n\nOpção: ";
                        texting(history, 35);
                        optionMenuAtk = input.nextLine();
                        if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                            enemyLife -= damage;
                            menuAtk = true;
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                            enemyLife -= (damage / 2 + sonicAtk);
                            menuAtk = true;
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                            enemyLife -= (damage / 2 + frozenAtk);
                            menuAtk = true;
                            enemyAtkS = false;
                        }else{
                            history = "\nComando inválido ou digitado de maneira errada!\n";
                            texting(history, 35);
                            menuAtk = false;
                        }
                    }while(!menuAtk);
                //Caso esteja no primeiro Boss
                }else{
                    do{
                        history = "\nMenu de Ataque\n\n~Atacar~\n~Ataque Sônico~\n~Ataque de Gelo~\n\nOpção: ";
                        texting(history, 35);
                        optionMenuAtk = input.nextLine();
                        if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                            enemyLife -= damage;
                            menuAtk = true;
                        }else{
                            history = "\nComando inválido ou digitado de maneira errada!\n";
                            texting(history, 35);
                            menuAtk = false;
                        }
                    }while(!menuAtk);
                }

                //Texto pós ataque
                if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                    history = "\nAtaque certeiro, você causou " + damage + " de dano ao Boss, ele atualmente está com " + enemyLife + " pontos de vida!\n";
                    texting(history, 35);
                }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                    history = "\nAtaque especial incrível, você causou " + damage + " de dano ao Boss, e ele atualmente está com apenas " + enemyLife + " pontos de vida!\n";
                    texting(history, 35);
                }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                    history = "\nAtaque especial fantástico, você causou " + damage + " de dano ao Boss, e ele atualmente está com apenas " + enemyLife + " pontos de vida e não atacará no próximo turno!\n";
                    texting(history, 35);
                }

                break;
            //Dano na vida reduzido por conta da armadura(caso tenha)
            case "Denfender":
            case "denfender":
                life -= (enemyDamage - armor);
                break;
            //Tentativa de se esvair de suas obrigações
            case "Correr":
            case "correr":

                break;
            default:
                history = "\nComando inválido ou digitado de maneira errada!\n";
                texting(history, 35);
        }
    }
}