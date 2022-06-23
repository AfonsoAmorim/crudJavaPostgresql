package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.jdbc.SingleConnection;
import model.UserposjavaModel;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UserposjavaModel userposModel) {

		try {
			String sql = "insert into userposjava(id,nome,email) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposModel.getId());
			insert.setString(2, userposModel.getNome());
			insert.setString(3, userposModel.getEmail());
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<UserposjavaModel> listar() throws Exception{
		List<UserposjavaModel> list = new ArrayList<UserposjavaModel>();
		String sql = "select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			UserposjavaModel user = new UserposjavaModel();
			user.setId(resultado.getLong("id"));
			user.setNome(resultado.getString("nome"));
			user.setEmail(resultado.getString("email"));
			
			list.add(user);
		}
		return list;
		
	}
	
	public void atualizar(UserposjavaModel userposjava) throws SQLException {
		try {
			String sql = "UPDATE userposjava SET nome = ? where id = " + userposjava.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());
			
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
	
	

}
