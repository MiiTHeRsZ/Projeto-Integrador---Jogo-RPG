//Importe das bibliotéca
import java.util.*;

public class Main {
    //Declaração de variáveis
    static String optionMenu, optionGame, optionMenuAtk, history, acaoJogador, acaoQuest, corretoQuest;
    static boolean menu = true, play = false, menuAtk, sonicAtkS = false, frozenAtkS = false, enemyAtkS = false, block, faseIncompleta, primEntrada;
    static int tempo = 0, sleepTime, lifePlayer = 35, damagePlayer = 10, sonicAtk, sonicAtkCD, frozenAtk, frozenAtkCD, atkCD = 0, bossLife = 50, bossDamage = 10, bossLvl = 1, bossFrozen, turn, areaCenario;

    //Instanciamento de objetos
    static Scanner input = new Scanner(System.in);

    //Função principal, onde o programa se iniciará
    public static void main(String[] args) throws InterruptedException {
        //Inicialização do menu
        do{
            Menu();

            //Inicialização do game
            while(play){
                //Texto início
                System.out.println("\n\n\n___________________________________________________________________________________________________________________________________________________________________________________________________");
                history = "\n╔═╗    ╦  ╔╗╔  ╦  ╔═╗  ╦  ╔═╗    ╔╦╗  ╔═╗     ╦  ╔═╗  ╦═╗  ╔╗╔  ╔═╗  ╔╦╗  ╔═╗  ┬  ┬  ┬\n║ ║    ║  ║║║  ║  ║    ║  ║ ║     ║║  ╠═╣     ║  ║ ║  ╠╦╝  ║║║  ╠═╣   ║║  ╠═╣  │  │  │\n╚═╝    ╩  ╝╚╝  ╩  ╚═╝  ╩  ╚═╝    ═╩╝  ╩ ╩    ╚╝  ╚═╝  ╩╚═  ╝╚╝  ╩ ╩  ═╩╝  ╩ ╩  o  o  o";
                texting(history, 5);

                //Seletor de fases e quests
                selecFase();
                
                //Após Zerar o jogo
                /*creditosFinais();*/
            }

        }while(menu);

        
        //Fim
        history = "\nObrigado por jogar ^-^\n";
        texting(history, 50);
    }

