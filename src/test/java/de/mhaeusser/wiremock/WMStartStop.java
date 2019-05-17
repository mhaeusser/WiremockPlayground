package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WMStartStop {

    public static final int portNumber = 8090;

    public static final int sec = 2;

    public static void main(String[] args) throws InterruptedException {
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(portNumber));
        wireMockServer.start();
        diagRunning(wireMockServer);

        System.out.println("Waiting " + sec + " seconds.");
        Thread.sleep(sec * 1000);

        wireMockServer.stop();
        diagRunning(wireMockServer);
    }

    public static void diagRunning(WireMockServer wireMockServer) {
        System.out.print("WireMockServer is ");
        if (!wireMockServer.isRunning()) System.out.print("NOT ");
        // wireMockServer.port() leads to IllegalStateException when server has been stopped
        System.out.println("running on port " + wireMockServer.getOptions().portNumber());
    }
}
