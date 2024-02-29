package com.finder.finderapi.worker;

import com.finder.finderapi.category.CategoryEntity;

import com.finder.finderapi.reviews.ReviewsEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

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
    private Long worker_id;

    private String full_name;

    private LocalDate birth_date;

    private String phone;

    private String email;

    @CPF(message = "CPF inválido")
    private String cpf;

    private String city;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    private Integer experience;

    private String summary;

    @Lob
    private String photoBase64;

    @OneToMany(mappedBy = "worker")
    private List<ReviewsEntity> reviews;


    public WorkerEntity(String full_name, LocalDate birth_date, String phone, String email, String cpf, String city, CategoryEntity category, Integer experience, String summary, String photoBase64){
        this.full_name = full_name;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.experience = experience;
        this.summary = summary;
        this.cpf = cpf;
        this.city = city;
        this.photoBase64 = photoBase64;
    }

    public static WorkerDTO entityToDto(WorkerEntity entity){
        return new WorkerDTO(entity.worker_id,entity.full_name, entity.birth_date, entity.phone, entity.email, entity.cpf, entity.city, entity.category.getName(), entity.experience, entity.summary, null,entity.photoBase64);
    }

}
