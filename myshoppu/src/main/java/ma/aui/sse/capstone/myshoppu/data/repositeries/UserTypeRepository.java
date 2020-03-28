package ma.aui.sse.capstone.myshoppu.data.repositeries;

import ma.aui.sse.capstone.myshoppu.data.entities.UserType;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserTypeRepository extends BaseRepository<UserType> {
    List<UserType> findByUserType(String userType);
}
