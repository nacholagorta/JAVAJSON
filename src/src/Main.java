package src;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Temas debca = new Temas("5", "barrio", "Azik", "1");
        Instrumental azikClassics = new Instrumental("4", "yeye", "sinel", "rap");
        JsonModel prueba = new JsonModel();

       // prueba.addTemas(debca);
       // prueba.showAllTemas();
        prueba.addInstrumentales(azikClassics);
    }
}
