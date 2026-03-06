import java.util.Scanner;

public class App {
    public static void main(String[] args){
        
        int option = 1;
        Scanner scan = new Scanner(System.in);
        String lixo = "";

        Agenda agenda = new Agenda();

        do{
            System.out.println("...");
            System.out.println("MENU");
            System.out.println("[1] Agendar consulta");
            System.out.println("[2] [Medico] Editar consulta");
            System.out.println("[3] Imprimir consulta (index)");
            System.out.println("[4] Imprimir todas as consultas");

            System.out.println("\nOpcão:");
            option = Integer.parseInt(scan.next());

            switch (option) {
                case 1 :
                {
                    Consulta consulta = new Consulta();

                    System.out.println("Codigo: ");
                    int cod = Integer.parseInt(scan.next());
                    consulta.setCodigo(cod);

                    System.out.println("\nData da consulta: ");
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

                    //PACIENTE
                    System.out.println("\nDados do paciente: ");
                    Paciente paciente = new Paciente();
                    System.out.println("Nome: ");
                    String nomePaciente = scan.next();
                    paciente.setNome(nomePaciente);
                    System.out.println("CPF: ");
                    int cpfPaciente = Integer.parseInt(scan.next());
                    paciente.setCpf(cpfPaciente);
                    System.out.println("Data de nascimento: ");
                    System.out.println("Dia: ");
                    int diaNascPaciente = Integer.parseInt(scan.next());
                    System.out.println("Mes: ");
                    String mesNascPaciente = scan.next();
                    System.out.println("Ano: ");
                    int anoNascPaciente = Integer.parseInt(scan.next());
                    Data dataNascPaciente = new Data();
                    dataNascPaciente.setDia(diaNascPaciente);
                    dataNascPaciente.setMes(mesNascPaciente);
                    dataNascPaciente.setAno(anoNascPaciente);
                    paciente.setDataNascimento(dataNascPaciente);
                    System.out.println("Plano de saude: ");
                    String plano = scan.next();
                    paciente.setPlanoSaude(plano);
                    System.out.println("Sexo: ");
                    String sexo = scan.next();
                    paciente.setSexo(sexo);

                    consulta.setPaciente(paciente);

                    //PROFISSIONAL
                    System.out.println("\nDados do Profissional: ");
                    Profissional profissional = new Profissional();
                    System.out.println("Nome: ");
                    String nomeProf = scan.next();
                    profissional.setNome(nomeProf);
                    System.out.println("CPF: ");
                    int cpf = Integer.parseInt(scan.next());
                    profissional.setCpf(cpf);
                    System.out.println("Especialidade: ");
                    String especialidade = scan.next();
                    profissional.setEspecialidade(especialidade);
                    System.out.println("Titulacao: ");
                    String titulacao = scan.next();
                    profissional.setTitulacao(titulacao);

                    consulta.setEspecialista(profissional);

                    System.out.println("Horario: ");
                    String horario = scan.next();
                    consulta.setHorario(horario);

                    agenda.cadastrarAgenda(consulta);
                }
                break;
                case 2:
                {
                    System.out.println("Digite o codigo da consulta: ");
                    int codigo = Integer.parseInt(scan.next());
                    agenda.editarConsulta(codigo, null);
                    break;
                }
                case 3:
                {
                    System.out.println("Digite o codigo da consulta para impressao: ");
                    int codigo = Integer.parseInt(scan.next());
                    agenda.imprimirConsulta(codigo);
                    break;
                }
                case 4:
                {
                    agenda.imprimirTodas();
                    break;
                }
                default:
                {
                    System.out.println("\n\nErro! Opção invalida!\n\n");
                    return;
                }
            }
        }while(option >= 1);


        scan.close();
    }
}



                /*break;
                case 1 :
                    {
                        
                    break;
                    }
                case 2 :
                    {
                        

                        break;
                    }
                     case 3 :
                    {
                        
                    }
                    case 4 :
                    {
                        
                        break;*/