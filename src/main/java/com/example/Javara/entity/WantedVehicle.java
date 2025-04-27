package com.example.Javara.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wanted_vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WantedVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wantedVehicleId;

    @Column(nullable = false)
    private String vehicleNumber;

    @Column
    private String caseNumber;

    @Column
    private String crimeType;

}
