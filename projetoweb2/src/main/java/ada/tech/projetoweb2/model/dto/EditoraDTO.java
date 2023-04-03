package ada.tech.projetoweb2.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditoraDTO {

    private Long id;

    @Size(max=255,message="Tamanho do nome acima do permitido.")
    @NotBlank(message="Nome deve conter algum valor.")
    private String nome;

    private String descricao;
}
