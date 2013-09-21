package edu.cs673.plm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cs673.plm.model.HelloMessage;

@Path( "/hello" )
public class Hello
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public HelloMessage getHelloMessage()
	{
		HelloMessage hm = new HelloMessage();
		hm.setMessage("Hello World");
		return hm;
	}
}
