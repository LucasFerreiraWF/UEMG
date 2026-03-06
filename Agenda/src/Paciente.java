public class Paciente extends Pessoa {
    private Data dataNascimento;
    private String planoSaude;
    private String sexo;


    public Paciente() {
        super("");
    }

    public Paciente(Data dataNascimento, String planoSaude, String sexo, String nome) {
        this.dataNascimento = dataNascimento;
        this.planoSaude = planoSaude;
        this.sexo = sexo;
        super(nome);
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
