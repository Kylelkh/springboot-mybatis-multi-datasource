package boot.mapper.clickhouse;

import boot.model.KeyValue;
import boot.model.User;
import boot.model.YourTable;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public interface ClickhouseUserMapper {

    User selectUserById(Integer id);

    List<YourTable> findByMapConditions(List<KeyValue> conditions);
}
