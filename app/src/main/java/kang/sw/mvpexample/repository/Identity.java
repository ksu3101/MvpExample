package kang.sw.mvpexample.repository;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author robin
 * @since 2016. 12. 6.
 */
@EqualsAndHashCode(of = { "_id" })
public class Identity {

  @Getter
  private String _id;

}
