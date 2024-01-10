package gestiondeboutique.main;

import java.util.ArrayList;
import java.util.List;

public class Essai {
    public static void main(String[]args){
        List<String> liste = new ArrayList<>();

        int ab = 10;
        String abn = "Areil";
        int bc = 12;
        String bcn = "Hugues";
        int cd = 15;
        String cdn = "Popi";

        String abs = String.format("|%10s|%5d|", abn, ab);
        String bcs = String.format("|%10s|%5d|", bcn, bc);
        String cds = String.format("|%10s|%5d|", cdn, cd);

        liste.add(abs);
        liste.add(bcs);
        liste.add(cds);

        System.out.println(liste);

        String str = "";

        for (String l : liste){
            str += l + ";";
        }

        System.out.println(str);

        String[] lili = str.split(";");

        for(int i = 0; i < lili.length; i++){
            System.out.println(lili[i]);
        }

        //Ici le commentaire
    }
}
