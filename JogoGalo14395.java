import java.util.Scanner; 
public class JogoGalo
{
	public static void main(String[] args)
	{
		Scanner ler = new Scanner(System.in); 
		char[] tabu = {'1','2','3','4','5','6','7','8','9'};  
		char jogador;
		char jogada;
		boolean temp;
		int aux = 0;
		jogador = 'O';
		do
		{
			cls();
			tabuleiro(tabu);
			if(jogador == 'X')
			{
				jogador = 'O';
			}
			else
			{
				jogador = 'X';
			}
			System.out.println("Jogador: "+ jogador);
			jogada = verificaJogada(tabu);
			for(int i = 0; i < 9; i++)
			{
				if(jogada == tabu[i])
				{
					tabu[i] = jogador;
				}
			}
			temp = verificaVitoria(tabu);
			aux++;
		}
		while(aux != 9 && temp != true);
		cls();
		tabuleiro(tabu);
		if(!temp)
		{
			System.out.print("Jogo Empatado!");
		}
		else
		{
			System.out.print("O jogador "+jogador+" ganhou.");
		}
	}

	public static void tabuleiro(char[] tabu)
	{
		System.out.println("JOGO DO GALO");
		System.out.println(" "+tabu[0]+" | "+tabu[1]+" | "+tabu[2]+" ");
		System.out.println("---+---+---");
		System.out.println(" "+tabu[3]+" | "+tabu[4]+" | "+tabu[5]+" ");
		System.out.println("---+---+---");
		System.out.println(" "+tabu[6]+" | "+tabu[7]+" | "+tabu[8]+" ");
	}
	public static boolean verificaVitoria(char[] tabu)
	{
		if(tabu[0] == tabu[1] && tabu[1] == tabu[2])
		{
			return true;
		}
		else if(tabu[3] == tabu[4] && tabu[4] == tabu[5])
		{
			return true;
		}
		else if(tabu[6] == tabu[7] && tabu[7] == tabu[8]) 
		{
			return true;
		}
		else if(tabu[0] == tabu[3] && tabu[3] == tabu[6]) 
		{
			return true;
		}
		else if(tabu[1] == tabu[4] && tabu[4] == tabu[7]) 
		{
			return true;
		}
		else if(tabu[2] == tabu[5] && tabu[5] == tabu[8]) 
		{
			return true;
		}
		else if(tabu[0] == tabu[4] && tabu[4] == tabu[8]) 
		{
			return true;
		}
		else if(tabu[2] == tabu[4] && tabu[4] == tabu[6]) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public static char verificaJogada(char[] tabu)
	{
		char jogada;
		Scanner ler = new Scanner(System.in);
		do 
		{
			System.out.print("Insira jogada (1-9): ");
			jogada = ler.next().charAt(0);
		} 
		while(jogada > '9' || jogada < '1' || tabu[jogada - '1'] == 'X' || tabu[jogada - '1'] == 'O');
		return jogada;
	}
	public static void cls()
	{
		try
		{	
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception E)
			{
				System.out.println(E);
			}
	}
}