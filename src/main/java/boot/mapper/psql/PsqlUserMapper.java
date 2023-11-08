package boot.mapper.psql;

import boot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PsqlUserMapper {

    User selectUserById(Integer id);
}
