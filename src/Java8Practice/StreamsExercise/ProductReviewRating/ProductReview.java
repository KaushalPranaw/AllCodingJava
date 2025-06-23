package Java8Practice.StreamsExercise.ProductReviewRating;

import java.time.LocalDate;

public class ProductReview {
    private String productName;
    private int reviewScore;
    private LocalDate reviewDate;

    public ProductReview(String productName, int reviewScore, LocalDate reviewDate) {
        this.productName = productName;
        this.reviewScore = reviewScore;
        this.reviewDate = reviewDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "productName='" + productName + '\'' +
                ", reviewScore=" + reviewScore +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
