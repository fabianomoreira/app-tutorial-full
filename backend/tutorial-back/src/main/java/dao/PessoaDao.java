package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import query.QueryPessoa;

public class PessoaDao {
	public List<Pessoa> listar(){
		Dao dao = new Dao();
        Connection cnx = dao.getConexao();

        String SQL = QueryPessoa.QUERY_BUSCAR_PESSOA;
        
        PreparedStatement ps;
        
        List<Pessoa> lista = new ArrayList<Pessoa>();
        Pessoa usuario;
        
        try {
            ps = cnx.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                usuario = new Pessoa();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setApelido(rs.getString("apelido"));
                
                lista.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return lista;
        }
	}
}
