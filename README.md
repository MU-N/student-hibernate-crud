# Hibernate Student Management Example

This project is a simple Java application demonstrating basic CRUD (Create, Read, Update, Delete) operations using Hibernate ORM with a PostgreSQL database. It manages `Student` entities and provides a clear example of how to set up and use Hibernate in a Java SE environment.

## Features
- Add new students to the database
- Retrieve students by ID
- Update student information
- Delete students by ID
- Uses Hibernate ORM for database operations
- PostgreSQL as the database backend

## Requirements
- Java 17 or later (project uses Java 24 in `pom.xml`)
- Maven 3.x
- PostgreSQL database

## Setup Instructions
1. **Clone the repository**
   ```bash
   git clone [<repository-url>](https://github.com/MU-N/student-hibernate-crud)
   cd student-hibernate-crud
   ```
2. **Configure the Database**
   - Ensure PostgreSQL is running and a database named `demo` exists.
   - Update the credentials in `src/main/resources/hibernate.cfg.xml` if needed:
     - `hibernate.connection.url`
     - `hibernate.connection.username`
     - `hibernate.connection.password`

3. **Build the Project**
   ```bash
   mvn clean package
   ```

4. **Run the Application**
   ```bash
   mvn exec:java -Dexec.mainClass="org.nasser.Main"
   ```
   Or run the compiled class directly:
   ```bash
   java -cp target/hibernate-1.0-SNAPSHOT.jar org.nasser.Main
   ```

## Project Structure
- `org.nasser.Main` - Application entry point
- `org.nasser.Student` - Entity class mapped to the database
- `org.nasser.StudentDAO` - Data access object for CRUD operations
- `src/main/resources/hibernate.cfg.xml` - Hibernate configuration file

## Configuration
The Hibernate configuration file (`hibernate.cfg.xml`) includes database connection settings and Hibernate properties. Example:
```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/demo</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">0000</property>
```

## Dependencies
- Hibernate Core 7.0.1.Final
- PostgreSQL JDBC Driver 42.7.7

Dependencies are managed via Maven (`pom.xml`).

## Notes
- The application uses `hibernate.hbm2ddl.auto=update` to automatically update the database schema.
- SQL logging is enabled for debugging purposes.


This project is for educational purposes. 
