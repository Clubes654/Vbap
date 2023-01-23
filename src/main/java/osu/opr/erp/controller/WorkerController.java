package osu.opr.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osu.opr.erp.entity.Worker;
import osu.opr.erp.service.WorkerService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @PostMapping("/")
    public Worker saveWorker(@Valid @RequestBody Worker worker){
        return  workerService.saveWorker(worker);
    }

    @GetMapping("/")
    public List<Worker> findAllWorkers(){
        return workerService.findAllWorkers();
    }

    @GetMapping("/{id}")
    public Worker findWorkerById(@PathVariable Long id){
        return workerService.findWorkerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkerById(@PathVariable Long id) {
        workerService.deleteWorkerById(id);
    }




}
