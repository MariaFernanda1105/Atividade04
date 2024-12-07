package base;

import exercicios.Estudante;
import exercicios.StudentGenerator;
import exercicios.Curso;
import java.util.List;
import java.util.stream.Stream;

public abstract class Aula {
    public static final int TOTAL_ESTUDANTES = 30;
    public final StudentGenerator generator;
    public final List<Estudante> estudantes;

    public Aula() {
        generator = new StudentGenerator(); // Gerador de estudantes
        estudantes = generator.generateStudents(); // Gera os estudantes
    }

    // Calcula a maior nota entre todos os estudantes
    protected double maiorNotaTodosEstudantes(final Stream<Estudante> stream) {
        return stream
                .mapToDouble(Estudante::getNota)  // Converte os Estudantes em suas notas
                .max()                           // Obtém a maior nota
                .orElse(0);                      // Caso não haja estudantes, retorna 0
    }

    // Calcula a maior nota entre os estudantes homens
    protected double maiorNotaHomens(final Stream<Estudante> stream) {
        return stream
                .filter(e -> e.getSexo() == 'M')    // Filtra os homens
                .mapToDouble(Estudante::getNota)    // Converte os homens em suas notas
                .max()                               // Obtém a maior nota entre os homens
                .orElse(0);                          // Caso não haja homens, retorna 0
    }

    // Calcula a maior nota entre os estudantes de um curso e sexo específicos
    protected double maiorNotaCursoAndSexo(final Stream<Estudante> stream, final Curso curso, final char sexo) {
        return stream
                .filter(e -> e.getCurso().equals(curso))  // Filtra os estudantes do curso especificado
                .filter(e -> e.getSexo() == sexo)          // Filtra pelo sexo especificado
                .mapToDouble(Estudante::getNota)           // Converte os estudantes em suas notas
                .max()                                     // Obtém a maior nota
                .orElse(0);                                // Caso não haja estudantes, retorna 0
    }

    // Calcula a média das notas dos estudantes de um curso
    protected double mediaNotaTodosEstudantesCurso(final Stream<Estudante> stream, final Curso curso) {
        return stream
                .filter(e -> e.getCurso().equals(curso))  // Filtra os estudantes do curso
                .mapToDouble(Estudante::getNota)           // Converte os estudantes em suas notas
                .average()                                // Calcula a média das notas
                .orElse(0);                               // Caso não haja estudantes, retorna 0
    }

    // Conta o número total de estudantes de um curso e sexo
    protected long totalEstudantesCursoAndSexo(final Stream<Estudante> stream, final Curso curso, final char sexo) {
        return stream
                .filter(e -> e.getCurso().equals(curso))  // Filtra os estudantes do curso
                .filter(e -> e.getSexo() == sexo)          // Filtra pelo sexo
                .count();                                 // Conta o número de estudantes
    }
}
