package com.example.netflix.titles;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "title", path = "title")
public interface TitleRepository extends PagingAndSortingRepository<Title, Integer> {

  @Query(value = "select * from title order by user_rating desc", nativeQuery = true)
  List<Title> findTop10ByTitleOrderByUser_ratingDesc(Pageable pageable);

  @Query(value = "select * from title where category_id = ?0 order by user_rating desc", nativeQuery = true)
  List<Title> findTop10ByCategoriesContainingOrderByUser_ratingDesc(Integer category_id, Pageable pageable);
}
