package info.bubna.up.converter;

import info.bubna.up.dto.CredentialsDTO;
import info.bubna.up.dto.db.RecCredentialWithAuthorities;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CredentialsDTOConverter
        implements Converter<RecCredentialWithAuthorities, CredentialsDTO> {

    @Override
    public CredentialsDTO convert(RecCredentialWithAuthorities from) {
        return CredentialsDTO.builder()
                .login(from.getLogin())
                .password(from.getPassword())
                .role(from.getRole())
                .authorities(from.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .build();
    }
}
