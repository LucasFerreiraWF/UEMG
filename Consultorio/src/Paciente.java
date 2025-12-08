import java.util.ArrayList;
import java.util.Scanner;
//Importacao para print e criacao de listas

//Paciente herda da classe pessoa(Herança)
public class Paciente extends Pessoa
{
    //atributos privados exceto pelo Id, que nao e uma informacao sensivel e pode ser acessada externamente
    //Encapsulamento
    public int id;
    private String tipoSanguineo;
    private ArrayList<String> alergias;
    private boolean ativo;

    
    //getters
    public String getTipoSanguineo() {return tipoSanguineo;}
    public ArrayList<String> getAlergias() {return alergias;}
    public boolean isAtivo() {return ativo;}
    //setters
    public void setTipoSanguineo(String tipoSanguineo) {this.tipoSanguineo = tipoSanguineo; }
    public void setAtivo(boolean ativo) {this.ativo = ativo;}
    public void setId(int id) {this.id = id; }

    //Construtor da classe; define valores iniciais
    public Paciente(int id, String tipoSanguineo, String nome, int cpf, String endereco, String email, String dataNascimento)
    {
        //Chama o construtor da classe pai
        super(nome, cpf, endereco, email, dataNascimento);
        this.id = id;
        this.tipoSanguineo = tipoSanguineo;
        this.alergias = new ArrayList<>();
        ativo = true;
    }

    //Printa os dados privados da classe
    public void exibirDados()
    {
        System.out.println(String.format("Id: %d - [%s]", id, ativo ? "Ativo" : "Inativo"));
        super.exibirDados();
        System.out.println(String.format("Tipo sanguineo: %s", tipoSanguineo));
    }

    //Exibe menu para atualizar os dados do objeto
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
            System.out.println("5. Tipo sanguineo");
            System.out.println("6. Ativar/Desativar paciente");
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
                    System.out.print("Tipo sanguineo correto: ");
                    String tipoSanguineo = scan.nextLine();
                    this.tipoSanguineo = tipoSanguineo;
                    System.out.println("Tipo sanguineo atualizada com sucesso.");
                    break;
                case 6:
                    ativo = !ativo;
                    System.out.println(String.format("[%s]", ativo ? "Ativo" : "Inativo"));
                    break;
                default:
                    break;
            }
        } while (escolha != 0);
    }

    //Adiciona uma nova alergia a lista
    public void adicionarAlergia(String alergia)
    {
        if (alergia == null || alergia.isEmpty())
        {
            System.out.println("Insira uma alergia valida.");
            return;
        }

        if (alergias.contains(alergia))
        {
            System.out.println("Alergia ja adicionada.");
            return;
        }

        alergias.add(alergia);
        System.out.println("Alergia adicionada com sucesso");
    }
}
