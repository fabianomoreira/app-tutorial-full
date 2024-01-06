package service;

import java.util.List;

import dao.PessoaDao;
import model.Pessoa;

public class PessoaService {
	public List<Pessoa> listarPessoas(){
		PessoaDao dao = new PessoaDao();
		
		return dao.listar();
	}
	
	public String incluirPessoa(Pessoa p) {
		PessoaDao dao = new PessoaDao();
		
		return dao.incluir(p);
	}
	
	public boolean excluirPessoa(int id) {
		PessoaDao dao = new PessoaDao();
		
		return dao.excluir(id);
	}
	
	public boolean alterarPessoa(Pessoa p) {
		PessoaDao dao = new PessoaDao();
		
		return dao.alterar(p);
	}
}
