package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WMStartStop {

    public static final int portNumber = 8090;

    private static WireMockServer wireMockServer;

    public static void main(String[] args) throws InterruptedException {
        start(false);

        wait(2);

        stop(false);
    }

    public static void start() {
        start(true);
    }

    public static void start(boolean silent) {
        wireMockServer = new WireMockServer(wireMockConfig().port(portNumber));
        wireMockServer.start();
        if (!silent) diagRunning();
    }

    public static void stop() {
        stop(true);
    }

    public static void stop(boolean silent) {
        wireMockServer.stop();
        if (!silent) diagRunning();
    }

    public static void wait(int sec) throws InterruptedException {
        System.out.println("Waiting " + sec + " seconds.");
        Thread.sleep(sec * 1000);
    }

    public static void diagRunning() {
        System.out.print("WireMockServer is ");
        if (!wireMockServer.isRunning()) System.out.print("NOT ");
        // wireMockServer.port() leads to IllegalStateException when server has been stopped
        System.out.println("running on port " + wireMockServer.getOptions().portNumber());
    }
}
