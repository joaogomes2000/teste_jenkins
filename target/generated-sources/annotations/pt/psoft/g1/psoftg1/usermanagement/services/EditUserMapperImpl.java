package pt.psoft.g1.psoftg1.usermanagement.services;

import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pt.psoft.g1.psoftg1.usermanagement.model.Role;
import pt.psoft.g1.psoftg1.usermanagement.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T17:47:09+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class EditUserMapperImpl extends EditUserMapper {

    @Override
    public User create(CreateUserRequest request) {
        if ( request == null ) {
            return null;
        }

        String username = null;
        String password = null;

        username = map( request.getUsername() );
        password = map( request.getPassword() );

        User user = new User( username, password );

        if ( user.getAuthorities() != null ) {
            Set<Role> set = stringToRole( request.getAuthorities() );
            if ( set != null ) {
                user.getAuthorities().addAll( set );
            }
        }
        user.setName( map( request.getName() ) );

        return user;
    }

    @Override
    public void update(EditUserRequest request, User user) {
        if ( request == null ) {
            return;
        }

        if ( user.getAuthorities() != null ) {
            user.getAuthorities().clear();
            Set<Role> set = stringToRole( request.getAuthorities() );
            if ( set != null ) {
                user.getAuthorities().addAll( set );
            }
        }
        if ( request.getUsername() != null ) {
            user.setUsername( map( request.getUsername() ) );
        }
        if ( request.getPassword() != null ) {
            user.setPassword( map( request.getPassword() ) );
        }
        if ( request.getName() != null ) {
            user.setName( map( request.getName() ) );
        }
    }
}
