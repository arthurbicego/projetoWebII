package ada.tech.projetoweb2.model.mapper;

import ada.tech.projetoweb2.model.dto.EditoraDTO;
import ada.tech.projetoweb2.model.entity.EditoraEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditoraMapper {

    public EditoraDTO update(EditoraEntity editora) {
        EditoraDTO editoraDTO = new EditoraDTO();
        editoraDTO.setId(editora.getId());
        editoraDTO.setNome(editora.getNome());
        editoraDTO.setDescricao(editora.getDescricao());
        return editoraDTO;
    }

    public EditoraEntity update(EditoraDTO editora) {
        EditoraEntity editoraEntity = new EditoraEntity();
        editoraEntity.setId(editora.getId());
        editoraEntity.setNome(editora.getNome());
        editoraEntity.setDescricao(editora.getDescricao());
        return editoraEntity;
    }

    public List<EditoraDTO> updateListDTO(List<EditoraEntity> listaEditora) {
        return listaEditora.stream()
                .map(editoraEntity ->
                        this.update(editoraEntity))
                .toList();
    }

    public List<EditoraEntity> updateListEntity(List<EditoraDTO> listaEditora){
        return listaEditora.stream()
                .map(editoraDTO->
                        this.update(editoraDTO))
                .toList();
    }

}
