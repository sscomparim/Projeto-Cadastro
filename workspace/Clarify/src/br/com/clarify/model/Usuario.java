package br.com.clarify.model;

import java.util.Date;

public class Usuario {

	/*
	 * id (inteiro)
	 * primeiroNome (string)
	 * segundoNome (String)
	 * dataNascimento (Date)
	 * email (String)
	 * @author
	 * */
	
	private int id;
	private String primeiroNome;
	private String segundoNome;
	private Date dataNascimento;
	private String email;
	
	@Override
	public String toString() {
		
		return "Usuario [id="+id+
				", primeiroNome="+primeiroNome+
				", segundoNome="+segundoNome+
				", dataNascimento="+dataNascimento+
				", email="+email+"]";
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
	
}
