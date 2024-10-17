package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if (pers.getName().contains(key)
                    || pers.getSurname().contains(key)
                    || pers.getPhone().contains(key)
                    || pers.getAddress().contains(key)) {
                result.add(pers);
            }
        }
        return result;
    }
 */

/*
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> surnamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);

        Predicate<Person> combine = namePredicate
                .or(surnamePredicate)
                .or(phonePredicate)
                .or(addressPredicate);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;

    }
}
 */

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> surnamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);

        Predicate<Person> combine = namePredicate
                .or(surnamePredicate)
                .or(phonePredicate)
                .or(addressPredicate);

        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
        
    }
}