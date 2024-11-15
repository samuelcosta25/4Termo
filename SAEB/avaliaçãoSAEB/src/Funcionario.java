public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String setor;
    private String registro;
    private String cargo;
    private String contato;

    public Funcionario(String nome, String cpf, String setor, String registro, String cargo, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.setor = setor;
        this.registro = registro;
        this.cargo = cargo;
        this.contato = contato;
    }

    public Funcionario(int idFuncionario, String nome, String cpf, String setor, String registro, String cargo, String contato) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.setor = setor;
        this.registro = registro;
        this.cargo = cargo;
        this.contato = contato;
    }

    // Getters e setters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
