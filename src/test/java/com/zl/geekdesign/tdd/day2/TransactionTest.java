package com.zl.geekdesign.tdd.day2;

import org.junit.jupiter.api.Test;

import javax.transaction.InvalidTransactionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 转账
 * 单元测试
 * Create by zhanglong on 2020/3/24
 */
public class TransactionTest {

    @Test
    public void testExecute() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;

        TransactionLock mockLock = new TransactionLock() {
            @Override
            public boolean lock(String id) {
                return true;
            }

            @Override
            public void unlock(String id) {
            }
        };

        Transaction transaction = new Transaction
                (null, buyerId, sellerId, productId, orderId, 1.1) {
            @Override
            protected boolean isExpired() {
                return false;
            }

        };
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        transaction.setLock(mockLock);

        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

}
