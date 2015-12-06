package LaboratorioPO;

public class Arquivo {
	
	private String nome="";
	
	public Arquivo(){}
	
	public Arquivo(String nome){
		this.nome=nome;
	}
	
	/**
	 * Retorna true para arquivo válido
	 * Retorna false para arquivo inválido*/
	public boolean validarArquivo(){
		return true;
	}
	
	/**
	 * Cria um problema a partir de um arquivo*/
	public Problema pegarProblema(String nome){
		if((this.nome==null)&&(nome==null)){
			return null;
		}
		if(this.nome==null && nome !=null){
			this.nome=nome;
		}
		
		if(!this.validarArquivo()){
			return null;
		}
		Problema problema = new Problema();
		return problema;
	}
	
	public Problema pegarProblema(){
		return this.pegarProblema(null);
	}
}
