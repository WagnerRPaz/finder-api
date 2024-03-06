package com.finder.finderapi.worker;

import com.finder.finderapi.category.CategoryEntity;
import com.finder.finderapi.category.CategoryRepository;
import com.finder.finderapi.exptions.WorkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;
    public void workerRegister(WorkerDTO data) throws IOException {
        CategoryEntity category = categoryRepository.findByName(data.getCategoryName());
        WorkerStatus status = WorkerStatus.PENDING;

        String photoBase64 = null;
        if (data.getPhotoFile() != null && !data.getPhotoFile().isEmpty()) {
            MultipartFile photoFile = data.getPhotoFile();
            byte[] photoBytes = photoFile.getBytes();
            photoBase64 = Base64.getEncoder().encodeToString(photoBytes);
        }
        WorkerEntity newWorker = new WorkerEntity(
                data.getFull_name(),
                data.getBirth_date(),
                data.getPhone(),
                data.getEmail(),
                data.getCpf(),
                data.getCity(),
                category,
                data.getExperience(),
                data.getSummary(),
                status,
                photoBase64
        );
        repository.save(newWorker);
    }

    public Page<WorkerDTO> getWorkerByCategory(String categoryName, Pageable pageable) {


        CategoryEntity category = categoryRepository.findByName(categoryName);
        Sort sort = Sort.by("experience").descending();
        Pageable pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),sort);

        return repository.findByCategory(category, pageableWithSort).map(WorkerEntity::entityToDto);
    }

    public void updateWorkerStatusToAccepted(Long workerId) {
        Optional<WorkerEntity> optionalWorker = repository.findById(workerId);
        if (optionalWorker.isPresent()) {
            WorkerEntity worker = optionalWorker.get();
            worker.setStatus(WorkerStatus.ACCEPTED);
            repository.save(worker);
        } else {
            throw new WorkerNotFoundException("Trabalhador não encontrado: ", workerId);
        }
    }

    public void deleteWorker(Long workerId) {
        Optional<WorkerEntity> optionalWorker = repository.findById(workerId);
        if (optionalWorker.isPresent()) {
            repository.deleteById(workerId);
        } else {
            throw new WorkerNotFoundException("Trabalhador não encontrado: ", workerId);
        }
    }
}
