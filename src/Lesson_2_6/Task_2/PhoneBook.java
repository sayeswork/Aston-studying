package Lesson_2_6.Task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new ArrayList<>());
        }

        phoneBook.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        if (!phoneBook.containsKey(surname)) {
            return new ArrayList<>();
        }

        return phoneBook.get(surname);
    }
}
