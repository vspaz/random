package class_223;

public class TestExamples {
    public static void main(String [] args) {
        String[] words = {"one", "one", "two", "three", "one", "two", "three", "four", "five", "six", "one", "two", "three", "twentyfive", "twenty"};
        WordCounter wc = new WordCounter(words);
        wc.printUniq();
        wc.printCount();

        // phonebook examples

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Doe", "012345670");
        phoneBook.add("Doe", "012345671");
        phoneBook.add("Doe", "012345672");

        phoneBook.add("Smidt", "012345673");
        phoneBook.add("Smidt", "012345674");

        phoneBook.add("Smith", "012345676");

        phoneBook.get("Smith");
        phoneBook.get("Doe");
        phoneBook.get("nonexistingname");
    }
}
