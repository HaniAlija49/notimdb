package com.notimdb.notimdb.pojo.dto;

import java.time.LocalDate;

public class MovieUpdateRequest {

        private String title;
        private LocalDate releaseDate;
        private String description;
        private double rating;
        private String posterUrl;

        // Constructors, getters, and setters

        public MovieUpdateRequest() {
        }

        public MovieUpdateRequest(String title, LocalDate releaseDate, String description, double rating, String posterUrl) {
            this.title = title;
            this.releaseDate = releaseDate;
            this.description = description;
            this.rating = rating;
            this.posterUrl = posterUrl;
        }

        // Getters and setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public LocalDate getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getPosterUrl() {
            return posterUrl;
        }

        public void setPosterUrl(String posterUrl) {
            this.posterUrl = posterUrl;
        }
}
