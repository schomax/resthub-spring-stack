package org.resthub.web.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.Assert;
import org.resthub.web.model.WebSampleResource;
import org.resthub.web.service.WebSampleResourceService;
import org.resthub.web.test.controller.AbstractControllerTest;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestWebSampleResourceController extends AbstractControllerTest<WebSampleResource, Long, WebSampleResourceService, WebSampleResourceController> {

	@Inject
	@Override
	@Named("webSampleResourceController")
	public void setController(WebSampleResourceController sampleController) {
		super.setController(sampleController);
	}

	@Override
	public void testUpdate() throws Exception {
		WebSampleResource r1 = new WebSampleResource();
		r1.setName("r1");

		WebResource r = resource().path(getResourcePath());
		r1 = (WebSampleResource)r.type(MediaType.APPLICATION_XML)
								 .post(getResourceClass(), r1);
		r = resource().path(getResourcePath() + "/" + r1.getId());
		WebSampleResource r2 = r1;
		r2.setName("r2");
		ClientResponse cr = r.type(MediaType.APPLICATION_XML)
							 .put(ClientResponse.class, r2);
		Assert.assertEquals("Resource not updated", Status.OK.getStatusCode(), cr.getStatus());
		String response = resource().path(getResourcePath())
									.accept(MediaType.APPLICATION_JSON)
									.get(String.class);
		Assert.assertFalse("Resource not updated", response.contains("r1"));
		Assert.assertTrue("Resource not updated", response.contains("r2"));
	}
	
}
