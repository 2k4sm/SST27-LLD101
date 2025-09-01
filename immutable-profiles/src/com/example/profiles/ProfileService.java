package com.example.profiles;

import java.util.Objects;

public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        Validation.requireNonBlank(id, "id");
        Validation.requireEmail(email);

        return UserProfile.builder(id, email).build();
    }

    public UserProfile updateDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");

        if (displayName != null && displayName.length() > 100) {
            displayName = displayName.substring(0, 100);
        }

        return UserProfile.builder(p.getId(), p.getEmail())
                .phone(p.getPhone())
                .displayName(displayName)
                .address(p.getAddress())
                .marketingOptIn(p.isMarketingOptIn())
                .twitter(p.getTwitter())
                .github(p.getGithub())
                .build();
    }
}
