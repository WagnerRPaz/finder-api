package com.finder.finderapi.worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerDTO {
    private Long worker_id;
    private String full_name;
    private LocalDate birth_date;
    private String phone;
    private String email;
    private String cpf;
    private String city;
    private String categoryName;
    private Integer experience;
    private String summary;
    private MultipartFile photoFile;
    private WorkerStatus status;
    private String photoBase64;
}
