package com.example.Javara.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private Long wantedVehicleId; //수배차량 id//pk

    @Column(nullable = false)
    private String vehicleNumber;//차량 번호

    @Column
    private String caseNumber; //사건 번호

    @Column
    private String crimeType; //범죄 유형

    @Column
    private String ownwr; // 소유자

    @Column
    private String wantedStatus; //수배차량 상태

    @Column
    private String memo; //메모

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 등록 날짜

    @Column
    private LocalDateTime updatedAt; // 업데이트 날짜

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
