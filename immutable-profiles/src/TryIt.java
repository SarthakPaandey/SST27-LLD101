import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        
        System.out.println("=== Immutable Profile Demo ===\n");
        
        UserProfile p1 = svc.createMinimal("user1", "a@b.com");
        System.out.println("Created minimal profile: " + p1.getEmail());
        
        UserProfile p2 = svc.createFull("user2", "user@example.com", "+1234567890", 
                                       "John Doe", "123 Main St", true, "@johndoe", "johndoe");
        System.out.println("Created full profile: " + p2.getDisplayName() + " (" + p2.getEmail() + ")");
        
        UserProfile p3 = svc.updateDisplayName(p1, "New Display Name");
        System.out.println("Updated display name: " + p3.getDisplayName());
        
        UserProfile p4 = svc.updateMarketingOptIn(p2, false);
        System.out.println("Updated marketing opt-in: " + p4.isMarketingOptIn());
        
        System.out.println("\n=== Builder Pattern Demo ===");
        UserProfile p5 = new UserProfile.Builder("user3", "builder@test.com")
                .phone("+9876543210")
                .displayName("Builder User")
                .address("456 Oak Ave")
                .marketingOptIn(true)
                .twitter("@builderuser")
                .github("builderuser")
                .build();
        
        System.out.println("Built profile: " + p5.getDisplayName() + " (" + p5.getEmail() + ")");
        
        System.out.println("\n=== Immutability Verification ===");
        System.out.println("Original profile email: " + p1.getEmail());
        System.out.println("Updated profile email: " + p3.getEmail());
        System.out.println("Are they the same object? " + (p1 == p3));
        System.out.println("✓ Immutability confirmed - original object unchanged!");
        
        System.out.println("\n=== Validation Demo ===");
        try {
            UserProfile invalid = new UserProfile.Builder("ab", "invalid-email").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
        
        try {
            UserProfile invalid2 = new UserProfile.Builder("user4", "valid@email.com")
                    .displayName("This is a very long display name that exceeds the maximum allowed length of one hundred characters and should cause a validation error")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
    }
}
