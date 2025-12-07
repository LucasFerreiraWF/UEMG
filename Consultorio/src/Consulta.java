public class Consulta {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private String dataConsulta;
    private String horaConsulta;
    private String statusConsulta;
    private String observacoes;

    public Consulta(int id, Paciente paciente, Medico medico, String dataConsulta, String horaConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.statusConsulta = "Agendada";
        this.observacoes = "";
    }

    public void remarcarConsulta(String dataConsulta, String horaConsulta) {
        if (this.statusConsulta.equals("Cancelada")) {
            System.out.println("Erro: Consulta cancelada não pode ser remarcada. Crie uma nova consulta.");
            return;
        }

        if (this.statusConsulta.equals("Realizada")) {
            System.out.println("Erro: Consulta já realizada não pode ser remarcada.");
            return;
        }

        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        System.out.println("Consulta remarcada com sucesso para " + dataConsulta + " às " + horaConsulta);
    }

    public void imprimirConsulta() {
        System.out.println("DADOS DA CONSULTA:");
        System.out.println("ID: " + id);
        System.out.println("Data: " + dataConsulta + " - Hora: " + horaConsulta);
        System.out.println("Status: " + statusConsulta);
        System.out.println("PACIENTE:");
        paciente.exibirDados();
        System.out.println("MÉDICO:");
        medico.exibirDados();
        if (!observacoes.isEmpty()) {
            System.out.println("Observações: " + observacoes);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}