package kang.sw.mvpexample.repository.example;

import java.util.List;

import lombok.Data;

/**
 * @author KangSungWoo
 * @since 2016-12-14
 */
@Data
public class UserInfo {
  int            id;
  String         email;
  String         nick_name;
  String         thumbnail;
  List<UserFeed> feeds;
}
