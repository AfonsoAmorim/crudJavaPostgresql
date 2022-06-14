package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
