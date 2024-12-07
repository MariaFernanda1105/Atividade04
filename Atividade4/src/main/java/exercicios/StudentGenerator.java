package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentGenerator {
    // Lista de cursos disponíveis para os estudantes
    public static final Curso[] CURSOS = {
            new Curso("Matemática"),
            new Curso("Física"),
            new Curso("Química"),
            new Curso("Engenharia")
    };

    private static final Random random = new Random();

    /**
     * Gera uma lista de estudantes com dados aleatórios (nome, idade, nota e curso).
     *
     * @return Uma lista de estudantes gerados aleatoriamente.
     */
    public static List<Estudante> generateStudents() {
        List<Estudante> students = new ArrayList<>();
        String[] nomes = {"John", "Jane", "Tom", "Alice", "Bob", "Carol"};

        for (String nome : nomes) {
            int age = random.nextInt(10) + 18;  // Idade entre 18 e 27
            int grade = random.nextInt(10) + 1; // Nota entre 1 e 10
            Curso curso = CURSOS[random.nextInt(CURSOS.length)];  // Atribui um curso aleatório
            char sexo = random.nextBoolean() ? 'M' : 'F'; // Gera sexo aleatório (M ou F)

            // Cria o estudante e adiciona à lista
            students.add(new Estudante(nome, age, grade, curso, sexo));
        }

        return students;
    }
}
