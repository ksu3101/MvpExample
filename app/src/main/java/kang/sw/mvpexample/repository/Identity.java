package kang.sw.mvpexample.repository;

import com.google.common.base.Objects;

import java.util.UUID;

/**
 * @author robin
 * @since 2016. 12. 6.
 */
public class Identity {
  private final String _id;

  public Identity() {
    this._id = UUID.randomUUID().toString();
  }

  public String getId() {
    return _id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Identity) {
      Identity identity = (Identity) obj;
      return Objects.equal(_id, identity.getId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(_id);
  }

  @Override
  public String toString() {
    return (this.getClass().getSimpleName() + " [ UID = " + _id + " ]");
  }

}
