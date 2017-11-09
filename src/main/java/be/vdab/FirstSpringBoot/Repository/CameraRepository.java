package be.vdab.FirstSpringBoot.Repository;

import be.vdab.FirstSpringBoot.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Integer> {
}
