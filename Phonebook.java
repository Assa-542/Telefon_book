import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "89153324356");
        addContact(phoneBook, "Петров", "89163334253");
        addContact(phoneBook, "Сидоров", "89162453223");
        addContact(phoneBook, "Иванов", "89263338502");
        addContact(phoneBook, "Петров", "89123994554");
        addContact(phoneBook, "Сидоров", "89163249888");

        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(sortedEntries, (entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void addContact(HashMap<String, HashSet<String>> phoneBook, String name, String phoneNumber) {

        if (phoneBook.containsKey(name)) {
            HashSet<String> numbers = phoneBook.get(name);
            numbers.add(phoneNumber);
        } else {
            // Если нет, создаем новую запись в книге
            HashSet<String> numbers = new HashSet<>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }
}
