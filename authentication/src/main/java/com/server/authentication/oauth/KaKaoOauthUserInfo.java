package com.server.authentication.oauth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KaKaoOauthUserInfo {
    private Map<String, Object> attributes;
    private Map<String, Object> attributesAccount;
    private Map<String, Object> attributesProfile;

    private KaKaoOauthUserInfo(Map<String, Object> attributes){
        this.attributes = Collections.unmodifiableMap(attributes);
        this.attributesAccount = Collections.unmodifiableMap((Map<String, Object>) attributes.get("kakao_account"));
        this.attributesProfile= Collections.unmodifiableMap((Map<String, Object>) attributesAccount.get("profile"));
    }

    public static KaKaoOauthUserInfo from(Map<String, Object> attributes){
        return new KaKaoOauthUserInfo(attributes);
    }

    public String getNickname(){
        return attributesProfile.get("nickname").toString();
    }

    public String getProfileImageUrl(){
        return attributesProfile.get("profile_image_url").toString();
    }

}
