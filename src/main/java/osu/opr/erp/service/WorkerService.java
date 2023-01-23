package osu.opr.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osu.opr.erp.entity.Worker;
import osu.opr.erp.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public Worker saveWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).get();
    }

    public void deleteWorkerById(Long id) {
        workerRepository.deleteById(id);
    }
}
