package resume.visitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import resume.visitor.model.VisitorModel;

@Repository
public interface VisitorRepository extends JpaRepository<VisitorModel, String> {
    @Query(nativeQuery = true,  value =
            "SELECT COUNT()" +
            "FROM visitor" +
            "WHERE reaction=true")
    long howManyReactions();
}
