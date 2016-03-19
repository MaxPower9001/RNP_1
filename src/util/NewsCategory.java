package util;

import java.util.ArrayList;

/**
 * Created by Rene on 19.03.2016.
 */
public enum NewsCategory {
    INFO("Info"),
    WARN("Warning"),
    CORR("Correction");

    private final String longDescription;
    private final ArrayList<String> news = new ArrayList<>();

    NewsCategory(String info) {
        this.longDescription = info;

        news.add("Mit Haut und Harem: Sultan von Kannibalen gefressen");
        news.add("Bobby Car: Londoner Polizei erhält neues Einsatzfahrzeug");
        news.add("Phönix: Feuervogel trocknet keine Haare");
        news.add("Kaufte sich den Typen: Polizist verhaftet Höchstbietenden bei Sklavenauktion ");
        news.add("Will sein Verderben: Sohn von Jockey heuert Auftragskiller an");
        news.add("Mein lieber Schwan!: Sodomist schreibt romantische Briefe");
        news.add("Von der Hütte abwärts gelehmt: Bergbauer bekommt Stollenreifen für Rollstuhl geschenkt");
        news.add("Hat sich wieder gelegt: Mann schlafwandelt nicht mehr");
        news.add("Ahn und Pfirsich kein Problem: Obstbaum auf Grab wurde genehmigt");
        news.add("Endlosschleifen: Tischler schmirgelt Tag für Tag nur Bretter");
        news.add(" \"Schön, Sie kämmen zu lernen\": Frisörazubi begrüßt Kunden");
        news.add("Rocher: Drogenhund fand Cannabis in Schoko-Kugel ");
        news.add("Wildpark: Autos am Tiergehege unerlaubt abgestellt");
        news.add("\"Nimm ein' Gummi, Bärchen!\": Peinliches Missverständnis beim ersten Date ");
        news.add("Störfall: Fisch in Reaktorbecken geplumpst");
        news.add("Paul McCartney: Ex-Beatle hat keinen Grund, sich zu beschweren");
        news.add("Einfach gestrickt: Hausfrau wusste nicht, dass man Reizwäsche auch kaufen kann");
        news.add("Wieder stanzfähig: Locher nach Reparatur zurück in Betrieb");
        news.add("Trendsport U-Bahn-Surfen: Immer mehr springen auf den Zug auf ");
        news.add("Koran falsch ausgelegt: Islamist bedroht Buchhändler");
        news.add("Muss sie großziehen: Zoodirektor zeigt kurzsichtigem Pfleger Aufnahmen neuer Tierbabys");
        news.add("Haken? Kreuz?: NPD-Wähler weiß nicht, wie er Stimmzettel ausfüllen soll");
        news.add("Fettziege Musik: Dicker Bock legt im Club auf");
        news.add("Steakdose verlegt: Elektriker findet Frühstück nicht mehr");
        news.add("Langsam nicht mehr lustig: Doping bei Schneckenrennen nimmt zu");
        news.add("Nur schmutzige Filme im Regal: Putzfrau von Videothek krank");
        news.add("Reubär: Pelztier entschuldigt sich für Überfall");
        news.add("Sieh dir mal die Wan an, wie die Wan Tan kann: Chinesin kocht auf Mauer Suppe");
        news.add("Endlich ein Auto für seine Frau bekommen: Araber freut sich über Tauschgeschäft");
        news.add("Trägt Hornbrille: Rhinozeros bekommt Sonderanfertigung");
        news.add("Sie braucht ihre Zeit: Funkuhr sucht lange nach geeignetem Sender");
        news.add("Kloß ab: Leere Gabel fotografiert");
        news.add("Lässt Stuhlprobe untersuchen: Tischler vermutet Wurmbefall");

    }

    public String getNews(int index){
        return news.get(index);
    }

    public int getNewsCounter(){
        return news.size();
    }

    @Override
    public String toString() {
        return longDescription;
    }
}
