package pl.mateuszkolodziejczyk.university;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mateuszkolodziejczyk.university.student.Student;
import pl.mateuszkolodziejczyk.university.teacher.Teacher;
import pl.mateuszkolodziejczyk.university.teacher.TeacherService;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class UniversityApplication implements CommandLineRunner {

	private final TeacherService teacherService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) {
		List<Student> students = createStudents();
		addTeachersAndStudents(students);
	}

	private List<Student> createStudents() {
		Student student1 = new Student(
				"Marcin", "Kowalski", 21, "mkowal@gmail.com", "Budownictwo");
		Student student2 = new Student(
				"Adam", "Bocian", 22, "abocian@gmail.com", "Architektura");
		Student student3 = new Student(
				"Katarzyna", "Sobol", 23, "katsobo@gmail.com", "Architektura");
		Student student4 = new Student(
				"Bogdan", "Paluch", 24, "paluch@gmail.com", "Filozofia");
		Student student5 = new Student(
				"Anna", "Sarna", 22, "annas@gmail.com", "Towaroznawstwo");
		return List.of(student1, student2, student3, student4, student5);
	}

	private void addTeachersAndStudents(List<Student> students) {
		Teacher teacher1 = new Teacher(
				"Mirosław", "Wołoszyn", 65, "mwolo@pk.edu.pl", "Matematyka", students);
		Teacher teacher2 = new Teacher(
				"Władysław", "Burnejko", 62, "wladbu@pk.edu.pl", "Fizyka", students);
		Teacher teacher3 = new Teacher(
				"Andrzej", "Skoneczny", 34, "skone@pk.edu.pl", "Chemia", students);
		Teacher teacher4 = new Teacher(
				"Antonina", "Maliszewska", 55, "anto@pk.edu.pl", "Biologia", students);
		Teacher teacher5 = new Teacher(
				"Piotr", "Wołoszyn", 65, "pwolo@pk.edu.pl", "Matematyka", students);
		Teacher teacher6 = new Teacher(
				"Bartosz", "Skalniak", 34, "skal@pk.edu.pl", "Termodynamika");
		List<Teacher> teachers = List.of(teacher1, teacher2, teacher3, teacher4, teacher5);

		students.get(0).setTeachers(teachers);
		students.get(1).setTeachers(teachers);
		students.get(2).setTeachers(teachers);
		students.get(3).setTeachers(teachers);
		students.get(4).setTeachers(teachers);

		teacherService.addTeacher(teacher1);
		teacherService.addTeacher(teacher2);
		teacherService.addTeacher(teacher3);
		teacherService.addTeacher(teacher4);
		teacherService.addTeacher(teacher5);
		teacherService.addTeacher(teacher6);
	}
}
