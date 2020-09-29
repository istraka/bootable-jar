package org.jboss.qa.appsint.deployments.examples;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;


@Path("/")
public class MicroProfileConfigEndpoint {


	@Inject
	@ConfigProperty(name = "demo-cli-property", defaultValue = "Default value")
	String property;

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("demo-cli-property = " + property).build();
	}

	@ApplicationPath("/")
	public static class RestApplication extends Application {
	}
}
