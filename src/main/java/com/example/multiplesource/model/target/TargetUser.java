package com.example.multiplesource.model.target;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "combined_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TargetUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String fullName;
    private String contact;
}
