package pl.mateuszkolodziejczyk.university.teacher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.mateuszkolodziejczyk.university.student.Student;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TeacherStudentsDto {

    private final List<Student> students;
}
