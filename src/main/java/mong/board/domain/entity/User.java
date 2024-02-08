package mong.board.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User extends BaseEntity { // 엔티티 데이터베이스 테이블 작성

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(updatable = false)
    private String nick;

    @Enumerated(EnumType.STRING)
    private  Role role;

    @Column(length = 1000)
    private String refreshToken;

    public void updateNick(String nick) {

        this.nick = nick;
    }
    // 사용자의 비밀번호를 hash 화 시켜줌
//    public void passwordEncode(PasswordEncoder passwordEncoder) {
//
//        this.password = passwordEncoder.encode(password);
//    }

    // 어디서든접근가능 메서드반환값없음 메서드명 (매개변수){
    // this.인스턴스변수가 들어오면 refreshToken 에 넣어줘
    public void updateRefreshToken(String refreshToken) {

        this.refreshToken = refreshToken;
    }

    public void deleteRefreshToken() {

        this.refreshToken = null;
    }


    // 한 명의 사용자는 여러 게시글을 올릴 수 있다. 1:N 관계
    // cascade = CascadeType.ALL = 연관관계가 때문에 User 를 삭제하면 해당 사용자의 게시글들도 함께 삭제하기 위해
    // mappedBy = "user" 가 owner
    // featch = FetchType.LAZY = 연관된 엔티티에 접근할 때 데이터베이스에서 가져온다
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boards;
}
