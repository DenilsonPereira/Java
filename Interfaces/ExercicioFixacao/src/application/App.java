package application;

import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.println("Entre os dados de contrato: ");
            System.out.println("Numero: ");
            System.out.println("Data (dd/MM/yyyy): ");
            Date data = sdf.parse(sc.next());
            System.out.println("Valor do contrato: ");
            System.out.println("Entre com o numero de parcelas: ");
            System.out.println("Parcelas:");
            System.out.println(sdf.format(data) + " - 222.00");
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        sc.close();
    }
}
