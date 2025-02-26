package ge.itvet.crud.company.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class base {

    @Id
    @SequenceGenerator(sequenceName = "CRUD_ID_SEQ", name = "CRUD_ID_GEN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRUD_ID_GEN")
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String sphere;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private Double capital;
    @Column(nullable = false)
    private LocalDate releaseDate;

}
