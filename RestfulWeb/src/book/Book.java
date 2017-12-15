package book;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/book")

public class Book {
	@GET
	@javax.ws.rs.Produces(MediaType.TEXT_XML)
	
	
	public String sayHelloXML(){
		String response="<?xml version='1.0'?>" +
	"<hello>Hello navya</hello>";
		return response;
	}
	/*@GET
	@javax.ws.rs.Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(){
		String response="<html>"
				+ "<body bgcolor='yellow'>"
				+ "<h1>hello World</h1>"
		+"</body>"
				+"</html>";;
		return response;*/
	}
