package kang.sw.mvpexample.main;

import kang.sw.mvpexample.utils.mvp.presenters.BaseState;

/**
 * @author robin
 * @since 2016. 12. 8.
 */
public class MainFragmentState implements BaseState {

  private int counterValue;

  public MainFragmentState(int counterValue) {
    this.counterValue = counterValue;
  }

  public int getCounterValue() {
    return counterValue;
  }

}
