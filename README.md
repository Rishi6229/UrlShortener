🔗 URL Shortener (Spring Boot + MongoDB)

A simple and functional URL Shortener built using Spring Boot and MongoDB. Inspired by services like Bit.ly, this application takes a long URL and returns a shortened version. When a user accesses the short URL, it redirects them to the original long URL.

📂 GitHub Repository: https://github.com/Rishi6229/UrlShortener
✨ Features

    ✅ Shorten any valid long URL

    ✅ Redirect using the generated short code

    ✅ Store URLs in MongoDB

    ✅ Track number of clicks per short URL

    ✅ Graceful handling of invalid or expired URLs (404)

    ✅ Tested locally using Postman

🚀 Tech Stack

    Java 17+

    Spring Boot

    MongoDB

    Spring Data MongoDB

    REST APIs

    UUID for short URL generation

    Postman (for local testing)

📦 Getting Started
Prerequisites

    Java 17+

    Maven

    MongoDB (local or cloud instance like MongoDB Atlas)

Setup

    Clone the repository

git clone https://github.com/Rishi6229/UrlShortener.git
cd UrlShortener

Configure MongoDB in application.properties (default is localhost)

spring.data.mongodb.uri=mongodb://localhost:27017/urlshortener

Run the application

    ./mvnw spring-boot:run

    The application will start at: http://localhost:8080

📫 API Endpoints
1. Shorten a URL

    URL: POST /api/shorten

    Body (JSON):

{
  "originalUrl": "https://example.com/very/long/url"
}

Response:

    {
      "shortUrl": "http://localhost:8080/d341eb"
    }

2. Redirect via Short URL

    URL: GET /{shortCode}

    Example: http://localhost:8080/d341eb

    Redirects to original URL (302 Found)

📌 MongoDB Schema

Collection: url_mappings

Example document:

{
  "_id": "d341eb",
  "originalUrl": "https://en.wikipedia.org/wiki/List_of_the_longest_words_in_the_English_language",
  "clickCount": 0,
  "createdAt": "2025-04-15T10:35:00.397Z"
}

🛠️ Upcoming Features

    Custom short codes

    Expiry-based cleanup

    Analytics dashboard

    Docker containerization

    Swagger API documentation

    CI/CD pipeline + deployment to cloud

🤝 Contributing

Feel free to fork this repo and open PRs with improvements or new ideas!
📄 License

This project is open-source under the MIT License.
