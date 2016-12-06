package kang.sw.mvpexample.repository.example.datasource;

import android.support.annotation.NonNull;

import kang.sw.mvpexample.repository.example.ExampleVO;
import kang.sw.mvpexample.repository.example.IExampleRepository;
import rx.Observable;

import java.util.List;

/**
 *
 * @author robin
 * @since 2016. 12. 6.
 */
public class ExampleRemoteRepository implements IExampleRepository {

  private static ExampleRemoteRepository instance;

  public static ExampleRemoteRepository getInstance() {
    if(instance == null) {
      instance = new ExampleRemoteRepository();
    }
    return instance;
  }

  @Override
  public Observable<List<ExampleVO>> getExamples() {
    return null;
  }

  @Override
  public Observable<ExampleVO> getExample() {
    return null;
  }

  @Override
  public void saveExample(@NonNull ExampleVO example) {

  }

  @Override
  public void deleteById(@NonNull String id) {

  }

  @Override
  public void deleteAll() {

  }
}
