package com.example.month9onlineshop.dto;

import com.example.month9onlineshop.entities.User;
import lombok.*;

import javax.validation.constraints.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTOSecond {

    public static UserDTOSecond from(User user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .accountName(user.getAccountName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
    private Long id;

    @NotNull
    @Size(min = 4, max = 128)
    private String name;


    @NotBlank
   // @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Account name can contains only letters and numbers")
    @Size(min = 4, max = 128)
    private String accountName;

    @NotNull
    @Email(message = "Email should be valid")
    @Size(min = 8, max = 128)
    private String email;

    @NotBlank
//    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password can contains only letters and numbers")
    @Size(min = 8, max = 24)
    private String password;
}
