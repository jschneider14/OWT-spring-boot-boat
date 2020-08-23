package ch.owt.boat.dao;

import ch.owt.boat.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface BoatRepository extends JpaRepository<Boat, Long> {
}
