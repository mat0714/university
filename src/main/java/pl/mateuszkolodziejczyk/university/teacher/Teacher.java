package pl.mateuszkolodziejczyk.university.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import pl.mateuszkolodziejczyk.university.student.Student;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Teacher {

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
    private String subject;
    @ManyToMany(mappedBy = "teachers")
    @Cascade(CascadeType.ALL)
    @JsonIgnore
    private List<Student> students;

    public Teacher(String name, String surname, int age, String email, String subject, List<Student> students) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.students = students;
    }

    public Teacher(String name, String surname, int age, String email, String subject) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.subject = subject;
    }
}
