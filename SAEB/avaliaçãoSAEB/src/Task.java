public class Task {
    private int idTarefa;
    private String nome;
    private String status;
    private String dataPrevisao;
    private int idFuncionario;

    public Task(String nome, String status, String dataPrevisao, int idFuncionario) {
        this.nome = nome;
        this.status = status;
        this.dataPrevisao = dataPrevisao;
        this.idFuncionario = idFuncionario;
    }

    public Task(int idTarefa, String nome, String status, String dataPrevisao, int idFuncionario) {
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.status = status;
        this.dataPrevisao = dataPrevisao;
        this.idFuncionario = idFuncionario;
    }

    // Getters e setters
    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(String dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
