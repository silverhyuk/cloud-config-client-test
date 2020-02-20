package com.silverhyuk.cloudconfigclienttest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class WelcomeController {

    private final ApplicationConfig applicationConfig;

    @GetMapping("/message")
    public Map<String, String> welcome() {

        final  Map<String, String> map = new HashMap<>();
        map.put("message", applicationConfig.getMessage());

        return map;
    }

}
