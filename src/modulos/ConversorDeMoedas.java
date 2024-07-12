package modulos;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedas {
        public Moeda consultarMoeda(String primeiraMoeda, String segundaMoeda, String nomeDaMoeda) throws IOException, InterruptedException {
            String apiKey = "5cfbbe03ae1d40a599b6afc6";
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + primeiraMoeda + "/" + segundaMoeda;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                return new Gson().fromJson(json, Moeda.class);
            } catch (IOException | InterruptedException | JsonSyntaxException e) {
                throw new RuntimeException("Moeda Inválida");
            }
        }
}
