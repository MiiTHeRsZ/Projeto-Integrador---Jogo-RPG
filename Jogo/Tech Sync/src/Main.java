//Importe das bibliotéca
import java.util.*;

import javax.security.auth.callback.TextInputCallback;

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

                //Corpo do jogo com seleção de fases, quests e atribuição de upgrades.
                gameBody();
                
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
    static void gameBody() throws InterruptedException{
        int atualFase;
        
        for (atualFase = 1; atualFase <= 11; atualFase ++){
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
                faseIncompleta = true;
                primEntrada = true;
                quest2();
                break;
                
                //BOSS FIGHT
                case 3: 
                fase3();
                faseIncompleta = true;
                primEntrada = true;
                BossFight();
                //Upgrades do player
                sonicAtkS = true;
                //Upgrades do boss para o próximo encontro
                bossLife = 2 * 50;
                bossDamage += 10;
                bossLvl++;
                break;
                
                case 4: 
                fase4();
                faseIncompleta = true;
                primEntrada = true;
                quest4();
                //Upgrades do player
                lifePlayer = 2 * 25;
                break;
                
                case 5: 
                fase5();
                faseIncompleta = true;
                primEntrada = true;
                quest5();
                //Upgrades do player
                damagePlayer += 10;
                break;
                
                //BOSS FIGHT
                case 6: 
                fase6();
                faseIncompleta = true;
                primEntrada = true;
                BossFight();
                //Upgrades do player
                frozenAtkS = true;
                //Upgrades do boss para o próximo encontro
                bossLife = 4 * 25;
                bossDamage += 10;
                bossLvl++;
                break;
                
                case 7: 
                fase7();
                faseIncompleta = true;
                primEntrada = true;
                quest7();
                break;

                case 8: 
                fase8();
                faseIncompleta = true;
                primEntrada = true;
                quest8();
                break;
                
                //BOSS FIGHT
                case 9:
                fase9();
                faseIncompleta = true;
                primEntrada = true;
                BossFight();
                //SEM UPGRADES POIS NÃO HAVERÁ MAIS BOSS FIGHTS                
                break;
                
                case 10: 
                fase10();
                faseIncompleta = true;
                primEntrada = true;
                quest10();
                break;
                
                case 11:
                FimDeJogo();
                faseIncompleta = true;
                primEntrada = true;
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
                        history = "\nOs brinquedos estão largados bem ao lado do escorregador. Parece que, seja lá quem esteve aqui, teve que sair às pressas... \n\nEntre as brinquedos há um papel, nele está escrito:\nMemórias secundárias são dispositivos com grandes capacidades de armazenamento, utilizadas para guardar dados de maneira a permanecerem no dispositivo mesmo após o interrompimento no fornecimento de energia.\nPor que este bilhete está aqui, e para que foi escrito?";
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
                        voltaCaminho();
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
        primEntrada = true;

        history = "\n\nApós conectar o HD junto ao computador, sinto que algo me puxou com muita força para dentro do meu peito em uma espécie de espiral estranha. Uma voz estranha começou a falar em minha cabeça \nParabéns, primeiro bloco de memória recuperado com sucesso, faltam aproximadamente\n...................\n9 blocos de memóra, continue com o bom trabalho.\nNão entendia o que aquilo tudo significava, mas não tive muito tempo para pensar sobre isso. \nEnquanto eu ouvia a voz, sem perceber, tudo ao meu redor mudava aos poucos, e eu sentia como se o tempo passasse bem entre os meus dedos, ainda assim, o lugar onde estou de alguma forma ainda parece o mesmo.\n\nA sensação de dever a cumprir, por outro lado, não sumiu... Uma sensação amarga e estranha  que continua martelando em algum lugar dentro da minha memória... \n\nDe alguma forma sinto que há alguém tentando se comunicar comigo...";
        texting(history, 35);
        do{
            switch(areaCenario){
                //CENÁRIO DE SPAWN
                case 1:
                    if(primEntrada){
                    history = "\n\nOlho nos meus arredores e percebo, estou de volta ao jardim, meus arredores parecem ter mudado de alguma forma, a janela por onde eu havia entrado antes já não existe mais. Por outro lado, a passagem que leva para a garagem está completamente livre.\nJuntamente com a minha intuição, ela praticamente me convida a entrar.";
                    texting(history, 35);
                    primEntrada = false;
                    }
                    
                    acaoJogador();
                
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
                    if(acaoJogador.equalsIgnoreCase("olhar")){
                        history = "\nErr, definitivamente meus arredores mudaram bastante, os brinquedos de criança sumiram e agora há um carro de época bem acabadinho. A mini cratera onde... bom... eu caí, foi aproveitada para a construção de um pequeno lago de peixes. Dessa vez a passagem pelo bosque parece ter sido bloqueada por arbustos altos... o varal, entretanto, continua lá - é sempre importante manter as roupas secas hehe - algo me chama a atenção no varal, parece que alguém esqueceu algo no bolso de uma jaqueta. A janela por onde eu havia entrado antes já não existe mais. Por outro lado, a passagem que leva para a garagem está completamente livre. \nJuntamente com a minha intuição, ela praticamente me convida a entrar.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("frente") || acaoJogador.equalsIgnoreCase("entrar") || acaoJogador.equalsIgnoreCase("garagem") || acaoJogador.equalsIgnoreCase("passagem")){
                        areaCenario = 2;
                        primEntrada = true;
                    }else if(acaoJogador.equalsIgnoreCase("Interagir")){
                        interacaoInvalida();
                    }else if(acaoJogador.equalsIgnoreCase("voltar")){
                        history = "\nAtrás de mim há apenas a mini cratera formada pelo minha queda, agora ela dá forma a um mini lago com alguns peixinhos. Fora isto, não há nada de interessante aqui.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("roupas")||acaoJogador.equalsIgnoreCase("roupa")||acaoJogador.equalsIgnoreCase("varal")){
                        history = "\nAs roupas já estão secas, seja lá quem às deixou aqui, já deixou faz algum tempo. \n\nNo bolso de uma das roupas há um papel um pouco enrrugado, deve ter secado junto com as roupas. Nele está escrito: \nMemórias secundárias são dispositivos com grandes capacidades de armazenamento, utilizadas para guardar dados de maneira a permanecerem no dispositivo mesmo após o interrompimento no fornecimento de energia.\nPor que este bilhete está aqui, e para que foi escrito?";
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
                     history = "É uma típica garagem do século passado. O carro lá fora parece ser o motivo para toda a bagunça aqui dentro.\nFora o computador que está na minha frente, nada mais por este lugar poderia me ajudar a prosseguir minha jornada...";
                     texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("Frente")||acaoJogador.equalsIgnoreCase("Entrar")){
                      caminhoInvalido();
                    }else if(acaoJogador.equalsIgnoreCase("Computador")||acaoJogador.equalsIgnoreCase("Caixa")||acaoJogador.equalsIgnoreCase("Interagir")){
                      faseIncompleta = false;
                    }else if(acaoJogador.equalsIgnoreCase("Voltar")){
                       voltaCaminho();
                       areaCenario = 1;
                      primEntrada = true;
                    }else{
                     acaoInvalida();
                    }
                break;
                    
            }
            
        }while(faseIncompleta);

    }
        
    static void fase3() throws InterruptedException{ //BOSS FIGHT
        do{
            //TEXTO DE INTRODUÇÃO DO CENÁRIO.
            history = "\n\nFoi só apertar o botão que aconteceu novamente... O tempo ao meu redor dobrando por mais uma vez, sinto que sou puxado para algo dentro de meu peito. O passar das estações e as mudanças climáticas passam diante dos meus olhos em cenários sempre distintos.\nMais uma vez, me encontro em um lugar estranho, meus sentidos e motivos parecem mais claros... De alguma forma sei que tenho uma missão a cumprir, sei que alguém ainda tenta se comunicar comigo...";
            texting(history, 35);
            history = "\n\nOk, estou dentro da casa branca novamente. Próximo de mim parece haver um dispositivo de comunicação semelhante a um headset, junto a ele, o mesmo computador de sempre está disposto em uma mesa de centro... Hmm, isso está fácil demais - Começo a caminhar em direção ao computador - Definitivamente algo não está certo.. o clima está pesado demais e.. parando pra pensar alguns detalhes ao meu redor não fazem sentido.. Por que há ferramentas espalhadas pela sala? Espera um pouco... elas estão se movendo? Mas que porcaria, eu não tenho tempo pra perder com esse tipo de alucinação, preciso sair logo desse lugar.. - chego perto da mesa de centro, ao interagir com o dispositivo de comunicação, UM VOID EM ESPIRAL surge bem em minha frente, colocando-se entre mim e o headset, me afasto instintivamente para me proteger e nesse momento percebo: Há agora uma espécie de máquina antropomórfica bem em minha frente. Seu semblante por si só é de dar calafrios.";
            texting(history, 10);
            //FALA DO BOSS
            history = "\n\n\nEU NÃO ACREDITO NO QUE ESTOU VENDO EM MINHA FRENTE MUAHAHAHAHAHAH ENTÃO A CRIATURA QUE ESTÁ ME DANDO TANTO TRABALHO NO PASSADO NÃO PASSA DE UM MERO  >>>R O B O Z I N H O<<<? VOCÊ SÓ PODE ESTAR DE BRINCADEIRA COM A MINHA CARA - Diz a figura bizarra que apareceu em minha frente.";
            texting(history, 20);
            //"FALA" DO ROBOZINHO
            history = "\n\n\nEspera, o quê? O que você quer dizer com robozinho... E como assim robozinho? - Foi o que eu quis dizer mas, quando me dei por conta, nenhum som saiu de mim.. - O que diabos é isso? - Continuei pensando comigo mesmo - EU SOU MUDO?";
            texting(history, 35);
            //FALA DO BOSS 2
            history = "\n\n\nTUDO QUE VOCÊ SABE FAZER SÃO ESSES MURMÚRIOS ESTRANHOS? VOCÊ É PRATICAMENTE FEITO DE SuCaTa, EU VOU ACABAR COM ESSA SUA VIAGENZINHA TEMPORAL AGORA MESMO, MORRA SUA PRAGA FEITA DE FERRUGEM! - O maldito robo mal termina sua frase e inicia uma ataque direto contra mim.";
            texting(history, 20);
            //RELATÓRIO DE COMBATE
            history = "\nA mão do maldito parece tão rápida quanto o próprio som, mas consigo desviar do ataque com um rápido pulo expontâneo.. Ouso então uma voz em minha cabeça.\n\nAtenção ameaça de alto nível detectada, modo de combate ativado - Enquanto a voz fala, sinto meu corpo ficando cada vez mais leve, é como se algo dentro de mim começasse a se mover, tornando cada um dos meus movimentos mais precisos - Menu de combate ativado, recomendo que escolha seus movimentos com cautela.";
            texting(history, 35);
            
            //Encontro com o Boss e início da boss fight - Transferido para o seletor de fases.
            //BossFight();
            faseIncompleta = false;
        }while(faseIncompleta);
    
    }
    
    static void fase4() throws InterruptedException{
        primEntrada = true;

        history = "\n\nDessa vez, o passar do tempo me pareceu diferente, demorei para processar mas, antes de ser puxado por mais uma vez, de relance pude ver a maldita máquina ainda de pé. Após isso, foi como apagar e passar por um mutirão de luzes vermelhas que piscam por todos os lados. Quando as coisas ao meu redor pararam de mudar, pude reparar uma voz dentro da minha cabeça, era a mesma de antes.";
        texting(history, 35);
        history = "\nRelatório de Danos: Componentes primordiais da placa principal danificados, núcleo de retaguarda atingido, procedimento recomendado: substituição de componentes. O mapa temporal aponta um equipamento compatível nesta época. Marcando coordenadas.";
        texting(history, 20);
        history = "\nPELOS DEUSES - uma segunda voz, dessa vez bem familiar, ecoou pela minha cabeça - O que diabos aconteceu contigo ZC-T2? E “quando” é este lugar onde você está?... - Por mais que a voz me pareça familiar, não consigo lembrar da imagem desse homem, só sei que deve ser alguém importante para mim - Hmmm... Deixe-me pensar... Acho que entendi, os relatórios em tempo real acabaram de ser atualizados... Parece que o maldito SyncWare pode te encontrar mesmo através das barreiras do tempo... Ok, sem pânico, os protocolos de segurança já te direcionaram para um momento apropriado da história, tudo que você precisa fazer é buscar aquele bloco de memória e usar as peças que encontrar no meio do caminho para reparar os seus danos, justamente como está descrito nos protocolos de emergência. - O homem disse com um leve peso em sua voz - Por favor ZC-T2, eu sei que você não é capaz de entender minhas súplicas, mas lembre-se da import..... - A voz é abruptamente interrompida, meus sentidos estão cada vez mais atordoados, tenho que continuar seguindo em frente...";
        texting(history, 35);

        do{
            switch(areaCenario){

                //CENÁRIO DE SPAWN
                case 1:
                    if(primEntrada){
                        history = "\n\nOlho ao meu redor, o lugar onde estou de alguma maneira me remete a sala onde eu consegui o HD... Hmm... Na veradede, de fato é a mesma sala onde eu o peguei. Só que está diferente... \nAgora não há mais um computador estranho no meio da sala, e uma bela mobília dá vida a cada canto do lugar.\nAs escadas, agora livres de bloqueio, arqueiam pela sala e, ao que tudo indica, levam a um ponto comum no andar superior. Consigo sentir que lá há algo que eu preciso obter.";
                        texting(history, 35);
                        primEntrada = false;
                    }
                    
                    acaoJogador();
                    
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
                    if(acaoJogador.equalsIgnoreCase("olhar")){
                        history = "\nUma lareira pode ser vista ao final da sala, há algumas poltronas vermelhas em seu entorno dando um ar gótico à sala. No lugar onde anteriormente estava o computador, agora há uma mesa redonda de vidro com várias cadeiras luxuosas dispostas ao seu redor. Também há alguns armários e gaveteiros espalhados pela sala, entre todos eles, um me chama a atenção devido a uma espécie de fotografia.\nAs escadas, agora livres de bloqueio, arqueiam pela sala e, ao que tudo indica, levam a um ponto comum no andar superior. Consigo sentir que lá há algo que eu preciso obter.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("frente") || acaoJogador.equalsIgnoreCase("subir") || acaoJogador.equalsIgnoreCase("escada") || acaoJogador.equalsIgnoreCase("escadaria") || acaoJogador.equalsIgnoreCase("escadas")){
                        areaCenario = 2;
                        primEntrada = true;
                    }else if(acaoJogador.equalsIgnoreCase("Interagir")){
                        interacaoInvalida();
                    }else if(acaoJogador.equalsIgnoreCase("voltar")){
                        history = "\nAtrás de mim deveria haver uma janela que levaria de volta ao jardim, entretanto, no lugar disso tudo que há é uma parede. A janela deve ter sido removida junto da reforma. De qualquer forma, preciso encontrar outro caminho...";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("roupas")||acaoJogador.equalsIgnoreCase("roupa")||acaoJogador.equalsIgnoreCase("varal")){
                        history = "\nAo pegar a fotografia, vejo um alvo homem com seus aproximadamente 60 anos. Os cabelos brancos deixam bem nítido o quanto o tempo o marcou... Do seu lado, há um rapaz na flor de seus 20 e poucos anos que claramente não queria estar naquela foto..\nNa parte de trás do quadro, consigo ver um papel dobrado. Nele está escrito: \nA placa-mãe é o dispositivo encarregado de fazer a interação dos hardwares entre si, sem ela não teriam como trocar informações para que pudessem funcionar em conjunto.\nPor que este bilhete está aqui, e para que foi escrito?";
                        texting(history, 35);
                    }else{
                        acaoInvalida();
                    }
                break;

                //CENÁRIO DA MISSÃO PRINCIPAL
                case 2:
                    if (primEntrada){
                        history = "\n\nAo subir as escadas, percebo o quão grande é a magnitude dessa casa, uma sala extensa se desenrola em minha frente como um domo, vejo uma espécie de biblioteca tomando conta de todas as partes, seja lá quem vive aqui, certamente é uma pessoa muito estudiosa\nNão me surpreende mais o fato de encontrar este computador estranho pelas salas dessa... digamos... jornada. Só me incomoda o quanto ele parece distópico em relação a todo o resto do ambiente...\nDessa vez ele se encontra no meio da sala, no ponto central que dá origem ao domo redondo que é a sala, a caixa estranha com fios conectados continua lá, e eu sei que ela guarda exatamente o que eu preciso para reparar o dano que sofri.";
                        texting(history, 35);
                        primEntrada = false;
                    }

                    acaoJogador();

                    if (acaoJogador.equalsIgnoreCase("olhar")){
                        history = "A bíblioteca tem proporções absurdas, há tantos livros aqui que provavelmente um só humano não conseguiria ler em uma vida. \nO formato circular da sala favorece a impressão de que, não importa para onde você olhe, sempre há uma sessão diferente para descobrir com centenas de livros. O computador estranho está localizado no centro dessa sala, no ponto X da redoma, sei que preciso ir até ele me reparar e, principalmente, para avançar na minha jornada.\nAdoro a ideia de poder absorver tanto conhecimento, mas no momento, só tenho tempo para presseguir com meu objetivo.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("Frente")||acaoJogador.equalsIgnoreCase("Entrar")){
                        caminhoInvalido();
                    }else if(acaoJogador.equalsIgnoreCase("Computador")||acaoJogador.equalsIgnoreCase("Caixa")||acaoJogador.equalsIgnoreCase("Interagir")){
                        faseIncompleta = false;
                    }else if(acaoJogador.equalsIgnoreCase("Voltar")){
                        voltaCaminho();
                        areaCenario = 1;
                        primEntrada = true;
                    }else{
                        acaoInvalida();
                    }
                break;
            }
            
        }while(faseIncompleta);

    }
    
    static void fase5() throws InterruptedException{
        primEntrada = true;

        history = "\n\nOK, o vórtice temporal me puxou e aqui estou eu em um lugar diferente MAIS UMA VEZ...... \nNão entenda errado, estou quase me acostumando com esses frequentes pulos esquisitos e tudo mais, mas... PORQUE EU APARECI NO MEIO DO MATO?";
        texting(history, 35);

        do{
            switch(areaCenario){

                //CENÁRIO DE SPAWN
                case 1:
                    if(primEntrada){
                        history = "\nNão tem nada aqui, só... grama e árvores? Hmm olhando melhor, acho que consigo notar alguns detalhes, a grama para aquele lado parece ser mais baixa.. Ah, parece ter uma espécie de... espera, isso é um TÚMULO?? QUE LUGAR É ESSE? É melhor eu evitar aquilo...\n Humpf.. pelo menos a minha intuição não está falhando... tenho que seguir na direção norte, certo? Ok, consigo ver agora, há fitas vermelhas enroladas nos troncos, acho que indicam o caminho...";
                        texting(history, 35);
                        primEntrada = false;
                    }
                    
                    acaoJogador();
                    
                    System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________");
                    if(acaoJogador.equalsIgnoreCase("olhar")){
                        history = "\nBom, não tem muito o que olhar aqui, só esse túmulo macabro e essas árvores com fitas... Tudo bem, a clareira onde estou até pode ser bonita, e o verde de alguma forma acalma meu coração mas... ISSO TUDO NÃO VAI ME AJUDAR A CONTINUAR A JORNADA! Preciso seguir em frente.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("frente") || acaoJogador.equalsIgnoreCase("seguir") || acaoJogador.equalsIgnoreCase("fitas") || acaoJogador.equalsIgnoreCase("fita") || acaoJogador.equalsIgnoreCase("norte")){
                        areaCenario = 2;
                        primEntrada = true;
                    }else if(acaoJogador.equalsIgnoreCase("Interagir")){
                        interacaoInvalida();
                    }else if(acaoJogador.equalsIgnoreCase("voltar")){
                        history = "\n......";
                        texting(history, 50);
                        history = "\nCara, para onde eu deveria voltar? EU ESTOU NO MEIO DO MATO!! \nNão tem pra onde voltar.";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("túmulo")||acaoJogador.equalsIgnoreCase("tumulo")||acaoJogador.equalsIgnoreCase("lápide") || acaoJogador.equalsIgnoreCase("lapide")){
                        history = "\nNão acredito que vou mesmo olhar esse treco... Bom, olhando de mais perto, parece muito pequeno para ser de um humano ou algo do gênero...\nArgh, tem uma lápide simples feita de madeira aqui.. parece estar.. suja? Não, espera, tem algo escrito... \n- AQUI JAZ MR. BENSON, VOCÊ FOI UM ÓTIMO GATO E UM AMIGO AINDA MELHOR -\nOk, isso ficou mais triste do que eu gostaria, acho que vou chorar\n\n........\n\nHm... o que é isso, um bilhete? Acho que alguém deixou cair em uma das visitas... Nele está escrito: \nO processador é encarregado de receber, processar e transformar dados em informação, para que essa mesma informação seja transmitida para os outros componentes do computador através da placa-mãe.\nPor que este bilhete está aqui, e para que foi escrito?";
                        texting(history, 35);
                    }else{
                        acaoInvalida();
                    }
                break;

                //CENÁRIO DA MISSÃO PRINCIPAL
                case 2:
                    if (primEntrada){
                        history = "\n\n............\n............\n............";
                        tempo += 5;
                        texting(history, 40);
                        history = "\nAAAAA FINALMENTE! Já não aguentava mais andar por esse bosque, não acredito que já está escurecendo... …Espera aí… estou de volta no jardim da casa? Merda, parece que alguma coisa não está certa… tem uma ambulância estacionada no lugar do carro de antes.. será que tem alguém aqui?";
                        texting(history, 35);
                        history = "\n\nZC-T2, os relatórios me indicaram que você está em um local de possível interação humana. - A conhecida voz daquele homem de antes tomou espaço em algum lugar da minha cabeça novamente - Eu sei que os bloqueios definidos te impediria de ter qualquer contato com seres humanos no passado mas… - ele claramente parecia confuso sobre aquela situação, talvez até tanto quanto eu - desde que você chegou aí, parece que tudo foi diferente do planejado, as leituras indicam que você entrou numa zona completamente diferente do nosso mundo… um tipo de mistura entre vários, digamos, momentos diferentes.. mas ao mesmo tempo?.... Bom, claramente há limitações para viagem no tempo, e acho que essa é uma delas… eu deveria saber disso, não deveria ter criado expectativas em relação ao meu… \nHouve uma interrupção longa na fala, por um instante pensei que o sinal havia caído, mas então ele continuou \nAh, estamos perdendo tempo precioso aqui Z2, você precisa continuar… Estou subindo os protocolos novos para situações de interação, dessa forma você poderá interagir com o computador dentro da ambulância, por favor busque os blocos restantes e volte o mais rápido o possível… Eu… não.. o MUNDO depende disso. - completou a frase e encerrou a comunicação.";
                        texting(history, 25);
                        history = "\n\nISSO TUDO NÃO FAZ SENTIDO NENHUM, não consigo entender qual a razão de tudo isso, nem sequer sei porquê estou aqui ou o que eu SOU exatamente… \n\n….\n….\n….\n\nBom, só me resta ajudar esse homem, eu sei que as intenções dele são puras. Ele parece muito preocupado com algo e eu, aparentemente, sou o único que pode ajudar… Tenho que seguir em frente!";
                        texting(history, 35);
                        primEntrada = false;
                    }

                    acaoJogador();

                    if (acaoJogador.equalsIgnoreCase("olhar")){
                        history = "\n\nA noite está muito escura, só consigo ver ambulância estacionada no quintal.\nComo o homem disse, o computador e a caixa estranha estão dentro dela… \nNos meus arredores não parece haver mais nada que vá me ajudar...\n Preciso resolver a questão no computador!";
                        texting(history, 35);
                    }else if(acaoJogador.equalsIgnoreCase("Frente")||acaoJogador.equalsIgnoreCase("Entrar")){
                        caminhoInvalido();
                    }else if(acaoJogador.equalsIgnoreCase("Computador")||acaoJogador.equalsIgnoreCase("Caixa")||acaoJogador.equalsIgnoreCase("Interagir")){
                        faseIncompleta = false;
                    }else if(acaoJogador.equalsIgnoreCase("Voltar")){
                        history = "Está ficando muito escuro, se eu for para o bosque agora, não vou conseguir achar meu caminho de volta... Preciso resolver a questão naquele computador!";
                    }else{
                        acaoInvalida();
                    }
                break;
            }
            
        }while(faseIncompleta);

    }

    static void fase6() throws InterruptedException{ //BOSS FIGHT
        do{


            //Encontro com o Boss e início da boss fight
            //BossFight(); - Transferido para o seletor de fases.
        }while(faseIncompleta);
        
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
            //BossFight(); - Transferido para o seletor de fases. 
        }while(faseIncompleta);
    
    }
    
    static void fase10() throws InterruptedException{
        do{

        }while(faseIncompleta);
    
    }

    static void FimDeJogo() throws InterruptedException{
        do{
            if(tempo <=150){
                //finalBom();
            }else if(tempo <= 250){
                //finalPadrao();
            }else if(tempo > 250){
                //finalRuim();
            }
            
            
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
                history = "\nPor que esse treco abriu tão violentamente? Eu tomei um susto!\nEnfim, o que temos aqui???\nUm HD? Hmm... A entrada é exatamente a mesma do computador, será que eu deveria conecta-lo? Essa intuição estranha continua me dizendo o que fazer, não consigo entender as coisas que estão acontecendo ao meu redor e isso está me deixando LOUCO!\n......\nBom, se há alguma forma de continuar deve ser conectando esse HD no comput..";
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
        history = "\n\nTá, parece a mesma coisa de antes, só há a aplicação de REVISÃO DE SEGURANÇA na tela... \nBom... não me resta outra alternativa senão abrir o aplicativo.\nHmm, parece há outra pergunta... Vamos ver...";
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
                history = "\nPORQUE TEM QUE SER SEMPRE TÃO BARULHENTO???\n....Enfim, o computador parece ter a mesma entrada de antes, vou conectar o HD.\nParabéns, segundo bloco de memória recuperado com sucesso, faltam aproximadamente\n...................\n8 blocos de memóra, continue com o bom trabalho.\nEssa voz estranha mais uma vez... bom, e na caixa? deixe-me ver.....\nUma Placa de Rede? Hmm... Parece que, da mesma forma que antes, um equipamento foi disponibilizado de acordo com o que estava escrito no questionário...\nBom, vejamos bem, o que eu deveria fazer com... - No momento em que eu encosto na placa de rede, uma voz estranha começa a falar em minha cabeça.";
                texting(history, 35);
                history = " - RELATORIO DE INSTALAÇÃO, INICIAR - ACLOPE O EQUIPAMENTO NA UNIDADE CENTRAL DO SEU BRAÇO ESQUERDO, EM SEGUIDA, PRESSIONE O BOTÃO AZUL AO LADO DO ENCAIXE PARA FINALIZAR A INSTALAÇÃO";
                texting(history, 20);                
                history = "Ohh, eu não tinha percebido que tenho equipamentos tão tecnológicos assim hehe. Ok moça, colocar no encaixe, e apertar o botão az....";
                texting(history, 35);
                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    //COMBATE NO LUGAR DA TERCEIRA QUEST

    static void quest4() throws InterruptedException{
        history = "\n\nCerto, vamos lá... REVISÃO DE SEGURANÇA... Como eu imaginei, o mesmo aplicativo de novo\nBom... como sempre, vou abrir o aplicativo.\nHmm, qual será a questão dessa vez... Vamos ver...";
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
                history = "\nNÃO ACREDITO QUE EU CONTINUO TOMANDO SUSTO MESMO JÁ SABENDO O QUE VAI ACONTECER!\nEnfim, o que temos aqui???\nUma placa mãe.. exatamente o que eu imaginava, bom preciso consultar o relatório de danos de novo, como posso reparar esse tipo de... bom, como eu chamo isso? Ferimento?\n...\nENFIM, ativar instruções de reparo!!";
                texting(history, 35);
                history = "\nANÁLISE DE DANOS ATUALIZADA, SOLTANDO MÓDULOS DANIFICADOS, APROXIME A PLACA DA UNIDADE TRASEIRA, OS MICROROBOS DE REPARO CUIDARÃO DO RESTO.";
                texting(history, 20);
                history = ".......";
                texting(history, 80);
                history = "Aaaah, bem melhor, sinto como se eu pudesse batalhar mais 200 vezes de novo... Se bem que..... parando pra pensar, melhor não me envolver em encrencas desnecessárias, aquele homem de antes parece estar contando comigo para algo muito importante...\nEnfim, porquê eu ainda não fui levado até o próximo local?... \nAH, é claro\nEsqueci de conectar o HD ao computador... Bom, vamos lá... 1, 2, 3...";
                texting(history, 35);

                faseIncompleta = false;
            }else{
                questInvalida();
            }

        }while(faseIncompleta);
    }

    static void quest5() throws InterruptedException{
        history = "\n\nREVISÃO DE SEGURANÇA... \nVamos ver o que vem a seguir...";
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
                history = "\n\n..........";
                texting(history, 40);
                history = " Ué, será que eu errei? A caixa não está fazendo na..";
                history = "\nAAAAAAAAAAAAAAAH, ABRIU DE NOVO!!!!";
                texting(history, 5);
                history = "\nEU AINDA VOU DESTRUIR O RESPONSÁVEL POR FAZER ESSAS CAIXAS!!!\n\nArgh, é melhor eu copiar o bloco de dados logo... Enquanto isso.. deixe me ver o que temos na caixa... Hmm, um processador como esperado.";
                texting(history, 35);
                history = "INICIANDO PROTOCOLO DE UPGRADE - CORTEX PRINCIPAL, ANTEÇÃO, APÓS A INSTALAÇÃO SERA NECESSÁRIO REALIZAR UM REBOOT DO SISTEMA, APROXIME A UNIDADE DE PROCESSAMENTO DO NÚCLEO DE PROCESSAMENTO CENTRAL - SUA CABEÇA - SE DESEJA CONTINUAR.";
                texting(history, 20);
                history = "Ué, porquê não... O que pode dar errad...";
                texting(history, 35);

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

    //Volta caminho.
    static void voltaCaminho() throws InterruptedException{
        history = "Volto pelo caminho de onde vim...";
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
                //Tentativa de se tornar um COVARDE perante suas obrigações
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
            if(bossLvl == 1){
                history = "\n\n\nFinalmente derrotei esse robô maligno... \nEstou exausto, mas preciso continuar.. - Começo a caminhar em direção ao computador estranho, deixando a carcaça do monstro metálico para trás. Ao chegar na mesa, vejo algo como uma matriz bem diante dos meus olhos. Ela me dá instruções sobre o que fazer com o headset que estava agora em minhas mãos. Sigo o procedimento até escutar um aviso de voz dizendo “instalação concluída”. \n\nNo mesmo instante em que eu concluo a instalação, um barulho de encaixe se faz presente no meu braço. O percebo que o HD que eu havia encontrado antes está num encaixe em meu braço - ..um robozinho.. - Tenho um flashback do que o inimigo havia me dito. \nBom, robô ou não, já vim muito longe seguindo minha intuição, agora preciso focar em continuar essa jornada para entender o que está acontecendo. Retiro o HD do meu braço e o conecto no computador...";
                texting(history, 35);
            }else if(bossLvl == 2){

            }else if(bossLvl == 3){

            }
        }
    }
}