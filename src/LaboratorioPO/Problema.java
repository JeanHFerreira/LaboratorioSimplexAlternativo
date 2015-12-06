package LaboratorioPO;

public class Problema {
	
	private Boolean maximizar;
	
	/**
	 * Cria um problema original de maximização*/
	public Problema() {
		this.maximizar=true;
	}
	
	/**
	 * Pega o problema original e cria o dal a partir dele*/
	public Problema transformarDual(){
		Problema dual = new Problema();
		dual.maximizar=!this.maximizar;
		return dual;
	}
	
	/**
	 * Imprime os valores das variaveis do problema*/
	public void mostrarProblema(){
		
	}
}
