package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface DataManager {
	//public void saveTemas();
    public void addTemas ( Temas tema) throws FileNotFoundException, IOException;
    public void addInstrumentales(Instrumental instrumental) throws FileNotFoundException, IOException;
    public void showAllTemas() throws FileNotFoundException, IOException;
    public void showAllInstrumentales() throws FileNotFoundException, IOException;
	public HashMap<String, Temas> saveTemas() throws FileNotFoundException, IOException;

}
