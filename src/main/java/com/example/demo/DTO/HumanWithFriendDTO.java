package com.example.demo.DTO;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HumanWithFriendDTO extends HumanDTO{
    private Set<HumanDTO> friends=new HashSet<>();

    public HumanWithFriendDTO(UUID id, String name, String lastName, Set<HumanDTO> friends) {
        super(id, name, lastName);
        this.friends = friends;
    }

    public Set<HumanDTO> getFriends() {
        return friends;
    }

    public void setFriends(Set<HumanDTO> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "HumanWithFriendDTO{" +
                "id="+getId()+
                ", name=" + getName() +
                ", lastname=" + getLastName() +
                ", friends=" + friends +
                '}';
    }
}
