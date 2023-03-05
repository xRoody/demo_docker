package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@NamedEntityGraph(
        name = "Human.friends",
        attributeNodes ={
                @NamedAttributeNode("friends"),
                @NamedAttributeNode("id"),
               // @NamedAttributeNode("name"),
                //@NamedAttributeNode("lastName")
        }
)
public class Human {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    private String name;
    private String lastName;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "friends",
        joinColumns = {@JoinColumn(name = "human")},
        inverseJoinColumns = {@JoinColumn(name="friend")}
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Human> friends;

    public Human() {
    }

    public Human(UUID id, String name, String lastName, Set<Human> friends) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.friends = friends;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Human> getFriends() {
        return friends;
    }


}
