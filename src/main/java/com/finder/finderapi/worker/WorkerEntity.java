package com.finder.finderapi.worker;

import com.finder.finderapi.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "worker")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long worker_id;

    String full_name;

    LocalDate birth_data;

    Integer phone;

    String email;

    @ManyToOne
    @JoinColumn(name = "category_id")
    CategoryEntity category;

    Integer experience;


    public WorkerEntity(String full_name, LocalDate birth_data, Integer phone, String email, CategoryEntity category, Integer experience){
        this.full_name = full_name;
        this.birth_data = birth_data;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.experience = experience;
    }

    public static WorkerDTO entityToDto(WorkerEntity entity){
        return new WorkerDTO(entity.worker_id,entity.full_name, entity.birth_data, entity.phone, entity.email, entity.category.getName(), entity.experience);
    }

}
