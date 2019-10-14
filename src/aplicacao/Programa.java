package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroQ = read.nextInt();
		System.out.print("Data de Check-in (dd/MM/yyyy): ");
		Date checkin = sdf.parse(read.next());
		System.out.print("Data de Check-out (dd/MM/yyyy): ");
		Date checkout = sdf.parse(read.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: Data de checkout deve ser posterior a data de Checkin");
		}else {
			Reserva reserva = new Reserva(numeroQ, checkin, checkout);
			System.out.println("Reserva : " + reserva.toString());
			
			System.out.println();
			
			System.out.println("Entre com os dados para atualizar a reserva");
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(read.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(read.next());
			
			Date agora = new Date();
			
			if(checkin.before(agora) || checkout.before(agora)) {
				
				System.out.println("Erro na reserva: As datas para atualizaçao devem ser futuras" );
				
			}else if (!checkout.after(checkin)) {
				
				System.out.println("Erro na reserva: Data de checkout deve ser posterior a data de Checkin");	
				
			}else {
				
			reserva.atualizarData(checkin, checkout);	
			System.out.println("Reserva atualizada: " + reserva.toString());
			
			}
		}
		

		
		
		
		
		read.close();
	}

}
