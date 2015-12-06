package LaboratorioPO;

public class Principal {
	//Args[0] é o nome do arquivo txt com os dados 
	public static void main(String[] args) {
		String nome = "teste1.txt";
		if(args[0]!=null){
			nome = args[0];
		}
		Arquivo arquivo = new Arquivo(nome);
		Problema problema = arquivo.pegarProblema();
		if (problema != null) {
			Problema dual = problema.transformarDual();
		}
	}
}
