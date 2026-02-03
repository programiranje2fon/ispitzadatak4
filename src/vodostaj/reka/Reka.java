package vodostaj.reka;

import java.io.Serializable;
import java.time.LocalDate;

public class Reka implements Serializable {
	
	private String naziv=null;
	private LocalDate datumMerenja;
	private double vodostaj=-1;
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		if (naziv == null || naziv.length() < 2)
			throw new RuntimeException("Naziv mora biti unet i mora imati vise od 2 znaka");
		this.naziv = naziv;
	}
	
	public LocalDate getDatumMerenja() {
		return datumMerenja;
	}
	
	public void setDatumMerenja(LocalDate datumMerenja) {
		if (datumMerenja == null || datumMerenja.isAfter(LocalDate.now()))
			throw new RuntimeException("Datum merenja se mora uneti i mora se odnositi na prosli trenutak");
		this.datumMerenja = datumMerenja;
	}
	
	public double getVodostaj() {
		return vodostaj;
	}
	
	public void setVodostaj(double vodostaj) {
		if(vodostaj<0) 
			throw new RuntimeException("Vodostaj mora biti 0 ili veci");
		this.vodostaj = vodostaj;
	}
	
	@Override
	public String toString() {
		return "Reka [naziv=" + naziv + ", datumMerenja=" + datumMerenja + ", vodostaj=" + vodostaj + "]";
	}
	
	
}