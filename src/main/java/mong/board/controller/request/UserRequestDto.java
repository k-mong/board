package mong.board.controller.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mong.board.domain.entity.Role;
import mong.board.domain.entity.User;

@Getter
@AllArgsConstructor
@Builder
public class UserRequestDto {   // 클라이언트에게 받아온 정보를 엔티티로 변환해주는 중개 역활

    private String email;
    private String password;
    private String nick;
    private Role role;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nick(nick)
                .role(role)
                .build();
    }

    public User toEntity(String encodedPassword){
        return User.builder()
                .email(this.email)
                .password(encodedPassword)
                .nick(this.nick)
                .role(Role.LOCAL)
                .build();
    }

}
