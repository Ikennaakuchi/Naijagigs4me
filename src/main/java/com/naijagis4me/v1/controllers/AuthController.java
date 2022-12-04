package com.naijagis4me.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {
    @GetMapping
    public String getHome() {
        return "Homepage";
    }

    @GetMapping("api/v1/super-admin")
    public String getUser() {
        return "Joy overflow";
    }
    @GetMapping("api/v1/admin")
    public String getAdminPage() {
        return "Admin Page";
    }
    @GetMapping("api/v1/auth/admin")
    public String getSuperAdmin() {
        return "Admin Auth Page";

    }

    @GetMapping("api/v1/auth/user")
    public String getAuthUser() {
        return "User/Client Page";
    }
    @GetMapping("api/v1/user")
    public String getForBothUsers() {
        return "All Users Page";
    }

    @GetMapping("api/v1/user/client")
    public String getClient() {
        return "User/Client Page";
    }





}
