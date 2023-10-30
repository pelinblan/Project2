import java.io.FileNotFoundException;

public class Proj2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to CSC 201B Project2!");
        if(args.length != 2){
            System.err.println("Argument count is invalid: " + args.length);
            System.exit(0);
        }
        System.out.println("Input file: "+ args[0]);
        switch (args[1]) {
            case "title" -> System.out.println("QuickSort: Sort by title.");
            case "year" -> System.out.println("MergeSort: Sort by year.");
            case "rating" -> System.out.println("HeapSort: Sort by rating.");
            case "year-title" -> System.out.println("QuickSort: Sort by year first, then by title.");
            case "year-rating" -> System.out.println("MergeSort: Sort by year first, then by rating.");
            case "rating-title" -> System.out.println("HeapSort: Sort by rating first, then by title.");
            default -> {
                System.err.println("Command is invalid: ");
                System.exit(0);
            }
        }
        new SortingEntry(args[0], args[1]);
    }
}