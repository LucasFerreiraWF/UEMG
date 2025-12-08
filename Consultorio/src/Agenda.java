import java.util.ArrayList; // Importa a classe ArrayList, usada para criar listas dinâmicas.

public class Agenda { // Define a classe Agenda, o molde para criar objetos que gerenciam consultas.

    // O atributo 'consultas' é private, implementando o pilar de
    // **Encapsulamento**.
    // Ele armazena uma lista de objetos do tipo Consulta e só pode ser acessado
    // pela Agenda
    private ArrayList<Consulta> consultas;

    // Construtor da Classe
    public Agenda() {
        // O construtor é chamado na criação do objeto Agenda.
        // Ele **inicializa** o ArrayList, garantindo que a lista esteja pronta e vazia
        // para receber consultas.
        this.consultas = new ArrayList<>();
    }

    /**
     * Marca uma nova consulta.
     * Esse método exemplifica a **Abstração** ao esconder a complexidade de como a
     * consulta é armazenada.
     */
    public boolean marcarConsulta(Consulta consulta) {
        this.consultas.add(consulta); // Adiciona o objeto Consulta recebido à lista interna.
        return true; // Retorna true para sinalizar que a operação foi bem-sucedida.
    }

    /**
     * Procura a consulta pelo ID e a remove.
     * O loop percorre a lista para encontrar o objeto com o ID correspondente.
     */
    public boolean cancelarConsulta(int id) {
        for (int i = 0; i < consultas.size(); i++) {
            // Compara o ID da consulta na posição 'i' com o ID fornecido.
            if (consultas.get(i).getId() == id) {
                consultas.remove(i); // Remove a consulta da lista ao encontrar o ID.
                return true; // Retorna true e encerra a busca, pois a remoção foi feita.
            }
        }
        // Se o loop terminar sem encontrar o ID, retorna false.
        return false;
    }

    /**
     * Busca e retorna uma lista de consultas de um médico específico.
     * Acessamos o nome do médico através de uma cadeia de chamadas:
     * `getMedico().getNome()`.
     */
    public ArrayList<Consulta> buscarConsultasPorMedico(Medico medico) {
        ArrayList<Consulta> consultas_medicos = new ArrayList<>(); // Cria uma nova lista para os resultados.

        for (int i = 0; i < consultas.size(); i++) {
            // Verifica se o nome do médico na consulta atual é igual ao nome do objeto
            // Medico fornecido.
            if (consultas.get(i).getMedico().getNome().equals(medico.getNome())) {
                consultas_medicos.add(consultas.get(i)); // Adiciona a consulta à lista de resultados se os nomes
                                                         // coincidirem.
            }
        }
        return consultas_medicos; // Retorna a lista contendo todas as consultas do médico.
    }

    /**
     * Busca e retorna uma lista de consultas de um paciente específico.
     * A lógica é a mesma do método anterior, mas acessando o nome do Paciente.
     */
    public ArrayList<Consulta> buscarConsultasPorpaciente(Paciente paciente) {
        ArrayList<Consulta> consultas_pacientes = new ArrayList<>();

        for (int i = 0; i < consultas.size(); i++) {
            // Compara o nome do paciente da consulta atual com o nome do objeto Paciente
            // fornecido.
            if (consultas.get(i).getPaciente().getNome().equals(paciente.getNome())) {
                consultas_pacientes.add(consultas.get(i));
            }
        }
        return consultas_pacientes;
    }

    /**
     * Busca e retorna uma lista de consultas agendadas para uma data específica.
     */
    public ArrayList<Consulta> buscarConsultasPorData(String data) {
        ArrayList<Consulta> consultas_data = new ArrayList<>();

        for (int i = 0; i < consultas.size(); i++) {
            // Compara a data da consulta atual (obtida por getDataConsulta()) com a string
            // de data fornecida.
            if (consultas.get(i).getDataConsulta().equals(data)) {
                consultas_data.add(consultas.get(i));
            }
        }
        return consultas_data;
    }
}