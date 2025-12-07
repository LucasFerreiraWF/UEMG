public class Pessoa 
{//
    private String nome;
    private int cpf;
    private String endereco;
    private String email;
    private String dataNascimento;

    public Pessoa(String nome, int cpf, String endereco, String email, String dataNascimento)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public void exibirDados()
    {
        System.out.println(String.format("Nome: %s - Cpf: %d - Data de nascimento: ", nome, cpf, dataNascimento));
        System.out.println(String.format("endereco: %s - email: %s", endereco, email));
    }
}
