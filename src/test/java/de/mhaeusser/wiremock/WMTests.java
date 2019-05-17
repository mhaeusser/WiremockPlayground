package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WMTests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void doStuff() {
        wireMockRule.stubFor(get(urlEqualTo("/blah")));
    }
}
