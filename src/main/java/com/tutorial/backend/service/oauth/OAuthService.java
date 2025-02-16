package com.tutorial.backend.service.oauth;

import com.tutorial.backend.controller.dto.MemberProfile;
import com.tutorial.backend.controller.dto.OAuthAttributes;
import com.tutorial.backend.entity.Member;
import com.tutorial.backend.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        MemberProfile memberProfile = OAuthAttributes.extract(registrationId, attributes);
        Member member = saveOrUpdate(memberProfile);

        Map<String, Object> customAttribute = customAttribute(attributes, userNameAttributeName, memberProfile, registrationId);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("USER")),
                customAttribute,
                userNameAttributeName);
    }

    private Map<String, Object> customAttribute(Map<String, Object> attributes, String userNameAttributeName, MemberProfile memberProfile, String registrationId) {
        Map<String, Object> customAttribute = new LinkedHashMap<>();
        customAttribute.put(userNameAttributeName, attributes.get(userNameAttributeName));
        customAttribute.put("provider", registrationId);
        customAttribute.put("name", memberProfile.getName());
        customAttribute.put("email", memberProfile.getEmail());
        customAttribute.put("phone", memberProfile.getPhoneNum());
        customAttribute.put("profile_image_url", memberProfile.getProfileImageUrl());
        return customAttribute;
    }

    private Member saveOrUpdate(MemberProfile memberProfile) {
        Optional<Member> optionalMember = memberRepository.findByMemberEmail(memberProfile.getEmail());

        if (optionalMember.isPresent()) {
            Member existingMember = optionalMember.get();
            existingMember.update(memberProfile.getName(), memberProfile.getEmail(),memberProfile.getProfileImageUrl());
            log.info("OAuthService에서 기존 회원 업데이트");
            return memberRepository.save(existingMember); // 업데이트 된 사용자 저장
        } else {
            Member newMember = memberProfile.toMember();
            log.info("OAuthService에서 신규 회원 저장");
            return memberRepository.save(newMember); // 신규 사용자 저장
        }
    }
}
