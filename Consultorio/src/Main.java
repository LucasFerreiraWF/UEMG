import java.util.*;
import java.io.*;

public class Main {

    //Listas
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<Medico> medicos = new ArrayList<>();
    private static Agenda agenda = new Agenda();
    private static Scanner sc = new Scanner(System.in);
    private static int idPaciente = 1;
    private static int idConsulta = 1;

    public static void main(String[] args) {
        menuPrincipal();
        sc.close();
    }

    public static void menuPrincipal() {
        while(true) {
            System.out.println("\n--- Clínica Médica ---");
            System.out.println("1 - Gerenciar Pacientes");
            System.out.println("2 - Gerenciar Médicos");
            System.out.println("3 - Gerenciar Consultas");
            System.out.println("4 - Gerar Relatórios");
            System.out.println("0 - Sair");

            int opc = sc.nextInt(); sc.nextLine();

            switch(opc) {
                case 1: gerenciarPacientes(); break;
                case 2: gerenciarMedicos(); break;
                case 3: gerenciarConsultas(); break;
                case 4: gerarRelatorios(); break;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    //Gerenciamento Pacientes
    public static void gerenciarPacientes() {
        while(true) {
            System.out.println("\n--- Gerenciar Pacientes ---");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Atualizar Paciente");
            System.out.println("0 - Voltar");

            int opc = sc.nextInt(); sc.nextLine();
            
            switch(opc) {
                case 1: 
                    System.out.println("Nome:"); String nome = sc.nextLine();
                    System.out.println("CPF:"); int cpf = sc.nextInt(); sc.nextLine();
                    System.out.println("Endereço:"); String endereco = sc.nextLine();
                    System.out.println("Email:"); String email = sc.nextLine(); 
                    System.out.println("Data de Nascimento (dd/mm/yyyy):"); String dataNasc = sc.nextLine();
                    System.out.println("Tipo Sanguíneo:"); String tipoSangue = sc.nextLine();
                    System.out.println("Quantidade de alergias:"); int nAlergias = sc.nextInt(); sc.nextLine();

                    ArrayList<String> alergias = new ArrayList<>();
                    for(int i=0; i<nAlergias; i++) {
                        System.out.println("Alergia " + (i+1) + ":"); 
                        alergias.add(sc.nextLine());
                    }

                    
                    Paciente p = new Paciente(idPaciente++, tipoSangue, nome, cpf, endereco, email, dataNasc);
                    for(String a : alergias) p.adicionarAlergia(a);

                    pacientes.add(p);
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;

                case 2:
                    if(pacientes.isEmpty()) {
                        System.out.println("Nenhum paciente cadastrado.");
                        break;
                    }
                    for(Paciente px : pacientes){
                        px.exibirDados();
                        System.out.println();
                    }
                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;

                case 3:
                    Paciente pacAtualizar = escolherPaciente();
                    if(pacAtualizar != null) {
                        pacAtualizar.atualizarDados();
                        System.out.println("Paciente atualizado com sucesso!");
                    }
                    break;

                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    //Gerenciamento Médicos
    public static void gerenciarMedicos() {
        while(true) {
            System.out.println("\n--- Gerenciar Médicos ---");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Listar Médicos");
            System.out.println("3 - Atualizar Médico");
            System.out.println("0 - Voltar");

            int opc = sc.nextInt(); sc.nextLine();

            switch(opc) {
                case 1:
                    System.out.println("Nome:"); String nomeM = sc.nextLine();
                    System.out.println("CPF:"); int cpfM = sc.nextInt(); sc.nextLine();
                    System.out.println("Endereço:"); String endM = sc.nextLine();
                    System.out.println("Email:"); String emailM = sc.nextLine();
                    System.out.println("Data de Nascimento:"); String dataM = sc.nextLine();
                    System.out.println("Especialidade:"); String esp = sc.nextLine();
                    System.out.println("CRM:"); String crm = sc.nextLine();

                    Medico m = new Medico(esp, crm, nomeM, cpfM, endM, emailM, dataM);
                    medicos.add(m);
                    System.out.println("Médico cadastrado com sucesso!");
                    break;

                case 2:
                    if(medicos.isEmpty()) {
                        System.out.println("Nenhum médico cadastrado.");
                        break;
                    }
                    for(int i=0; i<medicos.size(); i++){
                        System.out.println("[" + i + "]");
                        medicos.get(i).exibirDados();
                        System.out.println();
                    }
                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                    break;

                case 3:
                    Medico medAtualizar = escolherMedico();
                    if(medAtualizar != null) {
                        medAtualizar.atualizarDados();
                        System.out.println("Médico atualizado com sucesso!");
                    }
                    break;

                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    //Consultas
    public static void gerenciarConsultas() {
        while(true) {
            System.out.println("\n--- Gerenciar Consultas ---");
            System.out.println("1 - Agendar Consulta");
            System.out.println("2 - Consultar Histórico do Paciente");
            System.out.println("3 - Consultas do Médico");
            System.out.println("4 - Remarcar Consulta");
            System.out.println("5 - Alterar Status da Consulta");
            System.out.println("6 - Salvar Histórico do Paciente em TXT");
            System.out.println("0 - Voltar");

            int opc = sc.nextInt(); sc.nextLine();

            switch(opc) {
                case 1:
                    if(pacientes.isEmpty() || medicos.isEmpty()) {
                        System.out.println("Sem pacientes ou médicos.");
                        break;
                    }
                    Paciente pac = escolherPaciente();
                    Medico med = escolherMedico();
                    System.out.println("Data (dd/mm/aaaa):"); String data = sc.nextLine();
                    System.out.println("Hora (hh:mm):"); String hora = sc.nextLine();

                    Consulta c = new Consulta(idConsulta++, pac, med, data, hora);
                    agenda.marcarConsulta(c);
                    System.out.println("Consulta agendada!");
                    break;

                case 2:
                    Paciente pacHist = escolherPaciente();
                    if(pacHist != null) {
                        List<Consulta> historico = agenda.buscarConsultasPorpaciente(pacHist);
                        for(Consulta cx : historico) cx.imprimirConsulta();
                    }
                    break;

                case 3:
                    Medico medHist = escolherMedico();
                    if(medHist != null) {
                        List<Consulta> consMed = agenda.buscarConsultasPorMedico(medHist);
                        for(Consulta cx : consMed) cx.imprimirConsulta();
                    }
                    break;

                case 4:
                    Paciente pacRem = escolherPaciente();
                    if(pacRem != null) {
                        List<Consulta> consPac = agenda.buscarConsultasPorpaciente(pacRem);
                        if(consPac.isEmpty()) { System.out.println("Nenhuma consulta."); break; }

                        for(int i=0; i < consPac.size(); i++) {
                            System.out.println("[" + i + "]");
                            consPac.get(i).imprimirConsulta();
                        }

                        System.out.println("Selecione a consulta: ");
                        int idx = sc.nextInt(); sc.nextLine();

                        if(idx >= 0 && idx < consPac.size()) {
                            System.out.println("Nova data:"); String novaData = sc.nextLine();
                            System.out.println("Nova hora:"); String novaHora = sc.nextLine();
                            consPac.get(idx).remarcarConsulta(novaData, novaHora);
                            System.out.println("Consulta remarcada!");
                        }
                    }
                    break;

                case 5:
                    Paciente pacStatus = escolherPaciente();
                    if(pacStatus != null) {
                        List<Consulta> consPac = agenda.buscarConsultasPorpaciente(pacStatus);
                        if(consPac.isEmpty()){ 
                            System.out.println("Nenhuma consulta"); break;

                        }

                        for(int i=0; i<consPac.size(); i++){
                            System.out.println("[" + i + "]");
                            consPac.get(i).imprimirConsulta();
                        }
                        System.out.println("Selecione a consulta:");

                        int idx = sc.nextInt(); sc.nextLine();
                        if(idx >= 0 && idx < consPac.size()){
                            System.out.println("Novo status:");
                            String novoStatus = sc.nextLine();
                            consPac.get(idx).setStatusConsulta(novoStatus);
                            System.out.println("Status atualizado!");
                        }
                    }
                    break;

                case 6:
                    Paciente pacTxt = escolherPaciente();
                    if(pacTxt != null) {
                        List<Consulta> hist = agenda.buscarConsultasPorpaciente(pacTxt);
                        salvarHistoricoTXT(pacTxt, hist);
                        System.out.println("Histórico salvo!");
                    }
                    break;

                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
    public static void gerarRelatorios() {
        System.out.println("\n--- Relatório ---");
        System.out.println("Total de Pacientes: " + pacientes.size());
        System.out.println("Total de Médicos: " + medicos.size());

        List<Consulta> todas = agenda.buscarConsultasPorData("");
        System.out.println("Total de Consultas: " + todas.size());
    }

    private static Paciente escolherPaciente() {
        if(pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return null;
        }
        System.out.println("Selecione o paciente:");
        for(int i=0; i<pacientes.size(); i++)
            System.out.println("[" + i + "] - " + pacientes.get(i).getNome());

        int idx = sc.nextInt(); sc.nextLine();
        return (idx >=0 && idx < pacientes.size()) ? pacientes.get(idx) : null;
    }

    private static Medico escolherMedico() {
        if(medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return null;
        }
        System.out.println("Selecione o médico:");
        for(int i=0; i<medicos.size(); i++)
            System.out.println("[" + i + "] - " + medicos.get(i).getNome());

        int idx = sc.nextInt(); sc.nextLine();
        return (idx >=0 && idx < medicos.size()) ? medicos.get(idx) : null;
    }

    //Cria um arquivo com o nome do paciente, converte cada consulta para texto pelo toString e salva tudo.
    private static void salvarHistoricoTXT(Paciente p, List<Consulta> consultas) {
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(p.getNome() + "_historico.txt"));

            writer.write("Histórico de Consultas - Paciente: " + p.getNome() + "\n\n");
            for(Consulta c : consultas) {
                writer.write(c.toString() + "\n");
            }

            writer.close();
        } catch(IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
