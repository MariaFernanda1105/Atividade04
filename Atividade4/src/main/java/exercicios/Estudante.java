package exercicios;

public class Estudante {
    private String nome;
    private int idade;
    private int nota;
    private Curso curso;
    private char sexo;  // M para homem, F para mulher

    // Construtor corrigido, agora o sexo está sendo passado como parâmetro
    public Estudante(String nome, int idade, int nota, Curso curso, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
        this.curso = curso;
        this.sexo = sexo; // Aqui estava o erro, agora o sexo está sendo corretamente atribuído
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getNota() {
        return nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public char getSexo() {
        return sexo;
    }

    // Método toString para facilitar a impressão do estudante
    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nota=" + nota +
                ", curso=" + curso.getNome() +  // Considerando que Curso tenha o método getNome()
                ", sexo=" + sexo +
                '}';
    }
}
