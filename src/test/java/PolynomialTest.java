import models.Operation;
import models.Polynomial;
import models.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {
    @Test
    public void addTest(){
        Polynomial polynomial1 = new Polynomial("2x^2-x+3");
        Polynomial polynomial2 = new Polynomial("2x^3+x^2+4");
        Polynomial polynomialResult = new Polynomial("2x^3+3x^2-x+7");
        assertTrue(Operation.addPoly(polynomial1,polynomial2).toString().equals(polynomialResult.toString()), "correct");
    }

    @Test
    public void subtractTest(){
        Polynomial polynomial1 = new Polynomial("2x^2-x+3");
        Polynomial polynomial2 = new Polynomial("2x^3+2x^2+x+4");
        Polynomial polynomialResult = new Polynomial("-2x^3-2x-1");
        assertTrue(Operation.subtractPoly(polynomial1,polynomial2).toString().equals(polynomialResult.toString()), "correct");
    }

    @Test
    public void mulTest(){
        Polynomial polynomial1 = new Polynomial("2x^2+x+3");
        Polynomial polynomial2 = new Polynomial("2x^3+x^2+3");
        Polynomial polynomialResult = new Polynomial("4x^5+4x^4+7x^3+9x^2+3x+9");
        assertTrue(Operation.multiplicatePoly(polynomial1,polynomial2).toString().equals(polynomialResult.toString()), "correct");
    }

    @Test
    public void divTest(){
        Polynomial polynomial1 = new Polynomial("4x^4+x+3");
        Polynomial polynomial2 = new Polynomial("2x^3+x^2+3");
        Polynomial polynomialResult = new Polynomial("2x-1");
        Polynomial polynomialRemainder = new Polynomial("x^2-5x+6");
        try{
            Result result = Operation.dividePoly(polynomial1,polynomial2);
            assertTrue(result.getQuotient().toString().equals(polynomialResult.toString()) &&
                    result.getRemainder().toString().equals(polynomialRemainder.toString()), "correct");
        }
        catch(Exception ex){
            fail("Division by zero");
        }
    }

    @Test
    public void derivateTest(){
        Polynomial polynomial = new Polynomial("2x^2-x+3");
        Polynomial polynomialResult = new Polynomial("4x-1");
        assertTrue(Operation.derivatePoly(polynomial).toString().equals(polynomialResult.toString()), "correct");
    }

    @Test
    public void integrateTest(){
        Polynomial polynomial1 = new Polynomial("2x^2-x+3");
        Polynomial polynomialResult = new Polynomial("0.67x^3-0.5x^2+3x");
        assertTrue(Operation.integratePoly(polynomial1).toString().equals(polynomialResult.toString()), "correct");
    }
}
