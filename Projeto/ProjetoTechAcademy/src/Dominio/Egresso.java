package Dominio;

public class Egresso extends BasePessoa {

    private int anoConclusao;
    private String cursoFormacao;
    private String areaAtuacao;


    public int getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(int anoConclusao) {
        if (anoConclusao < 1900 || anoConclusao > 2100) {
            System.out.println("O ano de conclusão deve estar entre 1900 e 2100.");
            return;
            //Não implementado por não ter sido passado em sala de aula, mas poderia ser implementado com uma exceção
            //throw new IllegalArgumentException("O ano de conclusão deve estar entre 1900 e 2100.");
        }
        this.anoConclusao = anoConclusao;
    }

    public String getCursoFormacao() {
        return cursoFormacao;
    }

    public void setCursoFormacao(String cursoFormacao) {
        if (cursoFormacao == null || cursoFormacao.isEmpty()) {
            System.out.println("O curso de formação não pode ser nulo ou vazio.");
            return;
            //Não implementado por não ter sido passado em sala de aula, mas poderia ser implementado com uma exceção
            //throw new IllegalArgumentException("O curso de formação não pode ser nulo ou vazio.");
        }
        this.cursoFormacao = cursoFormacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        if (areaAtuacao == null || areaAtuacao.isEmpty()) {
            System.out.println("A área de atuação não pode ser nula ou vazia.");
            return;
            //Não implementado por não ter sido passado em sala de aula, mas poderia ser implementado com uma exceção
            //throw new IllegalArgumentException("A área de atuação não pode ser nula ou vazia.");
        }
        this.areaAtuacao = areaAtuacao;
    }

    public Egresso() {}

    public Egresso(int codigo, String nome, String cpf, int anoConclusao, String cursoFormacao, String areaAtuacao) {
        super(codigo, nome, cpf);
        this.anoConclusao = anoConclusao;
        this.cursoFormacao = cursoFormacao;
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public void exibir() {
        System.out.println("\n[EGRESSO] Código: " + this.codigo);
        System.out.println(" | Nome: " + this.nome);
        System.out.println(" | CPF: " + this.cpf);
        System.out.println(" | Ano de conclusão: " + this.anoConclusao);
        System.out.println(" | Curso de formação: " + this.cursoFormacao);
        System.out.println(" | Área de atuação: " + this.areaAtuacao);
    }
}
