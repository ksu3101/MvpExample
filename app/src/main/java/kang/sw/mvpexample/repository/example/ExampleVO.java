package kang.sw.mvpexample.repository.example;

import kang.sw.mvpexample.repository.Identity;
import lombok.Data;


/**
 * @author robin
 * @since 2016. 12. 6.
 */
@Data
public class ExampleVO extends Identity {

  String title;
  String description;

}
