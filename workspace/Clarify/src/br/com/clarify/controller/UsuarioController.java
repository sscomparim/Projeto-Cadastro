package br.com.clarify.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import br.com.clarify.dao.UsuarioDao;

public class UsuarioController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/usuario.jsp";
	private static String LIST_USER = "/Listusuario.jsp";
	private static UsuarioDao usuarioDao;

	
	public UsuarioController(){
		super();
		usuarioDao = new UsuarioDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String forward = "";
	String action =  request.getParameter("Action"); 
	  	
	}
	 
	
}
