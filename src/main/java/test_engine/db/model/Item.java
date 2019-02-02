package test_engine.db.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
@EqualsAndHashCode(callSuper = false)
public class Item {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse_id;

}
