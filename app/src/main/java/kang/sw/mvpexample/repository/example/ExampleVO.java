package kang.sw.mvpexample.repository.example;

import kang.sw.mvpexample.repository.Identity;

/**
 * @author robin
 * @since 2016. 12. 6.
 */
public class ExampleVO extends Identity {

  String title;
  String description;

  public ExampleVO(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
