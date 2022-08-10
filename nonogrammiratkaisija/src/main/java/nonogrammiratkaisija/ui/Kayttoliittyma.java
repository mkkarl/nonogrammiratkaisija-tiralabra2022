package nonogrammiratkaisija.ui;

import java.util.Scanner;

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
            } else if (komento.toUpperCase().equals("T")) {
                // tähän tulee tiedoston syöttö
                System.out.println("Tiedoston syöttö on tuleva ominaisuus\n");
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
            System.out.print("Vaakarivi " + i + ": ");
            vaakarivit[i] = lukija.nextLine();
        }

        System.out.println("\nSyötä pystyrivien numerot ylhäältä alas, käytä välimerkkinä välilyöntiä");
        String[] pystyrivit = new String[pystyrivitLkm];

        for (int i = 0; i < pystyrivitLkm; i++) {
            System.out.print("Pystyrivi " + i + ": ");
            pystyrivit[i] = lukija.nextLine();
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
            for (int j = 0; j < ruudukko[0].length;j++) {
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

    
}
