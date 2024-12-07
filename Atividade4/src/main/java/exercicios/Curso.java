package exercicios;

public class Curso implements Comparable<Curso> {
    private int id;
    private String nome;
    private int semestres;
    private Campus campus;

    public Curso() {
        // Construtor padrão
    }

    // Construtor com parâmetros (id, nome, semestres, campus)
    public Curso(int id, String nome, int semestres, Campus campus) {
        setId(id);
        setNome(nome);
        setSemestres(semestres);
        setCampus(campus);
    }

    // Construtor que aceita apenas o nome do curso
    public Curso(String nome) {
        this.nome = nome;
        this.id = 0;  // valor padrão
        this.semestres = 6;  // valor padrão
        this.campus = new Campus();  // Valor padrão (pode ser ajustado)
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestres() {
        return semestres;
    }

    public final void setSemestres(int semestres) {
        this.semestres = semestres;
    }

    public Campus getCampus() {
        return campus;
    }

    private void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return String.format("Id: %6d Nome: %-30s Semestres: %4d", id, nome, semestres);
    }

    @Override
    public int compareTo(final Curso other) {
        if (other == null) return 1;
        return this.nome.compareTo(other.nome);
    }
}
