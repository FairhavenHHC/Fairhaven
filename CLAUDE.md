# CLAUDE.md — FairHaven HHC

This file provides guidance for AI assistants working on the FairHaven HHC codebase. Read this before making changes.

---

## Project Overview

**FairHaven HHC** is a Java-based web application for a Home Health Care services company. It provides:
- A public-facing website with service listings, FAQs, and appointment scheduling
- A location-based search for finding nearby service offices
- An admin dashboard for managing appointments
- Email notification for appointment requests and general inquiries

---

## Technology Stack

| Layer | Technology |
|---|---|
| Language | Java 1.8 |
| Web Framework | Spring MVC 4.2.4 + Spring Boot 1.3.2 |
| Security | Spring Security 4.0.3 |
| ORM | Hibernate 4.3.10 (JPA annotations) |
| Full-Text Search | Hibernate Search 5.3.0 (Lucene) |
| View Layer | JSP + Apache Tiles 3.0.5 |
| Email Templates | Apache Velocity 1.6.2 |
| Database | MySQL (via C3P0 connection pool) |
| Build Tool | Maven 3 (WAR packaging) |
| Logging | Log4j 2.5 + SLF4J |
| Testing | JUnit 4.12, Spring Test, Selenium 2.44.0 |

---

## Repository Structure

```
src/main/
├── java/com/fairhaven/
│   ├── db/
│   │   ├── dao/
│   │   │   ├── hibernate/          # Hibernate DAO implementations
│   │   │   └── interfaces/         # DAO contracts (interfaces)
│   │   └── entities/               # JPA entity classes (9 entities)
│   ├── web/
│   │   ├── config/                 # Spring configuration classes
│   │   ├── controllers/            # Spring MVC controllers
│   │   ├── converters/             # Spring type converters
│   │   ├── forms/                  # Form backing beans
│   │   ├── interceptors/           # Spring HandlerInterceptors
│   │   └── exceptions/             # Exception handlers
│   └── utils/
│       ├── encryption/             # Password hashing utilities
│       └── mail/                   # Email sending and templating
├── resources/
│   ├── application.properties      # DB, mail, and app configuration
│   ├── log4j.properties            # Logging configuration
│   ├── messages/validation/        # i18n validation messages
│   └── velocity/templates/         # Email templates (.vm files)
└── webapp/
    ├── WEB-INF/
    │   ├── web.xml                 # Servlet descriptor
    │   └── tiles-defs.xml          # Apache Tiles layout definitions
    ├── Pages/                      # JSP views
    │   └── Administration/         # Admin JSP pages
    └── Resources/                  # Static assets (CSS, JS, Images)
```

---

## Application Configuration

### Application Entry Points

- **`WebInitializer.java`** — Servlet 3.0 initializer (replaces `web.xml` bootstrapping)
- **`SecurityWebAppInitializer.java`** — Spring Security filter chain initialization
- **`ApplicationContextConfig.java`** — Root context: Hibernate, DataSource, Velocity, Mail
- **`DispatcherServletConfig.java`** — Web context: MVC, view resolvers, interceptors, converters
- **`SpringSecurityConfig.java`** — Authentication, authorization, and password encoding

### Key Configuration File: `application.properties`

Located at `src/main/resources/application.properties`. Contains all runtime configuration:

```properties
application.name=Fairhaven HHC
jdbc.url=jdbc:mysql://localhost:3306/fairhavenhhc
jdbc.username=root
jdbc.password=<password>
mail.host=mail.fairhavenhhc.com
mail.port=8025
google.api.key=<api-key>
security.password.encryption_strength=4
upload.max_upload_size=50000000
```

> **Security Note:** Credentials are currently stored in plaintext in this file. Do not commit real credentials to version control. Consider migrating to environment variables or a secrets manager.

---

## Database

### Connection

- Driver: `com.mysql.jdbc.Driver`
- Database: `fairhavenhhc` (MySQL)
- Pool: C3P0 (min: 25, max: 100 connections)
- Lucene indexes stored at: `/tmp/lucene/indexes` (not persistent across reboots)

### Entities

| Entity | Description |
|---|---|
| `Users` | Application user accounts |
| `Groups` | Authorization roles (Many-to-Many with Users) |
| `Appointment` | Patient/client appointment records |
| `Services` | Available home care services |
| `Location` | Physical office locations |
| `Contact` | Contact form submissions |
| `ContactType` | Categories for contact types |
| `Faq` | Frequently asked questions |
| `Link` | External resource links |

Additional Spring Security tables: `authorities`, `persistent_logins`.

---

## URL Routes

### Public Routes

| Method | URL | Controller | Description |
|---|---|---|---|
| GET | `/index.htm` | `IndexController` | Homepage |
| GET | `/about.htm` | `AboutController` | About page |
| GET | `/services/` | `ServicesController` | Service listing with FAQs |
| GET | `/services/{id}` | `ServicesController` | Individual service detail |
| GET | `/contact/` | `ContactController` | Contact page |
| GET | `/contact/{id}` | `ContactController` | Contact for specific location |
| POST | `/contact/zip` | `ContactController` | Search locations by zip code |
| POST | `/contact/appointment` | `ContactController` | Submit appointment request |
| POST | `/contact/` | `ContactController` | Submit general inquiry |
| GET | `/login.htm` | `LoginController` | Login page |
| POST | `/security_check` | Spring Security | Login form submission |
| GET | `/logout.htm` | Spring Security | Logout |

### Admin Routes (requires `ROLE_ADMIN`)

| Method | URL | Controller | Description |
|---|---|---|---|
| GET | `/admin/` | `AdminController` | Admin dashboard |
| GET | `/admin/appointments` | `AdminController` | Appointments list |
| GET | `/admin/appointments/delete?id={id}` | `AdminController` | Delete an appointment |

