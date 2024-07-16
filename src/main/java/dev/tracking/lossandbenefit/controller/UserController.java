package dev.tracking.lossandbenefit.controller;

import dev.tracking.lossandbenefit.dto.PasswordUpdateRequest;
import dev.tracking.lossandbenefit.dto.UserDetailsDto;
import dev.tracking.lossandbenefit.dto.UserRegistrationDto;
import dev.tracking.lossandbenefit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @param userDto userDto
     * @return UserDetailsDto
     */
    @PostMapping("/register")
    public ResponseEntity<UserDetailsDto> registerUser(@RequestBody UserRegistrationDto userDto){
        UserDetailsDto registeredUser = userService.registerUser(userDto);
        return ResponseEntity.ok(registeredUser);
    }

    /**
     * @param username username
     * @return user
     */
    @GetMapping("/{username}")
    public ResponseEntity<UserDetailsDto> getUser(@PathVariable String username) {
        UserDetailsDto userDetailsDto = userService.getUserByUsername(username);
        return userDetailsDto != null ? ResponseEntity.ok(userDetailsDto): ResponseEntity.notFound().build();
    }

    /**
     * @param passwordUpdateRequest passwordUpdateRequest
     * @return updatePassword
     */
    @PostMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest passwordUpdateRequest) {
        boolean isUpdated = userService.updatePassword(
                passwordUpdateRequest.getUsername(),
                passwordUpdateRequest.getOldPassword(),
                passwordUpdateRequest.getNewPassword()
        );
        if (isUpdated) {
            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Old password is incorrect.");
        }
    }

    @GetMapping("/{username}/transactions")
    public ResponseEntity<UserDetailsDto> getUserWithTransactionsByUsername(@PathVariable String username){
        UserDetailsDto userDetailsDto = userService.getUserWithTransactionsByUsername(username);
        return userDetailsDto != null ? ResponseEntity.ok(userDetailsDto) : ResponseEntity.notFound().build();
    }
}
