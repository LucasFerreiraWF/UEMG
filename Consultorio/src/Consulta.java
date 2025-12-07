/*
classe Consulta
Representa uma consulta médica agendada no sistema MedConnect.

Esta classe demonstra o pilar do ENCAPSULAMENTO:
- Todos os atributos são privados (private)
- O acesso aos dados é feito através de getters e setters públicos
- A lógica de validação está protegida dentro dos métodos da classe
*/
public class Consulta {
    
    // ATRIBUTOS
    // Todos os atributos são privados, garantindo o ENCAPSULAMENTO
    // Isso protege os dados e permite controle sobre como são acessados e modificados
    
    private int id;
    private Paciente paciente;
    private Medico medico;
    private String dataConsulta;
    private String horaConsulta;
    private String statusConsulta;
    private String observacoes;

    //CONSTRUTOR
    /*
    Construtor da classe Consulta
    Inicializa uma nova consulta com status "Agendada" por padrão
    */
    public Consulta(int id, Paciente paciente, Medico medico, String dataConsulta, String horaConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.statusConsulta = "Agendada";
        this.observacoes = "";
    }

    //MÉTODOS PRINCIPAIS
    
    /*
    Método para remarcar uma consulta
    Altera a data e hora da consulta, com validações de regra de negócio:
    - Consultas canceladas não podem ser remarcadas
    - Consultas já realizadas não podem ser remarcadas
    */
    public void remarcarConsulta(String dataConsulta, String horaConsulta) {
        // Validação: consulta cancelada não pode ser remarcada
        if (this.statusConsulta.equals("Cancelada")) {
            System.out.println("Erro: Consulta cancelada não pode ser remarcada. Crie uma nova consulta.");
            return;
        }

        // Validação: consulta já realizada não pode ser remarcada
        if (this.statusConsulta.equals("Realizada")) {
            System.out.println("Erro: Consulta já realizada não pode ser remarcada.");
            return;
        }

        // Atualiza os dados da consulta
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        System.out.println("Consulta remarcada com sucesso para " + dataConsulta + " às " + horaConsulta);
    }

    /*
    Método para imprimir os dados completos da consulta
    Demonstra o uso de POLIMORFISMO ao chamar exibirDados() de Paciente e Medico,
    que são implementações específicas do método abstrato definido na classe Pessoa
    */
    public void imprimirConsulta() {
        System.out.println("DADOS DA CONSULTA:");
        System.out.println("ID: " + id);
        System.out.println("Data: " + dataConsulta + " - Hora: " + horaConsulta);
        System.out.println("Status: " + statusConsulta);
        
        // Chamada polimórfica: cada classe (Paciente e Medico) tem sua própria
        // implementação do método exibirDados() herdado da classe abstrata Pessoa
        System.out.println("PACIENTE:");
        paciente.exibirDados();
        System.out.println("MÉDICO:");
        medico.exibirDados();
        
        // Exibe observações apenas se houver
        if (!observacoes.isEmpty()) {
            System.out.println("Observações: " + observacoes);
        }
    }

    // GETTERS E SETTERS
    // Métodos de acesso que garantem o ENCAPSULAMENTO
    // Permitem acesso controlado aos atributos privados

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