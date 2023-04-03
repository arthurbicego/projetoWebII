package ada.tech.projetoweb2.service;

import ada.tech.projetoweb2.model.dto.CategoriaDTO;
import ada.tech.projetoweb2.model.entity.CategoriaEntity;
import ada.tech.projetoweb2.model.mapper.CategoriaMapper;
import ada.tech.projetoweb2.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaMapper mapper;

    public CategoriaEntity pegarEntityPorId(Integer id) {
        Optional<CategoriaEntity> categoriaEntityOp = repository.findById(id);

        if(categoriaEntityOp.isPresent()) {
            return categoriaEntityOp.get();
        }

        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public CategoriaDTO pegarPorId(Integer id) {
            return mapper.update(pegarEntityPorId(id));
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoria = mapper.update(categoriaDTO);

        categoria = repository.save(categoria);

        return mapper.update(categoria);
    }

    public CategoriaDTO editar(CategoriaDTO categoriaDTO, Integer id) {
        if(repository.existsById(id)) {

            CategoriaEntity categoriaEntity = mapper.update(categoriaDTO);
            categoriaEntity.setId(Long.valueOf(id));
            categoriaEntity = repository.save(categoriaEntity);

            return mapper.update(categoriaEntity);
        }

        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public void deletar(Integer id){
        Optional<CategoriaEntity> categoriaEntityOp =
                repository.findById(id);

        if(categoriaEntityOp.isPresent()) {
            CategoriaEntity categoriaEntity = categoriaEntityOp.get();
            repository.delete(categoriaEntity);
            return;
        }

        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public List<CategoriaDTO> listar() {
        List<CategoriaEntity> listaEntities =  repository.findAll();
        return mapper.updateListDTO(listaEntities);
    }

}
