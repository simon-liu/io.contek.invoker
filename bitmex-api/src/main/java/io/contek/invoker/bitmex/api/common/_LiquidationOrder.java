package io.contek.invoker.bitmex.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _LiquidationOrder {

  public String orderID;
  public String symbol;
  public String side;
  public Double price;
  public Double leavesQty;
}
