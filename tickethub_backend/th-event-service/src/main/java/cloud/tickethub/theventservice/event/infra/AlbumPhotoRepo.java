package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.AlbumPhoto;
import cloud.tickethub.theventservice.event.domain.EventAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumPhotoRepo extends JpaRepository<AlbumPhoto, Long> {

    List<AlbumPhoto> findAllByEventAlbumOrderByCreatedByDesc(EventAlbum album);
}
