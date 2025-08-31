package com.example.profiles;

import java.util.Objects;

public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createFull(String id, String email, String phone, String displayName, 
                                String address, boolean marketingOptIn, String twitter, String github) {
        return new UserProfile.Builder(id, email)
                .phone(phone)
                .displayName(displayName)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build();
    }

    public UserProfile updateDisplayName(UserProfile profile, String displayName) {
        Objects.requireNonNull(profile, "profile");
        
        if (displayName != null && displayName.length() > 100) {
            throw new IllegalArgumentException("displayName must not exceed 100 characters");
        }
        
        return new UserProfile.Builder(profile.getId(), profile.getEmail())
                .phone(profile.getPhone())
                .displayName(displayName)
                .address(profile.getAddress())
                .marketingOptIn(profile.isMarketingOptIn())
                .twitter(profile.getTwitter())
                .github(profile.getGithub())
                .build();
    }

    public UserProfile updateMarketingOptIn(UserProfile profile, boolean marketingOptIn) {
        Objects.requireNonNull(profile, "profile");
        
        return new UserProfile.Builder(profile.getId(), profile.getEmail())
                .phone(profile.getPhone())
                .displayName(profile.getDisplayName())
                .address(profile.getAddress())
                .marketingOptIn(marketingOptIn)
                .twitter(profile.getTwitter())
                .github(profile.getGithub())
                .build();
    }
}
