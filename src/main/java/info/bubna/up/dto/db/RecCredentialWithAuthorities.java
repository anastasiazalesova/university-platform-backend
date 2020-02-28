package info.bubna.up.dto.db;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@Builder
@RequiredArgsConstructor
public class RecCredentialWithAuthorities {
    private final String login;

    private final String password;

    private final String role;

    @With
    private final List<String> authorities;

    public RecCredentialWithAuthorities(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.authorities = List.of();
    }
}
