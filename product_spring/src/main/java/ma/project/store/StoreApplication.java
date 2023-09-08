package ma.project.store;

import ma.project.store.DAO.JPA.IProduct;
import ma.project.store.DAO.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.UUID;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IProduct iProduct){
        return args -> {
            for(int i = 0;i < 13 ; i++) {
                iProduct.save(new Product(i+1, "watch", 123, true));
            }

//            iProduct.findAllByNameContains("",PageRequest.of(0,5)).forEach(p->{
//                System.out.println(p);
//            });
            iProduct.findAll().forEach(p->{
                System.out.println(p);
            });
        };
    }

}
