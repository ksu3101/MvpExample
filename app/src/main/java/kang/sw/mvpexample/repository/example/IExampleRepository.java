package kang.sw.mvpexample.repository.example;

import android.support.annotation.NonNull;

import rx.Observable;

import java.util.List;

/**
 * @author robin
 * @since 2016. 12. 6.
 */
public interface IExampleRepository {

  Observable<List<ExampleVO>> getExamples();

  Observable<ExampleVO> getExample();

  void saveExample(@NonNull ExampleVO example);

  void deleteById(@NonNull String id);

  void deleteAll();

}
