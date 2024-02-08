package mong.board.domain.repository;

import mong.board.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // email 로 사용자 정보 조회
    Optional<User> findByEmail(String email);
    // nuick 존재여부 중복된 닉네임 사용 불가
    boolean existsByNick(String nick);
    boolean existByEmail(String email);
}
