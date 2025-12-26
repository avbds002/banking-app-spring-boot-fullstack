package com.impactsoft.bankingapp.services;

import com.impactsoft.bankingapp.entities.User;
import com.impactsoft.bankingapp.entities.dto.userDtos.UserDTO;
import com.impactsoft.bankingapp.entities.dto.userDtos.UserPasswordDTO;
import com.impactsoft.bankingapp.repositories.UserRepository;
import com.impactsoft.bankingapp.services.exceptions.InvalidPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    /*
    * User features and methods
    * 1) login(email: String, password: String)
    * 2) logout(): void
    * 3) changePassword(currentPassword: String, newPassword: String): boolean
    * 4) validateCredentials(): boolean
    * */

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
        User user = new User();
        copyDtoToEntity(userDto, user);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    //Complete user update
    public UserDTO update(Long id, UserDTO userDto) {
        User user = userRepository.getReferenceById(id);
        copyDtoToEntity(userDto, user);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserPasswordDTO updatePassword(Long id, String currentPassword, String newPassword, String confirmPassword) {
        User user = userRepository.getReferenceById(id);

        if (!newPassword.equals(confirmPassword)) {
            throw new InvalidPasswordException("Passwords doesn't match!");
        }

        user.setPassword(newPassword);

        return new UserPasswordDTO(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void copyDtoToEntity(UserDTO userDto, User entity) {
        entity.setCpf(userDto.getCpf());
        entity.setEmail(userDto.getEmail());
        entity.setPassword(userDto.getPassword());
    }
}
