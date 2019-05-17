package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WMStarter {

    public static final int portNumber = 8090;

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(portNumber));
        wireMockServer.start();
        diagRunning(wireMockServer);
    }

    public static void diagRunning(WireMockServer wireMockServer) {
        System.out.print("WireMockServer is ");
        if (!wireMockServer.isRunning()) System.out.print("NOT ");
        System.out.print("running on port " + wireMockServer.port());
    }
}
