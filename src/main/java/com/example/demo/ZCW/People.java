package com.example.demo.ZCW;

import java.util.List;

public abstract class People<PersonType extends Person>  implements Iterable<PersonType> {
    private List<PersonType> personList;

    public People(List<PersonType> personList) {
        this.personList = personList;
    }

    public void add(PersonType personType){
        personList.add(personType);
    }

    public void remove(PersonType personType){
        personList.remove(personType);
    }

    public Integer size(){
        return personList.size();
    }

    public void clear(){
        personList.clear();
    }

    public void addAll(Iterable<PersonType> iterable){
        for(PersonType person : iterable){
            personList.add(person);
        }
    }

    public PersonType findById(Long id){
        for(PersonType person : personList){
            if(person.getId().equals(id)){
                return person;
            }
        }
        return null;
    }

    public List<PersonType> findAll(){
        return personList;
    }
}
