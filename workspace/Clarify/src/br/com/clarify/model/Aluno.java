package br.com.clarify.model;

public class Aluno extends Usuario{

	 
	
	private String curso;
	private String cpf;
	private String rg;
	
	
	@Override
	public String toString() {
		
		return "Aluno [id="+id+
				", primeiroNome="+primeiroNome+
				", segundoNome="+segundoNome+
				", email="+email+
				", curso="+curso+
				", cpf="+cpf+ 
				", rg="+rg+"]";
	
	 } 
	
	




	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}
 


	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
}
