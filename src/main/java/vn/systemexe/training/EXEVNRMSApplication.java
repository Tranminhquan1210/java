/**
 * 
 */
package vn.systemexe.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lam-son
 */
@SpringBootApplication
@ComponentScan(value = { "vn.systemexe.training" })
public class EXEVNRMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(EXEVNRMSApplication.class, args);
	}

}
