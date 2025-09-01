import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();

        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Original email: " + p.getEmail());
        System.out.println("Original displayName: " + p.getDisplayName());

        UserProfile updated = svc.updateDisplayName(p, "New Display Name");

        System.out.println("After update - original displayName: " + p.getDisplayName());
        System.out.println("After update - new profile displayName: " + updated.getDisplayName());
    }
}
