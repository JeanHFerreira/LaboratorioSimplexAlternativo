package LaboratorioPO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Principal {
	// Args[0] é o nome do arquivo txt com os dados
	public static void main(String[] args) {
		//Date hora = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssss");
		Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
		String dataFormatada = sdf.format(hora);
		System.out.println("Iniciando programa: " + dataFormatada);
		String nome = "teste1.txt";
		if (args.length != 0) {
			nome = args[0];
		}
		Arquivo arquivo = new Arquivo(nome);
		Problema problema = arquivo.pegarProblema();
		if ((problema != null) || (!nome.equals(""))) {
			System.out.println("Problema");
			problema.mostrarProblema();
			Problema dual = problema.transformarDual();
			System.out.println("\nDual");
			dual.mostrarProblema();
		} else {
			System.out.println("Erro na leitura do arquivo");
		}
		
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssss");
		hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
		dataFormatada = sdf.format(hora);
		System.out.println("Finalizando programa: " + dataFormatada);
	}
}
