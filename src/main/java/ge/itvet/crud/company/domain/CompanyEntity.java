package ge.itvet.crud.company.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company", schema = "crud")
public class CompanyEntity {
    @Id
    @SequenceGenerator(sequenceName = "crud_ID_SEQ", name = "crud_ID_GEN", schema = "crud")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crud_ID_GEN")
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

    @Column(nullable = false, name = "release_date")
    private LocalDate releaseDate;
}