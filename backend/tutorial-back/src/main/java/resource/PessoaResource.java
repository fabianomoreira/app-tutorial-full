package resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Pessoa;
import service.PessoaService;

@Path("pessoa")
public class PessoaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getUsuarios() {
		PessoaService service = new PessoaService();
		
		List<Pessoa> lista = service.listarPessoas();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUsuario(Pessoa p) {
		PessoaService service = new PessoaService();
		
		String retorno = service.incluirPessoa(p);
		
		Response response = null;
		
		if(retorno != null) {
			response = Response.status(Response.Status.CREATED).entity(retorno).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar a inclusão").build();
		}
		
		return response;
	}
	
	@DELETE
	@Path("usuario/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUsuario(@PathParam("id") int id) {
		PessoaService service = new PessoaService();
		
		boolean retorno = service.excluirPessoa(id);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a exclusão").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUsuario(Pessoa p) {
		PessoaService service = new PessoaService();
		
		boolean retorno = service.alterarPessoa(p);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity(p).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("Não foi possível realizar a alteração").build();
		}
		
		return response;
	}
}
