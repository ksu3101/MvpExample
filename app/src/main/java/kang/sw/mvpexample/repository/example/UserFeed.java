package kang.sw.mvpexample.repository.example;

import lombok.Data;

/**
 * @author KangSungWoo
 * @since 2016-12-14
 */
@Data
public class UserFeed {
  String id;
  String title;
  String short_contents;
  String thumbnail;
  int like_count;
  int reply_count;
  long lastupdated;
}
