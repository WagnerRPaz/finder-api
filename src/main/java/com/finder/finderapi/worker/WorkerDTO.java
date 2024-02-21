package com.finder.finderapi.worker;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class WorkerDTO {
    String full_name;
    LocalDate birth_data;
    Integer phone;
    String email;
    String categoryName;
    Integer experience;
}
