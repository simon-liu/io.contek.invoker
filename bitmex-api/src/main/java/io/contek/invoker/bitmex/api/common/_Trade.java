package io.contek.invoker.bitmex.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Trade {

  public String timestamp;
  public String symbol;
  public String side;
  public Double size;
  public Double price;
  public String tickDirection;
  public String trdMatchID;
  public Double grossValue;
  public Double homeNotional;
  public Double foreignNotional;
}
