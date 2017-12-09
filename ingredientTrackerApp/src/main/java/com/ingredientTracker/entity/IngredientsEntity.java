package com.ingredientTracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "Ingredients", schema = "IngredientTracker")
public class IngredientsEntity {

    private int ingredientId;
    private String ingredientName;
    private Integer ingredientQuantity;
    private Integer userid;

    @Id
    @Column(name = "ingredientId", nullable = false)
    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Basic
    @Column(name = "ingredientName", nullable = true, length = -1)
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Basic
    @Column(name = "ingredientQuantity", nullable = true)
    public Integer getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(Integer ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientsEntity that = (IngredientsEntity) o;

        if (ingredientId != that.ingredientId) return false;
        if (ingredientName != null ? !ingredientName.equals(that.ingredientName) : that.ingredientName != null) return false;
        if (ingredientQuantity != null ? !ingredientQuantity.equals(that.ingredientQuantity) : that.ingredientQuantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ingredientId;
        result = 31 * result + (ingredientName != null ? ingredientName.hashCode() : 0);
        result = 31 * result + (ingredientQuantity != null ? ingredientQuantity.hashCode() : 0);
        return result;
    }
}
