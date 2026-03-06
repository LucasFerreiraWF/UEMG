public interface InterfaceAgenda {
    public abstract void cadastrarAgenda(Consulta consulta);
    public abstract void editarConsulta(int codigo, Consulta consulta);
    public abstract void imprimirTodos();
    public abstract void imprimirConsulta(int codigo);
}
