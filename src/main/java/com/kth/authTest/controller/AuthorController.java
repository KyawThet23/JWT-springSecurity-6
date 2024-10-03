package com.kth.authTest.controller;

import com.kth.authTest.dto.AuthorInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

    @PostMapping
    public String create(@RequestBody AuthorInput request){
        return "";
    }
}
