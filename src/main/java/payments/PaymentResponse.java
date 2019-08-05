package payments;

public class PaymentResponse {

    enum PaymentStatus{
        OK, ERROR
    }

    private PaymentStatus paymentStatus;

    public PaymentResponse(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
