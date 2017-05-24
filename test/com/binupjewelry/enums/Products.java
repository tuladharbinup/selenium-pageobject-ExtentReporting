/**
 * Created by binup on 5/13/2017.
 */
package com.binupjewelry.enums;

public enum Products {
	PandoraSilverRoseRing("BIN72034", "PANDORA Silver Pink Enamel Rose Ring 190905EN40"),
	PandoraSilverBirthsoneRing("BIN2004", "Pandora Silver Beaded January Garnet Birthsone Ring 190854GA");	

    //The price will fluctuate. So, we will utilize only the product code and title that will be more or less constant.
    private String productCode;
    private String productTitle;

    Products(String productCode, String productTitle){
        this.productCode = productCode;
        this.productTitle = productTitle;
    }

    public String getProductCode(){
        return productCode;
    }

    public String getProductTitle(){
        return productTitle;
    }
}
