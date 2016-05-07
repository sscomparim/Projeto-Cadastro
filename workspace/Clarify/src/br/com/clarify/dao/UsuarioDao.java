package br.com.clarify.dao;

import java.sql.*;
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
			sql.append("INSERT INTO Usuarios ");
			sql.append("primeiro_nome , segundo_nome, data_nascimento, email )");
			sql.append("VALEUS ( ? , ? , ? , ? ) " );	
			
			
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			
			// os paremetros iniciam de 1
			pstm.setString(1, object.getPrimeiroNome());
			pstm.setString(2, object.getSegundoNome());
			pstm.setDate(3, new java.sql.Date(object.getDataNascimento().getTime() ) );
			pstm.setString(4, object.getEmail());

			// execute a query
			pstm.execute();
			
		} catch (Exception e) {
			
				// Imprime se der erro
				e.printStackTrace();
			
		
		}
		
	}

	@Override
	public Usuario find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}