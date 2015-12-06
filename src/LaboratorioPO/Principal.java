package LaboratorioPO;

public class Principal {
	public static void main(String[] args) {
		String nome = "teste1.txt";
		Arquivo arquivo = new Arquivo(nome);
		Problema problema = arquivo.pegarProblema();
		if (problema != null) {
			Problema dual = problema.transformarDual();
		}
	}
}
