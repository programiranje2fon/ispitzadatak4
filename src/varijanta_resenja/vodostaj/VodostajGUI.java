package varijanta_resenja.vodostaj;

import varijanta_resenja.vodostaj.reka.Reka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;

public class VodostajGUI extends JFrame {
    private JPanel mojPanel;
    private JButton unesiButton;
    private JButton prikaziSveButton;
    private JButton izvestajButton;
    private JTextArea textArea1;
    private JTextField textFieldNaziv;
    private JComboBox comboBoxDan;
    private JComboBox comboBoxMesec;
    private JComboBox comboBoxGodina;
    private JTextField textFieldVodostaj;

    private Reka[] reke = new Reka[100];

    public VodostajGUI(){
        setContentPane(mojPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 300);
        setLocationRelativeTo(null);
        setTitle("Vodostaj");
        setResizable(false);
        unesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reka reka = new Reka();

                // preuzimanje vrednosti sa polja za unos na ekranu
                String naziv = textFieldNaziv.getText();

                int dan = Integer.parseInt((String) comboBoxDan.getSelectedItem());
                int mesec = Integer.parseInt((String) comboBoxMesec.getSelectedItem());
                int godina = Integer.parseInt((String) comboBoxGodina.getSelectedItem());
                LocalDate datumMerenja = LocalDate.of(godina, mesec, dan);

                double vodostaj = Double.parseDouble(textFieldVodostaj.getText());

                // objekat se puni podacima
                reka.setNaziv(naziv);
                reka.setDatumMerenja(datumMerenja);
                reka.setVodostaj(vodostaj);

                // ubacivanje na prvo slobodno mesto
                for (int i = 0; i < reke.length; i++) {
                    if (reke[i] == null) {
                        reke[i] = reka;
                        return;
                    }
                }

                JOptionPane.showMessageDialog(null,
                        "Nema mesta",
                        "Greska",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        prikaziSveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);

                // u prvom redu je potrebno da pise rec VODOSTAJ
                textArea1.append("VODOSTAJ" + System.lineSeparator());

                // reka sa najvisim vodostajem
                Reka maxReka = null;

                // krecemo od pocetka niza i za svaku reku proveravamo
                // da li je uneta(razlicita od null), prva reka koja nije
                // null ce biti reka sa najvisim vodostajem, a zatim se nastavlja do kraja niza
                // svaki put kada se pronadje reka koja ima veci vodostaj od trenutne sa
                // najvecim vodostajem,
                // ona ce biti postati reka sa najvecim vodostajem
                for (Reka reka : reke) {
                    if (reka != null) {
                        // ispisivanje podataka o svakoj reci u posebnom redu
                        textArea1.append(reka + System.lineSeparator());

                        if (maxReka == null || reka.getVodostaj() > maxReka.getVodostaj()) {
                            maxReka = reka;
                        }
                    }
                }

                // ako je maxReka i dalje null
                // znaci da nijedna reka nije uneta
                // ako nije ispisujemo njen naziv u poslednjem redu
                if (maxReka != null)
                    textArea1.append(maxReka.getNaziv());
                else
                    textArea1.append("Jos uvek nije uneta nijedna reka");
            }
        });
        izvestajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rezultat = "";

                // trazimo oba merenja za odredjenu reku, poredimo po nazivu reke
                // kada se nadju oba merenja proverava se koje je merenje bilo prvo, a koje
                // drugo
                // u zavisnosti od toga proverava se da li porast vodostaja reke ispunjava uslov
                // ako ispunjava dodajemo podatke o odredjenoj u pomocni String koji cemo
                // upisati u tekstualni fajl
                for (int i = 0; i < reke.length; i++) {
                    for (int j = i + 1; j < reke.length; j++) {
                        if (reke[i] != null && reke[j] != null && reke[i].getNaziv().equals(reke[j].getNaziv())) {
                            double porastVodostaja = reke[j].getVodostaj() - reke[i].getVodostaj();
                            if (reke[i].getDatumMerenja().isBefore(reke[j].getDatumMerenja())) {
                                if (porastVodostaja >= 1) {
                                    rezultat += reke[j] + System.lineSeparator();
                                }
                            } else {
                                if (porastVodostaja <= -1) {
                                    rezultat += reke[i] + System.lineSeparator();
                                }
                            }
                        }
                    }
                }
                try (PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter("izvestaj.txt")))){

                    out.print(rezultat);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new VodostajGUI().setVisible(true);
    }
}
