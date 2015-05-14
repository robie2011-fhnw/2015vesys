package bank.server;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class PlaygroundServer {
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }
}
