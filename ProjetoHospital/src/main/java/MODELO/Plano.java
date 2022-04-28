package MODELO;

public class Plano {
   public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano= plano;
	}
private  int Id;
   private  String plano;
@Override
public String toString() {
	return "Plano [Id=" + Id + ", plano=" + plano + "]";
}
   
   
}
