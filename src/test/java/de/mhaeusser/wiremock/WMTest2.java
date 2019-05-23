package de.mhaeusser.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.checkerframework.common.reflection.qual.GetMethod;
//import wiremock.org.apache.http.client.HttpClient;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static wiremock.org.hamcrest.MatcherAssert.assertThat;

public class WMTest2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        WireMockConfiguration config = WMStartStop.start();

        WireMock.configureFor("localhost", config.portNumber());
        String testUrl = "/some/thing";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));



        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().GET().build();

        HttpResponse response = client.send(request, null);

        System.out.println(response.statusCode());

        //assertThat(get.getStatusCode(), is(404));
        //assertThat(testClient.get("/some/thing").statusCode(), is(200));
        // assertThat(testClient.get("/some/thing/else").statusCode(), is(404));



        WMStartStop.wait(10);

        WMStartStop.stop();
    }
}
