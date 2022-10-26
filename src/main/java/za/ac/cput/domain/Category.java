/*
 * Category.java
 * Entity for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * //25.10.2022
 * */

package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @NotNull
    @Id
    @Column(name = "category_id")
    private String categoryId;
    @NotNull
    private String categoryName;
    @NotNull
    private String categoryDescription;

    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
        this.categoryDescription = builder.categoryDescription;
    }

    // This was a private constructor - Needs to be Public!
    public Category() {

    }

    public String getCategoryId() {return categoryId;}
    public String getCategoryName() {return categoryName;}
    public String getCategoryDescription() {return categoryDescription;}

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }


    public static class Builder {
        private String categoryId;
        private String categoryName;
        private String categoryDescription;

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
            return this;
        }

        public Builder copy(Category cat){
            this.categoryId = cat.categoryId;
            this.categoryName = cat.categoryName;
            this.categoryDescription = cat.categoryDescription;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
