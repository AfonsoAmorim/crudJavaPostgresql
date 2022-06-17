package pos_java_jdbc.pos_java_jdbc;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import conexao.jdbc.SingleConnection;
import dao.UserPosDAO;
import model.UserposjavaModel;

public class TesteBanco {

	@Test
	public void initBanco() {
		// SingleConnection.getConnection();
		UserPosDAO userDAO = new UserPosDAO();
		UserposjavaModel usermodel = new UserposjavaModel();

		usermodel.setId(3L);
		usermodel.setNome("Alex");
		usermodel.setEmail("alex3@hotmail.com");

		userDAO.salvar(usermodel);

	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<UserposjavaModel> list = dao.listar();
			
			for(UserposjavaModel user : list) {
				System.out.println(user);
				System.out.println("--------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
