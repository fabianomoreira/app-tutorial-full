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
	
	public boolean alterar(Pessoa p) {
		boolean resultado = true;
		Dao dao = new Dao();
		
		Connection cnx = dao.getConexao();
		
		String SQL = QueryPessoa.QUERY_ALTERAR_PESSOA;
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getIdade());
			ps.setString(3, p.getApelido());
			ps.setInt(4, p.getIdMunicipio());
			ps.setInt(5, p.getId());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean excluir(int id) {
		boolean resultado = true;
		Dao dao = new Dao();
		
		Connection cnx = dao.getConexao();
		
		String SQL = QueryPessoa.QUERY_EXCLUIR_PESSOA;
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public String incluir(Pessoa p) {
		boolean resultado = true;
		Dao dao = new Dao();
		
		Connection cnx = dao.getConexao();
		
		String SQL = QueryPessoa.QUERY_INCLUIR_PESSOA;
		
		PreparedStatement ps;
		String protocolo = null;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getIdade());
			ps.setString(3, p.getApelido());
			ps.setInt(4, p.getIdMunicipio());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
			protocolo = this.gerarProtocolo(p);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return protocolo;
	}
	
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
	
	private String gerarProtocolo(Pessoa p) {
		return (p.getNome().substring(0, 3)) + p.getIdade() + "PES01";
	}
}
