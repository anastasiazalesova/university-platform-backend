package info.bubna.up.controller;

import info.bubna.up.dto.WebDisciplineDTO;
import info.bubna.up.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}/disciplines")
    public List<WebDisciplineDTO> getDisciplines(@PathVariable("id") UUID id) {
        return userService.getDisciplines(id);
    }
}
