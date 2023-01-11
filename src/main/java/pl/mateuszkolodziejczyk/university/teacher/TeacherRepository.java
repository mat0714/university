package pl.mateuszkolodziejczyk.university.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mateuszkolodziejczyk.university.student.Student;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE surname = :surname")
    List<Teacher> findBySurname(@Param("surname") String surname);

    @Query("SELECT t.students FROM Teacher t WHERE t.id = :id")
    List<Student> findStudentsBelongingToTeacher(@Param("id") Long id);
}
