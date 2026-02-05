import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter city name: ");

        String city = input.next();
        System.out.println("You are in " + city);
    }
}
