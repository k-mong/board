package mong.board.service;

import mong.board.controller.request.UserRequestDto;

public interface UserService {
    Long join(UserRequestDto reqDto);
}
