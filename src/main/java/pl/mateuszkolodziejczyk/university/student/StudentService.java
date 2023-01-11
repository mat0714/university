package pl.mateuszkolodziejczyk.university.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mateuszkolodziejczyk.university.teacher.Teacher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Page<Student> getAllStudents(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("surname"));
        return studentRepository.findAll(pageRequest);
    }

    public List<Student> findStudentBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }

    public StudentTeachersDto getTeachersBelongingToStudent(Long id) {
        List<Teacher> teachersBelongingToStudent = studentRepository.findTeachersBelongingToStudent(id);
        return new StudentTeachersDto(teachersBelongingToStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, Student student) {
        Student studentFromDb = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        studentFromDb.setName(student.getName());
        studentFromDb.setSurname(student.getSurname());
        studentFromDb.setAge(student.getAge());
        studentFromDb.setEmail(student.getEmail());
        studentFromDb.setFieldOfStudy(student.getFieldOfStudy());
        studentFromDb.setTeachers(student.getTeachers());
        studentRepository.save(studentFromDb);
    }

}