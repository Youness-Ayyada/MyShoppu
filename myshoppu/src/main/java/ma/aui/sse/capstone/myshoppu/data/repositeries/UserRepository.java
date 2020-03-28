package ma.aui.sse.capstone.myshoppu.data.repositeries;

import ma.aui.sse.capstone.myshoppu.data.entities.User;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends BaseRepository<User> {
    User findByUsername(String username);
}
