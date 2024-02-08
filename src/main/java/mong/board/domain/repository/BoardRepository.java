package mong.board.domain.repository;

import mong.board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {   // 데이터베이스 테이블에 접근하는 메서드를 사용하기위한 인터페이스
}
