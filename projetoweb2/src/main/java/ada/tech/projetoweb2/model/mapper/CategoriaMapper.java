package ada.tech.projetoweb2.model.mapper;

import ada.tech.projetoweb2.model.dto.CategoriaDTO;
import ada.tech.projetoweb2.model.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {

    public CategoriaDTO update(CategoriaEntity categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());
        return categoriaDTO;
    }

    public CategoriaEntity update(CategoriaDTO categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setNome(categoria.getNome());
        return categoriaEntity;
    }

    public List<CategoriaDTO> updateListDTO(List<CategoriaEntity> listaCategoria) {
        return listaCategoria.stream()
                .map(categoriaEntity ->
                        this.update(categoriaEntity))
                .toList();
    }

    public List<CategoriaEntity> updateListEntity(List<CategoriaDTO> listaCategoria){
        return listaCategoria.stream()
                .map(categoriaDTO->
                        this.update(categoriaDTO))
                .toList();
    }

}
