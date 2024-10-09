package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import models.entities.CarRental;
import models.entities.Invoice;
import models.entities.Vehicle;

public class App {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        Vehicle vehicle = new Vehicle(carModel);

        CarRental cr = new CarRental(start, finish, vehicle);

        System.out.println("Entre com o preço por hora: ");
        System.out.println("Entre com o preço por dia: ");

        System.out.println("FATURA:");
        System.out.println("Pagamento básico: " + cr.getInvoice().getBasicPayments());
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());
        

        sc.close();
    }
}
