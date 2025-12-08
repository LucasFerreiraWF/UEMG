public class Pessoa 
{
    //Conceito de encapsulamento sendo aplicado.
    //Todos os dados sensiveis sao privados e so sao acessados por getters e setters
    private String nome;
    private int cpf;
    private String endereco;
    private String email;
    private String dataNascimento;

    //Construtor da classe; exige os valores iniciais
    public Pessoa(String nome, int cpf, String endereco, String email, String dataNascimento)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    //Printa todos os dados
    public void exibirDados()
    {
        System.out.println(String.format("Nome: %s - Cpf: %d - Data de nascimento: ", nome, cpf, dataNascimento));
        System.out.println(String.format("endereco: %s - email: %s", endereco, email));
    }

    //getter publico
    public String getNome() {return nome;}
    public int getCpf() {return cpf;}
    public String getEndereco() {return endereco;}
    public String getEmail() {return email;}
    public String getDataNascimento() {return dataNascimento;}

    //setter publico
    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(int cpf) {this.cpf = cpf;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setEmail(String email) {this.email = email;}
    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}
}
