package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    static Random random = new Random();

    boolean addNewDish(HashMap<String, ArrayList<String>> menu, String dishType, String dishName) {
        ArrayList<String> dishes = menu.getOrDefault(dishType, new ArrayList<>());
        if (!dishes.contains(dishName)) {
            dishes.add(dishName);
            menu.put(dishType, dishes);
            return true;
        } else {
            return false;
        }
    }


    ArrayList<ArrayList<String>> generateCombo(HashMap<String, ArrayList<String>> menu, ArrayList<String> types,
                                               int numberOfCombos) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                combo.add(menu.get(type).get(random.nextInt(menu.get(type).size())));
            }
            combos.add(combo);
        }
        return combos;
    }
}

