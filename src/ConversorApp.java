import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorApp {
    public static void mostrarMenu() {
        String menu = """
        *******************************************
        Sea Bienvenido/a al conversor de Monedas 

        1) Dólar =>> Peso argentino
        2) Peso argentino =>> Dólar
        3) Dólar =>> Real brasileño
        4) Real brasileño =>> Dólar
        5) Dólar =>> Peso colombiano
        6) Peso colombiano =>> Dólar
        7) Salir
        Elija una opción válida: 
        *******************************************
        """;
        System.out.print(menu);
    }
    public static void menu() {
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);
        while (continuar) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();
                continuar = procesarOpcion(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // limpiar buffer
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }
    }

    public static boolean procesarOpcion(int opcion) throws IOException, InterruptedException {
        switch (opcion) {
            case 1 -> Conversor("USD", "ARS");
            case 2 -> Conversor("ARS", "USD");
            case 3 -> Conversor("USD", "BRL");
            case 4 -> Conversor("BRL", "USD");
            case 5 -> Conversor("USD", "COP");
            case 6 -> Conversor("COP", "USD"); // corregido (antes decía ARS)
            case 7 -> {
                System.out.println("Gracias por usar el conversor de moneda. ¡Hasta luego!");
                return false;
            }
            default -> System.out.println("Opción no válida. Intente nuevamente.");
        }
        return true;
    }
    public static void Conversor(String codigoMonedaConvertir, String codigoMonedaFinal) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea convertir: ");
        Double valor = scanner.nextDouble();
        Monedas1 moneda = consultarApi(codigoMonedaConvertir);
        Double valorMoneda = moneda.getConversion_rates().get(codigoMonedaFinal);
        Double totalConversion = valorMoneda * valor;
        System.out.println("El valor de " + valor + " [" + codigoMonedaConvertir + "] corresponde al valor final de =>>>: " + totalConversion + " [" + codigoMonedaFinal + "]");

    }
    public static Monedas1 consultarApi(String codigoMoneda) throws IOException, InterruptedException{
        String url_str = "https://v6.exchangerate-api.com/v6/75c71da98c0c8ae9a1e14433/latest/"+codigoMoneda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas1.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda");
        }
    }
}
