package homeWork1;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ListTransports {
    Map<String, Transport> transports = new HashMap<String, Transport>();
    DecimalFormat df = new DecimalFormat("#.00");
    @Test
    public void allTransport() {
        transports.put("C3", new Transport("Citroen C3", 500, 155000, 8.51, 2.5));
        transports.put("C5", new Transport("Citroen C5", 500, 75000, 4.5, 1.0));
        transports.put("CC", new Transport("Citroen CACTUS", 169, 200000, 10.0, 3.5));
        transports.put("LK", new Transport("Train LOKOMOTIV", 375, 500000, 72.0, 30.5));
        transports.put("BL", new Transport("Train BELSTAT", 169, 27000, 105.0, 40.5));

        transports.forEach((k, v) -> {
            System.out.println("KEY: " + k);
            System.out.println(v.getTransportName());
            System.out.println("Fuel used on trip: " + df.format(v.calculateFUOD()) + " L");
            System.out.println("Fuel price with cargo: " + df.format(v.calculateWithCargo()) + " EUR");
            System.out.println("-----------");
        });
    }
}
