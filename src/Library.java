import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private static Library library;
    private Map<Long, Patron> patrons;
    private Inventory inventory;


    private Library() {
        patrons = new HashMap<Long, Patron>();
        inventory = Inventory.getInventory();
    }

    public static Library getLibrary() {
        if (library == null) {
            library = new Library();
        }
        return library;
    }

    public void addPatron(long patronId, String fullName, String email, long phoneNumber) {
        if(patrons.containsKey(patronId)) {
            System.out.println("This user already exists!");
        } else {
            List<BorrowInformation> borrowHistory = new ArrayList<>();
            List<BorrowInformation> currentlyBorrowedBooks = new ArrayList<>();
            Patron newPatron = new Patron(patronId, fullName, email, phoneNumber, borrowHistory, currentlyBorrowedBooks);
            patrons.put(patronId, newPatron);
        }
    }

    public void deletePatron(long patronId) {
        if(patrons.containsKey(patronId)) {
            patrons.remove(patronId);
            System.out.println("Patron has been deleted.");
        } else {
            System.out.println("Patron does not exist.");
        }
    }

    public Patron searchPatron(long patronId) {
        Patron patron = patrons.get(patronId);
        if (patron != null) {
            return patrons.get(patronId);
        } else {
            System.out.println("No patron was found with the id: " + patronId);
            return null;
        }
    }

    public void updatePatronFullName(long patronId, String updatedName) {
        Patron patron = patrons.get(patronId);
        String previousName = patron.getFullName();
        if(patron != null) {
            patron.setFullName(updatedName);
            System.out.println("Patron Name has been updated from " + previousName + " to " + updatedName);
        } else {
            System.out.println("Patron does not exist.");
        }
    }

    public void updatePatronEmail(long patronId, String updatedEmail) {
        Patron patron = patrons.get(patronId);
        String previousEmail = patron.getEmail();
        if(patron != null) {
            patron.setEmail(updatedEmail);
            System.out.println("Patron Email has been updated from " + previousEmail + " to " + updatedEmail);
        } else {
            System.out.println("Patron does not exist.");
        }
    }

    public void updatePatronPhoneNumber(long patronId, long updatedPhoneNumber) {
        Patron patron = patrons.get(patronId);
        long previousPhoneNumber = patron.getPhoneNumber();
        if(patron != null) {
            patron.setPhoneNumber(updatedPhoneNumber);
            System.out.println("Patron Phone Number has been updated from " + previousPhoneNumber + " to " + updatedPhoneNumber);
        } else {
            System.out.println("Patron does not exist.");
        }
    }



}
