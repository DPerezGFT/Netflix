package com.example.netflix.categories;

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
public class Category {

  @ManyToMany
  @JoinTable(
      name = "title_category",
      joinColumns = @JoinColumn(name = "title_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  Set<Title> titles;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @NotNull(message = "No puede ser nulo")
  private Integer id;
  @NotEmpty(message = "Tiene que haber nombre")
  private String  name;

}
