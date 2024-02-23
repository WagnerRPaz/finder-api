package com.finder.finderapi.category;

import com.finder.finderapi.worker.WorkerEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    @OneToMany(mappedBy = "category")
    List<WorkerEntity> workers;


    public static  CategoryDTO entityToDto(CategoryEntity entity){
        return new CategoryDTO(entity.id, entity.name, entity.description);
    }
}