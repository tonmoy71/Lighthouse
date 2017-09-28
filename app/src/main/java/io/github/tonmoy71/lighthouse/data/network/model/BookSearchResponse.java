package io.github.tonmoy71.lighthouse.data.network.model;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "GoodreadsResponse") public class BookSearchResponse {

  @Element(name = "search", required = false) Search search;

  @Element(name = "Request", required = false) Request request;

  public Search getSearch() {
    return this.search;
  }

  public void setSearch(Search value) {
    this.search = value;
  }

  public Request getRequest() {
    return this.request;
  }

  public void setRequest(Request value) {
    this.request = value;
  }

  public static class Method {

    @Element(name = "#cdata-section", required = false) String cdataSection;

    public String getCdataSection() {
      return this.cdataSection;
    }

    public void setCdataSection(String value) {
      this.cdataSection = value;
    }
  }

  public static class BooksCount {

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class OriginalPublicationMonth {

    @Attribute(name = "nil", required = false) Boolean nil;

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public Boolean getNil() {
      return this.nil;
    }

    public void setNil(Boolean value) {
      this.nil = value;
    }

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class Work {

    @Element(name = "books_count", required = false) BooksCount booksCount;

    @Element(name = "text_reviews_count", required = false) TextReviewsCount textReviewsCount;

    @Element(name = "original_publication_month", required = false) OriginalPublicationMonth
        originalPublicationMonth;

    @Element(name = "best_book", required = false) BestBook bestBook;

    @Element(name = "original_publication_day", required = false) OriginalPublicationDay
        originalPublicationDay;

    @Element(name = "average_rating", required = false) String averageRating;

    @Element(name = "id", required = false) Id id;

    @Element(name = "original_publication_year", required = false) OriginalPublicationYear
        originalPublicationYear;

    @Element(name = "ratings_count", required = false) RatingsCount ratingsCount;

    public BooksCount getBooksCount() {
      return this.booksCount;
    }

    public void setBooksCount(BooksCount value) {
      this.booksCount = value;
    }

    public TextReviewsCount getTextReviewsCount() {
      return this.textReviewsCount;
    }

    public void setTextReviewsCount(TextReviewsCount value) {
      this.textReviewsCount = value;
    }

    public OriginalPublicationMonth getOriginalPublicationMonth() {
      return this.originalPublicationMonth;
    }

    public void setOriginalPublicationMonth(OriginalPublicationMonth value) {
      this.originalPublicationMonth = value;
    }

    public BestBook getBestBook() {
      return this.bestBook;
    }

    public void setBestBook(BestBook value) {
      this.bestBook = value;
    }

    public OriginalPublicationDay getOriginalPublicationDay() {
      return this.originalPublicationDay;
    }

    public void setOriginalPublicationDay(OriginalPublicationDay value) {
      this.originalPublicationDay = value;
    }

    public String getAverageRating() {
      return this.averageRating;
    }

    public void setAverageRating(String value) {
      this.averageRating = value;
    }

    public Id getId() {
      return this.id;
    }

    public void setId(Id value) {
      this.id = value;
    }

    public OriginalPublicationYear getOriginalPublicationYear() {
      return this.originalPublicationYear;
    }

    public void setOriginalPublicationYear(OriginalPublicationYear value) {
      this.originalPublicationYear = value;
    }

    public RatingsCount getRatingsCount() {
      return this.ratingsCount;
    }

    public void setRatingsCount(RatingsCount value) {
      this.ratingsCount = value;
    }
  }

  public static class Author {

    @Element(name = "name", required = false) String name;

    @Element(name = "id", required = false) Id id;

    public String getName() {
      return this.name;
    }

    public void setName(String value) {
      this.name = value;
    }

    public Id getId() {
      return this.id;
    }

    public void setId(Id value) {
      this.id = value;
    }
  }

  public static class Query {

    @Element(name = "#cdata-section", required = false) String cdataSection;

    public String getCdataSection() {
      return this.cdataSection;
    }

    public void setCdataSection(String value) {
      this.cdataSection = value;
    }
  }

  public static class Request {

    @Element(name = "method", required = false) Method method;

    @Element(name = "key", required = false) Key key;

    @Element(name = "authentication", required = false) String authentication;

    public Method getMethod() {
      return this.method;
    }

    public void setMethod(Method value) {
      this.method = value;
    }

    public Key getKey() {
      return this.key;
    }

    public void setKey(Key value) {
      this.key = value;
    }

    public String getAuthentication() {
      return this.authentication;
    }

    public void setAuthentication(String value) {
      this.authentication = value;
    }
  }

  public static class OriginalPublicationYear {

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class Search {

    @Element(name = "results-end", required = false) String resultsEnd;

    @Element(name = "total-results", required = false) String totalResults;

    @Element(name = "query", required = false) Query query;

    @Element(name = "source", required = false) String source;

    @Element(name = "query-time-seconds", required = false) String queryTimeSeconds;

    @ElementList(name = "results", required = false) List<Work> results;

    @Element(name = "results-start", required = false) String resultsStart;

    public String getResultsEnd() {
      return this.resultsEnd;
    }

    public void setResultsEnd(String value) {
      this.resultsEnd = value;
    }

    public String getTotalResults() {
      return this.totalResults;
    }

    public void setTotalResults(String value) {
      this.totalResults = value;
    }

    public Query getQuery() {
      return this.query;
    }

    public void setQuery(Query value) {
      this.query = value;
    }

    public String getSource() {
      return this.source;
    }

    public void setSource(String value) {
      this.source = value;
    }

    public String getQueryTimeSeconds() {
      return this.queryTimeSeconds;
    }

    public void setQueryTimeSeconds(String value) {
      this.queryTimeSeconds = value;
    }

    public List<Work> getResults() {
      return this.results;
    }

    public void setResults(List<Work> value) {
      this.results = value;
    }

    public String getResultsStart() {
      return this.resultsStart;
    }

    public void setResultsStart(String value) {
      this.resultsStart = value;
    }
  }

  public static class TextReviewsCount {

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class BestBook {

    @Element(name = "small_image_url", required = false) String smallImageUrl;

    @Element(name = "author", required = false) Author author;

    @Element(name = "image_url", required = false) String imageUrl;

    @Element(name = "id", required = false) Id id;

    @Attribute(name = "type", required = false) String type;

    @Element(name = "title", required = false) String title;

    public String getSmallImageUrl() {
      return this.smallImageUrl;
    }

    public void setSmallImageUrl(String value) {
      this.smallImageUrl = value;
    }

    public Author getAuthor() {
      return this.author;
    }

    public void setAuthor(Author value) {
      this.author = value;
    }

    public String getImageUrl() {
      return this.imageUrl;
    }

    public void setImageUrl(String value) {
      this.imageUrl = value;
    }

    public Id getId() {
      return this.id;
    }

    public void setId(Id value) {
      this.id = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }

    public String getTitle() {
      return this.title;
    }

    public void setTitle(String value) {
      this.title = value;
    }
  }

  public static class OriginalPublicationDay {

    @Attribute(name = "nil", required = false) Boolean nil;

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public Boolean getNil() {
      return this.nil;
    }

    public void setNil(Boolean value) {
      this.nil = value;
    }

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class Id {

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class RatingsCount {

    @Text(required = false) String textValue;

    @Attribute(name = "type", required = false) String type;

    public String getTextValue() {
      return this.textValue;
    }

    public void setTextValue(String value) {
      this.textValue = value;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String value) {
      this.type = value;
    }
  }

  public static class Key {

    @Element(name = "#cdata-section", required = false) String cdataSection;

    public String getCdataSection() {
      return this.cdataSection;
    }

    public void setCdataSection(String value) {
      this.cdataSection = value;
    }
  }
}