package de.kaimon.schoolproject.kai;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.linear.List;

class VerwaltungList{
    List<Meldung> liste;
    private int counter;

    public VerwaltungList (){
        liste = new List<Meldung>();
        counter = 0;
        addReport(4, "Frankfurt", 20);
        addReport(2, "Berlin", 2);
        addReport(4, "Halle(Saale)", 10);
        addReport(6, "Erfurt", 10);
        addReport(5, "Hamburg", 100);
        addReport(4, "Potsdam", 1);
        System.out.println("--------------------");
        printReport();
        sortReports();
        printReport();
    }

    public void addReport(int pAutobahn, String pRichtung, int pZeitbedarf){
        liste.append(new Meldung (pAutobahn, pRichtung ,pZeitbedarf));
        counter++;
        System.out.println("succeed");
    }

    public void sortReports(){
        List<Meldung> tempList = liste;
        liste.toFirst();
        while (!liste.isEmpty()){
            liste.remove();
        }
        tempList.toFirst();
        System.out.println("lul");
        while (tempList.isEmpty()){
            System.out.println("lel");
            Meldung tempMeldung = tempList.getContent();
            tempList.remove();
            //falls die erste Meldung eingefuegt wird
            if (!liste.isEmpty()){
                liste.toFirst();
                int sec = 1;
                System.out.println("lol");
                while(tempMeldung.getAutobahn() < liste.getContent().getAutobahn()){
                    System.out.println("lal");
                    liste.next();
                }
            }
            liste.insert(tempMeldung);
        }
        System.out.println("sort succeed");
    }

    public void printReport(){
        liste.toFirst();
        if (liste.isEmpty()){
            System.out.println("Aktuell keine Staumeldungen vorhanden");
        } else {
            System.out.println("Alle hinterlegten Staumeldungen");
            for (int i = 0; i < counter -1; i++){
                System.out.println(i+1 + ". A" + liste.getContent().getAutobahn() + " Richtung " + liste.getContent().getRichtung() + " etwa "+ liste.getContent().getZeitbedarf() + " Minuten mehr");
                liste.next();
            }
        }
        System.out.println(" ");
    }

    public void clearReports(){
        liste.toFirst();
        while (liste.isEmpty() != true){
            liste.remove();
        }
        counter = 0;
        System.out.println("clearReports Succeed");
    }
}