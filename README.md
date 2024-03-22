# Spring Boot JPA Application - Movie and Director Management

This Spring Boot application demonstrates a movie and director management system, utilizing the H2 in-memory database for persistence with Java Persistence API (JPA). It offers a web interface for performing Create, Read, Update, and Delete (CRUD) operations on movie and director entities.

**Link to the Video Sumbission:**
-no link yet 

## Getting Started

Before you begin, ensure you have the following installed on your system:
- **Java Development Kit (JDK) 11 or newer**: The application is developed using Java, and you'll need the JDK to compile and run it.
- **A web browser**: As the application features a web interface, you will need a modern web browser to interact with it.
- **IntelliJ IDEA**: This project was developed using IntelliJ IDEA. While the Gradle wrapper helps mitigate potential portability issues, the use of IntelliJ IDEA is recommended for ease of setup and consistency with the project's original development environment.

### Initial Setup

1. **Clone the repository**: First, clone the repository to your local machine using the following command:
git clone https://github.com/SITE-ADA/as1-spring-boot-jpa-app-nargizh7-1.git
cd as1-spring-boot-jpa-app-nargizh7-1

2. **Database setup**: No additional database setup is required. The application uses an H2 in-memory database, which is initialized automatically upon starting the application.

### Building and Running the Application

Before running the application, it's recommended to clean and build the project to ensure it's up to date:
./gradlew clean build

Once the build is successful, start the application with:
./gradlew bootRun

The application will start and be accessible at **`http://localhost:9090`**.

### Using the Application

After launching the application, navigate to http://localhost:9090 in your web browser to access the home page. This page provides navigation links to the movies and directors management sections, where you can perform various operations.

## Features

- **Home Page**: The landing page with navigation links to movies and directors management sections.
- **Movies Management**: This section allows you to add, view, update, and delete movies. You can also sort and filter the list of movies based on different criteria.
- **Directors Management**: Similar to movies, this section enables you to manage director entities with CRUD operations and offers sorting and filtering capabilities.

## Navigating the Application

- To add a new movie or director, use the 'Add New Movie' or 'Add New Director' links, fill in the form, and submit.
- The list pages for movies and directors display all entries with options to update or delete each entry. Use the corresponding buttons beside each entry to perform these actions.
- Sorting and filtering options are available above the list tables. Select your criteria and click 'Apply' to update the list accordingly.

## H2 Console

The H2 database console is accessible at `http://localhost:9090/h2`. Use the JDBC URL `jdbc:h2:mem:umsDB`, with username `sa` and no password, to connect and interact directly with the in-memory database.

