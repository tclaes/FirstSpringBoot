package be.vdab.FirstSpringBoot.Service;

import be.vdab.FirstSpringBoot.model.Camera;

import java.util.List;

public interface CameraService {

    List<Camera> allCameras();
    void addCamera(Camera camera);

    Camera getOneCamera(Integer id);

    void deleteCamera(Integer id);

    void updateCamera(Camera c);
}
