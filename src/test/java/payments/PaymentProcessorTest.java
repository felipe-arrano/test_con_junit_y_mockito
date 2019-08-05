package payments;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void paymentIsCorrect(){
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void paymentIsWrong(){
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        assertFalse(paymentProcessor.makePayment(1000));
    }
}