package kang.sw.mvpexample.repository.example;

import android.support.annotation.NonNull;

import kang.sw.mvpexample.repository.Identity;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author robin
 * @since 2016. 12. 6.
 */
public class ExampleRepository implements IExampleRepository {

  private static ExampleRepository instance;

  private IExampleRepository remoteRepository;
  private IExampleRepository localRepository;
  private Map<String, ExampleVO> cachedDatas;

  private ExampleRepository(@NonNull IExampleRepository localRepository, @NonNull IExampleRepository remoteRepository) {
    this.localRepository = localRepository;
    this.remoteRepository = remoteRepository;
  }

  public static ExampleRepository getInstance(@NonNull IExampleRepository localRepository, @NonNull IExampleRepository remoteRepository) {
    if (instance == null) {
      instance = new ExampleRepository(localRepository, remoteRepository);
    }
    return instance;
  }

  @Override
  public Observable<List<ExampleVO>> getExamples() {
    if (cachedDatas != null) {
      return Observable.from(cachedDatas.values()).toList();
    }
    else {
      cachedDatas = new LinkedHashMap<>();
    }

    Observable<List<ExampleVO>> remoteDatas = getExamplesFromRemoteAndSaveToCache();
    Observable<List<ExampleVO>> localDatas = getExamplesFromLocalAndSaveToCache();

    return Observable.concat(localDatas, remoteDatas)
      .filter(new Func1<List<ExampleVO>, Boolean>() {
        @Override
        public Boolean call(List<ExampleVO> exampleVOs) {
          return (!exampleVOs.isEmpty());
        }
      })
      .first();
  }

  private Observable<List<ExampleVO>> getExamplesFromRemoteAndSaveToCache() {
    return remoteRepository.getExamples()
      .flatMap(new Func1<List<ExampleVO>, Observable<List<ExampleVO>>>() {
        @Override
        public Observable<List<ExampleVO>> call(List<ExampleVO> voList) {
          return Observable.from(voList)
            .doOnNext(new Action1<ExampleVO>() {
              @Override
              public void call(ExampleVO exampleVO) {
                cachedDatas.put(exampleVO.get_id(), exampleVO);
              }
            }).toList();
        }
      });
  }

  private Observable<List<ExampleVO>> getExamplesFromLocalAndSaveToCache() {
    return localRepository.getExamples()
      .flatMap(new Func1<List<ExampleVO>, Observable<List<ExampleVO>>>() {
        @Override
        public Observable<List<ExampleVO>> call(List<ExampleVO> voList) {
          return Observable.from(voList)
            .doOnNext(new Action1<ExampleVO>() {
              @Override
              public void call(ExampleVO exampleVO) {
                localRepository.saveExample(exampleVO);
                cachedDatas.put(exampleVO.get_id(), exampleVO);
              }
            }).toList();
        }
      });
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
