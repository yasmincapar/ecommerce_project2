package com.syqu.shop;

import com.syqu.shop.domain.Category;
import com.syqu.shop.domain.Product;
import com.syqu.shop.domain.Product2;
import com.syqu.shop.repository.CategoryRepository;
import com.syqu.shop.service.ProductService;
import com.syqu.shop.domain.User;
import com.syqu.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);

    @Autowired
    public StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        category();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        Category category4 = new Category();
        category1.setId(1);
        category1.setCategoryName("Zeytin");
        category2.setId(2);
        category2.setCategoryName("Peynir");
        category3.setId(3);
        category3.setCategoryName("Kekik");
        category4.setId(4);
        category4.setCategoryName("Honey");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
    }

    private void exampleProducts(){
        //final String NAME = "Example Name";
        //final String IMAGE_URL = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg";
        //final String DESCRIPTION = "Example Description";
        //final BigDecimal PRICE = BigDecimal.valueOf(21);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();




        product1.setName("Green Olives");
        product1.setImageUrl("https://www.olivesdirect.co.uk/media/catalog/product/cache/f4263ad906daca27ea2239a93d86f917/p/o/po06-colossal.jpg");
        product1.setDescription("Early Harvest Green Olives - Salted");
        product1.setCategory(categoryRepository.findByCategoryName("Zeytin"));
        product1.setPrice(BigDecimal.valueOf(21));

        product2.setName("Black Olives");
        product2.setImageUrl("https://blackolivecollection.com/wp-content/uploads/2017/08/black-olives-with-spoon-1.jpg");
        product2.setDescription("Salt cured Black olives");
        product2.setCategory(categoryRepository.findByCategoryName("Zeytin"));
        product2.setPrice(BigDecimal.valueOf(25));

        product3.setName("Olive Oil");
        product3.setImageUrl("https://bulknaturaloils.com/media/catalog/product/cache/5b89197651ea0053483b6b3397eafb60/o/l/olive-pure-470_11.png");
        product3.setDescription("Early Harvest - Cold Pressed Olive oil");
        product3.setCategory(categoryRepository.findByCategoryName("Zeytin"));
        product3.setPrice(BigDecimal.valueOf(21));

        product4.setName("Cheese");
        product4.setImageUrl("https://i0.wp.com/homesteadersofamerica.com/wp-content/uploads/2022/01/How-to-Make-Cheddar-Cheese-17.jpg?w=1080&ssl=1");
        product4.setDescription("Cow & Lamb milk mixture - hard cheese");
        product4.setCategory(categoryRepository.findByCategoryName("Peynir"));
        product4.setPrice(BigDecimal.valueOf(27));

        product5.setName("Kekik");
        product5.setImageUrl("https://cdn.shopify.com/s/files/1/0427/8314/6151/products/thyme-whole--timian-hel-asatrading_600x.jpg?v=1598970142");
        product5.setDescription("kekik");
        product5.setCategory(categoryRepository.findByCategoryName("kekik"));
        product5.setPrice(BigDecimal.valueOf(27));

        product6.setName("Honey");
        product6.setImageUrl("https://roots.vn/wp-content/uploads/2022/07/lam-the-nao-de-nhan-biet-mat-ong-chat-luong-cao-1.jpg.webp");
        product6.setDescription("Honey");
        product6.setCategory(categoryRepository.findByCategoryName("Honey"));
        product6.setPrice(BigDecimal.valueOf(27));




        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);


    }
}
