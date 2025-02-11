package MyCRUD.Ver_Demo.User.Controller;

import MyCRUD.Ver_Demo.User.Dto.UserDto;
import MyCRUD.Ver_Demo.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok("User registered successfully");
    }
}
