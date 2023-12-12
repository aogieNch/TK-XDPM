package pm02.cameraWebSeller.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pm02.cameraWebSeller.data_access.entity.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
}
