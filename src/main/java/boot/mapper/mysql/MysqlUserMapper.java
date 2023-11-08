package boot.mapper.mysql;

import boot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
public interface MysqlUserMapper {

    User selectUserById(Integer id);
}
