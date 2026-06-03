package com.live.butterfly;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

        public record Product(int id, String image, String badge, String category, String name, String description,
                        double price) {
        }

        @GetMapping("products")
        public List<Product> getAllProducts() {
                List<Product> products = new ArrayList<>();

                products.add(new Product(1, "http://localhost:8080/images/cerave_cleanser.png", "Bestseller",
                                "Facewash",
                                "CeraVe Hydrating Cleanser", "Cleanses and hydrates with 3 essential ceramides.",
                                14.99));

                products.add(new Product(2, "http://localhost:8080/images/cerave_cream.png", "Popular", "Moisturizer",
                                "CeraVe Moisturizing Cream", "Barrier-restoring moisturizing cream for dry skin.",
                                19.50));

                products.add(new Product(3, "http://localhost:8080/images/cerave_lotion.png", "Best-Seller", "Lotion",
                                "CeraVe Daily Lotion", "Lightweight moisturizing lotion for daily use.", 13.99));

                products.add(new Product(4, "http://localhost:8080/images/garnier_micellar.png", "Classic", "Facewash",
                                "Garnier Micellar Water", "All-in-1 facial cleanser and gentle makeup remover.", 8.99));

                products.add(new Product(5, "http://localhost:8080/images/dove_shampoo.png", "New", "Shampoo",
                                "Dove Intense Repair", "Nourishing shampoo for damaged hair.", 12.00));

                products.add(new Product(6, "http://localhost:8080/images/sunsilk_shampoo.png", "Popular", "Shampoo",
                                "Sunsilk Black Shine", "Shampoo for stunning black shiny hair.", 10.50));

                products.add(new Product(7, "http://localhost:8080/images/simple_facewash.png", "Trending", "Facewash",
                                "Simple Refreshing Wash", "100% soap-free face wash for sensitive skin.", 9.99));

                products.add(new Product(8, "http://localhost:8080/images/nivea_cream.png", "Classic", "Moisturizer",
                                "Nivea Soft Cream", "Light moisturizing cream with Jojoba Oil & Vitamin E.", 7.50));

                products.add(new Product(9, "http://localhost:8080/images/mac_lipstick.png", "Premium", "Lipstick",
                                "MAC Matte Lipstick", "Iconic matte finish lipstick.", 21.00));

                products.add(new Product(10, "http://localhost:8080/images/fitme_foundation.png", "Sale", "Foundation",
                                "Maybelline Fit Me", "Matte + Poreless liquid foundation.", 11.99));

                return products;
        }

        @PostMapping("cart")
        public String addToCart(@RequestParam String username, @RequestParam int productId) {
                return "success";
        }
}
