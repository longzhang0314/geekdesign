package com.zl.geekdesign.tdd.day2;


import javax.transaction.InvalidTransactionException;

/**
 * 转账
 * 重构后
 * Create by zhanglong on 2020/3/24
 */

public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private Long orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;

    public STATUS getStatus() {
        return status;
    }

    private String walletTransactionId;

    private WalletRpcService walletRpcService;
    private TransactionLock lock;

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    public void setLock(TransactionLock lock) {
        this.lock = lock;
    }

    // ...get() methods...

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, Long orderId, Double amount) {
        //重构后删除
//        if (preAssignedId != null && !preAssignedId.isEmpty()) {
//            this.id = preAssignedId;
//        } else {
//            this.id = IdGenerator.generateId();
//        }
//        if (!this.id.startsWith("t_")) {
//            this.id = "t_" + preAssignedId;
//        }
        fillTransactionId(preAssignedId);
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
        this.amount = amount;
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || (sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException("request params is invalid!");
        }
        if (status == STATUS.EXECUTED)
            return true;
        boolean isLocked = false;
        try {
            isLocked = lock.lock(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED)
                return true; // double check
            //  long executionInvokedTimestamp = System.currentTimeMillis(); 重构后删除
            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }
            // WalletRpcService walletRpcService = new WalletRpcService(); 重构后删除
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                lock.unlock(id);
            }
        }
    }

    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp > 14 * 1000 * 60 * 60 * 24;
    }

    protected void fillTransactionId(String preAssignedId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
    }

}
