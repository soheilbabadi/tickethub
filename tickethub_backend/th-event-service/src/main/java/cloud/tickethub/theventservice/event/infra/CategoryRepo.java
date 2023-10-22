package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
