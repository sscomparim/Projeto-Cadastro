package br.com.clarify.controller;

import java.io.IOException;
  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.catalina.connector.Request;

import br.com.clarify.dao.AlunoDao;
import br.com.clarify.dao.UsuarioDao;
import br.com.clarify.model.Aluno;
 
 
@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet{

private static final long serialVersionUID = 1L;
private static String INSERT_OR_EDIT = "/aluno.jsp";
private static String LIST_USER = "/listarAlunos.jsp";
private static AlunoDao alunoDao;  

	
	public AlunoController(){
		super();
		alunoDao = new AlunoDao();
	}
	

			@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				String forward = "";
				String action = request.getParameter("action");
			
				
			if (action.equalsIgnoreCase("delete")) {
				forward = LIST_USER;
				int id = Integer.parseInt(request.getParameter("id")); //pega o id a ser excluido
				alunoDao.delete(id); // deleta conforme o ID
				request.setAttribute("alunos", alunoDao.findAll()); // Retorna para view todos os usuarios
				
				
			} else if (action.equalsIgnoreCase("edit")) {
				forward = INSERT_OR_EDIT;
				int id = Integer.parseInt(request.getParameter("id"));
				
				
				//System.out.println(id);
				Aluno aluno = alunoDao.find(id); // Busquei o usuario
				request.setAttribute("aluno", aluno);
				
				
			}else if (action.equalsIgnoreCase("listarAlunos")) {
					forward = LIST_USER;
					request.setAttribute("alunos", alunoDao.findAll());
				
			} else {
				forward = INSERT_OR_EDIT;

			} 
			
			// redireciona para a view
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
		}
				
			
			@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 

				throws ServletException, IOException {

				
				Aluno user = new Aluno();
				user.setPrimeiroNome(request.getParameter("primeiroNome"));
				user.setSegundoNome(request.getParameter("segundoNome"));
				
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				user.setEmail(request.getParameter("email")); 
				user.setCurso(request.getParameter("curso"));
				user.setCpf(request.getParameter("cpf"));
				user.setRg(request.getParameter("rg"));
				String userId = request.getParameter("id");
				 
				
				if (userId == null | userId.isEmpty()) {
					alunoDao.create(user);
					
				} else { 
					user.setId(Integer.valueOf(userId));
					alunoDao.update(user); 
						} 
					
				RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
				request.setAttribute("alunos", alunoDao.findAll());
				view.forward(request, response);
				}
			
  
}  
		 	
			 