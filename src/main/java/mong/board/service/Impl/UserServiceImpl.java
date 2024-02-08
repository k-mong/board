package mong.board.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mong.board.controller.request.UserRequestDto;
import mong.board.domain.entity.User;
import mong.board.domain.repository.UserRepository;
import mong.board.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
//    private PasswordEncoder passwordEncoder;

    @Override
    public Long join(UserRequestDto reqDto) {
        // userRepo의 findByEmail 한다.(사용자로부터 요청해서.들어온이메일.값이존재하면true 아니면 false)
        if(userRepo.findByEmail(reqDto.getEmail()).isPresent()){
            // 예외발생 메서드 유요성검사
            throw new IllegalArgumentException("이미 존재하는 회원입니다");
        }

        User user = userRepo.save(reqDto.toEntity());
//        user.passwordEncode(passwordEncoder);
        return user.getId();
    }

    // 아이디 중복 체크
    public boolean checkEmail(String email){
        return userRepo.existByEmail(email);
    }

    //닉네임 중복 체크
    public boolean checkNick(String nick){
        return userRepo.existsByNick(nick);
    }

    


}
