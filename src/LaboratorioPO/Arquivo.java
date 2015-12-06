package LaboratorioPO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arquivo {

	private String nome = "";

	@SuppressWarnings("unused")
	private Arquivo() {
	}

	public Arquivo(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Cria um problema a partir de um arquivo Retorna o problema se arquivo
	 * válido Retorna null para arquivo inválido
	 */
	public Problema pegarProblema() {
		if ((this.nome == null) || (this.nome.equals(""))) {
			return null;
		}
		Boolean maximizar;
		int quantidadeVariaveis=-1;
		int quantidadeRestricoes=-1;
		String linha="";

		try {
			FileInputStream stream = new FileInputStream(this.nome);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			linha = buffer.readLine();
			if(linha.equals("Max")){
				maximizar=true;
			}else{
				if(linha.equals("Min")){
					maximizar=false;
				}else{
					buffer.close();
					return null;
				}
			}
			linha = buffer.readLine();
			int separador = linha.indexOf(" ");
			if(separador==0){
				buffer.close();
				return null;
			}
			quantidadeVariaveis=Integer.parseInt(linha.substring(0, separador));
			quantidadeRestricoes=Integer.parseInt(linha.substring(separador+1,linha.length()));
			if((quantidadeVariaveis<=0)||(quantidadeRestricoes<0)){
				buffer.close();
				return null;
			}
			for(int i =1; i<=buffer.lines().count()-3;i++){
				buffer.lines();
				linha = buffer.readLine();
			}
			buffer.close();
		} catch (IOException | NumberFormatException e) {
			return null;
		}
		Problema problema = new Problema();
		problema.setMaximizar(maximizar); 
		problema.setQuantidadeRestricoes(quantidadeRestricoes);
		problema.setQuantidadeVariaveis(quantidadeVariaveis);
		return problema;
	}

}
