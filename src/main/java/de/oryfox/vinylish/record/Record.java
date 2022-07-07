package de.oryfox.vinylish.record;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import de.oryfox.vinylish.ImageType;
import de.oryfox.vinylish.tags.Tag;
import de.oryfox.vinylish.track.Track;
import de.oryfox.vinylish.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String artist;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Track> tracks;
    private Integer releaseYear;
    private ImageType imageType = ImageType.NONE;
    private String color;
    private boolean limited;
    private boolean bootleg;
    @ManyToOne
    private User creator;
    @ManyToMany
    private List<Tag> tags;

    @JsonGetter("creator")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getCreator() {
        return creator != null ? creator.getId() : null;
    }
}
