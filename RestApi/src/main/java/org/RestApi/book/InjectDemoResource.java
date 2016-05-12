package org.RestApi.book;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String param, 
			@HeaderParam("customHeaderValue") String customHeaderValue)
	{
		return "MatrixParam: "+param+" Header Param: "+customHeaderValue;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo)
	{
		String path=uriinfo.getAbsolutePath().toString();
		return "path: "+path;
	}

}
