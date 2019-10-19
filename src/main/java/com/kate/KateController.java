package com.kate;

import com.kate.domain.Item;
import com.kate.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
    public class KateController {
    @Autowired
    private ItemRepo itemRepo;


    @GetMapping("/needThis")
    public String needThis(Map<String, Object> model) {
        Iterable<Item> items = itemRepo.findAll();
        model.put("items", items);
        return "needThis";
    }

        @GetMapping("/addItem")
    public String addItem(Map<String, Object> model) {
        Iterable<Item> items = itemRepo.findAll();
        model.put("items", items);
        return "addItem";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "/needThis");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam Long count, Map<String, Object> model) {
        Item item = new Item(name, count);
        itemRepo.save(item);
        Iterable<Item> items = itemRepo.findAll();
        model.put("items", items);
        return "addItem";
    }





    @RequestMapping(value = "needThis/delete/{id}", method = RequestMethod.DELETE)
            public String remove(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for this id :: " + id));;
        itemRepo.delete(item);
        Iterable<Item> items = itemRepo.findAll();
        itemRepo.findAll();
        model.put("items", item);

        return "needThis";
    }

}

