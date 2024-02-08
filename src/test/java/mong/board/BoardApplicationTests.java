package mong.board;

import jakarta.transaction.Transactional;
import mong.board.domain.entity.Role;
import mong.board.domain.entity.User;
import mong.board.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class BoardApplicationTests {

	@Autowired
	UserRepository userRepo;

	@Test
	public void addUser() throws Exception {
		// given
		User user = User.builder()
				.email("test@email.com")
				.password("123123")
				.nick("testName")
				.role(Role.LOCAL)
				.build();
		// when
		User saveUSer = userRepo.save(user);

		// then
		User findUser = userRepo.findByEmail(saveUSer.getEmail()).orElseThrow(() -> new RuntimeException("없는 회원입니다."));
	}

}
