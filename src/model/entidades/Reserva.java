package model.entidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("Erro na reserva: Data de checkout deve ser posterior a data de Checkin");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {
		LocalDate ld = checkin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate ld2 = checkout.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long qtdDias = ChronoUnit.DAYS.between(ld, ld2);
		return qtdDias;
	}

	public void atualizarData(Date checkin, Date checkout) throws DomainException {
		
		Date agora = new Date();
		
		if (checkin.before(agora) || checkout.before(agora)) {
			throw new DomainException("Erro na reserva: As datas para atualizaçao devem ser futuras") ;
		} 
		if (!checkout.after(checkin)) {
			throw new DomainException("Erro na reserva: Data de checkout deve ser posterior a data de Checkin");
		}		
		this.checkin = checkin;
		this.checkout = checkout;
		
		
		
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", Check-In " + sdf.format(checkin) + ", Check-Out " + sdf.format(checkout)
				+ ", " + duracao() + " noites";
	}

}
