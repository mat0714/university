package pl.mateuszkolodziejczyk.university.student;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(@RequestParam int page, @RequestParam int size) {
        Page<Student> allStudents = studentService.getAllStudents(page, size);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(allStudents);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> findStudentBySurname(@RequestParam String surname) {
        List<Student> studentsBySurname = studentService.findStudentBySurname(surname);
        return ResponseEntity.status(HttpStatus.OK).body(studentsBySurname);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<StudentTeachersDto> getTeachersBelongingToStudent(@PathVariable Long id) {
        StudentTeachersDto teachersBelongingToStudent = studentService.getTeachersBelongingToStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(teachersBelongingToStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
