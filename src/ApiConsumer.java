import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumer {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        //criando a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        try {
            // manipulando as resposta http
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Request Body " + response.body());
        } catch (IOException |  InterruptedException e) {
            e.printStackTrace();
        }

    }
}