    //Menu
    public static boolean Menu() throws InterruptedException {
        //Inicio do jogo
        history = "\n    ███        ▄████████  ▄████████    ▄█    █▄            ▄████████ ▄██   ▄   ███▄▄▄▄    ▄████████ \n▀█████████▄   ███    ███ ███    ███   ███    ███          ███    ███ ███   ██▄ ███▀▀▀██▄ ███    ███ \n   ▀███▀▀██   ███    █▀  ███    █▀    ███    ███          ███    █▀  ███▄▄▄███ ███   ███ ███    █▀  \n    ███   ▀  ▄███▄▄▄     ███         ▄███▄▄▄▄███▄▄        ███        ▀▀▀▀▀▀███ ███   ███ ███        \n    ███     ▀▀███▀▀▀     ███        ▀▀███▀▀▀▀███▀       ▀███████████ ▄██   ███ ███   ███ ███        \n    ███       ███    █▄  ███    █▄    ███    ███                 ███ ███   ███ ███   ███ ███    █▄  \n    ███       ███    ███ ███    ███   ███    ███           ▄█    ███ ███   ███ ███   ███ ███    ███ \n   ▄████▀     ██████████ ████████▀    ███    █▀          ▄████████▀   ▀█████▀   ▀█   █▀  ████████▀  \n                                                                                                    \n\n";
        texting(history, 1);
        
        history = "Bem vindo ao Jogo RPG Textual ambientado em um mundo futurista\n\n*INSTRUÇÃO para uso geral, ao escolher a opção desejada ignore qualquer acentuação, por exemplo,\nem 'Instruções' escreva 'intrucoes'!*\n";
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
                faseIncompleta = true;
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
                
            }
            play = false;
        }
        
    }

    //Desenvolvimento das fases do jogo
    static void fase1() throws InterruptedException{
        primEntrada = true;

        history = "\n\nAcordo em meio a um cenário estranho.\nOnde estou sugere que eu caí de algum lugar alto. Mesmo assim, não sinto dor alguma... na verdade, não sinto nada... não consigo lembrar de onde vim e nem como vim parar aqui.\nO.. O que é isso? Algo parece martelar por dentro de minha memória... São como... coordenadas? Algo me diz que, o que quer que esteja nesse lugar, é importante.";
        texting(history, 35);
        do{
            switch(areaCenario){

                //CENÁRIO DE SPAWN
                case 1:
                    if(primEntrada){
                        history = "\n\nEstou em um Jardim dos fundos de uma casa pequena, na minha frente a casa branca páira sobre a já escassa luz do fim de tarde.\nUma janela aberta é o único detalhe que pode ser contemplado em sua parede branca. Algo me diz que preciso ir por ela...";
                        texting(history, 35);
                        primEntrada = false;
                    }
                    
                    acaoJogador();
                    
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
                    if(acaoJogador.equalsIgnoreCase("olhar")){
                        history = "\nOs meus arredores de alguma forma remetem a um típico cenário do século passado... \nNa minha frente, a imponente casa em estilo vitoriano se estendia. Uma janela aberta é o único detalhe que pode ser contemplado em sua parede branca. \nJá na minha esquerda consigo ver um playground simples, com um escorregador e alguns brinquedos de criança soltos, também é possível ver uma porteira que parece levar para a casa de ferramentas. \nNa minha direita há um varal com roupas tremulando ao vento e também o que parece ser uma passagem pelos bosques.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("frente") || acaoJogador.equalsIgnoreCase("entrar") || acaoJogador.equalsIgnoreCase("janela")){
                        areaCenario = 2;
                        primEntrada = true;
                    }else if(acaoJogador.equalsIgnoreCase("Interagir")){
                        interacaoInvalida();
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

                //CENÁRIO DA MISSÃO PRINCIPAL
                case 2:
                    if (primEntrada){
                        history = "\n\nPulo pela janela que estava aberta, a sala onde estou é ampla, existem escadas nas duas extremidades da sala, mas elas estão bloqueadas por caixas e móveis... Ao que tudo indica, uma família acabou de se mudar para cá, ainda assim, eu estranhamente tenho certeza de que não encontrarei ninguém nestas salas...\nNo centro da sala, há uma mesa com um objeto atípico, uma caixa trancada e com cabos que ligam em uma espécie de computador... Tudo naqueles objetos parecem destoar no tempo, como se não pertencessem àquele lugar.";
                        texting(history, 35);
                        primEntrada = false;
                    }

                    acaoJogador();

                    if (acaoJogador.equalsIgnoreCase("olhar")){
                        history = "A sala onde estou é ampla, existem escadas nas duas extremidades da sala, mas elas estão bloqueadas por caixas e móveis...\nNo centro da sala, há uma mesa com um objeto atípico, uma caixa trancada e com cabos que ligam em uma espécie de computador...\nTalvez eu possa interagir com o computador!";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("Frente")||acaoJogador.equalsIgnoreCase("Entrar")){
                        caminhoInvalido();
                    }else if(acaoJogador.equalsIgnoreCase("Computador")||acaoJogador.equalsIgnoreCase("Caixa")||acaoJogador.equalsIgnoreCase("Interagir")){
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
        history = "\n\n\n\n\n\n\n\n ▄████▄      ▒█████      ███▄    █    ▄▄▄█████▓    ██▓    ███▄    █     █    ██     ▄▄▄      \n▒██▀ ▀█     ▒██▒  ██▒    ██ ▀█   █    ▓  ██▒ ▓▒   ▓██▒    ██ ▀█   █     ██  ▓██▒   ▒████▄    \n▒▓█    ▄    ▒██░  ██▒   ▓██  ▀█ ██▒   ▒ ▓██░ ▒░   ▒██▒   ▓██  ▀█ ██▒   ▓██  ▒██░   ▒██  ▀█▄  \n▒▓▓▄ ▄██▒   ▒██   ██░   ▓██▒  ████▒   ░ ▓██▓ ░    ░██░   ▓██▒  ████▒   ▓▓█  ░██░   ░██▄▄▄▄██ \n▒ ▓███▀ ░   ░ ████▓▒░   ▒██░   ▓██░     ▒██▒ ░    ░██░   ▒██░   ▓██░   ▒▒█████▓     ▓█   ▓██▒\n░ ░▒ ▒  ░   ░ ▒░▒░▒░    ░ ▒░   ▒ ▒      ▒ ░░      ░▓     ░ ▒░   ▒ ▒    ░▒▓▒ ▒ ▒     ▒▒   ▓▒█░\n  ░  ▒        ░ ▒ ▒░    ░ ░░   ░ ▒░       ░        ▒ ░   ░ ░░   ░ ▒░   ░░▒░ ░ ░      ▒   ▒▒ ░\n░           ░ ░ ░ ▒        ░   ░ ░      ░          ▒ ░      ░   ░ ░     ░░░ ░ ░      ░   ▒   \n░ ░             ░ ░              ░                 ░              ░       ░              ░  ░\n░                                                                                            ";
        texting(history, 40);

    }
    
    static void fase3() throws InterruptedException{ //BOSS FIGHT
        do{


            //Encontro com o Boss e início da boss fight
            BossFight();
        }while(faseIncompleta);
        
        //Upgrades do player
        sonicAtkS = true;

        //Upgrades do boss para o próximo encontro
        bossLife = 2 * 50;
        bossDamage += 10;
        bossLvl++;
    }
    
    static void fase4() throws InterruptedException{
        do{

        }while(faseIncompleta);

        //Upgrades do player
        lifePlayer = 2 * 25;
    }
    
    static void fase5() throws InterruptedException{
        do{

        }while(faseIncompleta);

        //Upgrades do player
        damagePlayer += 10;
    }

    static void fase6() throws InterruptedException{ //BOSS FIGHT
        do{


            //Encontro com o Boss e início da boss fight
            BossFight();
        }while(faseIncompleta);
        
        //Upgrades do player
        frozenAtkS = true;

        //Upgrades do boss para o próximo encontro
        bossLife = 4 * 25;
        bossDamage += 10;
        bossLvl++;
    }
    
    static void fase7() throws InterruptedException{
        do{

        }while(faseIncompleta);

        //Upgrades do player
        atkCD = 1;
        lifePlayer = 4 * 25;
    }
    
    static void fase8() throws InterruptedException{
        do{

        }while(faseIncompleta);

        //Upgrades do player
        damagePlayer += 10;
    }
    
    static void fase9() throws InterruptedException{ //BOSS FIGHT
        do{


            //Encontro com o Boss e início da boss fight
            BossFight();
        }while(faseIncompleta);
    
    }
    
    static void fase10() throws InterruptedException{
        do{

        }while(faseIncompleta);
    
    }

    //Quests desenvolvidas nas fases do jogo
    static void quest1() throws InterruptedException{
        history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, REVISÃO DE SEGURANÇA... \nQue? não faz mais nada além de abrir esse aplicativo... Quem diabos iria querer um computador tão limitado quanto esse? \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta... Vamos ver...";
        texting(history, 35);
        corretoQuest = "C";
        
        do{
            //Questionário: A alternativa correta é a C.
            //history = "\n\nQual a principal função da memória secundária?\n\nA) Alocar informações antes de enviá-las ao processador ou à uma unidade de armazenamento.\nB) Armazenar informações que são utilizadas com frequência para agilizar processos repetitivos.\nC) Armazenar massas de dados diversificados de maneira não volátil, para usos posteriores.\nD) Ser utilizada como uma espécie de backup da memória principal, já que é mais fácil trocar para memória secundária do que recarregar a principal.";
            history = "Memórias secundárias tem grande importância para o funcionamento diário na utilização de computadores pois:\n\nA) Alocar informações antes de enviá-las ao processador ou à uma unidade de armazenamento.\nB) Armazenar informações que são utilizadas com frequência para agilizar processos repetitivos.\nC) São dispositivos com grandes capacidades de armazenamento, utilizadas para guardar dados de maneira a permanecerem no dispositivo mesmo após o interrompimento no fornecimento de energia.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("A") || acaoQuest.equalsIgnoreCase("B")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("C")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }
    static void quest2() throws InterruptedException{
        /*§§§§§*/history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, REVISÃO DE SEGURANÇA... \nQue? não faz mais nada além de abrir esse aplicativo... Quem diabos iria querer um computador tão limitado quanto esse? \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta... Vamos ver...";
        texting(history, 35);
        corretoQuest = "A";
        
        do{
            //Questionário: A alternativa correta é a A.
            history = "A placa de rede é um item indispensável nos dias de hoje, principalmente pela integração que ela proporciona, pois:\n\nA) Permite a que o computador se conecte com outra rede por meio da troca de informações entre ambos, feitas via cabo Ethernet ou por conexão Wireless.\nB) Permite a que o computador se conecte com outra rede por meio da troca de informações entre ambos, feitas via Internet.\nC) Permite a que o computador se conecte com outra rede por meio da troca de informações entre ambos, feitas via aplicativos.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("B") || acaoQuest.equalsIgnoreCase("C")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("A")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                /*§§§§§*/history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    //COMBATE NO LUGAR DA TERCEIRA QUEST

    static void quest4() throws InterruptedException{
        /*§§§§§*/history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, REVISÃO DE SEGURANÇA... \nQue? não faz mais nada além de abrir esse aplicativo... Quem diabos iria querer um computador tão limitado quanto esse? \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta... Vamos ver...";
        texting(history, 35);
        corretoQuest = "B";
        
        do{
            //Questionário: A alternativa correta é a B.
            history = "A placa-mãe pode ser considerado o dispositivo central do computador, pois:\n\nA) É o dispositivo encarregado de calcular todas a variáveis de informações que recebe constantemente.\nB) É o dispositivo encarregado de fazer a interação dos hardwares entre si, sem ela não teriam como trocar informações para que pudessem funcionar em conjunto.\nC) É responsável por fornecer apenas energia aos outros componentes que estão diretamente em contato com ela.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("A") || acaoQuest.equalsIgnoreCase("C")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("B")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                /*§§§§§*/history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    static void quest5() throws InterruptedException{
        /*§§§§§*/history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, REVISÃO DE SEGURANÇA... \nQue? não faz mais nada além de abrir esse aplicativo... Quem diabos iria querer um computador tão limitado quanto esse? \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta... Vamos ver...";
        texting(history, 35);
        corretoQuest = "C";
        
        do{
            //Questionário: A alternativa correta é a C.
            history = "O processador pode ser categorizado como um poderoso dispositivo de calcular e de tomar decisões lógicas, pois:\n\nA) Ele faz a função da calculadora que pode ser acessada através do SO.\nB) É responsável por guardar informações que são usadas pelo SO ou por aplicativos, além de outros dados necessários para o funcionamento do sistema.\nC) É encarregado de receber, processar e transformar dados em informação, para que essa mesma informação seja transmitida para os outros componentes do computador através da placa-mãe.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("A") || acaoQuest.equalsIgnoreCase("B")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("C")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                /*§§§§§*/history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    //COMBATE NO LUGAR DA SEXTA QUEST

    static void quest7() throws InterruptedException{
        /*§§§§§*/history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, REVISÃO DE SEGURANÇA... \nQue? não faz mais nada além de abrir esse aplicativo... Quem diabos iria querer um computador tão limitado quanto esse? \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta... Vamos ver...";
        texting(history, 35);
        corretoQuest = "A";
        
        do{
            //Questionário: A alternativa correta é a A.
            history = "A memória principal tem um papel muito importante, pois:\n\nA) Tem como principal função guardar informações que são usadas pelo SO ou por aplicativos, além de outros dados necessários para o funcionamento do sistema, porém esses dados só se permanecem armazenados enquanto o computador está ligado, caso contrário ela é reiniciada e seus dados perdidos.\nB) é um dispositivo com grandes capacidades de armazenamento, utilizada para guardar dados de maneira a permanecerem no dispositivo mesmo após o interrompimento no fornecimento de energia.\nC) Ser utilizada como uma espécie de backup da memória secundária, já que é mais fácil trocar para memória principal do que recarregar a secundária.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("B") || acaoQuest.equalsIgnoreCase("C")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("A")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                /*§§§§§*/history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    static void quest8() throws InterruptedException{
        /*§§§§§*/history = "\n\nOk, esse computador realmente é estranho.. parece que só há um ícone na tela e, nele diz, REVISÃO DE SEGURANÇA... \nQue? não faz mais nada além de abrir esse aplicativo... Quem diabos iria querer um computador tão limitado quanto esse? \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece que só há uma pergunta... Vamos ver...";
        texting(history, 35);
        corretoQuest = "B";
        
        do{
            //Questionário: A alternativa correta é a B.
            history = "A fonte de alimentação pode elevar ou abaixar o nível de tensão elétrica, e alguns podem até ser um importante protetor contra picos de energia e instabilidade, com isso podemos dizer que:\n\nA) É responsável por alimentar o computador com elétrons.\nB) Ela é um componente responsável por transformar energia elétrica que é recebida diretamente da tomada para a voltagem adequada para o aparelho.\nC) É responsável por tranformar energia em 0 e 1, para que o computador continue a funcionar corretamente.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("A") || acaoQuest.equalsIgnoreCase("C")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("B")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                /*§§§§§*/history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    //COMBATE NO LUGAR DA NINA FASE

    static void quest10() throws InterruptedException{
        /*§§§§§*/history = "\n\nEstá é a parte final de sua jornada, todos os seus outros saltos temporais te trouxeram aqui, mas não por acaso ou coincidência, mas porque todos os outros caminhos tinham conhecimentos a serem passados adiante, e é aqui e agora que essa jornada terá seu ponto crucial, onde você será testado e é onde você deverá mostrar os frutos do seu esforço(...)";
        texting(history, 35);
        /*§§§§§*/history = "Para voltar a sua era, você deverá conectar as peças que estão armazenadas na gaveta abaixo a mim, isso fará com que eu tenha potência o suficiente para ajudar a te mandar de volta. Mas lembre-se, a ordem que você deverá colocar os componentes deve ser específica, e para te auxiliar nisso há algumas frases com lacunas a serem preenchidas.";
        texting(history,35);
        corretoQuest = "C";
        
        do{
            //Questionário: A alternativa correta é a C.
            history = "Essas são as seguintes frases:\n__________ é o dispositivo encarregado de fazer a interação dos hardwares entre si, sem ela não teriam como trocar informações para que pudessem funcionar em conjunto.\n__________ é encarregado de receber, processar e transformar dados em informação, para que essa mesma informação seja transmitida para os outros componentes do computador através da placa-mãe.\n__________ permite a que o computador se conecte com outra rede por meio da troca de informações entre ambos, feitas via cabo Ethernet ou por conexão Wireless.\n__________ tem como principal função guardar informações que são usadas pelo SO ou por aplicativos, além de outros dados necessários para o funcionamento do sistema, porém esses dados só se permanecem armazenados enquanto o computador está ligado, caso contrário ela é reiniciada e seus dados perdidos.\n__________ é um dispositivo com grandes capacidades de armazenamento, utilizada para guardar dados de maneira a permanecerem no dispositivo mesmo após o interrompimento no fornecimento de energia.\n__________ é um componente responsável por transformar energia elétrica que é recebida diretamente da tomada para a voltagem adequada para o aparelho.\n\nA) Placa de rede - Processador - Placa-mãe - Memória Secundária - Memória Principal - Fonte de alimentação.\nB) Placa-mãe - Processador - PLaca de rede - Memória principal - Memória secundária - Fonte de Alimentação.\nC) Placa-mãe – Processador – Placa de rede – Memória principal – Memória secundária – Fonte de alimentação.";
            texting(history, 5);
            
            if(primEntrada){
                history = "\n\nAAHH, essa sensação estranha na cabeça de novo... algo... algo me diz que eu não posso ficar perdendo... tempo? Como assim? \nBom, é melhor responder logo e não ficar errado atoa...";
                texting(history, 35);
                primEntrada = false;
            }

            acaoQuest();

            if(acaoQuest.equalsIgnoreCase("A") || acaoQuest.equalsIgnoreCase("B")){
                erraQuest();
            }else if(acaoQuest.equalsIgnoreCase("C")){ //CORRETA
                history = "\n\nAAAH, A CAIXA ABRIU!!!";
                texting(history, 10);
                /*§§§§§*/history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conect";
                texting(history, 35);
                history = ".......";
                texting(history, 80);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    
    //Ações do jogador
    static void acaoJogador() throws InterruptedException{
        System.out.println("\n___________________________________________________________________________________________________________________________________________________________________________________________________");
        history = "\n\nEscreva uma das seguintes opções:\n\nOlhar - Descreve mais detalhadamente os arredores.\nFrente ou Entrar ou Nome da Passagem - Avança para próxima tela.\nInteragir - No segundo cenário, incia a quest.\nVoltar - Se possível, volta para tela anterior.\n\nTambém é possível interagir com alguns objetos escrevendo o nome deles!\n\nSua ação: ";
        texting(history, 5);
        
        acaoJogador = input.next();
        tempo++;
    }
    //Ações Quest
    static void acaoQuest() throws InterruptedException{
        //System.out.println("\n___________________________________________________________________________________________________________________________________________________________________________________________________");
        history = "\n\nSua resposta: ";
        texting(history, 5);
        
        acaoQuest = input.next();
        if(acaoQuest != corretoQuest){
            tempo += 10;
        }else{
            tempo++;
        }

    }

    //Ação inválida.
    static void acaoInvalida() throws InterruptedException{
        history = "\n\nNão reconheço nenhuma opção válida para esta entrada, tente seguir uma das instruções";
        texting(history, 20);
    }
    //Ação quest inválida.
    static void questInvalida() throws InterruptedException{
        history = ".......";
        texting(history, 100);
        history = "\n\nInválido? NO QUE EU ESTOU PENSANDO? Tenho que parar de perder TEMPO e escolher uma das opções disponíveis!!!";
        texting(history, 25);
    }

    //Caminho inválido.
    static void caminhoInvalido() throws InterruptedException{
        history = "Não há caminhos para seguir por aqui, posso apenas voltar.";
        texting(history, 35);
    }

    //Interação inválida.
    static void interacaoInvalida() throws InterruptedException{
        history = "\nNão há nada para interagir aqui.";
        texting(history, 35);
    }

    //Errou na Quest.
    static void erraQuest() throws InterruptedException{
        history = "\n\nUuhg... Eu acho que errei... Estou ficando tonto, o tempo parece distorcer ao meu redor...";
        texting(history, 85);
        history = "\nÉ melhor não errar mais. De alguma forma sinto que perdi muito... tempo?";
        texting(history, 35);
    }

    //Estatisticas do Player
    public static void Player(int life, int damage, int cooldown){

    }

    //Estatisticas do Boss
    public static void BossFight() throws InterruptedException{
        Random random = new Random();

        sonicAtk = damagePlayer / 2 + 20;
        sonicAtkCD = 0;
        frozenAtk = damagePlayer / 2 + 10;
        frozenAtkCD = 0;
        turn = 1;
        do{
            MenuAtk();
            BossAtk(random.nextInt(100));

            turn++;
        }while(lifePlayer > 0 && bossLife > 0);
    }

    //Imprime o texto de forma mais lenta, carácter por carácter, como se estivesse sendo digitado em tempo real
    public static void texting(String history, int sleepTime) throws InterruptedException{
        for(int i = 0; i < history.length(); i++){
            Thread.sleep(sleepTime);
            System.out.print(history.charAt(i));
        }
    }

    //Ataques do Boss
    public static void BossAtk(int random) throws InterruptedException{
        if(bossLife <= 0){
            return;
        }
        //Chances de errar o ataque
        if(bossFrozen != 0){
            bossFrozen--;
        }else{
            if(bossLvl == 1){
                if(bossLife <= 10){
                    history = "AARG... aarg... Que belo golpe de sorte... ";
                    texting(history, 60);
                    history = "Mas não será o suficiente para me deter, terá que fazer melhor do que isso... MWAHAHAHAHAHA desvie disso se for capaz";
                    texting(history, 25);
                    history = "\nNeste momento ele dá seu ataque especial, Ataque Sônico\n";
                    texting(history, 30);
                    lifePlayer -= sonicAtk / 2;
                    if(lifePlayer > 0){
                        history = "Uhg!... Uhg, que ataque poderoso, mas ele claramente parece esgotado, se eu ainda tenho uma chance, essa hora é agora!!!\n\n";
                        texting(history, 25);
                    }
                    return;
                }
                if(random > 25 && random <= 75){
                    if(block){
                        lifePlayer -= bossDamage / 5;
                        history = "MWAHAHA, muito fácil... Mas que tal sair da defensiva!?\nEle te ataca e te dá " + (bossDamage/5) + " de dano!\n\n";
                        texting(history, 20);
                    }else{
                        lifePlayer -= bossDamage;
                        history = "MWAHAHA, muito fácil...\nEle te ataca e te dá " + bossDamage + " de dano!\n\n";
                        texting(history, 20);
                    }
                }else{
                    history = "AAARH... Não... Como pôde... Eu errei este simples ataque...\n\n";
                    texting(history, 40);
                }
            }else if(bossLvl == 2){
                if(bossLife <= 20){
                    history = "AARG... aarg... Que belo golpe de sorte... Parece que melhorou desde nosso último encontro. ";
                    texting(history, 60);
                    history = "Mas nem está perto de ser o suficiente, terá que me mostrar do que é feito... MWAHAHAHAHAHA desvie desta minha nova técnica se for capaz";
                    texting(history, 25);
                    history = "\nNeste momento ele usa seu novo ataque especial, Ataque de Gelo\n";
                    texting(history, 30);
                    lifePlayer -= frozenAtk;
                    if(lifePlayer > 0){
                        history = "Uhg... Uhg, que ataque poderoso, mas ele claramente parece esgotado, vejo um padrão, sempre que está com pouca vida ele se prepara para usar sua técnica especial, então eu só preciso me preparar e fazer de tudo para sobreviver, e se eu ainda tenho uma chance, essa hora é agora!!!\n\n";
                        texting(history, 25);
                    }
                    return;
                }
                if(random > 15 && random <= 85){
                    if(block){
                        lifePlayer -= bossDamage / 5;
                        history = "MWAHAHA, muito fácil... Mas que tal sair da defensiva!?\nEle te ataca e te dá " + (bossDamage/5) + " de dano!\n\n";
                        texting(history, 20);
                    }else{
                        lifePlayer -= bossDamage;
                        history = "MWAHAHA, muito fácil...\nEle te ataca e te dá " + bossDamage + " de dano!\n\n";
                        texting(history, 20);
                    }
                }else{
                    history = "AAARH... Não... Como pôde... Eu errei este simples ataque...\n\n";
                    texting(history, 40);
                }
            }else{
                if(bossLife <= 40){
                    history = "AARG... aarg... Devo dizer, você foi um oponente digno, o melhor que já enfrentei... Irei guardar você e este momento na lembrança... ";
                    texting(history, 60);
                    history = "Mas devo admitir, jamais perderei aqui e você não tem poder o suficiente para me deter, terá que fazer o impossível... MWAHAHAHAHAHA vamos e me mostre do que é capaz, ou virará cinzas MWAHAHAHA...";
                    texting(history, 25);
                    history = "\nNeste momento ele se concentra e canalisa todo seu poder em seu golpe supremo, Devastação Total!!!\n";
                    texting(history, 30);
                    lifePlayer -= sonicAtk / 2;
                    if(lifePlayer > 0){
                        history = "Uhg!... Uhg, adimito, que ataque fenomenal, mas não é o suficiente para me parar, você está esgotado, e essa é a minha chance de acabar do com você de uma vez por todas, a hora definitivamente é agora!!!";
                        texting(history, 25);
                    }
                    return;
                }
                if(random > 10 && random <= 90){
                    if(block){
                        lifePlayer -= bossDamage / 5;
                        history = "MWAHAHA, muito fácil... Mas que tal sair da defensiva!?\nEle te ataca e te dá " + (bossDamage/5) + " de dano!\n\n";
                        texting(history, 20);
                    }else{
                        lifePlayer -= bossDamage;
                        history = "MWAHAHA, muito fácil...\nEle te ataca e te dá " + bossDamage + " de dano!\n\n";
                        texting(history, 20);
                    }
                }else{
                    history = "AAARH... Não... Como pôde... Eu errei este simples ataque...\n\n";
                    texting(history, 40);
                }
            }
        }
    }
    //Menu de Ataques
    public static void MenuAtk() throws InterruptedException {
        block = false;
        if(sonicAtkCD != 0){
            sonicAtkCD--;
        }
        if(frozenAtkCD != 0){
            frozenAtkCD--;
        }
        do{
            history = "--------------------\nTurno " + turn + " - LP: "+ lifePlayer +"\n\nMenu de Ataque\n\n~Atacar~\n~Defender~\n~Correr~\n--------------------\nOpção: ";
            texting(history, 15);
            optionMenuAtk = input.nextLine();
            switch(optionMenuAtk){
                //Ataques possíveis
                case "Atacar":
                case "atacar":
                    //Caso tenha o segundo ataque disponível e já usado ou não o tenha
                    if(sonicAtkS && !frozenAtkS){
                        do{
                            history = "--------------------\nMenu de Ataque\n\n~Ataque Normal~\n~Ataque Sônico~\n--------------------\nOpção: ";
                            texting(history, 15);
                            optionMenuAtk = input.nextLine();
                            if(optionMenuAtk.equalsIgnoreCase("Ataque Normal") || optionMenuAtk.equalsIgnoreCase("Ataque") || optionMenuAtk.equalsIgnoreCase("Atacar")){
                                bossLife -= damagePlayer;
                                menuAtk = true;
                            }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                                if(sonicAtkCD == 0){
                                    bossLife -= (damagePlayer / 2 + sonicAtk);
                                    menuAtk = true;
                                    sonicAtkCD = 2 - atkCD;
                                }else{
                                    history = "Este ataque está em TEMPO DE REGARGA por mais " + sonicAtkCD + " turno(s).";
                                    texting(history, 15);
                                    menuAtk = false;
                                }
                            }else{
                                history = "\nComando inválido ou digitado de maneira errada!\n";
                                texting(history, 15);
                                menuAtk = false;
                            }
                        }while(!menuAtk);
                    //Caso tenha o primeiro ataque disponível e já usado
                    }else if(!sonicAtkS && frozenAtkS){
                        do{
                            history = "--------------------\nMenu de Ataque\n\n~Ataque Normal~\n~Ataque Sônico~\n--------------------\nOpção: ";
                            texting(history, 15);
                            optionMenuAtk = input.nextLine();
                            if(optionMenuAtk.equalsIgnoreCase("Ataque Normal") || optionMenuAtk.equalsIgnoreCase("Ataque") || optionMenuAtk.equalsIgnoreCase("Atacar")){
                                bossLife -= damagePlayer;
                                menuAtk = true;
                            }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                                if(frozenAtkCD == 0){
                                    bossLife -= (damagePlayer / 2 + frozenAtk);
                                    menuAtk = true;
                                    enemyAtkS = false;
                                    frozenAtkCD = 3 - atkCD;
                                }else{
                                    history = "Este ataque está em TEMPO DE REGARGA por mais " + frozenAtkCD + " turno(s).";
                                    texting(history, 15);
                                    menuAtk = false;
                                }
                            }else{
                                history = "\nComando inválido ou digitado de maneira errada!\n";
                                texting(history, 15);
                                menuAtk = false;
                            }
                        }while(!menuAtk);
                    //Caso tenha os ataques disponíveis e ainda não os tenham usados
                    }else if(sonicAtkS && frozenAtkS){
                        do{
                            history = "--------------------\nMenu de Ataque\n\n~Ataque Normal~\n~Ataque Sônico~\n~Ataque de Gelo~\n--------------------\nOpção: ";
                            texting(history, 15);
                            optionMenuAtk = input.nextLine();
                            if(optionMenuAtk.equalsIgnoreCase("Ataque Normal") || optionMenuAtk.equalsIgnoreCase("Ataque") || optionMenuAtk.equalsIgnoreCase("Atacar")){
                                bossLife -= damagePlayer;
                                menuAtk = true;
                            }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                                if(sonicAtkCD == 0){
                                    bossLife -= (damagePlayer / 2 + sonicAtk);
                                    menuAtk = true;
                                    sonicAtkCD = 2 - atkCD;
                                }else{
                                    history = "Este ataque está em TEMPO DE REGARGA por mais " + sonicAtkCD + " turno(s).";
                                    texting(history, 15);
                                    menuAtk = false;
                                }
                            }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                                if(frozenAtkCD == 0){
                                    bossLife -= (damagePlayer / 2 + frozenAtk);
                                    menuAtk = true;
                                    enemyAtkS = false;
                                    frozenAtkCD = 3 - atkCD;
                                }else{
                                    history = "Este ataque está em TEMPO DE REGARGA por mais " + frozenAtkCD + " turno(s).";
                                    texting(history, 15);
                                    menuAtk = false;
                                }
                            }else{
                                history = "\nComando inválido ou digitado de maneira errada!\n";
                                texting(history, 15);
                                menuAtk = false;
                            }
                        }while(!menuAtk);
                    //Caso não tenha adquirido os ataques especiais
                    }else{
                        bossLife -= damagePlayer;
                        menuAtk = true;
                    }

                    //Texto pós-ataque
                    if(optionMenuAtk.equalsIgnoreCase("Ataque Normal") || optionMenuAtk.equalsIgnoreCase("Ataque") || optionMenuAtk.equalsIgnoreCase("Atacar")){
                        history = "\nAtaque certeiro, você causou " + damagePlayer + " de dano ao Boss, ele atualmente está com " + bossLife + " pontos de vida!\n\n";
                        texting(history, 15);
                    }else if(optionMenuAtk.equalsIgnoreCase("Ataque Sonico")){
                        history = "\nAtaque especial incrível, você causou " + sonicAtk + " de dano ao Boss, e ele atualmente está com apenas " + bossLife + " pontos de vida!\n\n";
                        texting(history, 15);
                    }else if(optionMenuAtk.equalsIgnoreCase("Ataque de Gelo")){
                        history = "\nAtaque especial fantástico, você causou " + frozenAtk + " de dano ao Boss, e ele atualmente está com apenas " + bossLife + " pontos de vida e não atacará no próximo turno!\n\n";
                        texting(history, 15);
                    }

                    break;
                //Dano na vida reduzido por conta da armadura(caso tenha)
                case "Defender":
                case "defender":
                    history = "\nVocê defende!\n\n";
                    texting(history, 15);
                    block = true;
                    menuAtk = true;
                    break;
                //Tentativa de se esvair de suas obrigações
                case "Correr":
                case "correr":
                    history = "\nCorrer nunca será uma opção...\n\n";
                    texting(history, 20);
                    break;
                default:
                    history = "\nComando inválido ou digitado de maneira errada!\n";
                    texting(history, 15);
            }
        }while(!menuAtk);
        //Caso derrote o boss
        if(bossLife <= 0){
            history = "Oof... Oof... Eu... Eu venci... Não acredito nisso... Oof...\n";
            texting(history, 50);
            history = "Esta batalha foi incrível, mals consigo expressar o que estou sentindo, a única coisa de que tenho certeza é de que devo ir logo, não tenho tempo a perder...";
            texting(history, 35);
        }
    }
}