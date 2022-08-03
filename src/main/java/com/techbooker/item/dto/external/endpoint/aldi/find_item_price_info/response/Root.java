
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
    "ProductPrices",
    "Currency",
    "JsonContext"
})
@Generated("jsonschema2pojo")
public class Root {

    @JsonProperty("ProductPrices")
    private List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("JsonContext")
    private String jsonContext;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ProductPrices")
    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    @JsonProperty("ProductPrices")
    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    public Root withProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
        return this;
    }

    @JsonProperty("Currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Root withCurrency(Currency currency) {
        this.currency = currency;
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

    public Root withJsonContext(String jsonContext) {
        this.jsonContext = jsonContext;
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

    public Root withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Root.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productPrices");
        sb.append('=');
        sb.append(((this.productPrices == null)?"<null>":this.productPrices));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("jsonContext");
        sb.append('=');
        sb.append(((this.jsonContext == null)?"<null>":this.jsonContext));
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
        result = ((result* 31)+((this.productPrices == null)? 0 :this.productPrices.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.jsonContext == null)? 0 :this.jsonContext.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Root) == false) {
            return false;
        }
        Root rhs = ((Root) other);
        return (((((this.productPrices == rhs.productPrices)||((this.productPrices!= null)&&this.productPrices.equals(rhs.productPrices)))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.jsonContext == rhs.jsonContext)||((this.jsonContext!= null)&&this.jsonContext.equals(rhs.jsonContext))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
