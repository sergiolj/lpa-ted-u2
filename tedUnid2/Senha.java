
package tedUnid2;

import java.util.Random;
import java.util.Scanner;

public class Senha {

	public static void main(String[] args) {
		int[] password=new int[4];
		int[] jogada=new int[4];
		int rodada=1;
		boolean solucao=false;
		String passwrd="";
		String [] jogadas=new String[10];
		Scanner input=new Scanner(System.in);
		passwrd=geraSenhaRandom(password);
		instrucoes();
		input.nextLine();
		limpaTela();
			do {
				System.out.println(passwrd);// APAGAR
				rodada=jogador(jogada, rodada, jogadas, input);
				System.out.println(" ");
				solucao=verifica(password,jogada);
			}while ((rodada<=10)&&(solucao!=true));

		limpaTela();
			if ((rodada==11)&&(solucao!=true)){
				gameOver(passwrd);
			}else if (solucao==true){
				vencedor(passwrd, rodada);
		}
	}

	public static String geraSenhaRandom(int[] v) {
		String p="";
		Random aleat=new Random();
		for(int i=0;i<v.length;i++) {
			v[i]=aleat.nextInt(7-1)+1;
			p+=Integer.toString(v[i]);
		}
	return p;
	}

	public static int jogador(int []v, int r, String[] j, Scanner input) {
		String p="";
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+            Tentativa ["+r+"]                +");
		System.out.println("+ Digite 4 números inteiros em sequência  +");
		System.out.println("+ separados por espaço e a seguir <ENTER> +");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.print("Sua jogada? ");
			for(int i=0;i<v.length;i++) {
				v[i]=input.nextInt();
				p+=Integer.toString(v[i]);
			}
			j[r-1]=p;
			System.out.println("Histórico de Jogadas:");
			for(int i=0;i<r;i++) {
				System.out.print("["+(i+1)+"]"+j[i]+" ");
			}
			r+=1;
	return r;
	}

	public static boolean verifica(int [] p, int []j) {
		Scanner input=new Scanner(System.in);
		int [] ptemp=new int [p.length];
		boolean s=false;
			for(int i=0;i<p.length;i++) {
				ptemp[i]=p[i];
			}
		int npok=0;
		int nperr=0;
			for(int i=0;i<j.length;i++) {
				if (j[i]==ptemp[i]) {
					npok+=1;
					j[i]=0;
					ptemp[i]=0;
				}
			}
			if (npok==p.length) {
				s=true;
			}else {
				for(int ij=0;ij<j.length;ij++) {
					for(int ip=0;ip<p.length;ip++) {
						if((ptemp[ip]==j[ij])&&(ptemp[ip]!=0)) {
							nperr+=1;
							j[ij]=0;
							ptemp[ip]=0;
							ip=p.length;
						}
					}
				}
			}
		System.out.println();
		System.out.println("Dígito CERTO na posição CERTA: ["+npok+"]");
		System.out.println("Dígito CERTO na posição ERRADA: ["+nperr+"]");
		System.out.println("Digite <ENTER> para continuar...");
		input.nextLine();
		limpaTela();
	return s;
	}

	public static void limpaTela() {
		for (int i=0;i<70;i++) {
			System.out.println();
		}
	}

	public static void instrucoes() {
		System.out.println(" .----------------.  .----------------.  .-----------------. .----------------.  .----------------. ");
		System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");
		System.out.println("| |    _______   | || |  _________   | || | ____  _____  | || |  ____  ____  | || |      __      | |");
		System.out.println("| |   /  ___  |  | || | |_   ___  |  | || ||_   \\|_   _| | || | |_   ||   _| | || |     /  \\     | |");
		System.out.println("| |  |  (__ \\_|  | || |   | |_  \\_|  | || |  |   \\ | |   | || |   | |__| |   | || |    / /\\ \\    | |");
		System.out.println("| |   '.___`-.   | || |   |  _|  _   | || |  | |\\ \\| |   | || |   |  __  |   | || |   / ____ \\   | | ");
		System.out.println("| |  |`\\____) |  | || |  _| |___/ |  | || | _| |_\\   |_  | || |  _| |  | |_  | || | _/ /    \\ \\_ | | ");
		System.out.println("| |  |_______.'  | || | |_________|  | || ||_____|\\____| | || | |____||____| | || ||____|  |____|| | ");
		System.out.println("| |              | || |              | || |              | || |              | || |              | | ");
		System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' | ");
		System.out.println(" '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
		System.out.println("BEM VINDO ao jogo da senha, esse jogo foi adaptado a partir do jogo de tabuleiro Mastermind,");
		System.out.println("criado por Mordechai Meirowitz e publicado em 1971 (fonte: Wikipedia)");
		System.out.println("O objetivo do jogo é descobrir a senha de 4 dígitos (1 até 6) formada aleatoriamente pelo computador.");
		System.out.println(" ");
		System.out.println("INSTRUÇÕES:");
		System.out.println("O jogador possui 10 rodadas para descobrir a senha e a cada tentativa o computador informa quantos");
		System.out.println("números pertencem a senha e estão na posição correta e quantos pertencem a senha mas estão em posição incorreta.");
		System.out.println("O jogo termina quando a senha for descoberta ou acabarem as 10 tentativas do jogador.");
		System.out.println(" ");
		System.out.println("Digite <ENTER> para continuar...");
	}

	public static void gameOver(String p) {
		System.out.println("      ___   _   __  __ ___    _____   _____ ___");
		System.out.println("     / __| /_\\ |  \\/  | __|  / _ \\ \\ / / __| _ \\");
		System.out.println("    | (_ |/ _ \\| |\\/| | _|  | (_) \\ V /| _||   /");
		System.out.println("     \\___/_/ \\_\\_|  |_|___|  \\___/ \\_/ |___|_|_\\");
		System.out.println("   ______________________________________________ ");
		System.out.println("                VOCÊ QUASE ACERTOU!!");
		System.out.println("             MELHOR SORTE NA PRÓXIMA VEZ!!");
		System.out.print("             A senha correta era: [ "+p+" ]");
		System.out.println(" ");
	}

	public static void vencedor(String p, int r) {
		System.out.println("                ############################");
		System.out.println("                 ##########################");
		System.out.println("                 ##########################");
		System.out.println("                 ##########################");
		System.out.println("           ################     ################### ");
		System.out.println("         ####    ############   ###########      ##  ");
		System.out.println("         ####      ##########   ###########      ## ");
		System.out.println("           ##      ##########   ###########    ####  ");
		System.out.println("             ####    ########   #########    #### ");
		System.out.println("               ############       #############  ");
		System.out.println("                   ######################## ");
		System.out.println("                       ############## ");
		System.out.println("                         ############ ");
		System.out.println("                           ######## ");
		System.out.println("                             ####");
		System.out.println("                             ####");
		System.out.println("                        ##############");
		System.out.println("                       #####      #####");
		System.out.println("                        #### "+p+" ####");
		System.out.println("                      ##################");
		System.out.println("            _________________________________________");
		System.out.println("               PARABÉNS!! VOCÊ VENCEU O DESAFIO!!");
		System.out.println("                        Rodada [ "+(r-1)+" ]");
	}
}