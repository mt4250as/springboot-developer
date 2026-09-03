package me.scpark.springdeveloper;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class TestController {
    @GetMapping("/Test")
    public String Test() {
        return "Hello World";
    }
    @PostMapping("/Test")
    public String postTest() {
        return "Post Test response!!";
    }
    @DeleteMapping("/Test")
    public String deleteTest() {
        return "Delete Test";
    }
    @PutMapping("/Test")
    public String putTest() {
        return "Put Test response!!";
    }
}
