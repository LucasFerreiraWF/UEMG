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
    public int getId() { return id; }
    public String getTipoSanguineo() { return tipoSanguineo; }
    public ArrayList<String> getAlergias() { return alergias; }
    public boolean isAtivo() { return ativo; }

    //setters
    public void setTipoSanguineo(String tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public void setId(int id) { this.id = id; }

    //Construtor da classe; define valores iniciais
    public Paciente(int id, String tipoSanguineo, String nome, int cpf, String endereco, String email, String dataNascimento)
    {
        super(nome, cpf, endereco, email, dataNascimento);   //Chama o construtor da classe pai
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

        if (alergias.isEmpty()) {
            System.out.println("Alergias: Nenhuma cadastrada");
        } else {
            System.out.println("Alergias:");
            for (String a : alergias) {
                System.out.println(" - " + a);
            }
        }
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
            System.out.println("1. Nome");
            System.out.println("2. Endereço");
            System.out.println("3. E-mail");
            System.out.println("4. Data de Nascimento");
            System.out.println("5. Tipo sanguineo");
            System.out.println("6. Ativar/Desativar paciente");
            System.out.println("7. Adicionar alergia");
            System.out.println("0. Sair da Atualização");
            System.out.print("Opção: ");

            escolha = scan.nextInt(); scan.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Novo Nome: ");
                    setNome(scan.nextLine());
                    break;

                case 2:
                    System.out.print("Novo Endereço: ");
                    setEndereco(scan.nextLine());
                    break;

                case 3:
                    System.out.print("Novo E-mail: ");
                    setEmail(scan.nextLine());
                    break;

                case 4:
                    System.out.print("Nova Data de Nascimento (dd/mm/aaaa): ");
                    setDataNascimento(scan.nextLine());
                    break;

                case 5:
                    System.out.print("Tipo sanguineo correto: ");
                    setTipoSanguineo(scan.nextLine());
                    break;

                case 6:
                    ativo = !ativo;
                    System.out.println(String.format("[%s]", ativo ? "Ativo" : "Inativo"));
                    break;

                case 7:
                    System.out.print("Digite a alergia: ");
                    adicionarAlergia(scan.nextLine());
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

