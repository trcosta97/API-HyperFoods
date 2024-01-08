package com.hyperFoods.api.controller;

import com.hyperFoods.api.dto.CreateUserDTO;
import com.hyperFoods.api.dto.UserListDTO;
import com.hyperFoods.api.entity.User;
import com.hyperFoods.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateUserDTO data, UriComponentsBuilder uriBuilder) {
        var user = new User(data);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    public ResponseEntity<Page<UserListDTO>> getAll(@PageableDefault(sort = {"name"}, size = 5) Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(UserListDTO::new));
    }
}
