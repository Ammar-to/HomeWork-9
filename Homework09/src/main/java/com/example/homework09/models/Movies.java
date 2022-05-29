package com.example.homework09.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "movies")
public class Movies {
    @Id
    private Integer id;

    @NotNull @Size(min = 3)
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull @Pattern(regexp = "(?i)(Drama|Action|Comedy)")
    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    @Range(min = 1, max = 5) @Positive
    private Integer rating;

    @Column(nullable = false)
    @Positive @Range(min = 60)
    private Double duration;

    @Column(nullable = false)
    private LocalDate date;
}
