package dao;

import java.sql.Connection;

public class App {

	public static void main(String[] args) {
		Connection cnx = Dao.getConexao();
		PessoaDao dao = new PessoaDao();
		
		System.out.println(Dao.status);
		
		System.out.println(dao.listar());
	}

}
