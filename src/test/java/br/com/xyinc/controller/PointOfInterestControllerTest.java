package br.com.xyinc.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class PointOfInterestControllerTest {

	private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {

		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testAddPointOfInterest() {

		try {
			this.mockMvc.perform(post("/addpointofinterest?name=test.-1&x=-1&y=2"))
					.andExpect(status().is4xxClientError());
			this.mockMvc.perform(post("/addpointofinterest?name=test.-2&x=1&y=-2"))
					.andExpect(status().is4xxClientError());
			this.mockMvc.perform(post("/addpointofinterest?name=test.00&x=0&y=0"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.10&x=1&y=0"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.20&x=2&y=0"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.30&x=3&y=0"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.40&x=4&y=0"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.01&x=0&y=1"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.02&x=0&y=2"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.03&x=0&y=3"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.04&x=0&y=4"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.41&x=4&y=1"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.42&x=4&y=2"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.43&x=4&y=3"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.44&x=4&y=4"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.14&x=1&y=4"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.24&x=2&y=4"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.34&x=3&y=4"))
					.andExpect(status().is2xxSuccessful());
			this.mockMvc.perform(post("/addpointofinterest?name=test.22&x=2&y=2"))
					.andExpect(status().is2xxSuccessful());

		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterest() {

		try {

			this.mockMvc.perform(get("/listpointsofinterest")).andExpect(status().isOk())
					.andExpect(content().contentType(this.contentType)).andExpect(jsonPath("$", hasSize(17)))
					.andExpect(jsonPath("$[0].x", is(0))).andExpect(jsonPath("$[0].y", is(0)))
					.andExpect(jsonPath("$[0].name", is("test.00"))).andExpect(jsonPath("$[1].x", is(1)))
					.andExpect(jsonPath("$[1].y", is(0))).andExpect(jsonPath("$[1].name", is("test.10")))
					.andExpect(jsonPath("$[2].x", is(2))).andExpect(jsonPath("$[2].y", is(0)))
					.andExpect(jsonPath("$[2].name", is("test.20"))).andExpect(jsonPath("$[3].x", is(3)))
					.andExpect(jsonPath("$[3].y", is(0))).andExpect(jsonPath("$[3].name", is("test.30")))
					.andExpect(jsonPath("$[4].x", is(4))).andExpect(jsonPath("$[4].y", is(0)))
					.andExpect(jsonPath("$[4].name", is("test.40"))).andExpect(jsonPath("$[5].x", is(0)))
					.andExpect(jsonPath("$[5].y", is(1))).andExpect(jsonPath("$[5].name", is("test.01")))
					.andExpect(jsonPath("$[6].x", is(0))).andExpect(jsonPath("$[6].y", is(2)))
					.andExpect(jsonPath("$[6].name", is("test.02"))).andExpect(jsonPath("$[7].x", is(0)))
					.andExpect(jsonPath("$[7].y", is(3))).andExpect(jsonPath("$[7].name", is("test.03")))
					.andExpect(jsonPath("$[8].x", is(0))).andExpect(jsonPath("$[8].y", is(4)))
					.andExpect(jsonPath("$[8].name", is("test.04"))).andExpect(jsonPath("$[9].x", is(4)))
					.andExpect(jsonPath("$[9].y", is(1))).andExpect(jsonPath("$[9].name", is("test.41")))
					.andExpect(jsonPath("$[10].x", is(4))).andExpect(jsonPath("$[10].y", is(2)))
					.andExpect(jsonPath("$[10].name", is("test.42"))).andExpect(jsonPath("$[11].x", is(4)))
					.andExpect(jsonPath("$[11].y", is(3))).andExpect(jsonPath("$[11].name", is("test.43")))
					.andExpect(jsonPath("$[12].x", is(4))).andExpect(jsonPath("$[12].y", is(4)))
					.andExpect(jsonPath("$[12].name", is("test.44"))).andExpect(jsonPath("$[13].x", is(1)))
					.andExpect(jsonPath("$[13].y", is(4))).andExpect(jsonPath("$[13].name", is("test.14")))
					.andExpect(jsonPath("$[14].x", is(2))).andExpect(jsonPath("$[14].y", is(4)))
					.andExpect(jsonPath("$[14].name", is("test.24"))).andExpect(jsonPath("$[15].x", is(3)))
					.andExpect(jsonPath("$[15].y", is(4))).andExpect(jsonPath("$[15].name", is("test.34")))
					.andExpect(jsonPath("$[16].x", is(2))).andExpect(jsonPath("$[16].y", is(2)))
					.andExpect(jsonPath("$[16].name", is("test.22")));

		} catch (

		final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterestCloserToPoint2_2_0() {

		try {
			this.mockMvc.perform(get("/listpointsofinterestclosertopoint?x=2&y=2&maxDistance=0"))
					.andExpect(status().isOk()).andExpect(content().contentType(this.contentType))
					.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].x", is(2)))
					.andExpect(jsonPath("$[0].y", is(2))).andExpect(jsonPath("$[0].name", is("test.22")));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterestCloserToPoint2_2_2() {

		try {
			this.mockMvc.perform(get("/listpointsofinterestclosertopoint?x=2&y=2&maxDistance=2"))
					.andExpect(status().isOk()).andExpect(content().contentType(this.contentType))
					.andExpect(jsonPath("$", hasSize(5))).andExpect(jsonPath("$[0].x", is(2)))
					.andExpect(jsonPath("$[0].y", is(0))).andExpect(jsonPath("$[0].name", is("test.20")))
					.andExpect(jsonPath("$[1].x", is(0))).andExpect(jsonPath("$[1].y", is(2)))
					.andExpect(jsonPath("$[1].name", is("test.02"))).andExpect(jsonPath("$[2].x", is(4)))
					.andExpect(jsonPath("$[2].y", is(2))).andExpect(jsonPath("$[2].name", is("test.42")))
					.andExpect(jsonPath("$[3].x", is(2))).andExpect(jsonPath("$[3].y", is(4)))
					.andExpect(jsonPath("$[3].name", is("test.24"))).andExpect(jsonPath("$[4].x", is(2)))
					.andExpect(jsonPath("$[4].y", is(2))).andExpect(jsonPath("$[4].name", is("test.22")));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterestCloserToPoint2_2_1() {

		try {
			this.mockMvc.perform(get("/listpointsofinterestclosertopoint?x=2&y=2&maxDistance=1"))
					.andExpect(status().isOk()).andExpect(content().contentType(this.contentType))
					.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].x", is(2)))
					.andExpect(jsonPath("$[0].y", is(2))).andExpect(jsonPath("$[0].name", is("test.22")));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterestCloserToPoint2_2_3() {

		try {
			this.mockMvc.perform(get("/listpointsofinterestclosertopoint?x=2&y=2&maxDistance=3"))
					.andExpect(status().isOk()).andExpect(content().contentType(this.contentType))
					.andExpect(jsonPath("$", hasSize(17))).andExpect(jsonPath("$[0].x", is(0)))
					.andExpect(jsonPath("$[0].y", is(0))).andExpect(jsonPath("$[0].name", is("test.00")))
					.andExpect(jsonPath("$[1].x", is(1))).andExpect(jsonPath("$[1].y", is(0)))
					.andExpect(jsonPath("$[1].name", is("test.10"))).andExpect(jsonPath("$[2].x", is(2)))
					.andExpect(jsonPath("$[2].y", is(0))).andExpect(jsonPath("$[2].name", is("test.20")))
					.andExpect(jsonPath("$[3].x", is(3))).andExpect(jsonPath("$[3].y", is(0)))
					.andExpect(jsonPath("$[3].name", is("test.30"))).andExpect(jsonPath("$[4].x", is(4)))
					.andExpect(jsonPath("$[4].y", is(0))).andExpect(jsonPath("$[4].name", is("test.40")))
					.andExpect(jsonPath("$[5].x", is(0))).andExpect(jsonPath("$[5].y", is(1)))
					.andExpect(jsonPath("$[5].name", is("test.01"))).andExpect(jsonPath("$[6].x", is(0)))
					.andExpect(jsonPath("$[6].y", is(2))).andExpect(jsonPath("$[6].name", is("test.02")))
					.andExpect(jsonPath("$[7].x", is(0))).andExpect(jsonPath("$[7].y", is(3)))
					.andExpect(jsonPath("$[7].name", is("test.03"))).andExpect(jsonPath("$[8].x", is(0)))
					.andExpect(jsonPath("$[8].y", is(4))).andExpect(jsonPath("$[8].name", is("test.04")))
					.andExpect(jsonPath("$[9].x", is(4))).andExpect(jsonPath("$[9].y", is(1)))
					.andExpect(jsonPath("$[9].name", is("test.41"))).andExpect(jsonPath("$[10].x", is(4)))
					.andExpect(jsonPath("$[10].y", is(2))).andExpect(jsonPath("$[10].name", is("test.42")))
					.andExpect(jsonPath("$[11].x", is(4))).andExpect(jsonPath("$[11].y", is(3)))
					.andExpect(jsonPath("$[11].name", is("test.43"))).andExpect(jsonPath("$[12].x", is(4)))
					.andExpect(jsonPath("$[12].y", is(4))).andExpect(jsonPath("$[12].name", is("test.44")))
					.andExpect(jsonPath("$[13].x", is(1))).andExpect(jsonPath("$[13].y", is(4)))
					.andExpect(jsonPath("$[13].name", is("test.14"))).andExpect(jsonPath("$[14].x", is(2)))
					.andExpect(jsonPath("$[14].y", is(4))).andExpect(jsonPath("$[14].name", is("test.24")))
					.andExpect(jsonPath("$[15].x", is(3))).andExpect(jsonPath("$[15].y", is(4)))
					.andExpect(jsonPath("$[15].name", is("test.34"))).andExpect(jsonPath("$[16].x", is(2)))
					.andExpect(jsonPath("$[16].y", is(2))).andExpect(jsonPath("$[16].name", is("test.22")));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterestCloserToPoint3_3_0() {

		try {
			this.mockMvc.perform(get("/listpointsofinterestclosertopoint?x=3&y=3&maxDistance=0"))
					.andExpect(status().isOk()).andExpect(content().contentType(this.contentType))
					.andExpect(jsonPath("$", hasSize(0)));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListPointsOfInterestCloserToPoint3_3_1() {

		try {
			this.mockMvc.perform(get("/listpointsofinterestclosertopoint?x=3&y=3&maxDistance=1"))
					.andExpect(status().isOk()).andExpect(content().contentType(this.contentType))
					.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].x", is(4)))
					.andExpect(jsonPath("$[0].y", is(3))).andExpect(jsonPath("$[0].name", is("test.43")))
					.andExpect(jsonPath("$[1].x", is(3))).andExpect(jsonPath("$[1].y", is(4)))
					.andExpect(jsonPath("$[1].name", is("test.34")));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
