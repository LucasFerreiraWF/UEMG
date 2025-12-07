import java.util.ArrayList;
//
public class Paciente extends Pessoa
{
    public int id;
    private String tipoSanguineo;
    private ArrayList<String> alergias;
    private boolean ativo;

    public Paciente(String nome, int cpf, String endereco, String email, String dataNascimento)
    {
        super(nome, cpf, endereco, email, dataNascimento);
        
    }

    public void exibirDados()
    {
        System.out.println(String.format("Id: %d - [%s]", id, ativo ? "Ativo" : "Inativo"));
        super.exibirDados();
        System.out.println(String.format("Tipo sanguineo: %s", tipoSanguineo));
    }

    public void atualizarDados()
    {
        
    }

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
