package Dominio;

public abstract class BasePrestador extends BasePessoa {

    protected String email;
    protected String telefone;
    protected String endereco;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            System.out.println("E-mail não pode ser nulo ou vazio.");
        }
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            System.out.println("Telefone não pode ser nulo ou vazio.");
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            System.out.println("Endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    public BasePrestador(int codigo, String nome, String cpf, String email, String telefone, String endereco) {
        super(codigo, nome, cpf);
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public BasePrestador(String email, String telefone, String endereco) {
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public BasePrestador() {}
}
