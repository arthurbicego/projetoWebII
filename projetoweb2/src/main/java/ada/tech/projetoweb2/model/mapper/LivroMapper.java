package ada.tech.projetoweb2.model.mapper;

import ada.tech.projetoweb2.model.dto.LivroDTO;
import ada.tech.projetoweb2.model.entity.LivroEntity;
import ada.tech.projetoweb2.service.CategoriaService;
import ada.tech.projetoweb2.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroMapper {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private EditoraMapper editoraMapper;

    @Autowired
    private EditoraService editoraService;

    public LivroDTO update(LivroEntity livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setEditora_id(livro.getEditora().getId());
        livroDTO.setCategoria_id(livro.getCategoria().getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setIsbn(livro.getIsbn());
        return livroDTO;
    }

    public LivroEntity update(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setId(livro.getId());
        livroEntity.setEditora(editoraService.pegarEntityPorId(Math.toIntExact(livro.getEditora_id())));
        livroEntity.setCategoria(categoriaService.pegarEntityPorId(Math.toIntExact(livro.getCategoria_id())));
        livroEntity.setNome(livro.getNome());
        livroEntity.setIsbn(livro.getIsbn());
        return livroEntity;
    }

    public List<LivroDTO> updateListDTO(List<LivroEntity> listaLivro) {
        return listaLivro.stream()
                .map(livroEntity ->
                        this.update(livroEntity))
                .toList();
    }

    public List<LivroEntity> updateListEntity(List<LivroDTO> listaLivro){
        return listaLivro.stream()
                .map(livroDTO->
                        this.update(livroDTO))
                .toList();
    }

}
