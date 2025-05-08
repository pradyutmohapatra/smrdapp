package com.tatapower.smrd.kicklock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    private String access_token;
    private float expires_in;
    private float refresh_expires_in;
    private String refresh_token;
    private String token_type;
    private String id_token;
    private String session_state;
    private String scope;
}
