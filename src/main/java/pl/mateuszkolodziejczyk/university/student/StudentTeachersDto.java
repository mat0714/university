package pl.mateuszkolodziejczyk.university.student;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.mateuszkolodziejczyk.university.teacher.Teacher;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentTeachersDto {

    private final List<Teacher> teachers;
}