package src;

public class Instrumental {

	private String Id_Instrumental;
	private String Nombre;
    private String Productor;
    private String Genero;

    public Instrumental(String Id_Instrumental, String Nombre, String Productor, String Genero) {
        this.Id_Instrumental = Id_Instrumental;
        this.Nombre = Nombre;
        this.Productor = Productor;
        this.Genero = Genero;
    }
	    public String getId_Instrumental() {
		return Id_Instrumental;
	}

	public void setId_Instrumental(String id_Instrumental) {
		Id_Instrumental = id_Instrumental;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getProductor() {
		return Productor;
	}

	public void setProductor(String productor) {
		Productor = productor;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}
}

