package ada.tech.projetoweb2.repository;

import ada.tech.projetoweb2.model.entity.CategoriaEntity;
import ada.tech.projetoweb2.model.entity.EditoraEntity;
import ada.tech.projetoweb2.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity,Integer> {
    List<LivroEntity> findByCategoria(CategoriaEntity categoria);
    List<LivroEntity> findByEditora(EditoraEntity categoria);
    List<LivroEntity> findByNomeOrIsbn(String nome, String isbn);
}
