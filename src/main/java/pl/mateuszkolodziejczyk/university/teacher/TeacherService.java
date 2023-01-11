package pl.mateuszkolodziejczyk.university.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.mateuszkolodziejczyk.university.student.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Page<Teacher> getAllTeachers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("surname"));
        return teacherRepository.findAll(pageRequest);
    }

    public List<Teacher> findTeacherBySurname(String surname) {
        return teacherRepository.findBySurname(surname);
    }

    public TeacherStudentsDto getStudentsBelongingToTeacher(Long id) {
        List<Student> studentsBelongingToTeacher = teacherRepository.findStudentsBelongingToTeacher(id);
        return new TeacherStudentsDto(studentsBelongingToTeacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void updateTeacher(Long id, Teacher teacher) {
        Teacher teacherFromDb = teacherRepository.findById(id).orElseThrow(RuntimeException::new);
        teacherFromDb.setName(teacher.getName());
        teacherFromDb.setSurname(teacher.getSurname());
        teacherFromDb.setAge(teacher.getAge());
        teacherFromDb.setEmail(teacher.getEmail());
        teacherFromDb.setSubject(teacher.getSubject());
        teacherFromDb.setStudents(teacher.getStudents());
        teacherRepository.save(teacherFromDb);
    }
}
