package MODELO;

public class Especialidade {
	private int Id;
	
    @Override
	public String toString() {
		return "Especialidade [Id=" + Id + ", Espe=" + Espe + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEspe() {
		return Espe;
	}
	public void setEspe(String espe) {
		Espe = espe;
	}
	private String Espe;
}
