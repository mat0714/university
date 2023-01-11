package pl.mateuszkolodziejczyk.university.teacher;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherApi {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Void> addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<Teacher>> getAllTeachers(@RequestParam int page, @RequestParam int size) {
        Page<Teacher> allTeachers = teacherService.getAllTeachers(page, size);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(allTeachers);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Teacher>> findTeacherBySurname(@RequestParam String surname) {
        List<Teacher> teachersBySurname = teacherService.findTeacherBySurname(surname);
        return ResponseEntity.status(HttpStatus.OK).body(teachersBySurname);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<TeacherStudentsDto> getStudentsBelongingToTeacher(@PathVariable Long id) {
        TeacherStudentsDto teacherStudentsDto = teacherService.getStudentsBelongingToTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(teacherStudentsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTeacher(@PathVariable Long id, @Valid @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
