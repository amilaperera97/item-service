
package com.techbooker.item.dto.external.endpoint.aldi.find_item_price_info.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ProductId",
    "IsPriceDiscounted",
    "DefaultListPrice",
    "ListPrice",
    "VariantPrices",
    "JsonContext",
    "IsOnSale",
    "UnitPrice"
})
@Generated("jsonschema2pojo")
public class ProductPrice {

    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("IsPriceDiscounted")
    private Boolean isPriceDiscounted;
    @JsonProperty("DefaultListPrice")
    private String defaultListPrice;
    @JsonProperty("ListPrice")
    private String listPrice;
    @JsonProperty("VariantPrices")
    private List<Object> variantPrices = new ArrayList<Object>();
    @JsonProperty("JsonContext")
    private String jsonContext;
    @JsonProperty("IsOnSale")
    private Boolean isOnSale;
    @JsonProperty("UnitPrice")
    private String unitPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ProductId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ProductPrice withProductId(String productId) {
        this.productId = productId;
        return this;
    }

    @JsonProperty("IsPriceDiscounted")
    public Boolean getIsPriceDiscounted() {
        return isPriceDiscounted;
    }

    @JsonProperty("IsPriceDiscounted")
    public void setIsPriceDiscounted(Boolean isPriceDiscounted) {
        this.isPriceDiscounted = isPriceDiscounted;
    }

    public ProductPrice withIsPriceDiscounted(Boolean isPriceDiscounted) {
        this.isPriceDiscounted = isPriceDiscounted;
        return this;
    }

    @JsonProperty("DefaultListPrice")
    public String getDefaultListPrice() {
        return defaultListPrice;
    }

    @JsonProperty("DefaultListPrice")
    public void setDefaultListPrice(String defaultListPrice) {
        this.defaultListPrice = defaultListPrice;
    }

    public ProductPrice withDefaultListPrice(String defaultListPrice) {
        this.defaultListPrice = defaultListPrice;
        return this;
    }

    @JsonProperty("ListPrice")
    public String getListPrice() {
        return listPrice;
    }

    @JsonProperty("ListPrice")
    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public ProductPrice withListPrice(String listPrice) {
        this.listPrice = listPrice;
        return this;
    }

    @JsonProperty("VariantPrices")
    public List<Object> getVariantPrices() {
        return variantPrices;
    }

    @JsonProperty("VariantPrices")
    public void setVariantPrices(List<Object> variantPrices) {
        this.variantPrices = variantPrices;
    }

    public ProductPrice withVariantPrices(List<Object> variantPrices) {
        this.variantPrices = variantPrices;
        return this;
    }

    @JsonProperty("JsonContext")
    public String getJsonContext() {
        return jsonContext;
    }

    @JsonProperty("JsonContext")
    public void setJsonContext(String jsonContext) {
        this.jsonContext = jsonContext;
    }

    public ProductPrice withJsonContext(String jsonContext) {
        this.jsonContext = jsonContext;
        return this;
    }

    @JsonProperty("IsOnSale")
    public Boolean getIsOnSale() {
        return isOnSale;
    }

    @JsonProperty("IsOnSale")
    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public ProductPrice withIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
        return this;
    }

    @JsonProperty("UnitPrice")
    public String getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("UnitPrice")
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public ProductPrice withUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ProductPrice withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductPrice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("isPriceDiscounted");
        sb.append('=');
        sb.append(((this.isPriceDiscounted == null)?"<null>":this.isPriceDiscounted));
        sb.append(',');
        sb.append("defaultListPrice");
        sb.append('=');
        sb.append(((this.defaultListPrice == null)?"<null>":this.defaultListPrice));
        sb.append(',');
        sb.append("listPrice");
        sb.append('=');
        sb.append(((this.listPrice == null)?"<null>":this.listPrice));
        sb.append(',');
        sb.append("variantPrices");
        sb.append('=');
        sb.append(((this.variantPrices == null)?"<null>":this.variantPrices));
        sb.append(',');
        sb.append("jsonContext");
        sb.append('=');
        sb.append(((this.jsonContext == null)?"<null>":this.jsonContext));
        sb.append(',');
        sb.append("isOnSale");
        sb.append('=');
        sb.append(((this.isOnSale == null)?"<null>":this.isOnSale));
        sb.append(',');
        sb.append("unitPrice");
        sb.append('=');
        sb.append(((this.unitPrice == null)?"<null>":this.unitPrice));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.defaultListPrice == null)? 0 :this.defaultListPrice.hashCode()));
        result = ((result* 31)+((this.unitPrice == null)? 0 :this.unitPrice.hashCode()));
        result = ((result* 31)+((this.productId == null)? 0 :this.productId.hashCode()));
        result = ((result* 31)+((this.variantPrices == null)? 0 :this.variantPrices.hashCode()));
        result = ((result* 31)+((this.jsonContext == null)? 0 :this.jsonContext.hashCode()));
        result = ((result* 31)+((this.isPriceDiscounted == null)? 0 :this.isPriceDiscounted.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.isOnSale == null)? 0 :this.isOnSale.hashCode()));
        result = ((result* 31)+((this.listPrice == null)? 0 :this.listPrice.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductPrice) == false) {
            return false;
        }
        ProductPrice rhs = ((ProductPrice) other);
        return ((((((((((this.defaultListPrice == rhs.defaultListPrice)||((this.defaultListPrice!= null)&&this.defaultListPrice.equals(rhs.defaultListPrice)))&&((this.unitPrice == rhs.unitPrice)||((this.unitPrice!= null)&&this.unitPrice.equals(rhs.unitPrice))))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.variantPrices == rhs.variantPrices)||((this.variantPrices!= null)&&this.variantPrices.equals(rhs.variantPrices))))&&((this.jsonContext == rhs.jsonContext)||((this.jsonContext!= null)&&this.jsonContext.equals(rhs.jsonContext))))&&((this.isPriceDiscounted == rhs.isPriceDiscounted)||((this.isPriceDiscounted!= null)&&this.isPriceDiscounted.equals(rhs.isPriceDiscounted))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.isOnSale == rhs.isOnSale)||((this.isOnSale!= null)&&this.isOnSale.equals(rhs.isOnSale))))&&((this.listPrice == rhs.listPrice)||((this.listPrice!= null)&&this.listPrice.equals(rhs.listPrice))));
    }

}
