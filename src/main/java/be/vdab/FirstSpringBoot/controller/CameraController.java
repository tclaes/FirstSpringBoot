package be.vdab.FirstSpringBoot.controller;

import be.vdab.FirstSpringBoot.Service.CameraService;
import be.vdab.FirstSpringBoot.model.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CameraController {

    private final CameraService service;

    @Autowired
    public CameraController(CameraService service) {
        this.service = service;
    }

    @RequestMapping("/cameras")
    public List<Camera> showCameras(){
        return service.allCameras();
    }

    @PostMapping("/cameras")
    public void addCamera(@RequestBody Camera c){
        service.addCamera(c);
    }

    @GetMapping("/cameras/{id}")
    public Camera getCameraById(@PathVariable Integer id){
        return service.getOneCamera(id);
    }

    @DeleteMapping("/cameras/{id}")
    public void deleteCamera(@PathVariable Integer id){
        service.deleteCamera(id);
    }

    @PostMapping("/cameras/update")
    public void updateCamera(@RequestBody Camera id){
        service.updateCamera(id);
    }


}
