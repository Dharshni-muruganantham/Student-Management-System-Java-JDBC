# Student Management System (Full Stack)

Spring Boot (REST API + JPA) + MySQL + HTML/JS frontend served by the same app.

## Run
1. Start MySQL: `docker compose up -d`  (or use your local MySQL; user/password default to root/root)
2. Start the app: `mvn spring-boot:run`
3. Open http://localhost:8080

Override DB settings with env vars: `DB_URL`, `DB_USER`, `DB_PASS`.

## API
| Method | URL | Purpose |
|---|---|---|
| GET | /api/students?search=&sortBy=name&dir=asc | List / search / sort |
| GET | /api/students/{id} | One student |
| POST | /api/students | Create |
| PUT | /api/students/{id} | Update |
| DELETE | /api/students/{id} | Delete |

Requires Java 17+ and Maven.
