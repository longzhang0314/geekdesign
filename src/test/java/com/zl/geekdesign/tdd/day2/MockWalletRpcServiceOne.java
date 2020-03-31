package com.zl.geekdesign.tdd.day2;

/**
 * Create by zhanglong on 2020/3/24
 */
public class MockWalletRpcServiceOne extends WalletRpcService {

    @Override
    public String moveMoney(String id, Long buyerId, Long sellerId, Double amount) {
        return "123456abc";
    }
}
