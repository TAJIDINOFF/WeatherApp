import java.io.IOException;
import java.util.Scanner;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class WeatherApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter city name: ");

        String city = input.nextLine();
        String API_KEY = System.getenv("WEATHER_API_KEY");


        String URL = "http://api.weatherapi.com/v1/current.json?key="+ API_KEY +"&q="+ city +"&units=metric";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        String json = response.body();

        int index = json.indexOf("\"temp_c\":");
        int start = index + 9;
        int end = json.indexOf(",", start);
        String temperature = json.substring(start, end);


        int country = json.indexOf("\"country\":");
        start = country + 11;
        end = json.indexOf("\"", start);
        String region = json.substring(start, end);

        //System.out.println(region);
        System.out.println("Today's temperature in " + city + " is " + temperature + " C " + "(" + region + ")");

    }
}
