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
        carregarDados();
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
            System.out.println("5 - Salvar Dados");
            System.out.println("0 - Sair");

            int opc = sc.nextInt(); sc.nextLine();

            switch(opc) {
                case 1: gerenciarPacientes(); break;
                case 2: gerenciarMedicos(); break;
                case 3: gerenciarConsultas(); break;
                case 4: gerarRelatorios(); break;
                case 5: salvarDados(); break;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    //Gerenciamento Pac
    public static void gerenciarPacientes() {
        while(true) {
            System.out.println("\n--- Gerenciar Pacientes ---");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Atualizar Paciente");
            System.out.println("0 - Voltar");

            int opc = sc.nextInt(); sc.nextLine();
            switch(opc) {
                case 1: //Cadastrar
                    System.out.println("Nome:"); String nome = sc.nextLine();
                    System.out.println("CPF:"); int cpf = sc.nextInt(); sc.nextLine();
                    System.out.println("Endereço:"); String endereco = sc.nextLine();
                    System.out.println("Email:"); String email = sc.nextLine();
                    System.out.println("Data de Nascimento:"); String dataNasc = sc.nextLine();
                    System.out.println("Tipo Sanguíneo:"); String tipoSangue = sc.nextLine();
                    System.out.println("Quantidade de alergias:"); int nAlergias = sc.nextInt(); sc.nextLine();
                    List<String> alergias = new ArrayList<>();
                    for(int i=0; i<nAlergias; i++) {
                        System.out.println("Alergia " + (i+1) + ":"); 
                        alergias.add(sc.nextLine());
                    }
                    Paciente p = new Paciente(idPaciente++, tipoSangue, nome, cpf, endereco, email, dataNasc);
                    for(String al : alergias) p.adicionarAlergia(al);
                    pacientes.add(p);
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;

                case 2: //Listar
                    for(Paciente px : pacientes) {
                        px.exibirDados(); System.out.println();
                    }
                    break;

                case 3: //Atualizar
                    Paciente pacAtualizar = escolherPaciente();
                    if(pacAtualizar != null) {
                        pacAtualizar.atualizarDados();
                        System.out.println("Paciente atualizado com sucesso!");
                    } else System.out.println("Paciente não encontrado.");
                    break;

                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    //Gerenciamento Med
    public static void gerenciarMedicos() {
        while(true) {
            System.out.println("\n--- Gerenciar Médicos ---");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Listar Médicos");
            System.out.println("3 - Atualizar Médico");
            System.out.println("0 - Voltar");

            int opc = sc.nextInt(); sc.nextLine();
            switch(opc) {
                case 1: //Cadastrar
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

                case 2: //Listar
                    for(Medico mx : medicos) { mx.exibirDados(); System.out.println(); }
                    break;

                case 3: //Atualizar
                    Medico medAtualizar = escolherMedico();
                    if(medAtualizar != null) {
                        medAtualizar.atualizarDados();
                        System.out.println("Médico atualizado com sucesso!");
                    } else System.out.println("Médico não encontrado.");
                    break;

                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    //Gerenciamento
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
                case 1: //Agendar
                    if(pacientes.isEmpty() || medicos.isEmpty()) { System.out.println("Sem pacientes ou médicos."); break; }
                    Paciente pac = escolherPaciente();
                    Medico med = escolherMedico();
                    System.out.println("Data (dd/mm/aaaa):"); String data = sc.nextLine();
                    System.out.println("Hora (hh:mm):"); String hora = sc.nextLine();
                    Consulta c = new Consulta(idConsulta++, pac, med, data, hora);
                    agenda.marcarConsulta(c);
                    System.out.println("Consulta agendada!");
                    break;

                case 2: //Histórico do paciente
                    Paciente pacHist = escolherPaciente();
                    if(pacHist != null) {
                        List<Consulta> historico = agenda.buscarConsultasPorpaciente(pacHist);
                        for(Consulta cx : historico) cx.imprimirConsulta();
                    }
                    break;

                case 3: //Consultas do médico
                    Medico medHist = escolherMedico();
                    if(medHist != null) {
                        List<Consulta> consMed = agenda.buscarConsultasPorMedico(medHist);
                        for(Consulta cx : consMed) cx.imprimirConsulta();
                    }
                    break;
                case 4: //Remarcar
                    Paciente pacRem = escolherPaciente();
                    if(pacRem != null) {
                        List<Consulta> consPac = agenda.buscarConsultasPorpaciente(pacRem);
                        if(consPac.isEmpty()) { System.out.println("Nenhuma consulta encontrada."); break; }
                        for(int i = 0; i < consPac.size(); i++) {
                            System.out.println(i + " - ");
                            consPac.get(i).imprimirConsulta();
                        }
                        System.out.println("Selecione a consulta pelo número:"); int idx = sc.nextInt(); sc.nextLine();
                        if(idx >= 0 && idx < consPac.size()) {
                            System.out.println("Nova data:"); String novaData = sc.nextLine();
                            System.out.println("Nova hora:"); String novaHora = sc.nextLine();
                            consPac.get(idx).remarcarConsulta(novaData, novaHora);
                            System.out.println("Consulta remarcada!");
                        } else System.out.println("Seleção inválida.");
                    }
                    break;

                case 5: //Alterar status
                    Paciente pacStatus = escolherPaciente();
                    if(pacStatus != null) {
                        List<Consulta> consPac = agenda.buscarConsultasPorpaciente(pacStatus);
                        if(consPac.isEmpty()) { System.out.println("Nenhuma consulta encontrada."); break; }
                        for(int i = 0; i < consPac.size(); i++) {
                            System.out.println(i + " - ");
                            consPac.get(i).imprimirConsulta();
                        }
                        System.out.println("Selecione a consulta pelo número:"); int idx = sc.nextInt(); sc.nextLine();
                        if(idx >= 0 && idx < consPac.size()) {
                            System.out.println("Novo status (Agendada / Cancelada / Realizada):");
                            String novoStatus = sc.nextLine();
                            consPac.get(idx).setStatusConsulta(novoStatus);
                            System.out.println("Status atualizado!");
                        } else System.out.println("Seleção inválida.");
                    }
                    break;

                case 6: //Salvar histórico em TXT
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

    //Relatorios
    public static void gerarRelatorios() {
        System.out.println("\n--- Relatório ---");
        System.out.println("Total de Pacientes: " + pacientes.size());
        System.out.println("Total de Médicos: " + medicos.size());
        System.out.println("Total de Consultas: " + agenda.buscarConsultasPorData("").size());
    }

    //Salvamentos
    public static void salvarDados() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados_clinica.dat"));
            oos.writeObject(pacientes);
            oos.writeObject(medicos);
            oos.writeObject(agenda);
            oos.close();
            System.out.println("Dados salvos com sucesso!");
        } catch(Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    @SuppressWarnings("unchecked")
    public static void carregarDados() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados_clinica.dat"));
            pacientes = (ArrayList<Paciente>) ois.readObject();
            medicos = (ArrayList<Medico>) ois.readObject();
            agenda = (Agenda) ois.readObject();
            ois.close();
        } catch(Exception e) {
            System.out.println("Nenhum dado encontrado. Iniciando nova clínica.");
        }
    }

    //Metodos auxiliares
    private static Paciente escolherPaciente() {
        System.out.println("Selecione o paciente (ID):");
        for(Paciente px : pacientes) System.out.println(px.id + " - " + px.getNome());
        int id = sc.nextInt(); sc.nextLine();
        for(Paciente px : pacientes) if(px.id == id) return px;
        System.out.println("Paciente não encontrado.");
        return null;
    }
    private static Medico escolherMedico() {
        System.out.println("Selecione o médico (ID):");
        for(int i=0;i<medicos.size();i++) System.out.println(i + " - " + medicos.get(i).getNome());
        int id = sc.nextInt(); sc.nextLine();
        if(id >=0 && id < medicos.size()) return medicos.get(id);
        System.out.println("Médico não encontrado.");
        return null;
    }
    private static void salvarHistoricoTXT(Paciente p, List<Consulta> consultas) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(p.getNome() + "_historico.txt"));
            writer.write("Histórico de Consultas do paciente: " + p.getNome() + "\n\n");
            for(Consulta c : consultas) c.imprimirConsulta();
            writer.close();
        } catch(IOException e) { System.out.println("Erro ao salvar arquivo: " + e.getMessage()); }
    }
}
