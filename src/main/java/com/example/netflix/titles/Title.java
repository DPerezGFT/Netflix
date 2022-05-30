package com.example.netflix.titles;

import com.example.netflix.actors.Actor;
import com.example.netflix.categories.Category;
import com.example.netflix.directors.Director;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
  @Column(name = "id", nullable = false)
  @NotNull(message = "No puede ser nulo")
  private Integer id;
  @NotEmpty(message = "No puede estar vacio")
  private String  date_added;
  @NotEmpty(message = "No puede estar vacio")
  private String  release_year;
  @NotEmpty(message = "No puede estar vacio")
  private String  description;
  @NotEmpty(message = "No puede estar vacio")
  private String  duration;
  @NotEmpty(message = "No puede estar vacio")
  private String  name;
  @NotEmpty(message = "No puede estar vacio")
  private String  rating;
  @Min(0)
  private Integer num_ratings;
  @Min(0)
  @Max(10)
  private Float   user_rating;

}
