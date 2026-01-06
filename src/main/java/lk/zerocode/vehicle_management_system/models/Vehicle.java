package lk.zerocode.vehicle_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private String capacity;

    @ManyToOne
    private Model model;

}
