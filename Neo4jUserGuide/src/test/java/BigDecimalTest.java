import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * Neo4jUserGuide
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/21
 **/


public class BigDecimalTest {

    @Test
    public void testValueOfAndNew() {
        BigDecimal a = new BigDecimal(0.01);
        BigDecimal b = BigDecimal.valueOf(0.01);
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test2(){
        BigDecimal a = new BigDecimal("0.01");
        BigDecimal b = new BigDecimal("0.010");
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));
    }

    @Test
    public void test3(){
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("3.0");
        a.divide(b);
    }

    @Test
    public void test4(){
        BigDecimal a = BigDecimal.valueOf(35634535255456719.22345634534124578902);
        System.out.println(a.toString());
        System.out.println(a.toPlainString());
        System.out.println(a.toEngineeringString());
    }

}
