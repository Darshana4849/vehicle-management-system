package lk.zerocode.vehicle_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "type")
//    private List<Model> modelList;

}
