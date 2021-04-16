
import javax.ws.rs.client.ClientBuilder;

public class Main {

	public static void main(String[] args) {
		Livros livros = ClientBuilder.newClient()
				.target("http://localhost:8080/livraria-virtual")
		        .path("livro")
		        .request(javax.ws.rs.core.MediaType.APPLICATION_XML)
                .get(Livros.class);
        
        for (Livro livro : livros.getLivros()) {
        	System.out.println(livro.getAutor());
			
		}
	}
}
