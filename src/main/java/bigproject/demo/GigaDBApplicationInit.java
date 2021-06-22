package bigproject.demo;


import bigproject.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GigaDBApplicationInit implements CommandLineRunner {
  private final ProductService productService;
  private final UserService userService;

  public GigaDBApplicationInit(ProductService productService, UserService userService ) {
    this.productService = productService;
    this.userService = userService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.productService.initProducts();
    this.userService.seedUsers();
//test

  }
}
