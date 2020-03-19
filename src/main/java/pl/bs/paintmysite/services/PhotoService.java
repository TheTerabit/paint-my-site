package pl.bs.paintmysite.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.bs.paintmysite.controllers.msg.PhotoMsg;
import pl.bs.paintmysite.models.Photo;
import pl.bs.paintmysite.repositories.PhotoRepository;

import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getAll() {
        return photoRepository.findAll();
    }

    public Photo getById(Long id) {
        return photoRepository.findById(id).orElseThrow(() -> new RuntimeException("Such photo does not exist."));
    }

    public void create(PhotoMsg photoMsg) {
        Photo photo = new Photo();
        photo.setProjectId(photoMsg.getProjectId());
        photo.setOrderInProject(photoMsg.getOrderInProject());
        photo.setUrl(photoMsg.getUrl());
        photoRepository.save(photo);
    }

    public void update(Long id, PhotoMsg photoMsg) {
        Photo photo = new Photo();
        photo.setProjectId(photoMsg.getProjectId());
        photo.setOrderInProject(photoMsg.getOrderInProject());
        photo.setUrl(photoMsg.getUrl());
        photo.setId(id);
        photoRepository.save(photo);
    }

    public void delete(Long id) {
        photoRepository.deleteById(id);
    }
}
