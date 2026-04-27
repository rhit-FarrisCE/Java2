package Exercize_4.Problem_2;
/**
 * LibrarySystem - Demonstrates Generics, Upper Bounded Wildcards, 
 * and Generic Methods with Lower Bounded Wildcards
 */
public class LibrarySystem {

    /**
     * Upper Bounded Wildcard Method
     * Prints details of all media on a shelf (uses ? extends Media for reading/producing)
     * PECS: Producer Extends - Use extends when reading data
     * 
     * @param shelf the shelf containing media items
     */
    public static void printMediaDetails(Shelf<? extends Media> shelf) {
        System.out.println("=== Shelf Contents (" + shelf.getCount() + " items) ===");
        for (int i = 0; i < shelf.getCount(); i++) {
            System.out.println((i + 1) + ". " + shelf.get(i));
        }
        System.out.println();
    }

    /**
     * Generic Method with Lower Bounded Wildcard
     * Safely moves items from source shelf to destination shelf
     * PECS: Consumer Super - Use super when writing data
     * 
     * This method allows moving items from a Shelf<T> to any Shelf that can hold T or its parents.
     * For example: Shelf<Book> items can be moved to Shelf<Media>
     * 
     * @param <T> the type parameter for the source shelf
     * @param source the shelf to transfer items from
     * @param destination the shelf to transfer items to (must be ? super T)
     */
    public static <T> void transferItems(Shelf<T> source, Shelf<? super T> destination) {
        System.out.println("Transferring " + source.getCount() + " items...");
        
        while (!source.isEmpty()) {
            T item = source.take();
            destination.add(item);
        }
        
        System.out.println("Transfer complete! Destination now has " + destination.getCount() + " items.");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("========== Smart Library System ==========\n");

        // Test Scenario (1): Create Shelf<Book> and Shelf<Magazine>, add objects
        System.out.println("--- Step 1: Creating Shelves ---");
        Shelf<Book> bookShelf = new Shelf<>();
        Shelf<Magazine> magazineShelf = new Shelf<>();

        // Add books to book shelf
        bookShelf.add(new Book("The Great Gatsby", 1925, "F. Scott Fitzgerald"));
        bookShelf.add(new Book("To Kill a Mockingbird", 1960, "Harper Lee"));
        bookShelf.add(new Book("1984", 1949, "George Orwell"));

        // Add magazines to magazine shelf
        magazineShelf.add(new Magazine("National Geographic", 2023, 1));
        magazineShelf.add(new Magazine("Time Magazine", 2023, 15));
        System.out.println("Created bookShelf with " + bookShelf.getCount() + " books");
        System.out.println("Created magazineShelf with " + magazineShelf.getCount() + " magazines\n");

        // Test Scenario (2): Call printMediaDetails using Upper Bounded Wildcard
        System.out.println("--- Step 2: Printing Media Details (Upper Bounded Wildcard) ---");
        printMediaDetails(bookShelf);
        printMediaDetails(magazineShelf);

        // Test Scenario (3): Create a general Shelf<Media>
        System.out.println("--- Step 3: Creating General Media Shelf ---");
        Shelf<Media> mediaShelf = new Shelf<>();
        System.out.println("Created mediaShelf (empty, ready to receive items)\n");

        // Test Scenario (4): Transfer items using Generic Method with Lower Bounded Wildcard
        System.out.println("--- Step 4: Transferring Books to Media Shelf (Lower Bounded Wildcard) ---");
        transferItems(bookShelf, mediaShelf);

        // Verify transfer
        System.out.println("--- Step 5: Verifying Transfer ---");
        printMediaDetails(mediaShelf);

        // Bonus: Also transfer magazines
        System.out.println("--- Bonus: Also transferring magazines to media shelf ---");
        transferItems(magazineShelf, mediaShelf);

        // Final state
        System.out.println("--- Final State: All Media on Universal Shelf ---");
        printMediaDetails(mediaShelf);

        System.out.println("========== End of Library System Demo ==========");
    }
}
