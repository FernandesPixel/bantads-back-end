package com.tads.bantads.model;

import java.math.BigDecimal;

public class Account {
    private long id;
    private BigDecimal balance;
    private BigDecimal salary;
    private BigDecimal limit;
    private Manager manager;
    private Boolean approved;
    private String accountStatus;
}
