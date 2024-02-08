package mong.board.controller;

import lombok.RequiredArgsConstructor;
import mong.board.controller.request.UserRequestDto;
import mong.board.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public Long join(@RequestBody UserRequestDto userDto) {

        System.out.println("들어옴");
        return userService.join(userDto);
    }
}
