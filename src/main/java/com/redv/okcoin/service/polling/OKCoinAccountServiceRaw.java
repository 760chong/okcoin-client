package com.redv.okcoin.service.polling;

import com.redv.okcoin.domain.UserInfo;
import com.xeiam.xchange.ExchangeSpecification;

public class OKCoinAccountServiceRaw extends OKCoinBaseTradePollingService {

	private static final String METHOD_GET_USER_INFO = "userinfo";

	/**
	 * @param exchangeSpecification
	 */
	protected OKCoinAccountServiceRaw(
			ExchangeSpecification exchangeSpecification) {
		super(exchangeSpecification);
	}

	public UserInfo getUserInfo() {
		sleep(METHOD_GET_USER_INFO);
		UserInfo userInfo = okCoin.getUserInfo(partner, signatureCreator.sign());
		updateLast(METHOD_GET_USER_INFO);
		return returnOrThrow(userInfo);
	}

}