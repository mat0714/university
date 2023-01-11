package pl.mateuszkolodziejczyk.university.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mateuszkolodziejczyk.university.teacher.Teacher;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    private String name;
    @NotBlank
    private String surname;
    @Min(18)
    private int age;
    @Email
    private String email;
    @NotBlank
    private String fieldOfStudy;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Teacher> teachers;

    public Student(String name, String surname, int age, String email, String fieldOfStudy) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.fieldOfStudy = fieldOfStudy;
    }
}