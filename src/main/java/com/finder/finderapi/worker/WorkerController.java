package com.finder.finderapi.worker;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {
    @Autowired
    private final WorkerService service;

    @PostMapping("/newWorker")
    public ResponseEntity<?> workerRegister(@ModelAttribute @Valid WorkerDTO data) throws IOException {
        service.workerRegister(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/findWorker")
    public ResponseEntity<Page<WorkerDTO>>findWorker(@RequestParam String categoryName, Pageable pageable){
        Page<WorkerDTO> workers = service.getWorkerByCategory(categoryName, pageable);
        return  ResponseEntity.ok(workers);

    }

    @PostMapping("/acceptWorker/{workerId}")
    public ResponseEntity<?> acceptWorker(@PathVariable Long workerId) {
        service.updateWorkerStatusToAccepted(workerId);
        return ResponseEntity.ok().build();
    }
}