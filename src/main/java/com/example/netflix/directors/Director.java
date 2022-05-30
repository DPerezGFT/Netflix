package com.example.netflix.directors;

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
public class Director {

  @ManyToMany
  @JoinTable(
      name = "title_director",
      joinColumns = @JoinColumn(name = "title_id"),
      inverseJoinColumns = @JoinColumn(name = "director_id")
  )
  Set<Title> titles;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String  name;

}
