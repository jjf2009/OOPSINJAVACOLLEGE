import java.util.Scanner;

class TemperatureConverter {

    // Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Convert based on scale
    public static double convert(double value, String scale) {
        if (scale.equalsIgnoreCase("C")) {
            return celsiusToFahrenheit(value);
        } 
        else if (scale.equalsIgnoreCase("F")) {
            return fahrenheitToCelsius(value);
        } 
        else {
            System.out.println("Invalid scale. Use C or F.");
            return value;
        }
    }
}

public class TemperatureConverterSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double value = sc.nextDouble();

        System.out.print("Enter scale (C for Celsius, F for Fahrenheit): ");
        String scale = sc.next();

        double result = TemperatureConverter.convert(value, scale);

        if (scale.equalsIgnoreCase("C")) {
            System.out.println("Temperature in Fahrenheit: " + result);
        } else if (scale.equalsIgnoreCase("F")) {
            System.out.println("Temperature in Celsius: " + result);
        }

        sc.close();
    }
}