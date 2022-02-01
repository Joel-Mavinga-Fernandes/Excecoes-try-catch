package entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import entidade.exceptions.Excecoes;

public class Reserva {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private int numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	public Reserva(int numeroQuarto, Date checkin, Date checkout) {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new Excecoes("As datas de reserva tem que ser datas futuras");
		}
		
		if(checkout.before(checkin)) {
			throw new Excecoes("A data de entrada tem quer antes da data de saída");
		}

		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public long duracao(Date checkin, Date checkout) {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizardatas(Date checkin, Date checkout){
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new Excecoes("As datas de reserva tem que ser datas futuras");
		}
		
		if(checkout.before(checkin)) {
			throw new Excecoes("A data de entrada tem quer antes da data de saída");
		}
		
		this.checkin=checkin;
		this.checkout=checkout;
	}
	
	public String toString() {
		return "Quarto:"
				+ numeroQuarto
				+", check-in: "
				+ sdf.format(checkin)
				+", check-out: "
				+ sdf.format(checkout)
				+", "
				+ duracao(checkin, checkout)
				+ " Noites";
	}
}
