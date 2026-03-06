
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda implements InterfaceAgenda{

    private ArrayList<Consulta> agendaMedica = new ArrayList<>();

    @Override
    public void cadastrarAgenda(Consulta consulta) {
        if (consulta == null)
        {
            System.out.println("Consulta nula adicionada!");
            return;
        }

        System.out.println("Consulta cadastrada com sucesso!");
        agendaMedica.add(consulta);
    }

    @Override
    public void editarConsulta(int codigo, Consulta consulta) {
        if (consulta == null)
        {
            for (Consulta c : agendaMedica)
            {
                if (c.getCodigo() == codigo)
                    consulta = c;
            }

            if (consulta == null)
            {
                System.out.println("Consulta invalida!");
                return;
            }
        }

        System.out.println("Editando consulta...");
        imprimirConsulta(codigo);
        int option = 0;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("...");
            System.out.println("O que deseja editar?");
            System.out.println("[0] Codigo");
            System.out.println("[1] Data");
            System.out.println("[2] Paciente");
            System.out.println("[3] Profissional");
            System.out.println("[4] Horario");
            System.out.println("[5] Descricao dos Sintomas");
            System.out.println("[6] Prescricao");

            System.out.println("\nOpcão:");
            option = Integer.parseInt(scan.next());

            switch (option) {
                case 0 :
                    System.out.println("Novo codigo: ");
                    int cod = Integer.parseInt(scan.next());
                    consulta.setCodigo(cod);
                break;
                case 1 :
                    {
                        System.out.println("Atualizar data: ");
                        System.out.println("Dia: ");
                        int dia = Integer.parseInt(scan.next());
                        System.out.println("Mes: ");
                        String mes = scan.next();
                        System.out.println("Ano: ");
                        int ano = Integer.parseInt(scan.next());
                        
                        Data novaData = new Data();
                        novaData.setDia(dia);
                        novaData.setMes(mes);
                        novaData.setAno(ano);

                        consulta.setData(novaData);
                    break;
                    }
                case 2 :
                    {
                        System.out.println("Atualizar Paciente: ");
                        Paciente paciente = new Paciente();

                        System.out.println("Nome: ");
                        String nome = scan.next();

                        paciente.setNome(nome);

                        System.out.println("CPF: ");
                        int cpf = Integer.parseInt(scan.next());

                        paciente.setCpf(cpf);

                        System.out.println("Data de nascimento: ");
                        System.out.println("Dia: ");
                        int dia = Integer.parseInt(scan.next());
                        System.out.println("Mes: ");
                        String mes = scan.next();
                        System.out.println("Ano: ");
                        int ano = Integer.parseInt(scan.next());

                        Data data = new Data();
                        data.setDia(dia);
                        data.setMes(mes);
                        data.setAno(ano);

                        paciente.setDataNascimento(data);

                        System.out.println("Plano de saude: ");
                        String plano = scan.next();

                        paciente.setPlanoSaude(plano);

                        System.out.println("Sexo: ");
                        String sexo = scan.next();

                        paciente.setSexo(sexo);

                        break;
                    }
                     case 3 :
                    {
                        System.out.println("Atualizar Profissional: ");
                        Profissional profissional = new Profissional();

                        System.out.println("Nome: ");
                        String nome = scan.next();

                        profissional.setNome(nome);

                        System.out.println("CPF: ");
                        int cpf = Integer.parseInt(scan.next());

                        profissional.setCpf(cpf);

                        System.out.println("Especialidade: ");
                        String especialidade = scan.next();

                        profissional.setEspecialidade(especialidade);

                        System.out.println("Titulacao: ");
                        String titulacao = scan.next();

                        profissional.setTitulacao(titulacao);

                        break;
                    }
                    case 4 :
                    {
                        System.out.println("Novo horario: ");
                        String horario = scan.next();
                        consulta.setHorario(horario);
                        break;
                    }
                    case 5 :
                    {
                        System.out.println("Registrar sintomas: ");
                        String sintomas = scan.next();
                        consulta.setDescricaoSintoma(sintomas);
                        break;
                    }
                    case 6 :
                    {
                        System.out.println("Adicionar prescricao: ");
                        String prescricao = scan.next();
                        consulta.setPrescricao(prescricao);
                        break;
                    }
                    default:
                    {
                        System.out.println("\n\nErro! Opção invalida!\n\n");
                        return;
                    }
            }

        }while(option >= 0);

        
    }

    @Override
    public void imprimirTodas() {
        System.out.println("Imprimindo agenda...\n\n");

        for(Consulta c : agendaMedica) 
            imprimirConsulta(c.getCodigo());
    }

    @Override
    public void imprimirConsulta(int codigo) {
        Consulta consulta = null;

        for (Consulta c : agendaMedica)
        {
            if (c.getCodigo() == codigo)
                consulta = c;
        }

        if (consulta == null)
        {
            System.out.println("Consulta invalida!");
            return;
        }

        Paciente paciente = consulta.getPaciente();
        Profissional profissional = consulta.getEspecialista();

        if (paciente == null || profissional == null)
        {
            System.out.println("Consulta Invalida! Paciente e/ou profissional nulo!");
            return;
        }

        System.out.println("\n-----------------------");
        String pacienteNome = paciente.getNome();
        String profissionalNome = profissional.getNome();
        String data = String.format("%02d/%s/%04d", consulta.getData().getDia(), consulta.getData().getMes(), consulta.getData().getAno());
        System.out.println(String.format("\nData: %s \nPaciente: %s \nEspecialista: %s ", data, pacienteNome, profissionalNome));
        if (consulta.getHorario() != "")
            System.out.println("Horario: " + consulta.getHorario());
        if (consulta.getDescricaoSintoma() != "")
            System.out.println("Descricao dos Sintomas: " + consulta.getDescricaoSintoma());
        if (consulta.getPrescricao() != "")
            System.out.println("Prescricao: " + consulta.getPrescricao());

        System.out.println("\n-----------------------");
    }
    
}
