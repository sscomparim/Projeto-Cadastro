package br.com.clarify.dao;

import java.util.List; 

	public abstract class Dao <T> {
	
	//Salvar
	abstract public void create(T t);
	
	//Listar um
	abstract public T find(int id);
	
	//Listar todos
	abstract public List<T> findAll();
	
	//Atualizar
	abstract public void update(T t);
	
	//excluir
	abstract public void delete(int id);
	
	}	
 