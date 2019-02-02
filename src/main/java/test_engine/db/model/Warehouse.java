package test_engine.db.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
@Data
@EqualsAndHashCode(callSuper = false)
public class Warehouse {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

}
