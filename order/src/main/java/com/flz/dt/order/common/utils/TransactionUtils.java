package com.flz.dt.order.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Component
public class TransactionUtils {

    public void runAfterCommit(Runnable runnable) {
        runByTransactionStatus(TransactionSynchronization.STATUS_COMMITTED, runnable);
    }

    public void runAfterRollback(Runnable runnable) {
        runByTransactionStatus(TransactionSynchronization.STATUS_ROLLED_BACK, runnable);
    }

    private void runByTransactionStatus(int transactionStatus, Runnable runnable) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCompletion(int status) {// after commit or rollback
                log.info("-----after completion-----");
                if (status == transactionStatus) {
                    runnable.run();
                }
            }
        });
    }
}
