package info.bubna.up.service;

import info.bubna.up.dao.CredentialsDao;
import info.bubna.up.dto.CredentialsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCredentialsService implements UserDetailsService {

    private final CredentialsDao credentialsDao;
    private final ConversionService conversionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return conversionService.convert(credentialsDao.fetchByLogin(username), CredentialsDTO.class);
    }
}
