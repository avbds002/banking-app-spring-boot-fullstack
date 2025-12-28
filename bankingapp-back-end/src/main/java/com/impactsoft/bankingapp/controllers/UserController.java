package com.impactsoft.bankingapp.controllers;

import com.impactsoft.bankingapp.entities.dto.userDtos.UserDTO;
import com.impactsoft.bankingapp.entities.dto.userDtos.UserPasswordDTO;
import com.impactsoft.bankingapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO userDto = userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> userDTOPage = userService.findAll(pageable);
        return ResponseEntity.ok(userDTOPage);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDto) {
        userDto = userService.insert(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDto) {
        userDto = userService.update(id, userDto);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(value = "/{id}/updatePassword")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UserPasswordDTO userDto) {
        userDto = userService.updatePassword(id, userDto.getCurrentPassword(), userDto.getNewPassword(), userDto.getConfirmPassword());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
