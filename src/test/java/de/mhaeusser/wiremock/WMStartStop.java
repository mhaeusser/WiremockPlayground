package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WMStartStop {

    public static final int portNumber = 8090;

    public static void main(String[] args) throws InterruptedException {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(portNumber));
        wireMockServer.start();
        diagRunning(wireMockServer);

        test1();

        wait(5);

        wireMockServer.stop();
        diagRunning(wireMockServer);
    }

    public static void test1() {
        WireMock.configureFor("localhost", portNumber);
        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));
    }

    public static void wait(int sec) throws InterruptedException {
        System.out.println("Waiting " + sec + " seconds.");
        Thread.sleep(sec * 1000);
    }

    public static void diagRunning(WireMockServer wireMockServer) {
        System.out.print("WireMockServer is ");
        if (!wireMockServer.isRunning()) System.out.print("NOT ");
        // wireMockServer.port() leads to IllegalStateException when server has been stopped
        System.out.println("running on port " + wireMockServer.getOptions().portNumber());
    }
}
