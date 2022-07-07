package de.oryfox.vinylish.tags;

import de.oryfox.vinylish.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private short r;
    private short g;
    private short b;
    private short a;
    @ManyToOne
    private User creator;
}
