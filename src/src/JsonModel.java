package src;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonModel implements DataManager {
    private Temas newTema;
    private Instrumental newInstrumental;

    ApiRequests encargadoPeticiones;
    private String SERVER_PATH, GET_TEMA, GET_INSTRUMENTAL, SET_TEMA, SET_CURSE; // Datos de la conexion

    public JsonModel() {
        char c;

        encargadoPeticiones = new ApiRequests();

        SERVER_PATH = "http://localhost/Nacho/PisoFranko/";
        GET_TEMA = "readTema.php";
        GET_INSTRUMENTAL = "readInstrumental.php";
        SET_TEMA = "writeTema.php";
        SET_CURSE = "writeInstrumental.php";

    }

    @Override
    public void addTemas(Temas tema) throws FileNotFoundException, IOException {

        try {
            JSONObject objJTemas = new JSONObject();
            JSONObject objPeticion = new JSONObject();

            objJTemas.put("ID", tema.getStr_mid());
            objJTemas.put("Nombre", tema.getStr_mname());
            objJTemas.put("Instrumental", tema.getStr_minstrumental());
            objJTemas.put("ID_Instrumental", tema.getStr_midinstrumental());

            objPeticion.put("peticion", "add");
            objPeticion.put("tema", objJTemas);

            String json = objPeticion.toJSONString();
            String url = SERVER_PATH + SET_TEMA;
            String response = encargadoPeticiones.postRequest(url, json);
            System.out.println(response);

        } catch (Exception e) {
            System.out.println(
                    "Excepcion desconocida.");
            // e.printStackTrace();
            System.out.println("Fin ejecución");
            System.exit(-1);
        }

    }

    @Override
    public void addInstrumentales(Instrumental instrumental) throws FileNotFoundException, IOException {
/*
        try {
            JSONObject objJCurse = new JSONObject();
            JSONObject objPeticion = new JSONObject();

            objJCurse.put("int_id", auxCurse.getInt_id());
            objJCurse.put("str_mname", auxCurse.getStr_mname());
            objJCurse.put("str_mfirst_characteristic", auxCurse.getStr_mfirst_characteristic());
            objJCurse.put("str_msecond_characteristic", auxCurse.getStr_msecond_characteristic());
            objJCurse.put("str_mthird_characteristic", auxCurse.getStr_mthird_characteristic());

            objPeticion.put("peticion", "add");
            objPeticion.put("curse", objJCurse);

            String json = objPeticion.toJSONString();
            String url = SERVER_PATH + SET_CURSE;
            String response = encargadoPeticiones.postRequest(url, json);
            System.out.print("Insert hecho");

        } catch (Exception e) {
            System.out.println(
                    "Excepcion desconocida.");
            // e.printStackTrace();
            System.out.println("Fin ejecución");
            System.exit(-1);
        }

     */

    }

    @Override
    public void showAllTemas() throws FileNotFoundException, IOException {
    	  HashMap<String, Temas> hm_temas = saveTemas();

          for (Map.Entry<String, Temas> entry : hm_temas.entrySet()) {
              String k = entry.getKey();
              Temas v = entry.getValue();
              System.out.println("ID: " + hm_temas.get(k).getStr_mid());
              System.out.println("Nombre: " + hm_temas.get(k).getStr_mname());
              System.out.println("Instrumental: " + hm_temas.get(k).getStr_minstrumental());
              System.out.println("ID_Instrumental: " + hm_temas.get(k).getStr_midinstrumental());
           
              System.out.println("--------------");
    }
          }

          
    @Override
    public void showAllInstrumentales() throws FileNotFoundException, IOException {

    }

	@Override
	public HashMap<String, Temas> saveTemas() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, Temas> hm_temas = new HashMap<String, Temas>();


        try {

            String url = SERVER_PATH + GET_TEMA; // Sacadas de configuracion
            String response = encargadoPeticiones.getRequest(url);

            // Parseamos la respuesta y la convertimos en un JSONObject
            JSONObject respuesta = (JSONObject) JSONValue.parse(response);

            // El JSON recibido es correcto
            String estado = (String) respuesta.get("estado");
            // Si ok, obtenemos array de jugadores para recorrer y generar hashmap
            if (estado.equals("ok")) {
                JSONArray array = (JSONArray) respuesta.get("temas");

                if (array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject row = (JSONObject) array.get(i);

                        String ID = row.get("ID").toString();
                        String Nombre = row.get("Nombre").toString();
                        String Instrumental = row.get("Instrumental").toString();
                        String ID_Instrumental = row.get("ID_Instrumental").toString();
                       

                        newTema = new Temas(ID, Nombre, Instrumental, ID_Instrumental);


                        hm_temas.put(ID, newTema);
                    }

                }

            }


        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en la busqueda de datos");

            e.printStackTrace();

            System.exit(-1);
        }

        return hm_temas;
	}

}


