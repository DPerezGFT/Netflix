package com.example.netflix.actors;

import com.example.netflix.titles.Title;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Actor {

  @ManyToMany
  @JoinTable(
      name = "title_actor",
      joinColumns = @JoinColumn(name = "title_id"),
      inverseJoinColumns = @JoinColumn(name = "actor_id")
  )
  Set<Title> titles;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String  name;

}
