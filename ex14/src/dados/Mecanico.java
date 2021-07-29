package dados;

public class Mecanico {
    private int codm;
    private String cpf;
    private String nome;
    private int idade;
    private String endereco;
    private String cidade;
    private String funcao;
    private int cods;

    public int getCodm() {
        return codm;
    }

    public void setCodm(int codm) {
        this.codm = codm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getCods() {
        return cods;
    }

    public void setCods(int cods) {
        this.cods = cods;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "codm=" + codm +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", funcao='" + funcao + '\'' +
                ", cods=" + cods +
                '}';
    }
}
