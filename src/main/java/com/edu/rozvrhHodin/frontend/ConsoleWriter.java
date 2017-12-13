package com.edu.rozvrhHodin.frontend;

public class ConsoleWriter {
    public ConsoleWriter(){

    }
    public static void menuWriter(){
        System.out.println("-----Menu-----");
        System.out.println("1 - Vytvoření studenta");
        System.out.println("2 - Vytvoření předmětu");
        System.out.println("3 - Zobrazení informací");
        System.out.println("5 - Editace účtu studenta");
        System.out.println("6 - Editace předmětu");
        System.out.println("7 - Deaktivace studenta");
        System.out.println("8 - Přihlášení studenta na předmětu");
        System.out.println("9 - Odhlášení studenta z předmětu");
        System.out.println("0 - Konec");
    }
    public static void informationWriter(){
        System.out.println("1 - Zobrazení rozvrhu studenta");
        System.out.println("2 - Zobrazení rozvrhu více studentů");
        System.out.println("3 - Zobrazení volného času");
        System.out.println("4 - Zobrazení přihlášených studentů na předmět");
        System.out.println("5 - Výpis všech předmětů studenta");
        System.out.println("6 - Výpis údajů konkrétního studenta");
        System.out.println("7 - Výpis všech studentů");
        System.out.println("8 - Výpis údajů konkrétního předmětu");
        System.out.println("9 - Výpis všech předmětů");
        System.out.println("0 - Zpět");
    }
}
