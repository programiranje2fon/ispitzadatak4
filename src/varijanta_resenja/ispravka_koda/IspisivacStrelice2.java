package varijanta_resenja.ispravka_koda;

public class IspisivacStrelice2 {
	
	public static void ispisiStrelicu2() {
		
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 6; j++)
				if (j == 3 || i - j == 3 || i + j == 9)
					System.out.print('0');
				else
					System.out.print(' ');
			System.out.println();

		}
	}
	
}