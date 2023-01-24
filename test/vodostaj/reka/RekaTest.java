package vodostaj.reka;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class RekaTest {

	Reka instance;
	
	@Before
	public void setUp() throws Exception {
		instance=new Reka();
	}

	@After
	public void tearDown() throws Exception {
		instance=null;
	}

	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut imePrezime", TestUtil.doesFieldExist(Reka.class, "naziv"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan",
				TestUtil.hasFieldModifier(Reka.class, "naziv", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_naziv_pocetnaVrednost() {
		String expected = null;
		String actual = (String) TestUtil.getFieldValue(instance, "naziv");
		assertEquals(expected, actual);
	}
	
	@Test
	public void atribut_datumMerenja() {
		assertTrue("U klasi nije definisan atribut datumMerenja", TestUtil.doesFieldExist(Reka.class, "datumMerenja"));
	}
	
	@Test
	public void atribut_datumMerenja_vidljivost() {
		assertTrue("Atribut datumMerenja nije privatan",
				TestUtil.hasFieldModifier(Reka.class, "datumMerenja", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_vodostaj() {
		assertTrue("U klasi nije definisan atribut imePrezime", TestUtil.doesFieldExist(Reka.class, "naziv"));
	}
	
	@Test
	public void atribut_vodostaj_vidljivost() {
		assertTrue("Atribut vodostaj nije privatan",
				TestUtil.hasFieldModifier(Reka.class, "vodostaj", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_vodostaj_pocetnaVrednost() {
		double expected = -1;
		double actual = (double) TestUtil.getFieldValue(instance, "vodostaj");
		assertEquals(expected, actual,0);
	}
	
	@Test
	public void metoda_getNaziv_vidljivost() {
		assertTrue("Metoda getNaziv nije javna",
				TestUtil.hasMethodModifier(Reka.class, "getNaziv", null, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_setNaziv_vidljivost() {
		assertTrue("Metoda setNaziv nije javna", TestUtil.hasMethodModifier(Reka.class, "setNaziv",
				new Class<?>[] { String.class }, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_setNaziv_null() {
		assertThrows(java.lang.RuntimeException.class,
				() -> instance.setNaziv(null) );
	}

	@Test
	public void metoda_setNaziv_kraciOdDvaZnaka() {
		assertThrows(java.lang.RuntimeException.class,
				() -> instance.setNaziv("r"));
	}
	
	@Test
	public void metoda_getDatumMerenja_vidljivost() {
		assertTrue("Metoda getDatumMerenja nije javna",
				TestUtil.hasMethodModifier(Reka.class, "getDatumMerenja", null, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_setDatumMerenja_vidljivost() {
		assertTrue("Metoda setDatumMerenja nije javna", TestUtil.hasMethodModifier(Reka.class, "setDatumMerenja",
				new Class<?>[] { GregorianCalendar.class }, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_setDatumMerenja_null() {
		assertThrows(java.lang.RuntimeException.class,
				() -> instance.setDatumMerenja(null) );
	}

	@Test
	public void metoda_setDatumMerenja_buduciDatum() {
		GregorianCalendar arg = new GregorianCalendar(new GregorianCalendar().get(GregorianCalendar.YEAR) + 1, 1, 1);
		assertThrows(java.lang.RuntimeException.class,
				() -> instance.setDatumMerenja(arg) );
	}
	
	@Test
	public void metoda_getVodostaj_vidljivost() {
		assertTrue("Metoda getVodostaj nije javna",
				TestUtil.hasMethodModifier(Reka.class, "getDatumMerenja", null, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_setVodostaj_vidljivost() {
		assertTrue("Metoda setVodostaj nije javna", TestUtil.hasMethodModifier(Reka.class, "setVodostaj",
				new Class<?>[] { double.class }, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_setVodostaj_manjiOdNule() {
		assertThrows(java.lang.RuntimeException.class,
				() -> instance.setVodostaj(-1));
	}

	@Test
	public void metoda_toString() {
		String naziv = "Dunav";
		GregorianCalendar datumMerenja = new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1);
		double vodostaj=4.1;
		
		instance.setNaziv(naziv);
		instance.setDatumMerenja(datumMerenja);
		instance.setVodostaj(vodostaj);
		String result = instance.toString();
		
		
		assertTrue("String koji vraca metoda to String ne sadrzi vrednost atributa naziv",
				result.indexOf(instance.getNaziv()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi godinu merenja",
				result.indexOf(((Integer) instance.getDatumMerenja().get(GregorianCalendar.YEAR)).toString()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi dan merenja",
				result.indexOf(((Integer) instance.getDatumMerenja().get(GregorianCalendar.DAY_OF_MONTH)).toString()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi vrednost atributa vodostaj",
				result.indexOf(((Double)instance.getVodostaj()).toString()) != -1);
	}

}
