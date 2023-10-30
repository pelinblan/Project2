import java.io.*;
import java.util.*;
public class SortingEntry {
    public SortingEntry(String filename, String command) throws FileNotFoundException {
        ArrayList<FilmRecord> records = new ArrayList<>();
        // Read data from file
        File input = new File(filename);
        Scanner scnr = new Scanner(input);
        scnr.nextLine();
        int count = 0;
        while (scnr.hasNext()) {
            String line = scnr.nextLine();
            try {
                FilmRecord record = new FilmRecord(line.split(","));
                records.add(record);
            } catch (Exception e) {
                continue;
            }
            count++;
            if (count == 5) {
                break;
            }
        }
        System.out.println("There are " + records.size() + " records in list.");
        System.out.println(records);

        // Your Implement Here
        switch (command) {
            // case "title" -> System.out.println("QuickSort: Sort by title.");
            // case "year" -> System.out.println("MergeSort: Sort by year.");
            // case "rating" -> System.out.println("HeapSort: Sort by rating.");
            // case "year-title" -> System.out.println("QuickSort: Sort by year first, then by title.");
            // case "year-rating" -> System.out.println("MergeSort: Sort by year first, then by rating.");
            // case "rating-title" -> System.out.println("HeapSort: Sort by rating first, then by title.");
        }
    }
}




