package MyCRUD.Ver_Demo.Service;

import MyCRUD.Ver_Demo.User.Dto.UserDto;
import MyCRUD.Ver_Demo.User.Model.User;
import MyCRUD.Ver_Demo.User.Repository.UserRepository;
import MyCRUD.Ver_Demo.User.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")// application-test.yml 활성화
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll(); // 테스트 데이터 초기화
    }

    // 회원 저장 성공 테스트
    @Test
    public void saveUser_Success() {

        // given
        UserDto userDto = new UserDto("User1", "1234", "TestUser@naver.com");

        // when
        userService.save(userDto);

        // then
        User savedUser = userRepository.findByUsername(userDto.getUsername());
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo(userDto.getUsername());
    }

    // 회원 저장 예외 테스트
    @Test
    public void saveUser_Exception() {

        // given
        UserDto userDto = new UserDto("User1", "1234", "TestUser1@naver.com");
        UserDto userDto2 = new UserDto("User1", "1234", "TestUser2@naver.com");

        // when
        userService.save(userDto);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> userService.save(userDto2));

        // then
        assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
    }
}
