package com.blog.blogapplication.payloads;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    @NotEmpty
    @Size(min = 3, max = 20, message = "name min of 3 and max of 20 character")
    private String name;

    @Email(message = "email is not valid")
    private String email;

    @NotEmpty
   // @Pattern(regexp = "\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$\"")
    @Size(min = 8, max = 12, message = "password size min of 8 max of 10 characters")
    private String password;

    @NotEmpty
    private String about;
}
