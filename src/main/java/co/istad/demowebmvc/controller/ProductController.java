package co.istad.demowebmvc.controller;

import co.istad.demowebmvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
private  List<Product>products;
public ProductController(){

    Product mouse1 = Product.builder()
            .id(1)
            .name("Logitech Mouse")
            .description("Gaming Mouse for programmer")
            .price(25.0)
            .build();

    Product mouse2 = Product.builder()
            .id(2)
            .name("Razor Mouse")
            .description("Gaming Mouse for programmer")
            .price(25.0)
            .build();

    Product mouse3 = Product.builder()
            .id(3)
            .name("Red Dragon Mouse")
            .description("Gaming Mouse for programmer")
            .price(25.0)
            .build();

    Product mouse4 = Product.builder()
            .id(4)
            .name("Apple Magic Mouse")
            .description("Gaming Mouse for programmer")
            .price(25.0)
            .build();

     products = new ArrayList<>();
    products.add(mouse1);
    products.add(mouse2);
    products.add(mouse3);
    products.add(mouse4);
}

    @GetMapping("/product")
    public String viewProduct(ModelMap modelMap) {



        modelMap.addAttribute("products", products);
        modelMap.addAttribute("isAdmin", false);
        modelMap.addAttribute("roleId", 4);

        return "product/product";
    }
    @GetMapping("/product/{id}")
    public String viewProductDetail(@PathVariable Integer id ,
                                    @RequestParam String name,
                                    ModelMap modelMap){
        for (Product product:products){
            if(product.getId().equals(id)){
                modelMap.addAttribute("product",product);
            }
        }

        return "product/productDetail";
    }

}
