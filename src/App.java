

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {

    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    //public static final String ANSI_YELLOW_BACKGROUND = "\u001b[43m";

    public static void main(String[] args) throws IOException, InterruptedException {
        // fazer uma conexão HTTP e buscar os top 250 filmes

        // a variavel abaixo irá retornar um emoji estrela
        String emoji = "⭐";

        String url = "https://imdb-api.com/en/API/MostPopularMovies/k_rpx39871";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair os dados que importam (titulo, poster e classificação)

        var parser = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parser.parse(body);
        System.out.println(ListaDeFilmes.size());


        // exibir e manipular os dados
        for (Map<String, String> Filme: ListaDeFilmes){

            System.out.println(Filme.get("title"));
            System.out.println(Filme.get("image"));
            System.out.println(Filme.get("imDbRating"));
            System.out.println(ANSI_YELLOW + emoji );
            System.out.println();
        }



    }
}