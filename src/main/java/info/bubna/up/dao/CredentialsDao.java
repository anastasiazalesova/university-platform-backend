package info.bubna.up.dao;

import info.bubna.up.dto.db.RecCredentialWithAuthorities;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static info.bubna.up.gen.tables.DictRight.DICT_RIGHT;
import static info.bubna.up.gen.tables.LinkRoleRight.LINK_ROLE_RIGHT;
import static info.bubna.up.gen.tables.RecCredentials.REC_CREDENTIALS;
import static info.bubna.up.gen.tables.RecRole.REC_ROLE;
import static info.bubna.up.gen.tables.RecUser.REC_USER;

@Repository
@RequiredArgsConstructor
public class CredentialsDao {

    private final DSLContext dsl;

    public RecCredentialWithAuthorities fetchByLogin(String login) {
        var result = dsl.select().from(REC_USER)
                .join(REC_CREDENTIALS).on(REC_CREDENTIALS.ID.eq(REC_USER.CREDENTIALS_ID))
                .join(REC_ROLE).on(REC_USER.ROLE_ID.eq(REC_ROLE.ID))
                .where(REC_CREDENTIALS.LOGIN.eq(login))
                .fetchOne()
                .map(it -> RecCredentialWithAuthorities.builder()
                        .login(it.get(REC_CREDENTIALS.LOGIN))
                        .password(it.get(REC_CREDENTIALS.PASSWORD))
                        .role(it.get(REC_ROLE.NAME))
                        .build());
        return result.withAuthorities(dsl.select(REC_ROLE.NAME).from(DICT_RIGHT)
                .join(LINK_ROLE_RIGHT).on(LINK_ROLE_RIGHT.RIGHT_ID.eq(DICT_RIGHT.ID))
                .join(REC_ROLE).on(REC_ROLE.ID.eq(LINK_ROLE_RIGHT.ROLE_ID))
                .where(REC_ROLE.NAME.eq(result.getRole())).fetch().map(it -> it.get(REC_ROLE.NAME)));
    }
}
