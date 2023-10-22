package cloud.tickethub.theventservice.event.infra;

import cloud.tickethub.theventservice.event.domain.AlbumPhoto;
import cloud.tickethub.theventservice.event.domain.EventAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumPhotoRepo extends JpaRepository<AlbumPhoto, Long> {

    List<AlbumPhoto> findAllByEventAlbumOrderByCreatedByDesc(EventAlbum album);
}
