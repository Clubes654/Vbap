package osu.opr.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osu.opr.erp.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
