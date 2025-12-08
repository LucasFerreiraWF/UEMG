//ListarConsultas() Somente o main tem acesso à agenda para poder filtrar e ver as consultas do médico

import java.util.ArrayList;
import java.util.Scanner;
//Importacao para print e criacao de listas

//Medico herda da classe pessoa, tendo acesso a tudo que esta como publico ou protegido
public class Medico extends Pessoa 
{
    // atributos privados exceto pelo Id, que nao e uma informacao sensivel e pode
    // ser acessada externamente
    private String especialidade;
    private String crm;
    private ArrayList<String> diasAtendimento;

    public Medico(String especialidade, String crm, String nome, int cpf, String endereco, String email,String dataNascimento) 
    {
        super(nome, cpf, endereco, email, dataNascimento);
        this.especialidade = especialidade;
        this.crm = crm;
        this.diasAtendimento = new ArrayList<>();
    }

    public void exibirDados() 
    {
        super.exibirDados();
        System.out.println(String.format("Especialidade: %s", especialidade));
        System.out.println(String.format("Crm: %s", crm));
    }

    public void atualizarDados() 
    {
        Scanner scan = new Scanner(System.in);
        int escolha;

        do
        {
            this.exibirDados();
            System.out.println("------ Atualizar Dados ------");
            System.out.println("Escolha o dado para atualizar:");
            System.out.println("1. Nome");
            System.out.println("2. Endereço");
            System.out.println("3. E-mail");
            System.out.println("4. Data de Nascimento");
            System.out.println("5. Especialidade");
            System.out.println("6. CRM");
            System.out.println("0. Sair da Atualização");
            System.out.print("Opção: ");

            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Novo Nome: ");
                    String nome = scan.nextLine();
                    setNome(nome);
                    System.out.println("Nome atualizado com sucesso.");
                    break;
                case 2:
                    System.out.print("Novo Endereço: ");
                    String endereco = scan.nextLine();
                    setEndereco(endereco);
                    System.out.println("Endereço atualizado com sucesso.");
                    break;
                case 3:
                    System.out.print("Novo E-mail: ");
                    String email = scan.nextLine();
                    setEmail(email);
                    System.out.println("E-mail atualizado com sucesso.");
                    break;
                case 4:
                    System.out.print("Nova Data de Nascimento (dd/mm/aaaa): ");
                    String dataNasc = scan.nextLine();
                    setDataNascimento(dataNasc);
                    System.out.println("Data de Nascimento atualizada com sucesso.");
                    break;
                case 5:
                    System.out.print("Nova especialidade: ");
                    String especialidade = scan.nextLine();
                    this.especialidade = especialidade;
                    System.out.println("especialidade atualizada com sucesso.");
                    break;
                case 6:
                    System.out.print("Novo CRM: ");
                    String crm = scan.nextLine();
                    this.crm = crm;
                    System.out.println("CRM atualizada com sucesso.");
                    break;
                default:
                    break;
            }
        } while (escolha != 0);
    }

}
