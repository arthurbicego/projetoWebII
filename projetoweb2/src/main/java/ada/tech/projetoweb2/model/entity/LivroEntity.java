package ada.tech.projetoweb2.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private EditoraEntity editora;

    @ManyToOne
    private CategoriaEntity categoria;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

}
