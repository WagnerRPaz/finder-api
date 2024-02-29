package com.finder.finderapi.exptions;

public class WorkerNotFoundException extends RuntimeException {

    public WorkerNotFoundException(String msg, Long worker_id) {
        super(msg + worker_id);
    }
}
