package ch.owt.boat.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="boat")
@Data
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private BoatType type;

}
