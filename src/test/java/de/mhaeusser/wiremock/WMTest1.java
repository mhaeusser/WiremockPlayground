package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WMTest1 {

    public static void main(String[] args) {

        WireMockConfiguration config = WMStartStop.start();

        WireMock.configureFor("localhost", config.portNumber());
        String testUrl = "/some/thing";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));

        String url = String.format("http://localhost:%s%s", config.portNumber(), testUrl);
        System.out.println("Now open/curl " + url);

        WMStartStop.wait(10);

        WMStartStop.stop();
    }
}
