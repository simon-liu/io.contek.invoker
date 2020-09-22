package io.contek.invoker.commons.api.actor.security;

import javax.annotation.concurrent.Immutable;

@Immutable
public interface ICredential {

  static Anonymous anonymous() {
    return Anonymous.INSTANCE;
  }

  boolean isAnonymous();

  String getApiKeyId();

  String sign(String payload);

  @Immutable
  final class Anonymous implements ICredential {

    private static final Anonymous INSTANCE = new Anonymous();

    @Override
    public boolean isAnonymous() {
      return true;
    }

    @Override
    public String getApiKeyId() {
      throw new UnsupportedOperationException();
    }

    @Override
    public String sign(String payload) {
      throw new UnsupportedOperationException();
    }

    private Anonymous() {}
  }
}
