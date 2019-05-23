package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertThat;
import static wiremock.org.hamcrest.core.Is.is;

public class WMTests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void doStuff() {
        wireMockRule.stubFor(get(urlEqualTo("/blah")));
    }
    @Test
    public void exactUrlOnly() {
        WireMock.stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));

        //assertThat(testClient.get("/some/thing").statusCode(), is(200));
        //assertThat(testClient.get("/some/thing/else").statusCode(), is(404));
    }}
