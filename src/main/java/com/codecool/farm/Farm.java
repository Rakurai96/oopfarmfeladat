package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {

    private List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public void feedAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).feed();
        }
    }

    public void butcher(Butcher butcher) {
        for (int i = 0; i < animals.size(); i++) {
            if(butcher.canButcher(animals.get(i))) {
                animals.remove(i);
            }
        }
    }

    public boolean isEmpty() {
        if(animals.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> getStatus() {
        List<String> statusList = new ArrayList<>();
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            String status = "There is a ";
            status += animal.getSize();
            status += " sized ";
            status += (animal.getClass() == Pig.class ? "pig" : "cattle") + " in the farm.";
            statusList.add(status);
        }
        return statusList;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
