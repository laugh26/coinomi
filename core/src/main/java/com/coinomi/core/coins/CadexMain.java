package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 */
public class CadexMain extends BitFamily {
    private CadexMain() {
        id = "cadex.main"; // Do not change this id as wallets serialize this string

        addressHeader = 76;
        p2shHeader = 16;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 204;

        name = "Cadex";
        symbol = "CADEX";
        uriScheme = "cadex"; // TODO add multi uri, darkcoin
        bip44Index = 5;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 cadex mininput
        softDustLimit = value(100000); // 0.001  cadex
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("Cadex Signed Message:\n");
    }

    private static CadexMain instance = new CadexMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
