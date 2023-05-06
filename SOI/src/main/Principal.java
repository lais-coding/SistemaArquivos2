package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import controll.SteamController;

public class Principal {

	public static void main(String[] args) throws IOException {


		
		int opcao = 0;
		
		String path = "C:\\TEMP";
		String arquivo = "SteamCharts.csv";

		do {


			SteamController steam = new SteamController ();

			opcao = Integer.parseInt(JOptionPane.showInputDialog("\n 1) EXIBIR MÉDIA DE JOGADORES ATIVOS \n 2) GERAR UM NOVO ARQUIVO: "));
			
			
			String ano = JOptionPane.showInputDialog("ANO: ");
			int escolherMes = Integer.parseInt(JOptionPane.showInputDialog("MÊS: "));
			String mes = "";
			
			
			
			switch(escolherMes) {
			case 1:
				mes = "January";
				break;
			case 2:
				mes = "February";
				break;
			case 3:
				mes = "March";
				break;
			case 4:
				mes = "April";
				break;
			case 5:
				mes = "May";
				break;
			case 6:
				mes = "June";
				break;
			case 7:
				mes = "July";
				break;
			case 8:
				mes = "August";
				break;
			case 9:
				mes = "September";
				break;
			case 10:
				mes = "October";
				break;
			case 11:
				mes = "November";
				break;
			case 12:
				mes = "December";
				break;
			}	
	
			

			if(opcao == 1) {
			
			double mediaUser =  Double.parseDouble(JOptionPane.showInputDialog("MÉDIA: "));
			
			
			steam.leArquivo(ano, mes, mediaUser, path, arquivo);
			
			}
			
			 if (opcao == 2) {
				steam.escreveArquivo(ano, mes, path, arquivo);
			}

			
		} while (opcao != 0);
			

	}

}