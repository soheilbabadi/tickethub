package cloud.tickethub.theventservice.event.service;

import cloud.tickethub.theventservice.event.domain.EventPhotoDto;
import cloud.tickethub.theventservice.event.domain.EventPhotoPostDto;

public interface EventPhotoService {
    EventPhotoDto getImage(String id) throws Exception;

    EventPhotoDto postImage(EventPhotoPostDto dto) throws Exception;

    void deleteImage(String id) throws Exception;
}
