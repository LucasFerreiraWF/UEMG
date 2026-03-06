public class Consulta {
    private int codigo;
    private Data data;
    private Paciente paciente;
    private Profissional especialista;
    private String horario;
    private String descricaoSintoma;
    private String prescricao;

    public Consulta(int codigo, Data data, Paciente paciente, Profissional especialista) {
        this.codigo = codigo;
        this.data = data;
        this.paciente = paciente;
        this.especialista = especialista;
        horario = "";
        descricaoSintoma = "";
        prescricao = "";
    }

    public Consulta() {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Profissional getEspecialista() {
        return especialista;
    }
    public void setEspecialista(Profissional especialista) {
        this.especialista = especialista;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getDescricaoSintoma() {
        return descricaoSintoma;
    }
    public void setDescricaoSintoma(String descricaoSintoma) {
        this.descricaoSintoma = descricaoSintoma;
    }
    public String getPrescricao() {
        return prescricao;
    }
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
    
}
