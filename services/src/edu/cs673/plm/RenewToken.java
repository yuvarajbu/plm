package edu.cs673.plm;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import edu.cs673.plm.model.StatusMessage;
import edu.cs673.plm.model.User;
import edu.cs673.plm.model.TokenMessage;

@Path( "/renewtoken" )
public class RenewToken {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StatusMessage getRenewMessage(TokenMessage token) {
		StatusMessage sm;
		SessionToken orig_st = new SessionToken(token.getToken());
		SessionToken new_st;
		String tok;

		if(orig_st.getUid()>0){
			new_st = new SessionToken(orig_st.getUid());
			tok = new_st.generateToken();
			if(tok==null){
				sm = new StatusMessage(2,"Internal Error");
			}
			else{
				sm = new StatusMessage(0,tok);
			}
		}
		else{
			sm = new StatusMessage(1,"Invalid Token");
		}

		return sm;
	}
}
