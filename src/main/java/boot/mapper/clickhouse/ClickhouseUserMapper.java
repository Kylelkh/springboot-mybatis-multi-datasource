package boot.mapper.clickhouse;

import boot.model.User;
import org.springframework.stereotype.Repository;
@Repository
public interface ClickhouseUserMapper {

    User selectUserById(Integer id);
}
