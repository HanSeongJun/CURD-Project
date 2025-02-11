package MyCRUD.Ver_Demo.User.Service;

import MyCRUD.Ver_Demo.User.Dto.UserDto;
import MyCRUD.Ver_Demo.User.Model.User;
import MyCRUD.Ver_Demo.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
        userRepository.save(user);
    }
}
