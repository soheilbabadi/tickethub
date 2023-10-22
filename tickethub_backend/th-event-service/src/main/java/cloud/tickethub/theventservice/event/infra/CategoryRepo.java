package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
