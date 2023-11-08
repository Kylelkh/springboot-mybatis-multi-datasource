package boot;

import boot.mapper.clickhouse.ClickhouseUserMapper;
import boot.mapper.mysql.MysqlUserMapper;
import boot.mapper.psql.PsqlUserMapper;
import boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MainApplication {


  @Autowired
  private MysqlUserMapper mysqlUserMapper;

  @Autowired
  private ClickhouseUserMapper clickhouseUserMapper;

  @Autowired
  private PsqlUserMapper psqlUserMapper;


  @RequestMapping("/")
  public int hello() {
    int i = 234;
    return i;
  }

  @RequestMapping("/mysql")
  public User mysql() {
    System.out.println("mysql inside");
    final User user = mysqlUserMapper.selectUserById(1);
    return user;
  }

  @RequestMapping("/psql")
  public User psql() {
    System.out.println("psql inside");
    final User user = psqlUserMapper.selectUserById(1);
    return user;
  }

  @RequestMapping("/click")
  public User click() {
    System.out.println("click inside");
    final User user = clickhouseUserMapper.selectUserById(1);
    return user;
  }

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }
}
