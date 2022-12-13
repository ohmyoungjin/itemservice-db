package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.mybatis.ItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
//@Import(JdbcTemplateV2Config.class)
@Slf4j
//@Import(JdbcTemplateV3Config.class)
//@Import(MyBatisConfig.class)
@Import(JpaConfig.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	//application.properties 설정 값이
	//spring.profiles.active=local 이면 실행되는 로직
	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

	//test인 경우 datasource를 직접 등록해서 쓴다.
	//내가 직접 선언하는 경우 spring 에서는 자동으로 리소스를 등록하지 않는다.
	/*@Bean
	@Profile("test")
	public DataSource dataSource() {
		//dataSource()
		//jdbc:h2:mem:db : 이 부분이 중요하다. 데이터소스를 만들때 이렇게만 적으면 임베디드 모드
		// (메모리 모드)로 동작하는 H2 데이터베이스를 사용할 수 있다.
		//DB_CLOSE_DELAY=-1 : 임베디드 모드에서는 데이터베이스 커넥션 연결이 모두 끊어지면
		//데이터베이스도 종료되는데, 그것을 방지하는 설정이다.
		//이 데이터소스를 사용하면 메모리 DB를 사용할 수 있다.
		log.info("메모리 데이터베이스 초기화");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}*/
}
