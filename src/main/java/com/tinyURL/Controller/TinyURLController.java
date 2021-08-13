package com.tinyURL.Controller;

import com.tinyURL.Service.Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TinyURLController {

    @Autowired
    private Codec codec;

    @GetMapping("/tinyUrl/{ID}")
    public String gettinyURL(@PathVariable String ID){
        String actualURL = codec.getActualURL(ID);
        return actualURL;
    }

    @PostMapping("/tinyUrl")
    public String setTinyUrl(@RequestBody String url){
        String sortURL = codec.setsortUrl(url);

        return sortURL;
    }
}