---

## Naming Conventions

Follow these conventions consistently when adding new code:

| Type | Convention | Example |
|---|---|---|
| Controllers | `*Controller` suffix | `ContactController` |
| DAO interfaces | `*DAO` suffix | `AppointmentDAO` |
| DAO implementations | `Hibernate*DAO` prefix | `HibernateAppointmentDAO` |
| Form backing beans | `*FormBackingBean` suffix | `ContactFormBackingBean` |
| Type converters | `StringTo*Converter` or `*ToStringConverter` | `StringToServicesConverter` |
| Entities | Simple PascalCase nouns | `Appointment`, `Services` |
| Packages | `com.fairhaven.{layer}.{sublayer}` | `com.fairhaven.web.controllers` |

---

## Validation Messages

Validation message keys are defined in `src/main/resources/messages/validation/`. Key patterns:

- `field.length` — Length constraint messages
- `form.message.*` — Form-level messages
- Email and phone fields use `@Pattern` with JSR-303 annotations

---

## View Layer (Tiles + JSP)

Views use **Apache Tiles** for layout composition. Layout definitions are in `WEB-INF/tiles-defs.xml`.

- JSP pages live under `webapp/Pages/`
- Admin JSPs live under `webapp/Pages/Administration/`
- Shared layout fragments live under `webapp/Resources/Layout/`
- Static resources (CSS, JS, images) live under `webapp/Resources/`

When adding a new page:
1. Create the JSP under `webapp/Pages/`
2. Add a Tiles definition in `tiles-defs.xml`
3. Add a controller method that returns the view name matching the Tiles definition

---

## Email System

Email is sent via Spring Mail with Velocity templates.

- Templates located in: `src/main/resources/velocity/templates/`
- Mail utility classes in: `com.fairhaven.utils.mail`
- Mail server configured in `application.properties`
- Two email flows: appointment requests and general inquiries

---

## Security

- Authentication: JDBC-based with `users` and `authorities` tables
- Password encoding: MD5 (strength 4) — **note: MD5 is weak; BCrypt is available but not active**
- Remember-me: Persistent token stored in `persistent_logins` table
- CSRF: Configured via Spring Security
- Role prefix: `ROLE_` (e.g., `ROLE_ADMIN`)
- Admin paths (`/admin/**`) require `ROLE_ADMIN`

> If upgrading authentication, switch from MD5 to BCrypt by changing the `passwordEncoder` bean in `SpringSecurityConfig.java`.

---

## Interceptors

Three interceptors are registered in `DispatcherServletConfig`:

| Interceptor | Purpose |
|---|---|
| `LoggingInterceptor` | Logs incoming requests and responses |
| `SessionVariablesInterceptor` | Populates common session attributes |
| `LocaleChangeInterceptor` | Handles locale/language switching |

---

## Build & Run

### Prerequisites

- Java 1.8 JDK
- Maven 3.x
- MySQL with database `fairhavenhhc` created and seeded

### Common Maven Commands

```bash
# Compile only
mvn clean compile

# Run all tests
mvn clean test

# Build WAR
mvn clean package

# Build and install to local Maven repo
mvn clean install
```

The WAR artifact is output to `target/FairHavenHHC-1.0-SNAPSHOT.war`.

### Deployment

Deploy the WAR to an Apache Tomcat 7/8/9 server's `webapps/` directory, or use Spring Boot's embedded Tomcat if configured.

### No Test Directory

There is currently **no `src/test/` directory**. Test dependencies (JUnit, Spring Test, Selenium) are declared in `pom.xml` but no tests exist yet. When adding tests, create the standard Maven test layout:

```
src/test/java/com/fairhaven/
src/test/resources/
```

---

## Known Issues & Technical Debt

1. **Outdated dependencies** — Spring 4.2, Spring Boot 1.3, Hibernate 4.3 (all EOL). Migration to Spring 6 / Spring Boot 3 requires Java 17+.
2. **Weak password hashing** — MD5 is cryptographically broken. Migrate to BCrypt.
3. **Hardcoded credentials** — Database and mail passwords are in `application.properties`. Use environment variables or a vault.
4. **No test coverage** — No unit or integration tests exist.
5. **Lucene index location** — Stored at `/tmp/lucene/indexes`; this is wiped on system restart. Change to a persistent path in production.
6. **No CI/CD pipeline** — No `Jenkinsfile`, GitHub Actions, or similar pipeline definition is present.
7. **No environment profiles** — No dev/staging/prod configuration separation (Spring Profiles not used).

---

## Development Workflow

1. Make changes on a feature branch.
2. Build with `mvn clean package` to verify compilation.
3. Deploy WAR to a local Tomcat for manual verification.
4. When adding features, follow existing layer separation (entity → DAO interface → Hibernate DAO → Controller).
5. Add validation messages to `messages/validation/` rather than hardcoding in controllers.
6. Use `@Transactional` on DAO or service methods that modify data.

---

## File Locations Quick Reference

| What | Where |
|---|---|
| DB/mail config | `src/main/resources/application.properties` |
| Spring beans (root context) | `com.fairhaven.web.config.ApplicationContextConfig` |
| Spring MVC config | `com.fairhaven.web.config.DispatcherServletConfig` |
| Security config | `com.fairhaven.web.config.SpringSecurityConfig` |
| Tiles layout definitions | `src/main/webapp/WEB-INF/tiles-defs.xml` |
| Email templates | `src/main/resources/velocity/templates/` |
| Validation messages | `src/main/resources/messages/validation/` |
| JSP views | `src/main/webapp/Pages/` |
| Static assets | `src/main/webapp/Resources/` |
