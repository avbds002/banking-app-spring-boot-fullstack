package com.impactsoft.bankingapp.services;

import com.impactsoft.bankingapp.entities.User;
import com.impactsoft.bankingapp.entities.dto.UserDTO;
import com.impactsoft.bankingapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(x -> new UserDTO(x));
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Resource not found!")
        );
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO userDto) {
        User entity = new User();
        copyDtoToEntity(userDto, entity);
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }


    private void copyDtoToEntity(UserDTO userDto, User entity) {
        entity.setCpf(userDto.getCpf());
        entity.setEmail(userDto.getEmail());
        entity.setPassword(userDto.getPassword());
    }
}
