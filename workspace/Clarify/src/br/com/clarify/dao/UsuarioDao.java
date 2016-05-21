package br.com.clarify.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import br.com.clarify.model.Usuario;
import br.com.clarify.util.DbUtil;

public class UsuarioDao extends Dao<Usuario> {

	private Connection conn = null;
	 
	public UsuarioDao() {
		this.conn = DbUtil.getConnection();
	}
	
	
	
	@Override
	public void create(Usuario object) {

		try {
			StringBuilder sql = new StringBuilder("");
			sql.append("INSERT INTO Usuarios     ");
			sql.append("(primeiro_nome , segundo_nome, data_nascimento, email )   ");
			sql.append( "VALUES ( ? , ? , ? , ? )    " );	
			
			
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			
			// os paremetros iniciam de 1
			pstm.setString(1, object.getPrimeiroNome());
			pstm.setString(2, object.getSegundoNome());
			pstm.setDate(3, new java.sql.Date(object.getDataNascimento().getTime() ) );
			pstm.setString(4, object.getEmail());

			// execute a query
			pstm.execute();
			
		} catch (Exception e) {
			
				System.out.println(e.getMessage());
				//e.printStackTrace();
			
		
		}
		
	} 

	
	@Override
	public Usuario find(int id) {

		
		Usuario user = new Usuario();
		System.out.println(id);
		
		try {
			PreparedStatement pst = conn.prepareStatement(
					"SELECT * FROM usuarios WHERE id = ? ");
			 
			pst.setInt(1, id); 
			ResultSet rs = pst.executeQuery();
			  
			  
			if (rs.next()){
			user = getUsuario(rs);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return user;
	}


	
	@Override
	public List<Usuario> findAll() {


		List<Usuario> usuarios = new ArrayList<>();
		 
		try { 
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios ");
			
			while ( rs.next() ){
				usuarios.add( getUsuario(rs) );
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		
		 return usuarios; 
	 
	}
	
	
	
	private Usuario getUsuario(ResultSet rs) {

		Usuario user = new Usuario();
		 
		try {
			user.setId(rs.getInt("id"));
			user.setPrimeiroNome(rs.getString("primeiro_nome"));
			user.setSegundoNome(rs.getString("segundo_nome"));
			user.setEmail(rs.getString("email"));
			user.setDataNascimento(rs.getDate("data_nascimento"));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		 
		return user;
	} 


	
	
	
	
	
	
	
	
	
 
	@Override
	public void update(Usuario object) {


				StringBuilder sql = new StringBuilder("");
				sql.append(" UPDATE usuarios set primeiro_nome = ? , ");
				sql.append(" segundo_nome = ? , email = ? , data_nascimento = ? ");
				sql.append(" WHERE id = ? ");

				try {
					
					PreparedStatement pst = conn.prepareStatement(sql.toString() );
					pst.setString(1, object.getPrimeiroNome() );
					pst.setString(2, object.getSegundoNome() );
					pst.setString(3,  object.getEmail() );
					pst.setDate(4, new java.sql.Date(object.getDataNascimento().getTime()) );
					pst.setInt(5, object.getId() );
					pst.executeUpdate();
					 
					
				} catch (Exception e) {
					e.printStackTrace(); 
				}
	}

	
	
	@Override
	public void delete(int id) {
		
		
		StringBuilder sql = new StringBuilder("");
		sql.append(" DELETE FROM usuarios ");
		sql.append(" WHERE id = ? ");

		try {
			
			PreparedStatement pst = conn.prepareStatement(sql.toString() );
			pst.setInt(1, id);
			pst.execute();

	}catch (Exception e){
		e.printStackTrace();
	}
	}

	
}
