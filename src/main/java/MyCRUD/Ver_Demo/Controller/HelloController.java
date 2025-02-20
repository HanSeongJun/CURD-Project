package MyCRUD.Ver_Demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String home() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/api/Ver_Demo")
    public List<String> Hello() {
        return Arrays.asList("리액트 스프링 ", "연결 성공");
    }
}
