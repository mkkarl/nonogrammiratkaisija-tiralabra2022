package nonogrammiratkaisija.ui;

import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    
    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
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
                System.out.println("Käsin syöttö on tuleva ominaisuus\n");
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

    
}
