package ada.tech.projetoweb2.service;

import ada.tech.projetoweb2.model.dto.EditoraDTO;
import ada.tech.projetoweb2.model.entity.EditoraEntity;
import ada.tech.projetoweb2.model.mapper.EditoraMapper;
import ada.tech.projetoweb2.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository repository;

    @Autowired
    private EditoraMapper mapper;

    public EditoraEntity pegarEntityPorId(Integer id) {

        Optional<EditoraEntity> editoraEntityOp =
                repository.findById(id);

        if(editoraEntityOp.isPresent()) {
            return editoraEntityOp.get();
        }

        throw new EntityNotFoundException("Editora não encontrada.");
    }

    public EditoraDTO pegarPorId(Integer id) {

        return mapper.update(this.pegarEntityPorId(id));
    }

    public EditoraDTO criar(EditoraDTO editoraDTO) {

        EditoraEntity editora = mapper.update(editoraDTO);

        editora = repository.save(editora);

        return mapper.update(editora);
    }

    public EditoraDTO editar(EditoraDTO editoraDTO, Integer id) {

        if(repository.existsById(id)) {

            EditoraEntity editoraEntity = mapper.update(editoraDTO);
            editoraEntity.setId(Long.valueOf(id));
            editoraEntity = repository.save(editoraEntity);

            return mapper.update(editoraEntity);
        }

        throw new EntityNotFoundException("Editora não encontrada");
    }

    public void deletar(Integer id){
        Optional<EditoraEntity> editoraEntityOp =
                repository.findById(id);

        if(editoraEntityOp.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOp.get();
            repository.delete(editoraEntity);
            return;
        }

        throw new EntityNotFoundException("Editora não encontrada");
    }

    public List<EditoraDTO> listar() {
        List<EditoraEntity> listaEntities =  repository.findAll();
        return mapper.updateListDTO(listaEntities);
    }
}
