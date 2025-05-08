package com.tatapower.smrd.controller;

import com.tatapower.smrd.kicklock.TokenResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/smrd")
public class RedirectURIController {
    @GetMapping("/redirect")
    public TokenResponse getRedirectURI(@RequestParam("code") String code)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("code", code);
        formData.add("redirect_uri", "https://192.168.0.61:9090/smrd/redirect");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
        ResponseEntity<TokenResponse> response = new RestTemplate().postForEntity("https://loginnew.cnxy.in/realms/TATA-POWER/protocol/openid-connect/token", requestEntity, TokenResponse.class);
        return response.getBody();
    }

    @GetMapping("/login")
    public RedirectView login() {
        return new RedirectView("https://loginnew.cnxy.in/realms/TATA-POWER/protocol/openid-connect/auth?response_type=code&client_id=Java-SignClient-Local&redirect_uri=http://192.168.0.61:9090/smrd/redirect&scope=openid+profile+email+SMRD");
    }



}
