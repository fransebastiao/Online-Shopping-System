/*
 * Category.java
 * Entity for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.entity;

public class Category {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;

    public Category() {
    }

    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
        this.categoryDescription = builder.categoryDescription;
    }

    public String getCategoryId() {return categoryId;}

    public void setCategoryId(String categoryId) {this.categoryId = categoryId;}

    public String getCategoryName() {return categoryName;}

    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}

    public String getCategoryDescription() {return categoryDescription;}

    public void setCategoryDescription(String categoryDescription) {this.categoryDescription = categoryDescription;}

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

