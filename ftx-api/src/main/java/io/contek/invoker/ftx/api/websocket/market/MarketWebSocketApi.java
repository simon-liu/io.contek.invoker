package io.contek.invoker.ftx.api.websocket.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.websocket.WebSocketContext;
import io.contek.invoker.ftx.api.websocket.WebSocketApi;

import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public final class MarketWebSocketApi extends WebSocketApi {

  private final Map<String, OrderBookChannel> orderBookChannels = new HashMap<>();
  private final Map<String, TickerChannel> tickerChannels = new HashMap<>();
  private final Map<String, TradesChannel> tradesChannels = new HashMap<>();

  public MarketWebSocketApi(IActor actor, WebSocketContext context) {
    super(actor, context);
  }

  public OrderBookChannel getOrderBookChannel(String symbol) {
    synchronized (orderBookChannels) {
      return orderBookChannels.computeIfAbsent(
          symbol,
          k -> {
            OrderBookChannel result = new OrderBookChannel(k);
            attach(result);
            return result;
          });
    }
  }

  public TradesChannel getTradesChannel(String symbol) {
    synchronized (tradesChannels) {
      return tradesChannels.computeIfAbsent(
          symbol,
          k -> {
            TradesChannel result = new TradesChannel(k);
            attach(result);
            return result;
          });
    }
  }

  public TickerChannel getTickerChannel(String symbol) {
    synchronized (tickerChannels) {
      return tickerChannels.computeIfAbsent(
          symbol,
          k -> {
            TickerChannel result = new TickerChannel(k);
            attach(result);
            return result;
          });
    }
  }
}
