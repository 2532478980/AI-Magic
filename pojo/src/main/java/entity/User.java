package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private UUID user_id;

    private String account;

    private String password_hash;

    private String username;

    private String phone;

    private String email;

    private LocalDateTime created_at;

    private  LocalDateTime last_login;

    private int status;
}
