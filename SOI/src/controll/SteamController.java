package controll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController implements ISteamController {
	
	
	public SteamController() {
		super();
	}
	
	//EXERCÍCIO 1
	
	public void leArquivo(String ano, String mes, double mediaUser, String path, String arquivo) throws IOException {
		
		File arq = new File (path, arquivo);
		
		if(arq.exists() && arq.isFile()) {
			
			
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			
			String linha = buffer.readLine();
			
			while(linha != null) {
				
				String [] vetLinha = linha.split(",");
				
				if(linha.contains(ano) && linha.contains(mes)) {
					
					double mediaAtivos = Double.parseDouble(vetLinha[3]);
					
					if(mediaAtivos >= mediaUser) {
						
						System.out.println("NOME DO JOGO: " + vetLinha[0] + "\n ANO: " + vetLinha[1] + "\n MÊS: " + vetLinha[2] + "\n MÉDIA DO USUÁRIO: " + mediaUser + "\n MÉDIA DE ATIVOS: " + mediaAtivos);
						System.out.println("\n");
						System.out.println("----------------------------------------------------------------");
						System.out.println("\n");
					}
					
					
				}
					
				linha = buffer.readLine();
				
				
			}
			
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			
		}
		
		
		
	}
	
	
	
	//EXERCÍCIO 2

	@Override
	public void escreveArquivo(String ano, String mes, String path, String arquivo) throws IOException {
		
		File dir = new File(path);
		
		
		//Verificar se arquivo e diretório existe
		
		if(dir.exists() && dir.isDirectory()) {
			
			File arq = new File (path, arquivo);
			
			boolean existe = false;
			
			if(arq.exists()) {
				existe = true;
				
				//Gravar conteúdo
				
				String conteudo = gravarConteudo(ano, mes, path, arquivo, arq);
				

				
				//Gerar novo arquivo
				
				String arquivoNovo = "SteamFormatado.csv";
						
				File arqNovo = new File(path, arquivoNovo);
				FileWriter abreArq = new FileWriter(arqNovo);
				PrintWriter escreveArq = new PrintWriter(arqNovo);
				escreveArq.write(conteudo);
				escreveArq.flush();
				escreveArq.close();
				abreArq.close();
				
			
				
			}
			

		
			
	} else {
		
		
		throw new IOException("Diretório inválido!!!");
	}
	

	}

	
	private String gravarConteudo(String ano, String mes, String path, String arquivo, File arq) throws IOException {
		
		StringBuffer thebuffer = new StringBuffer();
		FileInputStream abreFluxoArq = new FileInputStream(arq);
		InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
		BufferedReader buffer = new BufferedReader(leitorFluxo);
		
		
		String linha = buffer.readLine();
		String linhaArquivo = "";		
		
			while(linha != null) {
			
			String [] vetLinha = linha.split(",");
			
			if(linha.contains(ano) && linha.contains(mes)) {
				linhaArquivo = ("NOME DO JOGO: " + vetLinha[0] + "\n ANO: " + vetLinha[1] + "\n MÊS: " + vetLinha[2] + "\n MÉDIA DE ATIVOS: " + vetLinha[3]);
				thebuffer.append(linhaArquivo + "\n ------------------------ ");
			}
			
			linha = buffer.readLine();
			
			
			} 
			
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
			
		
			return thebuffer.toString();
		
			

	} 


	
	
	}

