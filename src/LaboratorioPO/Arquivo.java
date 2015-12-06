package LaboratorioPO;

public class Arquivo {

	private String nome = "";

	@SuppressWarnings("unused")
	private Arquivo() {}

	public Arquivo(String nome) {
		this.nome = nome;
	}

	/**
	 * Cria um problema a partir de um arquivo Retorna o problema se arquivo
	 * válido Retorna null para arquivo inválido
	 */
	public Problema pegarProblema() {
		if ((this.nome == null)||(this.nome.equals(""))) {
			return null;
		}
		

		Problema problema = new Problema();
		return problema;
	}

}
