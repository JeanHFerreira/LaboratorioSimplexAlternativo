package LaboratorioPO;

import Jama.Matrix;

public class Problema {

	private Boolean maximizar;
	private int quantidadeVariaveis;
	private int quantidadeRestricoes;
	private Matrix funcaoObjetivo;

	/**
	 * Cria um problema original de maximização
	 */
	public Problema() {
		this.maximizar = true;
		this.quantidadeVariaveis = -1;
		this.quantidadeRestricoes = -1;
	}

	/**
	 * Pega o problema original e cria o dal a partir dele
	 */
	public Problema transformarDual() {
		Problema dual = new Problema();
		dual.setMaximizar(!this.maximizar);
		dual.setQuantidadeRestricoes(this.quantidadeVariaveis);
		dual.setQuantidadeVariaveis(this.quantidadeRestricoes);
		return dual;
	}

	/**
	 * Imprime os valores das variaveis do problema
	 */
	public void mostrarProblema(){
		System.out.println((this.maximizar)?"Max":"Min");
		System.out.println(""+this.quantidadeVariaveis+" "+this.quantidadeRestricoes);
		for(int i=0;i<this.funcaoObjetivo.getRowDimension();i++){
			for(int j=0;j<this.funcaoObjetivo.getColumnDimension();j++){
				System.out.print(this.funcaoObjetivo.get(i, j)+" ");
			}
		}
	}

	/* Sets e gets */
	public void setMaximizar(Boolean m) {
		this.maximizar = m;
	}

	public void setQuantidadeVariaveis(int m) {
		this.quantidadeVariaveis = m;
	}

	public void setQuantidadeRestricoes(int m) {
		this.quantidadeRestricoes = m;
	}

	public void setFuncaoObjetivo(Matrix m) {
		this.funcaoObjetivo = m;
	}

	public Boolean getMaximizar() {
		return this.maximizar;
	}

	public int getQuantidadeVariaveis() {
		return this.quantidadeVariaveis;
	}

	public int getQuantidadeRestricoes() {
		return this.quantidadeRestricoes;
	}

	public Matrix getFuncaoObjetivo() {
		return this.funcaoObjetivo;
	}
}
