package sanchez.eighthLight.clients;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class APIClient {

    private String Key;
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public APIClient(String k){
        this.Key = k;
    }

    public String getKey() {
        return Key;
    }

    /**
     * Get top 5 results from google books api
     * @param query search criteria
     * @return JSON String with response from API
     */
    public String getBooks(String query){
        try
        {
            String base = "https://www.googleapis.com/books/v1/volumes?q=";

            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(URI.create(base + query + "&maxResults=5&key=" + getKey()))
                    .setHeader("User-Agent", "CLI Books Client")
                    .build();

            CompletableFuture<HttpResponse<String>> response =
                    httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());


            return response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return "404";
    }
}
