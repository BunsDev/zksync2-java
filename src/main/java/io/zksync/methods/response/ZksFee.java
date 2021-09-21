package io.zksync.methods.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZksFee {

    private String gasTxAmount;

    private String gasPriceWei;

    private String gasFee;

    private String zkpFee;

    private String totalFee;

    public BigInteger getTotalFeeInteger() {
        return new BigInteger(totalFee);
    }
}
