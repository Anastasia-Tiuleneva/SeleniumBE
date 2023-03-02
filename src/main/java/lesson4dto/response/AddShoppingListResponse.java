
package lesson4dto.response;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "measures",
    "usages",
    "usageRecipeIds",
    "pantryItem",
    "aisle",
    "cost",
    "ingredientId"
})
@Generated("jsonschema2pojo")
public class AddShoppingListResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("measures")
    private Measures measures;
    @JsonProperty("usages")
    private List<Object> usages = new ArrayList<Object>();
    @JsonProperty("usageRecipeIds")
    private List<Object> usageRecipeIds = new ArrayList<Object>();
    @JsonProperty("pantryItem")
    private Boolean pantryItem;
    @JsonProperty("aisle")
    private String aisle;
    @JsonProperty("cost")
    private Double cost;
    @JsonProperty("ingredientId")
    private Integer ingredientId;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("measures")
    public Measures getMeasures() {
        return measures;
    }

    @JsonProperty("measures")
    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    @JsonProperty("usages")
    public List<Object> getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(List<Object> usages) {
        this.usages = usages;
    }

    @JsonProperty("usageRecipeIds")
    public List<Object> getUsageRecipeIds() {
        return usageRecipeIds;
    }

    @JsonProperty("usageRecipeIds")
    public void setUsageRecipeIds(List<Object> usageRecipeIds) {
        this.usageRecipeIds = usageRecipeIds;
    }

    @JsonProperty("pantryItem")
    public Boolean getPantryItem() {
        return pantryItem;
    }

    @JsonProperty("pantryItem")
    public void setPantryItem(Boolean pantryItem) {
        this.pantryItem = pantryItem;
    }

    @JsonProperty("aisle")
    public String getAisle() {
        return aisle;
    }

    @JsonProperty("aisle")
    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    @JsonProperty("cost")
    public Double getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Double cost) {
        this.cost = cost;
    }

    @JsonProperty("ingredientId")
    public Integer getIngredientId() {
        return ingredientId;
    }

    @JsonProperty("ingredientId")
    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public String toString() {
        return "AddShoppingListResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measures=" + measures +
                ", usages=" + usages +
                ", usageRecipeIds=" + usageRecipeIds +
                ", pantryItem=" + pantryItem +
                ", aisle='" + aisle + '\'' +
                ", cost=" + cost +
                ", ingredientId=" + ingredientId +
                '}';
    }
}
