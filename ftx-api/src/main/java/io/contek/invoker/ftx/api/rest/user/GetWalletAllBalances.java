package io.contek.invoker.ftx.api.rest.user;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.ftx.api.common._WalletBalance;
import io.contek.invoker.ftx.api.rest.common.RestResponse;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Map;

import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetWalletAllBalances extends UserRestRequest<GetWalletAllBalances.Response> {

  GetWalletAllBalances(IActor actor, RestContext context) {
    super(actor, context);
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/wallet/all_balances";
  }

  @Override
  protected RestParams getParams() {
    return RestParams.empty();
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends RestResponse<Map<String, List<_WalletBalance>>> {}
}
