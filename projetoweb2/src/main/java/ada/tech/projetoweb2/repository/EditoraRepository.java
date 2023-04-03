package ada.tech.projetoweb2.repository;

import ada.tech.projetoweb2.model.entity.EditoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity,Integer> {
}
