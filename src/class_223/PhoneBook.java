package class_223;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> nameToPhone;

    public PhoneBook() {
        nameToPhone = new HashMap<>();
    }

    public void add(String name, String number) {
        ArrayList<String> phones;
        if (nameToPhone.containsKey(name)) {
            phones = nameToPhone.get(name);
        } else {
            phones = new ArrayList<>();

        }
        phones.add(number);
        nameToPhone.put(name, phones);
    }

    public void get(String name) {
        if (nameToPhone.containsKey(name)) {
            ArrayList<String> phones = nameToPhone.get(name);
            Collections.sort(phones);
            for (String phone : phones) {
                System.out.println(String.format("%-10s - %s", name, phone));
            }
        } else {
            System.out.println(String.format("No entries found for '%s'.", name));
        }
    }
}
