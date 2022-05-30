package com.example.netflix.titles;

import com.example.netflix.actors.Actor;
import com.example.netflix.categories.Category;
import com.example.netflix.directors.Director;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Title {
  @ManyToMany
  @JoinTable(
      name = "title_director",
      joinColumns = @JoinColumn(name = "director_id"),
      inverseJoinColumns = @JoinColumn(name = "title_id")
  )
  Set<Director> directors;
  @ManyToMany
  @JoinTable(
      name = "title_actor",
      joinColumns = @JoinColumn(name = "actor_id"),
      inverseJoinColumns = @JoinColumn(name = "title_id")
  )
  Set<Actor>    actors;
  @ManyToMany
  @JoinTable(
      name = "title_category",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "title_id")
  )
  Set<Category> categories;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String  date_added;
  private String  release_year;
  private String  description;
  private String  duration;
  private String  name;
  private String  rating;
  private Integer num_ratings;
  private Float   user_rating;

}
