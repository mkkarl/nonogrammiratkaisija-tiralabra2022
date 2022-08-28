package nonogrammiratkaisija.ui;

import java.nio.file.Paths;
import java.util.Scanner;

import nonogrammiratkaisija.logiikka.MustaPatka;
import nonogrammiratkaisija.logiikka.Rivi;
import nonogrammiratkaisija.logiikka.Ruutu;
import nonogrammiratkaisija.logiikka.Sovelluslogiikka;

public class Kayttoliittyma {
    private Scanner lukija;
    private Sovelluslogiikka sovelluslogiikka;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        this.sovelluslogiikka = new Sovelluslogiikka();
    }

    public void kaynnista() {
        System.out.println("Tervetuloa nonogrammiratkaisijaan!");
        System.out.println("");

        while (true) {
            System.out.println("Komennot:\n");

            System.out.println("S - Syötä nonogrammi käsin");
            System.out.println("T - Syötä nonogrammi tekstitiedostona");
            System.out.println("L - Lopeta");

            System.out.println("\nAnna komento: ");
            String komento = lukija.nextLine();
            System.out.println();

            if (komento.toUpperCase().equals("S")) {
                // tähän tulee käsin syöttö
                kasiSyotto();
                sovelluslogiikka.ratkaiseNonogrammi();
                tulostaNonogrammi();
                tulostaPatkat();
            } else if (komento.toUpperCase().equals("T")) {
                // tähän tulee tiedoston syöttö
                tiedostoSyotto();
                sovelluslogiikka.ratkaiseNonogrammi();
                tulostaNonogrammi();
                tulostaPatkat();
            } else if (komento.toUpperCase().equals("L")) {
                System.out.println("Kiitos ja näkemiin!");
                break;
            } else {
                System.out.println("TUNTEMATON KOMENTO!\n");
            }
        }
    }

    private void kasiSyotto() {
        System.out.println("Vaakarivien määrä: ");
        int vaakarivitLkm = Integer.valueOf(lukija.nextLine());
        System.out.println("Pystyrivien määrä: ");
        int pystyrivitLkm = Integer.valueOf(lukija.nextLine());

        System.out.println("\nSyötä vaakarivien numerot vasemmalta oikealle, käytä välimerkkinä välilyöntiä");
        String[] vaakarivit = new String[vaakarivitLkm];

        for (int i = 0; i < vaakarivitLkm; i++) {
            System.out.print("Vaakarivi " + (i + 1) + ": ");
            vaakarivit[i] = lukija.nextLine();
        }

        System.out.println("\nSyötä pystyrivien numerot ylhäältä alas, käytä välimerkkinä välilyöntiä");
        String[] pystyrivit = new String[pystyrivitLkm];

        for (int i = 0; i < pystyrivitLkm; i++) {
            System.out.print("Pystyrivi " + (i + 1) + ": ");
            pystyrivit[i] = lukija.nextLine();
        }

        sovelluslogiikka.alustaNonogrammi(vaakarivit, pystyrivit);
    }

    private void tiedostoSyotto() {
        System.out.println("Nonogrammin syöttö tiedostona");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("Nonogrammin tiedot tulee antaa seuraavassa muodossa:");
        System.out.println("1. Ensimmäisellä rivillä on vaakarivien lukumäärä");
        System.out.println("2. Toisella rivillä on pystyrivien lukumäärä");
        System.out.println(
                "3. Seuraavaksi annetaan vaakarivien numerot riveittäin ylhäältä alas. Samalla rivillä olevien numeroiden erottimena on käytettävä välilyöntiä.");
        System.out.println(
                "4. Lopuksi annetaan pystyrivien numeort riveittäin vasemmalta oikealle. Samalla rivillä olevien numeroiden erottimena on käytettävä välilyöntiä.");
        System.out.println(
                "Älä jätä näiden vaiheiden väliin tyhjiä rivejä, sillä tyhjät rivit tulkitaan nonogrammin tyhjiksi riveiksi.");
        System.out.println();

        System.out.print("Anna tiedoston nimi (Ubuntussa muodossa '/home/[kayttajanimi]/[tiedostopolku]/[tiedostonimi]'): ");
        String tiedostonimi = lukija.nextLine();

        String[] vaakarivit = {};
        String[] pystyrivit = {};

        try (Scanner tiedostonLukija = new Scanner(Paths.get(tiedostonimi))) {
            System.out.println("Luetaan tiedostoa");
            int vaakarivitLkm = Integer.valueOf(tiedostonLukija.nextLine());
            int pystyrivitLkm = Integer.valueOf(tiedostonLukija.nextLine());
            vaakarivit = new String[vaakarivitLkm];
            pystyrivit = new String[pystyrivitLkm];
            System.out.println("Vaakarivejä " + vaakarivitLkm + " Pystyrivejä " + pystyrivitLkm);

            int i = 0;

            while (tiedostonLukija.hasNextLine() && i < vaakarivitLkm) {
                vaakarivit[i] = tiedostonLukija.nextLine();
                i++;
            }

            while (i < vaakarivit.length) { // jos nonogrammi on tyhjä
                vaakarivit[i] = "";
            }

            i = 0;

            while (tiedostonLukija.hasNextLine() && i < vaakarivitLkm) {
                pystyrivit[i] = tiedostonLukija.nextLine();
                i++;
            }

            while (i < pystyrivit.length) { // jos viimeiset pystyrivit ovat tyhjiä
                pystyrivit[i] = "";
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        sovelluslogiikka.alustaNonogrammi(vaakarivit, pystyrivit);
    }

    private void tulostaNonogrammi() {
        Ruutu[][] ruudukko = this.sovelluslogiikka.getNonogrammi().getRuudukko();
        int leveys = ruudukko[0].length;

        String ylaAlaReuna = "+";

        for (int i = 0; i < leveys; i++) {
            ylaAlaReuna += "-";
        }

        ylaAlaReuna += "+";

        System.out.println("\n" + ylaAlaReuna);

        for (int i = 0; i < ruudukko.length; i++) {
            System.out.print("|");
            for (int j = 0; j < ruudukko[0].length; j++) {
                String ruudunTila = ruudukko[i][j].getTila().toString();

                if (ruudunTila.equals("TUNTEMATON")) {
                    System.out.print("?");
                } else if (ruudunTila.equals("VALKOINEN")) {
                    System.out.print(" ");
                } else if (ruudunTila.equals("MUSTA")) {
                    System.out.print("O");
                } else if (ruudunTila.equals("VIRHE")) {
                    System.out.print("X");
                } else {
                    System.out.print("Ä");
                }
            }
            System.out.println("|");
        }

        System.out.println(ylaAlaReuna + "\n");
    }

    private void tulostaPatkat() {
        Rivi[] rivit = this.sovelluslogiikka.getNonogrammi().getRivit();

        for (int i = 0; i < rivit.length; i++) {
            if (rivit[i].onVaakarivi()) {
                System.out.println("Vaakarivi " + rivit[i].getRivinumero());
            } else {
                System.out.println("Pystyrivi " + rivit[i].getRivinumero());
            }

            MustaPatka[] patkat = rivit[i].getPatkat();

            if (patkat != null) {
                System.out.print(patkat[0].toString());

                for (int j = 1; j < patkat.length; j++) {
                    System.out.print(" | " + patkat[j].toString());
                }

                System.out.println();
            }
        }

        System.out.println();
    }

}
