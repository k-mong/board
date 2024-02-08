package mong.board.controller.response;

import lombok.Getter;
import mong.board.domain.entity.User;

@Getter
public class UserResponseDto {  // 서버에서 클라이언트로 보내는 중개 역활

    private final Long id;
    private final String email;
    private final String password;
    private final String nick;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nick = user.getNick();
    }
}
