package br.com.clarify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import br.com.clarify.model.Aluno;
import br.com.clarify.model.Usuario;
import br.com.clarify.util.DbUtil;


public class AlunoDao extends Dao<Aluno> {

	
	private Connection conn = null;
	 
	public AlunoDao() { 
		this.conn = DbUtil.getConnection();
	}
	
	
	/**
	 * 
	 * Metodo responsavel por inserir o Aluno no banco de dados

	 * 
	 *  @param Aluno
	 *  @return void
	 */
	
	@Override
	public void create(Aluno object) {

		
		try {
			StringBuilder sql = new StringBuilder("");
			sql.append("	INSERT INTO Alunos     						");
			sql.append(" (primeiro_nome , segundo_nome, email  ,  		");
			sql.append("  curso, cpf, rg)								");
			sql.append(" VALUES ( ? , ? , ? , ?, ?, ?)    				");	
			 
			
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			
			// os paremetros iniciam de 1
			pstm.setString(1, object.getPrimeiroNome());
			pstm.setString(2, object.getSegundoNome());
			pstm.setString(4, object.getEmail());
			pstm.setString(5, object.getCurso());
			pstm.setString(6, object.getCpf());
			pstm.setString(7, object.getRg());

			// execute a query
			pstm.execute();
			
		} catch (Exception e) {
			
				System.out.println( "Erro no cadastrto do aluno: " + e.getMessage());
		
		}
		
		
	}

	
	@Override
	public Aluno find(int id) {


		Aluno user = new Aluno();
		System.out.println(id);
		
		try { 
			PreparedStatement pst = conn.prepareStatement(
					"SELECT * FROM alunos WHERE id = ? ");
			 
			pst.setInt(1, id);   
			ResultSet rs = pst.executeQuery();
			  
			  
			if (rs.next()){
			user = getAluno(rs);
			} 
			 
		} catch (Exception e) {
			System.out.println( "Erro ao listar: " + e.getMessage());
		}
		
		return user;
		
	}
		
	
	/**
	 * 
	 * Metodo responsavel por pegar os atributos do banco e insere no objeto e cria.

	 * 
	 *  @param Aluno
	 *  @return user
	 */
	
	private Aluno getAluno(ResultSet rs) {

		 
		
		Aluno user = new Aluno();
		
		try { 
			user.setId(rs.getInt("id"));
			user.setPrimeiroNome(rs.getString("primeiro_nome"));
			user.setSegundoNome(rs.getString("segundo_nome"));
			user.setEmail(rs.getString("email"));
			user.setCurso(rs.getString("curso"));
			user.setCpf(rs.getString("cpf"));
			user.setRg(rs.getString("rg"));
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return user;
		
	}




	/**
	 * 
	 * Metodo responsavel por listar todos os alunos da tabela.

	 * 
	 *  @param Aluno
	 *  @return uma lista de alunos
	 */
	
	@Override
	
	// Retorna uma lista de alunos
	public List<Aluno> findAll() {

		
		
		List<Aluno> alunos = new ArrayList<>();
		
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(" select * from alunos ");
			
			while (rs.next()){
				alunos.add( getAluno(rs) );
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		} 

		return alunos;
	}

	   
	
	
	
	
	
	
	
	@Override
	public void update(Aluno t) {

		StringBuilder sql = new StringBuilder("");
		sql.append(" UPDATE usuarios set primeiro_nome = ? , ");
		sql.append(" se undo_nome = ? , email = ? ,          ");
		sql.append("curso = ? , cpf = ? , rg = ?  ,			 ");
		sql.append("WHERE id = ?							 ");
		
		
		try {
			
		} catch (Exception e) {
			
			PreparedStatement  
			
		}
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
