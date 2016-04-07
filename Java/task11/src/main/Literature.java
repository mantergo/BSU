package main;


public class Literature {
    private String mainAuthor;
    private String authors;
    private String title;
    private String place;
    private String publishing;
    private String yearOfPublishing;
    private String pages;

    public void setMainAuthor(String mainAuthor) {
        this.mainAuthor = mainAuthor;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPublishing(String publishing) {this.publishing = publishing;}

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String toString() {
        return "\nmain author: " + mainAuthor +
                "\nauthors: " + authors +
                "\ntitle:   " + title +
                "\nplace:   " + place +
                "\npublishing: " + publishing +
                "\nthe year of publishing:  " + yearOfPublishing +
                "\npages:   " + pages + "\n";
    }
}
