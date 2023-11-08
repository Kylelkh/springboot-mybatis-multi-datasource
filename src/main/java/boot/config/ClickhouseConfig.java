package boot.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "boot.mapper.clickhouse", sqlSessionFactoryRef = "clickSqlSessionFactory")
public class ClickhouseConfig {

    @Primary // 表示这个数据源是默认数据源, 这个注解必须要加，因为不加的话spring将分不清楚那个为主数据源（默认数据源）
    @Bean("click")
    @ConfigurationProperties(prefix = "spring.datasource.click") //读取application.yml中的配置参数映射成为一个对象
    public DataSource getDb1DataSource(){
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean("clickSqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("click") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

        // 设置数据源
        bean.setDataSource(dataSource);

        // 设置mapper.xml位置，必须设置。多数据源时在application.yml设置mapper-locations无效
        final Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/ClickhouseUserMapper.xml");
        bean.setMapperLocations(resources);
        // mybatis配置。多数据源时在application.yml设置mybatis.configuration无效

        final org.apache.ibatis.session.Configuration configuration = bean.getObject().getConfiguration();
        // final org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();

        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);


        return bean.getObject();
    }

    @Primary
    @Bean("clickSqlSessionTemplate")
    public SqlSessionTemplate clickSqlSessionTemplate(@Qualifier("clickSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("clickSqlSessionTemplateForBatch")
    public SqlSessionTemplate clickSqlSessionTemplateForBatch(@Qualifier("clickSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
    }
}
