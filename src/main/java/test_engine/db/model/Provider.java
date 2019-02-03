package test_engine.db.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Класс orm для сущности Provider.
 */
@Entity
@Table(name = "providers")
@NamedQuery(name = "Provider.findAll", query = "select p from Provider p")
@NamedQuery(name = "Provider.findById", query = "select distinct p from Provider p where p.id = :id")
@Data
@EqualsAndHashCode(callSuper = false)
public class Provider {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
