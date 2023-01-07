#Zadatak 4

Napraviti javnu klasu **Reka** u paketu **vodostaj.reka** koja može da se serijalizuje i ima:

* Privatni atribut **naziv** koji predstavlja naziv reke. Početna vrednost je NULL.
* Privatni atribut **datumMerenja** koji predstavlja datum merenja vodostaja (klasa GregorianCalendar).
* Privatni atribut **vodostaj** koji predstavlja nivo vode u metrima. Početna vrednost je -1.
* Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za naziv su null i Stringovi kraći od dva znaka, vodostaj mora biti nula ili veći, a datum mora da bude različit od null i pre trenutnog datuma. U slučaju unosa nedozvoljenih vrednosti baciti izuzetak.
* Redefinisanu metodu toString koja vraća String sa svim podacima o reci uz odgovarajući tekst.

Napraviti vizuelnu klasu **VodostajGUI** u paketu **vodostaj** koja izgleda kao na slici. Padajuća lista za dan bi trebalo da sadrži vrednosti od 1 do 31, za mesec od 1 do 12 a za godinu od 2010 do 2015. Naslov prozora bi trebalo da bude “Vodostaj”, i trebalo bi **onemogućiti da mu se menjaju dimenzije**.


* Klasa VodostajGUI bi trebalo da sadrži privatni atribut **reke** koja predstavlja niz objekata klase Reka. Niz odmah inicijalizovati na kapacitet od 100 elemenata.
* Kada se pritisne dugme “Unesi”, preuzimaju se vrednosti svih polja za unos na ekranu, pravi se novi objekat klase Reka, puni se ovim podacima i unosi se u niz na prvo slobodno mesto. Mesto u nizu je slobodno ako element na tom mestu ima vrednost NULL.
* Kada se pritisne dugme “Prikaži sve”, potrebno je u editoru ispisati sve podatke o svakoj reci iz niza. U prvom redu ispisati reč “VODOSTAJ” a onda podatke o svakoj reci ispisati u posebnom redu. Obratiti pažnju na prazna mesta u nizu. Na kraju ispisati i naziv reke sa najvišim vodostajem.
* Kada se pritisne dugme “Izveštaj”, potrebno je u tekstualni fajl “izveštaj.txt” upisati podatke o onim rekama iz niza u kojima je vodostaj u odnosu na prethodno merenje porastao za više od metar. Računati na to da se u nizu nalaze podaci iz samo dva poslednja merenja za svaku reku. Sam redosled ovih podataka o merenju u nizu nije definisan. Obratiti pažnju na prazna mesta u nizu.

![Alt text](../images/VodostajGUI.jpg)

#Zadatak 4 - Ispravka koda 
U produžetku teksta je dat kod klase sa metodom koja bi trebalo da, na ekranu, ispisuje strelicu od znakova
0. Ideja je da strelica bude visine šest redova, širine 5 znakova i okrenuta “na dole”, tako da bi konačan ispis
na ekranu trebalo da bude:

		0

		0
   
		0
   
	0   0	0

	   000
 
		0
Dati kod se kompajlira, ali ne radi to šta treba. Napraviti javnu klasu **IspisivacStrelice2** u paketu
**ispravka_koda**, prekucati u nju kod koji je dat i, __uz minimalne izmene__ ga ispraviti tako da funkcioniše
kako treba. Napraviti test klasu i, koristeći njenu main metodu, pozvati metodu ispisiStrelicu2() i proveriti
njen rad.

package ispravka_koda;

	public class IspisivacStrelice2 {
	
		public static void ispisiStrelicu2() {
		
			for (int i=1; i<7; i++) {
			
				for(int j=1; j<6; j++)
				
					if (j==1 || i-j==2 || i+j==9)
					
						System.out.print('0');
						
					else
					
						System.out.print(' ');
						
			}
			
	}
	
}