//Importe das bibliotéca
import java.util.*;

public class Main {
    //Declaração de variáveis
    static String optionMenu, optionGame, optionMenuAtk, history, acaoJogador, acaoQuest;
    static boolean menu = true, play = false, menuAtk, sonicAtkS = false, frozenAtkS = false, enemyAtkS = false, faseIncompleta, primEntrada;
    static int tempo = 0, sleepTime, life, damage = 10, heal, cooldown, sonicAtk = 20, sonicAtkCD, frozenAtk = 10, frozenAtkCD, enemyLife, enemyDamage, areaCenario;

    //Instanciamento de objetos
    static Scanner input = new Scanner(System.in);

    //Função principal, onde o programa se iniciará
    public static void main(String[] args) throws InterruptedException {
        //Inicialização do menu
        Menu();

        //Inicialização do game
        while(play){
            selecFase();

            //Primeira fase
            selecFase();

            
            //Chamando o menu para que seja verificado se deseja jogar novamente ou encerrar o programa
            Menu();
        }
        
        //Fim
        history = "\nObrigado por jogar ^-^\n";
        texting(history, 50);
    }

    //Menu
    public static boolean Menu() throws InterruptedException {
        //Inicio do jogo
        history = "    ███        ▄████████  ▄████████    ▄█    █▄            ▄████████ ▄██   ▄   ███▄▄▄▄    ▄████████ \n▀█████████▄   ███    ███ ███    ███   ███    ███          ███    ███ ███   ██▄ ███▀▀▀██▄ ███    ███ \n   ▀███▀▀██   ███    █▀  ███    █▀    ███    ███          ███    █▀  ███▄▄▄███ ███   ███ ███    █▀  \n    ███   ▀  ▄███▄▄▄     ███         ▄███▄▄▄▄███▄▄        ███        ▀▀▀▀▀▀███ ███   ███ ███        \n    ███     ▀▀███▀▀▀     ███        ▀▀███▀▀▀▀███▀       ▀███████████ ▄██   ███ ███   ███ ███        \n    ███       ███    █▄  ███    █▄    ███    ███                 ███ ███   ███ ███   ███ ███    █▄  \n    ███       ███    ███ ███    ███   ███    ███           ▄█    ███ ███   ███ ███   ███ ███    ███ \n   ▄████▀     ██████████ ████████▀    ███    █▀          ▄████████▀   ▀█████▀   ▀█   █▀  ████████▀  \n                                                                                                    \n\n";
        texting(history, 1);

        history = "Bem vindo ao Tech Sync\nJogo RPG Textual ambientado em um mundo futurista\n\n*INSTRUÇÃO para uso geral, ao escolher a opção desejada ignore qualquer acentuação, por exemplo,\nem 'Instruções' escreva 'intrucoes'!*\n";
        texting(history, 20);
        do{
            history = "\n    MENU\n----Jogar---\n--Tutorial--\n--Créditos--\n----Sair----\n\nOpção: ";
            texting(history, 20);
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
                    history = "\n~Le pika/DEV: Gusta ;p\n~Le Writer/DEV: Lucky >..<\n";
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

    
    //Seleção de fases conforme progressão em jogo
    static void selecFase() throws InterruptedException{
        int atualFase;
        
        for (atualFase = 1; atualFase <= 10; atualFase ++){
            areaCenario = 1;
            faseIncompleta = true;
            
            switch(atualFase){
                
                case 1: 
                fase1();
                faseIncompleta =true;
                primEntrada = true;
                quest1();
                break;
                case 2: 
                fase2();
                break;
                case 3: 
                fase3();
                break;
                case 4: 
                fase4();
                break;
                case 5: 
                fase5();
                break;
                /*
                case 6: 
                fase6();
                break;
                case 7: 
                fase7();
                break;
                case 8: 
                fase8();
                break;
                case 9:
                fase9();
                break;
                case 10: 
                fase10();
                break;
                */
                
            }
            
        }
        
    }

    //Desenvolvimento das fases do jogo
    static void fase1() throws InterruptedException{
        primEntrada = true;

        history = "\n\n----------TECH SYNC----------\n\nAcordo em meio a um cenário estranho.\nO lugar onde estou sugere que eu caí de algum lugar alto. Mesmo assim, não sinto dor alguma... na verdade, não sinto nada... não consigo lembrar de onde vim e nem como vim parar aqui.\nO.. O que é isso? Algo parece martelar por dentro de minha memória... São como... coordenadas? Algo me diz que, o que quer que esteja nesse lugar, é importante.";
        texting(history, 35);
        do{
            switch(areaCenario){
                case 1:
                if(primEntrada){
                    history = "\n\nEstou em um Jardim dos fundos de uma casa pequena, na minha frente a casa branca páira sobre a já escassa luz do fim de tarde.\nUma janela aberta é o único detalhe que pode ser contemplado em sua parede branca. Algo me diz que preciso ir por ela...";
                    texting(history, 35);
                    primEntrada = false;
                }
                
                acaoJogador();
                
                if(acaoJogador.equalsIgnoreCase("olhar")){
                    history = "\nOs meus arredores de alguma forma remetem a um típico cenário do século passado... Na minha frente, a imponente casa em estilo vitoriano se estendia. Uma janela aberta é o único detalhe que pode ser contemplado em sua parede branca. \nJá na minha esquerda consigo ver um playground simples, com um escorregador e alguns brinquedos de criança soltos, também é possível ver uma porteira que parece levar para a casa de ferramentas. \nNa minha direita há um varal com roupas tremulando ao vento e também o que parece ser uma passagem pelos bosques.";
                    texting(history, 35);
                }else if(acaoJogador.equalsIgnoreCase("frente") || acaoJogador.equalsIgnoreCase("entrar") || acaoJogador.equalsIgnoreCase("janela")){
                    areaCenario = 2;
                    primEntrada = true;
                }else if(acaoJogador.equalsIgnoreCase("Interagir")){
                    history = "\nNão há nada para interagir aqui.";
                    texting(history, 35);
                }else if(acaoJogador.equalsIgnoreCase("voltar")){
                    history = "\nAtrás de mim há apenas a mini cratera formada pelo minha queda. Fora isto, não há nada de interessante aqui.";
                    texting(history, 35);
                }else if(acaoJogador.equalsIgnoreCase("brinquedos")||acaoJogador.equalsIgnoreCase("brinquedo")||acaoJogador.equalsIgnoreCase("escorregador")){
                    //Sistema de dicas como recompensa para exploração do cenário. Só estará presente na primeira fase como teste. Se possível, será adicionado um esquema de inventário onde, ao escrever "bilhete", a mensagem do mesmo seja imprimida.
                    history = "\nOs brinquedos estão largados bem ao lado do escorregador. Parece que, seja lá quem esteve aqui, teve que sair às pressas... \n\nEntre as brinquedos há um papel, nele está escrito:\nUm HD serve para Armazenar massas de dados diversificados de maneira não volátil, para usos posteriores.\nPor que este bilhete está aqui, e para que foi escrito?";
                    texting(history, 35);
                }else{
                    acaoInvalida();
                }
                break;

                case 2:
                if (primEntrada){
                    history = "\n\nPulo pela janela que estava aberta, a sala onde estou é ampla, existem escadas nas duas extremidades da sala, mas elas estão bloqueadas por caixas e móveis... Ao que tudo indica, uma família acabou de se mudar para cá, ainda assim, eu estranhamente tenho certeza de que não encontrarei ninguém nestas salas...\nNo centro da sala, há uma mesa com um objeto atípico, uma caixa trancada e com cabos que ligam em uma espécie de computador... Tudo naqueles objetos parecem destoar no tempo, como se não pertencessem àquele lugar.";
                    texting(history, 35);
                    primEntrada = false;
                }

                acaoJogador();

                if (acaoJogador.equalsIgnoreCase("olhar")){
                    history = "A sala onde estou é ampla, existem escadas nas duas extremidades da sala, mas elas estão bloqueadas por caixas e móveis…\nNo centro da sala, há uma mesa com um objeto atípico, uma caixa trancada e com cabos que ligam em uma espécie de computador…\nTalvez eu possa interagir com o computador!";
                    texting(history, 35);
                }else if(acaoJogador.equalsIgnoreCase("Frente")||acaoJogador.equalsIgnoreCase("Entrar")){
                    history = "Não há caminhos para seguir por aqui, posso apenas voltar.";
                    texting(history, 35);
                }else if(acaoJogador.equalsIgnoreCase("Computador")||acaoJogador.equalsIgnoreCase("Caixa")||acaoJogador.equals("Interagir")){
                    faseIncompleta = false;
                }else if(acaoJogador.equalsIgnoreCase("Voltar")){
                    history = "Volto pelo janela de onde vim...";
                    texting(history, 35);
                    areaCenario = 1;
                    primEntrada = true;
                }else{
                    acaoInvalida();
                }
                break;
            }
            
        }while(faseIncompleta);
    
    }
    static void fase2() throws InterruptedException{
        
    
    }
    
    static void fase3() throws InterruptedException{
        
    
    }
    
    static void fase4() throws InterruptedException{
        
    
    }
    
    static void fase5() throws InterruptedException{
        
    
    }

    static void fase6(){
        
    
    }
    
    static void fase7(){
        
    
    }
    
    static void fase8(){
        
    
    }
    
    static void fase9(){
        
    
    }
    
    static void fase10(){

    
    }

    //Quests desenvolvidas nas fases do jogo
    static void quest1() throws InterruptedException{
        history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, “revisão de segurança”... Que? não faz mais nada além de abrir esse aplicativo… Quem diabos iria querer um computador tão limitado quanto esse? \nBom… não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta… Vamos ver…";
        texting(history, 35);
        
        do{
            //Questionário: A alternativa correta é a C.
            history = "\n\n\sQual a principal função da memória secundária?\n\nA) Alocar informações antes de enviá-las ao processador ou à uma unidade de armazenamento.\nB) Armazenar informações que são utilizadas com frequência para agilizar processos repetitivos.\nC) Armazenar massas de dados diversificados de maneira não volátil, para usos posteriores.\nD) Ser utilizada como uma espécie de backup da memória principal, já que é mais fácil trocar para memória secundária do que recarregar a principal.";
            texting(history, 5);
            
            if(primEntrada = true){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("A")){

            }else if(acaoQuest.equalsIgnoreCase("B")){

            }else if(acaoQuest.equalsIgnoreCase("C")){ //CORRETA

            }else if(acaoQuest.equalsIgnoreCase("D")){

            }else{

            }

        }while(faseIncompleta);


    }
    
    //Ações do jogador
    static void acaoJogador() throws InterruptedException{
        history = "\n___________________________________________________________________________________\n\nEscreva uma das seguintes opções:\n\nOlhar - Descreve mais detalhadamente os arredores.\nFrente ou Entrar ou Nome da Passagem - Avança para próxima tela.\nInteragir - No segundo cenário, incia a quest.\nVoltar - Se possível, volta para tela anterior.\n\nTambém é possível interagir com alguns objetos escrevendo o nome deles!\n\nSua ação: ";
        texting(history, 5);
        
        acaoJogador = input.next();
        tempo++;
    }
    //Ações Quest
    static void acaoQuest() throws InterruptedException{
        history = "\n___________________________________________________________________________________\n\nEscreva uma das seguintes opções:\n\nA)                  B)\nC)                  D)\nSua resposta: ";
    
        acaoQuest = input.next();
        tempo++;
    }

    //Ação inválida.
    static void acaoInvalida() throws InterruptedException{
        history = "\n\nNão reconheço nenhuma opção válida para esta entrada, tente seguir uma das instruções";
        texting(history, 20);
    }
    //Caminho inválido.


    //Interação inválida.


    //Estatisticas do Player
    public static void Player(int life, int damage, int heal, int cooldown){
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
                //Caso tenha o segundo ataque disponível e já usado ou não o tenha
                if(sonicAtkS && !frozenAtkS){
                    do{
                        history = "\nMenu de Ataque\n\n~Atacar~\n~Ataque Sônico~\n\nOpção: ";
                        texting(history, 35);
                        optionMenuAtk = input.nextLine();
                        if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                            enemyLife -= damage;
                            menuAtk = true;
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                            if(sonicAtkCD == 0){
                                enemyLife -= (damage / 2 + sonicAtk);
                                menuAtk = true;
                                sonicAtkCD = 2;
                            }else{
                                history = "Este ataque está em TEMPO DE REGARGA por mais " + frozenAtkCD;
                                texting(history, 35);
                                menuAtk = false;
                            }
                        }else{
                            history = "\nComando inválido ou digitado de maneira errada!\n";
                            texting(history, 35);
                            menuAtk = false;
                        }
                    }while(!menuAtk);
                //Caso tenha o primeiro ataque disponível e já usado
                }else if(!sonicAtkS && frozenAtkS){
                    do{
                        history = "\nMenu de Ataque\n\n~Atacar~\n~Ataque Sônico~\n\nOpção: ";
                        texting(history, 35);
                        optionMenuAtk = input.nextLine();
                        if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                            enemyLife -= damage;
                            menuAtk = true;
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                            if(frozenAtkCD == 0){
                                enemyLife -= (damage / 2 + frozenAtk);
                                menuAtk = true;
                                enemyAtkS = false;
                                frozenAtkCD = 3;
                            }else{
                                history = "Este ataque está em TEMPO DE REGARGA por mais " + frozenAtkCD;
                                texting(history, 35);
                                menuAtk = false;
                            }
                        }else{
                            history = "\nComando inválido ou digitado de maneira errada!\n";
                            texting(history, 35);
                            menuAtk = false;
                        }
                    }while(!menuAtk);
                //Caso tenha os ataques disponíveis e ainda não os tenham usados
                }else if(sonicAtkS && frozenAtkS){
                    do{
                        history = "\nMenu de Ataque\n\n~Atacar~\n~Ataque Sônico~\n~Ataque de Gelo~\n\nOpção: ";
                        texting(history, 35);
                        optionMenuAtk = input.nextLine();
                        if(optionMenuAtk.equalsIgnoreCase("Atacar")){
                            enemyLife -= damage;
                            menuAtk = true;
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                            if(sonicAtkCD == 0){
                                enemyLife -= (damage / 2 + sonicAtk);
                                menuAtk = true;
                                sonicAtkCD = 2;
                            }else{
                                history = "Este ataque está em TEMPO DE REGARGA por mais " + frozenAtkCD;
                                texting(history, 35);
                                menuAtk = false;
                            }
                        }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                            if(frozenAtkCD == 0){
                                enemyLife -= (damage / 2 + frozenAtk);
                                menuAtk = true;
                                enemyAtkS = false;
                                frozenAtkCD = 3;
                            }else{
                                history = "Este ataque está em TEMPO DE REGARGA por mais " + frozenAtkCD;
                                texting(history, 35);
                                menuAtk = false;
                            }
                        }else{
                            history = "\nComando inválido ou digitado de maneira errada!\n";
                            texting(history, 35);
                            menuAtk = false;
                        }
                    }while(!menuAtk);
                //Caso não tenha adquirido os ataques especiais
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
                life += heal;
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