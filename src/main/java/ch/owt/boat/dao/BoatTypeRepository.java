package ch.owt.boat.dao;

import ch.owt.boat.entity.BoatType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoatTypeRepository extends JpaRepository<BoatType, Long> {
}
