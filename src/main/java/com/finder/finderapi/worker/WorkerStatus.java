package com.finder.finderapi.worker;

import lombok.Getter;

@Getter
public enum WorkerStatus {
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED");
    private final String status;

    WorkerStatus (String status){
        this.status= status;
    }
}
