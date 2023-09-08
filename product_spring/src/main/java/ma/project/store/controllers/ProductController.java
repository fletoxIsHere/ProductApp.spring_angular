package ma.project.store.controllers;

import lombok.AllArgsConstructor;
import ma.project.store.DAO.JPA.IProduct;
import ma.project.store.DAO.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor

public class ProductController {
    private IProduct iProduct;

    @GetMapping("product/getAll")
    @ResponseBody
    public Page<Product> products(Model model,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size,
                                  @RequestParam(name = "keyword", defaultValue = "") String keyword
                                  ){

      Page<Product> pageProducts =   iProduct.findAllByNameContains(keyword,PageRequest.of(page,size));
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);

        return pageProducts;
}

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("product/deleteById")
    public ResponseEntity<Void> deleteProductById(@RequestParam(name = "id") int id){
        iProduct.deleteById(id);
        System.out.println("deleting");
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product p){
        System.out.println(p);
       Product savedProduct =  iProduct.save(p);
        System.out.println("create one Product");
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
