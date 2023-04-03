package ada.tech.projetoweb2.service;

import ada.tech.projetoweb2.model.dto.LivroDTO;
import ada.tech.projetoweb2.model.entity.CategoriaEntity;
import ada.tech.projetoweb2.model.entity.EditoraEntity;
import ada.tech.projetoweb2.model.entity.LivroEntity;
import ada.tech.projetoweb2.model.mapper.LivroMapper;
import ada.tech.projetoweb2.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroMapper mapper;

    public LivroDTO pegarPorId(Integer id) {

        Optional<LivroEntity> livroEntityOp =
                repository.findById(id);

        if(livroEntityOp.isPresent()) {
            LivroEntity livroEntity = livroEntityOp.get();
            return mapper.update(livroEntity);
        }

        throw new EntityNotFoundException("Livro não encontrado.");
    }

    public LivroDTO criar(LivroDTO livroDTO) {

        LivroEntity categoria = mapper.update(livroDTO);

        System.out.println(categoria);

        categoria = repository.save(categoria);

        return mapper.update(categoria);
    }

    public LivroDTO editar(LivroDTO livroDTO, Integer id) {

        if(repository.existsById(id)) {

            LivroEntity livroEntity = mapper.update(livroDTO);
            livroEntity.setId(Long.valueOf(id));
            livroEntity = repository.save(livroEntity);

            return mapper.update(livroEntity);
        }

        throw new EntityNotFoundException("Categoria não encontrada");
    }

    public void deletar(Integer id){
        Optional<LivroEntity> livroEntityOp =
                repository.findById(id);

        if(livroEntityOp.isPresent()) {
            LivroEntity livroEntity = livroEntityOp.get();
            repository.delete(livroEntity);
            return;
        }

        throw new EntityNotFoundException("Categoria não encontrada");
    }

    public List<LivroDTO> listar() {
        List<LivroEntity> listaEntities =  repository.findAll();
        return mapper.updateListDTO(listaEntities);
    }

    public List<LivroDTO> listarPorCategoria(Integer idCategoria) {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(Long.valueOf(idCategoria));
        List<LivroEntity> listaEntities =  repository.findByCategoria(categoria);
        return mapper.updateListDTO(listaEntities);
    }

    public List<LivroDTO> listarPorEditora(Integer idEditora) {
        EditoraEntity editora = new EditoraEntity();
        editora.setId(Long.valueOf(idEditora));
        List<LivroEntity> listaEntities =  repository.findByEditora(editora);
        return mapper.updateListDTO(listaEntities);
    }

    public List<LivroDTO> filtrar(String nome, String isbn) {
        List<LivroEntity> listaEntities =  repository.findByNomeOrIsbn(nome, isbn);
        return mapper.updateListDTO(listaEntities);
    }
}
