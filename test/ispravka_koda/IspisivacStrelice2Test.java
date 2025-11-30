package ispravka_koda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ispravka_koda.IspisivacStrelice2;

public class IspisivacStrelice2Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	private String pomocna() {
		String s = new String();
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 6; j++)
				if (j == 3 || i - j == 3 || i + j == 9)
					s = s.concat("0");
				else
					s = s.concat(" ");
			s = s.concat("\n");
		}
		return s;
	}

	// ne stavljati trim
	// jer ako se stavi ne vodi racuna o
	// tome da li je prvi red uvucen
	@Test
	public void metoda_ispisiStrelicu2() {
		IspisivacStrelice2.ispisiStrelicu2();
		assertEquals("  0  " + System.lineSeparator() +
				"  0  " + System.lineSeparator() + 
				"  0  " + System.lineSeparator() + 
				"0 0 0" + System.lineSeparator() + 
				" 000 " + System.lineSeparator() + 
				"  0  " + System.lineSeparator(), outContent.toString());
	}
}
