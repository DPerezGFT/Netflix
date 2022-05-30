package com.example.netflix.actors;

import com.example.netflix.titles.Title;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
  @Column(name = "id", nullable = false)
  @NotNull(message = "No puede ser nulo")
  private Integer id;
  @NotEmpty(message = "Tiene que haber nombre")
  private String  name;

}
