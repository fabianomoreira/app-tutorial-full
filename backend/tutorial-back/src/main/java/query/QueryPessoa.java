package query;

public class QueryPessoa {
	
	public static final String QUERY_BUSCAR_PESSOA = "SELECT * FROM pessoa";
	public static final String QUERY_INCLUIR_PESSOA = "INSERT INTO pessoa(nome, idade, apelido, id_municipio) VALUES(?, ?, ?, ?)";
	public static final String QUERY_EXCLUIR_PESSOA = "DELETE FROM pessoa WHERE id = ?";
	public static final String QUERY_ALTERAR_PESSOA = "UPDATE pessoa SET nome=?, idade=?, apelido=?, id_municipio=? WHERE id=?";

}
