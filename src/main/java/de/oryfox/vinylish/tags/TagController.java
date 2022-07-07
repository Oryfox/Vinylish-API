package de.oryfox.vinylish.tags;

import de.oryfox.vinylish.user.UserController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("tag")
@AllArgsConstructor
public class TagController {

    final TagRepository tagRepository;
    final UserController userController;

    @PostMapping
    public Tag createTag(@RequestHeader String token, @RequestBody Tag tag) {
        tag.setCreator(userController.check(token));
        return tagRepository.save(tag);
    }

    @GetMapping
    public List<Tag> getUserTags(@RequestHeader String token) {
        return tagRepository.findAllByCreator(userController.check(token));
    }

    @DeleteMapping
    public void deleteTag(@RequestHeader String token, @RequestParam Long id) {
        var user = userController.check(token);
        var opt = tagRepository.findByCreatorAndId(user, id);
        opt.ifPresent(tagRepository::delete);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
