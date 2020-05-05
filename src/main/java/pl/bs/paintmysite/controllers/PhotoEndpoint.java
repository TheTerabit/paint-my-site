package pl.bs.paintmysite.controllers;


import org.springframework.web.bind.annotation.*;
import pl.bs.paintmysite.controllers.msg.PhotoMsg;
import pl.bs.paintmysite.models.Photo;
import pl.bs.paintmysite.services.PhotoService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/photos")
public class PhotoEndpoint {

    private final PhotoService photoService;

    public PhotoEndpoint(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getAll() {
        return photoService.getAll();
    }

    @GetMapping("/{id}")
    public Photo getById(@PathVariable("id") Long id) {
        return photoService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody PhotoMsg photoMsg) {
        photoService.create(photoMsg);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody PhotoMsg photoMsg) {
        photoService.update(id, photoMsg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        photoService.delete(id);
    }
}
