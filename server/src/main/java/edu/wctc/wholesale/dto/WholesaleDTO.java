package edu.wctc.wholesale.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class WholesaleDTO {
    private String customerName;
    private LocalDate date;
    private String poNumber;
    private String productName;
    private String terms;
    private LocalDate shipped;
    private double total;
}
