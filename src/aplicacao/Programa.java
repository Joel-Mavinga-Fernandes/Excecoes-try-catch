package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidade.Reserva;
import entidade.exceptions.Excecoes;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Digite o número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Digite a data de checkin (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Digite a data de checkout (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Digite as datas atualizadas");
			reserva.atualizardatas(checkin, checkout);
			System.out.print("Digite a data de checkin (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Digite a data de checkout (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Reserva res = new Reserva(numeroQuarto, checkin, checkout);
			
			System.out.println("Reserva: "+ res);
			
		}catch(ParseException e) {
			System.out.println("formato de data inválido");
		}catch(Excecoes a) {
			System.out.println("Erro na reserva: " +a.getMessage());
		}catch(RuntimeException i) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}
}
