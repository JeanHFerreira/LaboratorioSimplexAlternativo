package LaboratorioPO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Jama.Matrix;

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
		int quantidadeVariaveis = -1;
		int quantidadeRestricoes = -1;
		String linha = "";
		Matrix ladoDireito = null;
		Matrix funcaoObjetivo = null;
		// Matrix LadoDireito=null;

		try {
			FileInputStream stream = new FileInputStream(this.nome);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			linha = buffer.readLine();
			if (linha.equals("Max")) {
				maximizar = true;
			} else {
				if (linha.equals("Min")) {
					maximizar = false;
				} else {
					buffer.close();
					return null;
				}
			}
			linha = buffer.readLine();
			int separador = linha.indexOf(" ");
			if (separador == 0) {
				buffer.close();
				return null;
			}
			quantidadeVariaveis = Integer.parseInt(linha
					.substring(0, separador));
			quantidadeRestricoes = Integer.parseInt(linha.substring(
					separador + 1, linha.length()));
			if ((quantidadeVariaveis <= 0) || (quantidadeRestricoes < 0)) {
				buffer.close();
				return null;
			}
			linha = buffer.readLine();
			double[][] valores = new double[1][quantidadeVariaveis];
			int index = 0;
			while (separador != -1) {
				separador = linha.indexOf(" ");
				index++;
				if(index>quantidadeVariaveis){
					buffer.close();
					return null;
				}
				valores[0][index-1] = Double.parseDouble(linha.substring(0,
						(separador == -1) ? linha.length() : separador));
				if (separador != -1)
					linha = linha.substring(separador + 1, linha.length());
			}
			funcaoObjetivo = new Matrix(valores);
			for (int i = 2; i <= buffer.lines().count() - 3; i++) {
				linha = buffer.readLine();
			}
			buffer.close();
		} catch (IOException | NumberFormatException | NullPointerException
				| ArrayIndexOutOfBoundsException e) {
			return null;
		}
		Problema problema = new Problema();
		problema.setMaximizar(maximizar);
		problema.setQuantidadeRestricoes(quantidadeRestricoes);
		problema.setQuantidadeVariaveis(quantidadeVariaveis);
		problema.setFuncaoObjetivo(funcaoObjetivo);
		return problema;
	}

}
