package be.vdab.FirstSpringBoot.Service;

import be.vdab.FirstSpringBoot.Repository.CameraRepository;
import be.vdab.FirstSpringBoot.model.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraRepository repository;

    @Override
    public List<Camera> allCameras() {
        return repository.findAll();
    }

    @Override
    public void addCamera(Camera camera) {
        Camera c = repository.saveAndFlush(camera);
        if(c==null){
            throw new RuntimeException("Camera niet gemaakt");
        }
    }

    @Override
    public Camera getOneCamera(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteCamera(Integer id) { repository.delete(id);

    }

    @Override
    public void updateCamera(Camera c) {
        System.out.println("Update");
        Camera cam = repository.findOne(c.getId());
        cam.setAantalMpx(c.getAantalMpx());
        cam.setLens(c.getLens());
        repository.saveAndFlush(cam);
    }
}
