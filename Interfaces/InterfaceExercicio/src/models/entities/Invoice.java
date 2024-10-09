package models.entities;

public class Invoice {
    private Double basicPayments;
    private Double tax;
    
    public Invoice(){}

    public Invoice(Double basicPayments, Double tax) {
        this.basicPayments = basicPayments;
        this.tax = tax;
    }

    public Double getBasicPayments() {
        return basicPayments;
    }

    public void setBasicPayments(Double basicPayments) {
        this.basicPayments = basicPayments;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
    
    public Double getTotalPayment(){
        return getBasicPayments() - getTax();
    }

}
