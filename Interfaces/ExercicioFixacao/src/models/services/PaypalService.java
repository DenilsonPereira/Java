package models.services;

public class PaypalService implements OnlinePaymentService{
    public Double paymentFee(Double amount){
        return 0.0;
    }
    public Double interest(Double amount, int months){
        return 0.0;
    }
}
