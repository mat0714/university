package pl.mateuszkolodziejczyk.university.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mateuszkolodziejczyk.university.teacher.Teacher;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findBySurname(String surname);

    @Query("SELECT s.teachers FROM Student s WHERE s.id = :id")
    List<Teacher> findTeachersBelongingToStudent(@Param("id") Long id);
}
