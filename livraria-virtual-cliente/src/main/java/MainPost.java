import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class MainPost {

	public static void main(String[] args) {
		
	  Livro livro = new Livro(123l, "ISBN-2021","Infokhgkja", 12325498.5546, "AKShjfdlkhasdhf");
		Response response = ClientBuilder.newClient()
				.target("http://localhost:8080/livraria-virtual")
		        .path("livro")
		        .request()
                .post(Entity.xml(livro));
		
		if (response.getStatus() == Status.CREATED.getStatusCode()) {
			ItemBusca item = ClientBuilder.newClient()
					.target(response.getLocation())
			        .request(javax.ws.rs.core.MediaType.APPLICATION_XML)
	                .get(ItemBusca.class);
			System.out.println(item.getLivro().getAutor());
			
		}else if (response.getStatus() == Status.BAD_REQUEST.getStatusCode())
           System.out.println("Verifique os dados se estao corretos");
     
   }
}
