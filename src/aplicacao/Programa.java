package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entidades.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Número do quarto: ");
			int numeroQ = read.nextInt();
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			Date checkin = sdf.parse(read.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			Date checkout = sdf.parse(read.next());
	
			Reserva reserva = new Reserva(numeroQ, checkin, checkout);
			System.out.println("Reserva : " + reserva.toString());
	
			System.out.println();
	
			System.out.println("Entre com os dados para atualizar a reserva");
	
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(read.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(read.next());
	
			reserva.atualizarData(checkin, checkout);
			
			System.out.println("Reserva atualizada: " + reserva.toString());
		}
		catch(ParseException e) {
			System.out.println("Data inserida inválida");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		}

		read.close();
	}

}
