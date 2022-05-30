package com.example.netflix.categories;

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
public class Category {

  @ManyToMany
  @JoinTable(
      name = "title_category",
      joinColumns = @JoinColumn(name = "title_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  Set<Title> titles;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String  name;

}
