package nme.cs209a.lab10;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.google.gson.Gson;

public class Main {
  private static final HttpClient httpClient = HttpClient.newHttpClient();
  private static final Gson gson = new Gson();

  public static void main(String[] args) throws IOException, InterruptedException {
    String url = "https://pokeapi.co/api/v2/pokemon/";
    try (Scanner sc = new Scanner(System.in)) {
      url = url + sc.nextLine() + '/';
      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .build();
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      String json = response.body();
      Pokemon pokemon = gson.fromJson(json, Pokemon.class);
      System.out.printf("Name: %s\n", pokemon.name);
      System.out.printf("Height: %d\n", pokemon.height);
      System.out.printf("Weight: %d\n", pokemon.weight);
      System.out.printf("Abilities: %s\n", pokemon.abilities.parallelStream().map(ability -> ability.ability.name).collect(Collectors.joining(", ", "[", "]")));
    }
  }
}
