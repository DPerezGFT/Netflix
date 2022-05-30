package com.example.netflix.recommend;

import com.example.netflix.titles.TitleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendController {
  private final TitleRepository titleRepository;

  public RecommendController(TitleRepository titleRepository) {this.titleRepository = titleRepository;}

  @GetMapping("/recommend/best")
  Object best(@RequestParam(defaultValue = "10") Integer top) {
    return titleRepository.findTop10ByTitleOrderByUser_ratingDesc(PageRequest.of(0, top));
  }

  @GetMapping("/recommend/category/{id}")
  Object best(Integer id, @RequestParam(defaultValue = "10") Integer top) {
    return titleRepository.findTop10ByCategoriesContainingOrderByUser_ratingDesc(id, PageRequest.of(0, top));
  }

}
