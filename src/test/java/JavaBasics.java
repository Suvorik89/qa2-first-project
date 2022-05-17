import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class JavaBasics {
    @Test
    public void javaBasics() {
        double d = 10.00;

        String s = "10";
        int a = Integer.parseInt(s);
        System.out.println(a);

        int b = (int)d;
        System.out.println(b);
    }
}
