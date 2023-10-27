package cloud.tickethub.theventservice.event.service;

import cloud.tickethub.theventservice.event.domain.Event;
import cloud.tickethub.theventservice.event.domain.EventPhoto;
import cloud.tickethub.theventservice.event.dto.EventPhotoDto;
import cloud.tickethub.theventservice.event.dto.EventPhotoPostDto;
import cloud.tickethub.theventservice.event.infra.EventPhotoRepo;
import cloud.tickethub.theventservice.event.infra.EventRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class EventPhotoServiceImpl implements EventPhotoService {

    @Autowired
    private EventPhotoRepo eventPhotoRepo;

    @Autowired
    private EventRepo eventRepo;


    @Override
    public EventPhotoDto getImage(String id) {
        var dto = new EventPhotoDto();
        var picture = eventPhotoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        BeanUtils.copyProperties(picture, dto);
        return dto;
    }

    @Override
    public EventPhotoDto postImage(EventPhotoPostDto dto) throws Exception {

        String imageId = UUID.randomUUID().toString();
        Event event = eventRepo.findById(dto.getEventId()).orElseThrow(() -> new RuntimeException("Event not found"));

        eventPhotoRepo.deleteAllByEvent(event);


        var userImage = EventPhoto.builder()
                .id(imageId)
                .contentType(dto.getOriginalPhoto().getContentType())
                .createdBy(dto.getCreatedBy())
                .fileContent(dto.getOriginalPhoto().getBytes())
                .originalPhotoName(dto.getOriginalPhoto().getOriginalFilename())
                .photoSize(dto.getOriginalPhoto().getSize())
                .createOn(LocalDateTime.now(ZoneId.of("UTC")))
                .photoUrl("http://localhost:8080/api/v1/event/photo/" + imageId)
                .event(event)
                .build();
        eventPhotoRepo.save(userImage);

        return EventPhotoDto.builder()
                .id(imageId)
                .eventId(dto.getEventId())
                .originalPhotoName(dto.getOriginalPhoto().getOriginalFilename())
                .photoSize(dto.getOriginalPhoto().getSize())
                .contentType(dto.getOriginalPhoto().getContentType())
                .build();
    }

    @Override
    public void deleteImage(String id) {

        eventPhotoRepo.deleteById(id);
    }

    private byte[] thumbnail(MultipartFile file) throws IOException {
        int newWidth = 200;

        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();
        int newHeight = (int) (height * ((float) newWidth / (float) width));
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        resizedImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        ByteArrayOutputStream bass = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", bass);
        return bass.toByteArray();

    }
}
