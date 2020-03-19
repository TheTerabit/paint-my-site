package pl.bs.paintmysite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.bs.paintmysite.repositories")
public class PaintMySiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaintMySiteApplication.class, args);
    }

}
