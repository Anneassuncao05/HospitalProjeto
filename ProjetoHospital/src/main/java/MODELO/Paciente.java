package MODELO;

public class Paciente {

    private int Id;
    private String NomePaciente;
    private String NumeroCarteiraPlano;
    private int Especialidade;
    private int Plano;
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getNomePaciente() {
        return NomePaciente;
    }
    public void setNomePaciente(String NomePaciente) {
        this.NomePaciente = NomePaciente;
    }
    public String getNumeroCarteiraPlano() {
        return NumeroCarteiraPlano;
    }
    public void setNumeroCarteiraPlano(String NumeroCarteiraPlano) {
        this.NumeroCarteiraPlano = NumeroCarteiraPlano;
    }
    public int getEspecialidade() {
        return Especialidade;
    }
    public void setEspecialidade(int Especialidade) {
        this.Especialidade  = Especialidade;
    }
    public int getPlano() {
        return Plano;
    }
    public void setPlano(int Plano) {
        this.Plano = Plano;
    }
 
    
    @Override
    public String toString() {
        return "Paciente [Id=" + Id + ", NomePaciente=" + NomePaciente
                + ", NumeroCarteiraPlano=" + NumeroCarteiraPlano + ","
                		+ " Especialidade=" +Especialidade + ", Plano="
                + Plano + "]";
    }    
}


