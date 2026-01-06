package lk.zerocode.vehicle_management_system.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String modelId;

//    @ManyToOne
//    private Type type;

    @OneToMany(mappedBy = "model")
    private List<Vehicle> vehicleList;

    @ManyToOne
    private Brand brand;


}
