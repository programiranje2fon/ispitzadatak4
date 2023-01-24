package vodostaj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import test.TestUtil;
import vodostaj.reka.Reka;

public class VodostajGUITest {

	VodostajGUI instance;
	
	@Before
	public void setUp() throws Exception {
		instance=new VodostajGUI();
	}

	@After
	public void tearDown() throws Exception {
		instance=null;
	}

	@Test
	public void atribut_title() {
		String expected = "Vodostaj";
		String actual = (String)instance.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	public void atribut_cmbDan() {
		JComboBox combo = null;
		try {
			combo = (JComboBox)getFiledsByType(instance, JComboBox.class).get(0);
		} catch (Exception e) {
			assertTrue("Nije definisana padajuca lista za dane",false);
		}
		List<Object> itemsActual = new ArrayList<>();
		int countActual = combo.getItemCount();
		Object[] itemsExpected = new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
				16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
		int countExpected = itemsExpected.length;
		assertTrue("Padajuca lista treba da sadrzi "+countExpected+"stavki, a sadrzi"+countActual, countExpected == countActual);
		
		for(int i = 0; i < countActual; i++) {
			itemsActual.add(combo.getItemAt(i));
		} 
		
		for(Object ex : itemsExpected) {
			assertTrue("Padajuca lista ne sadrzis stavku \""+ex+"\"",itemsActual.contains(ex));
		}
	}
	
	@Test
	public void atribut_cmbMesec() {
		JComboBox combo = null;
		try {
			combo = (JComboBox)getFiledsByType(instance, JComboBox.class).get(1);
		} catch (Exception e) {
			assertTrue("Nije definisana padajuca lista za mesece",false);
		}
		List<Object> itemsActual = new ArrayList<>();
		int countActual = combo.getItemCount();
		Object[] itemsExpected = new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int countExpected = itemsExpected.length;
		assertTrue("Padajuca lista treba da sadrzi "+countExpected+"stavki, a sadrzi"+countActual, countExpected == countActual);
		
		for(int i = 0; i < countActual; i++) {
			itemsActual.add(combo.getItemAt(i));
		} 
		
		for(Object ex : itemsExpected) {
			assertTrue("Padajuca lista ne sadrzis stavku \""+ex+"\"",itemsActual.contains(ex));
		}
	}
	
	@Test
	public void atribut_cmbGodina() {
		JComboBox combo = null;
		try {
			combo = (JComboBox)getFiledsByType(instance, JComboBox.class).get(2);
		} catch (Exception e) {
			assertTrue("Nije definisana padajuca lista za godine",false);
		}
		List<Object> itemsActual = new ArrayList<>();
		int countActual = combo.getItemCount();
		Object[] itemsExpected = new Object[] {2010, 2011, 2012, 2013, 2014, 2015 };
		int countExpected = itemsExpected.length;
		assertTrue("Padajuca lista treba da sadrzi "+countExpected+"stavki, a sadrzi"+countActual, countExpected == countActual);
		
		for(int i = 0; i < countActual; i++) {
			itemsActual.add(combo.getItemAt(i));
		} 
		
		for(Object ex : itemsExpected) {
			assertTrue("Padajuca lista ne sadrzis stavku \""+ex+"\"",itemsActual.contains(ex));
		}
	}
	
	
	public List<Object> getFiledsByType(Object inst,Class<?> type){
		 Field[] fields =	(inst.getClass()).getDeclaredFields();
		 List<Object> list = new ArrayList<>();
		 for(Field f : fields) {
			 if(f.getType().equals(type)) {
				f.setAccessible(true);
				try {
					list.add(f.get(inst));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
		 return list;
	}
	
	@Test
	public void atribut_txtNaziv() {
		JTextField textField1 = null;
		try {
			textField1 = (JTextField)getFiledsByType(instance, JTextField.class).get(0);
		} catch (Exception e) {
			assertTrue("Nije definisano tekstualno polje za unos naziva reke",false);
		}
	}
	
	@Test
	public void atribut_txtVodostaj() {
		JTextField textField2 = null;
		try {
			textField2 = (JTextField)getFiledsByType(instance, JTextField.class).get(1);
		} catch (Exception e) {
			assertTrue("Nije definisano tekstualno polje za unos nivoa vodostaja",false);
		}
	}
	
	@Test
	public void atribut_btnUnesi() {
		JButton btnUnesi = null;
		try {
			btnUnesi = (JButton)getFiledsByType(instance, JButton.class).get(0);
		} catch (Exception e) {
			assertTrue("Nije definisano dugme Unesi",false);
		}
	}
	
	@Test
	public void atribut_btnPrikaziSve() {
		JButton btnPrikaziSve = null;
		try {
			btnPrikaziSve = (JButton)getFiledsByType(instance, JButton.class).get(1);
		} catch (Exception e) {
			assertTrue("Nije definisano dugme Prikazi sve",false);
		}
	}
	
	@Test
	public void atribut_btnIzvestaj() {
		JButton btnIzvestaj = null;
		try {
			btnIzvestaj = (JButton)getFiledsByType(instance, JButton.class).get(2);
		} catch (Exception e) {
			assertTrue("Nije definisano dugme Izvestaj",false);
		}
	}
	
	
	@Test
	public void atribut_editor() {
		JTextArea textArea = null;
		try {
			textArea = (JTextArea)getFiledsByType(instance, JTextArea.class).get(0);
		} catch (Exception e) {
			assertTrue("Nije definisan editor",false);
		}
	}
	
	@Test
	public void dimenzije_prozora() {
		boolean expected = false;
		boolean actual = instance.isResizable();
		assertEquals(expected, actual);
	}
	
	@Test
	public void atribut_reke() {
		assertTrue("U klasi nije definisan atribut reke", TestUtil.doesFieldExist(VodostajGUI.class, "reke"));
	}
	
	@Test
	public void atribut_reke_vidljivost() {
		assertTrue("Atribut reke nije privatan", TestUtil.hasFieldModifier(VodostajGUI.class, "reke", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_reke_kapacitet() {
		Reka[] niz = (Reka[])(TestUtil.getFieldValue(instance,"reke"));
		assertEquals(100, niz.length);
	}
	
	@Test
	public void metoda_unesiReku() {
		Reka r1 = new Reka();
		
		instance.unesiReku(r1);
		
		Reka[] niz = (Reka[])(TestUtil.getFieldValue(instance,"reke"));

		assertEquals("Metoda ne unosi reku na prvo slobodno", r1, niz[0]);
		assertEquals("Metoda unosti istu reku na vise slobodnih mesta", null, niz[1]);
		assertEquals("Metoda unosti istu reku na vise slobodnih mesta", null, niz[2]);
		assertEquals("Metoda unosti istu reku na vise slobodnih mesta", null, niz[3]);
		assertEquals("Metoda unosti istu reku na vise slobodnih mesta", null, niz[4]);
	
	}
	
	@Test
	public void metoda_prikaziSve_prazanNiz() {
		String expected = "VODOSTAJ\n"+"Jos uvek nije uneta ni jedna reka";
		String actual = instance.prikaziSve();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void metoda_prikaziSve() {
		Reka r1=new Reka();
		r1.setNaziv("Dunav");
		r1.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1));
		r1.setVodostaj(4.1);
		
		Reka r2=new Reka();
		r2.setNaziv("Sava");
		r2.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1));
		r2.setVodostaj(3.5);
		
		Reka r3=new Reka();
		r3.setNaziv("Tisa");
		r3.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1));
		r3.setVodostaj(3.9);
		
		instance.unesiReku(r1);
		instance.unesiReku(r2);
		instance.unesiReku(r3);
		
		String expected = "VODOSTAJ\n"+r1+"\n"+r2+"\n"+r3+"\n"+r1.getNaziv();
		String actual = instance.prikaziSve();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void metoda_napraviIzvestaj() {
		Reka r1=new Reka();
		r1.setNaziv("Dunav");
		r1.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1));
		r1.setVodostaj(4.1);
		
		Reka r2=new Reka();
		r2.setNaziv("Sava");
		r2.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 3, 1, 1));
		r2.setVodostaj(3.5);
		
		Reka r3=new Reka();
		r3.setNaziv("Tisa");
		r3.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1));
		r3.setVodostaj(3.9);
		
		Reka r4=new Reka();
		r4.setNaziv("Dunav");
		r4.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 3, 1, 1));
		r4.setVodostaj(2.9);
		
		Reka r5=new Reka();
		r5.setNaziv("Sava");
		r5.setDatumMerenja(new GregorianCalendar(
				new GregorianCalendar().get(GregorianCalendar.YEAR) - 1, 1, 1));
		r5.setVodostaj(2.7);
		
		instance.unesiReku(r1);
		instance.unesiReku(r2);
		instance.unesiReku(r3);
		instance.unesiReku(r4);
		instance.unesiReku(r5);
		
		String expected = r1.toString()+"\n";
		String actual = instance.napraviIzvestaj();
		
		assertEquals(expected, actual);
	}
	

}
