package com.bipin.springmvc.controller;

import com.bipin.springmvc.dao.ProductDao;
import com.bipin.springmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductDao productDao;
    @RequestMapping("/")
    public String home(Model model)
    {
        List<Product> products=this.productDao.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }
    @RequestMapping("/add-product")
    public String addProduct(Model model)
    {
        model.addAttribute("title","Add Product");
        return "add_product";
    }

    @RequestMapping(value = "/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute("product") Product product, BindingResult bindingResult)
    {
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("/Product-CRUD-APP");
        if(bindingResult.hasErrors())
        {
            return redirectView;
        }
        System.out.println(product);
        this.productDao.createProduct(product);

        return  redirectView;
    }

    @RequestMapping(value = "/delete-product/{productid}")
    public RedirectView handleDelete(@PathVariable("productid") int productId)
    {
        this.productDao.deleteProduct(productId);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("/Product-CRUD-APP");
        return  redirectView;
    }
    @RequestMapping(value = "/update-product/{productid}")
    public String handleUpdate(@PathVariable("productid") int productId, Model model)
    {
        Product product=this.productDao.getProduct(productId);
        model.addAttribute("product", product);
        return  "update_product";
    }
}