# REST version of Spring PetClinic Sample Application (spring-framework-petclinic extension)

[![Java Build Status](https://github.com/spring-petclinic/spring-petclinic-rest/actions/workflows/maven-build-master.yml/badge.svg)](https://github.com/spring-petclinic/spring-petclinic-rest/actions/workflows/maven-build-master.yml)
[![Docker Build Status](https://github.com/spring-petclinic/spring-petclinic-rest/actions/workflows/docker-build.yml/badge.svg)](https://github.com/spring-petclinic/spring-petclinic-rest/actions/workflows/docker-build.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=spring-petclinic_spring-petclinic-rest&metric=alert_status)](https://sonarcloud.io/dashboard?id=spring-petclinic_spring-petclinic-rest)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=spring-petclinic_spring-petclinic-rest&metric=coverage)](https://sonarcloud.io/dashboard?id=spring-petclinic_spring-petclinic-rest)

This backend version of the Spring Petclinic application only provides a REST API. **There is no UI**.
The [spring-petclinic-angular project](https://github.com/spring-petclinic/spring-petclinic-angular) is a Angular front-end application which consumes the REST API.

## Understanding the Spring Petclinic application with a few diagrams

[See the presentation of the Spring Petclinic Framework version](http://fr.slideshare.net/AntoineRey/spring-framework-petclinic-sample-application)

### Petclinic ER Model

![alt petclinic-ermodel](petclinic-ermodel.png)

## Running Petclinic locally

### With Maven command line

```sh
git clone https://github.com/spring-petclinic/spring-petclinic-rest.git
cd spring-petclinic-rest
./mvnw spring-boot:run
```

### With Docker

```sh
docker run -p 9966:9966 springcommunity/spring-petclinic-rest
```

You can then access petclinic here: [http://localhost:9966/petclinic/](http://localhost:9966/petclinic/)

There is an actuator health check route as well:

- [http://localhost:9966/petclinic/actuator/health](http://localhost:9966/petclinic/actuator/health)

## OpenAPI REST API Documentation

This project provides a RESTful API for managing a veterinary clinic's **owners, pets, veterinarians, visits, and specialties**.

### **Access Swagger UI**

Swagger UI is available at: [http://localhost:9966/petclinic/swagger-ui.html](http://localhost:9966/petclinic/swagger-ui.html).

API documentation (OAS 3.1) is accessible at: [http://localhost:9966/petclinic/v3/api-docs](http://localhost:9966/petclinic/v3/api-docs).

## API Endpoints Overview

| **Method**      | **Endpoint**                                | **Description**                  |
| --------------- | ------------------------------------------- | -------------------------------- |
| **Owners**      |                                             |                                  |
| **GET**         | `/api/owners`                               | Retrieve all pet owners          |
| **GET**         | `/api/owners/{ownerId}`                     | Get a pet owner by ID            |
| **POST**        | `/api/owners`                               | Add a new pet owner              |
| **PUT**         | `/api/owners/{ownerId}`                     | Update an owner's details        |
| **DELETE**      | `/api/owners/{ownerId}`                     | Delete an owner                  |
| **GET**         | `/api/owners/{ownerId}/pets/{petId}`        | Get a pet by ID (owner's pet)    |
| **PUT**         | `/api/owners/{ownerId}/pets/{petId}`        | Update pet details (owner's pet) |
| **POST**        | `/api/owners/{ownerId}/pets`                | Add a new pet to an owner        |
| **POST**        | `/api/owners/{ownerId}/pets/{petId}/visits` | Add a vet visit for a pet        |
| **Pets**        |                                             |                                  |
| **GET**         | `/api/pets`                                 | Retrieve all pets                |
| **GET**         | `/api/pets/{petId}`                         | Get a pet by ID                  |
| **PUT**         | `/api/pets/{petId}`                         | Update pet details               |
| **DELETE**      | `/api/pets/{petId}`                         | Delete a pet                     |
| **Vets**        |                                             |                                  |
| **GET**         | `/api/vets`                                 | Retrieve all veterinarians       |
| **GET**         | `/api/vets/{vetId}`                         | Get a vet by ID                  |
| **POST**        | `/api/vets`                                 | Add a new vet                    |
| **PUT**         | `/api/vets/{vetId}`                         | Update vet details               |
| **DELETE**      | `/api/vets/{vetId}`                         | Delete a vet                     |
| **Pet Types**   |                                             |                                  |
| **GET**         | `/api/pettypes`                             | Retrieve all pet types           |
| **GET**         | `/api/pettypes/{petTypeId}`                 | Get a pet type by ID             |
| **POST**        | `/api/pettypes`                             | Add a new pet type               |
| **PUT**         | `/api/pettypes/{petTypeId}`                 | Update pet type details          |
| **DELETE**      | `/api/pettypes/{petTypeId}`                 | Delete a pet type                |
| **Specialties** |                                             |                                  |
| **GET**         | `/api/specialties`                          | Retrieve all vet specialties     |
| **GET**         | `/api/specialties/{specialtyId}`            | Get a specialty by ID            |
| **POST**        | `/api/specialties`                          | Add a new specialty              |
| **PUT**         | `/api/specialties/{specialtyId}`            | Update a specialty               |
| **DELETE**      | `/api/specialties/{specialtyId}`            | Delete a specialty               |
| **Visits**      |                                             |                                  |
| **GET**         | `/api/visits`                               | Retrieve all vet visits          |
| **GET**         | `/api/visits/{visitId}`                     | Get a visit by ID                |
| **POST**        | `/api/visits`                               | Add a new visit                  |
| **PUT**         | `/api/visits/{visitId}`                     | Update a visit                   |
| **DELETE**      | `/api/visits/{visitId}`                     | Delete a visit                   |
| **Users**       |                                             |                                  |
| **POST**        | `/api/users`                                | Create a new user                |

## Screenshot of the Angular client

See its repository here: https://github.com/spring-petclinic/spring-petclinic-angular

<img width="1427" alt="spring-petclinic-angular2" src="https://cloud.githubusercontent.com/assets/838318/23263243/f4509c4a-f9dd-11e6-951b-69d0ef72d8bd.png">

## In case you find a bug/suggested improvement for Spring Petclinic

Our issue tracker is available here: https://github.com/spring-petclinic/spring-petclinic-rest/issues

## Database configuration

By default, Petclinic uses an **in-memory H2 database**, which is automatically populated with sample data at startup.

### **Supported Databases**

Petclinic supports the following databases:

- **H2 (Default, In-Memory)**
- **HSQLDB (Alternative In-Memory Option)**
- **MySQL (Persistent)**
- **PostgreSQL (Persistent)**

### **Switching Databases**

You can change the database by updating the `spring.profiles.active` property in `application.properties`:

| Database                           | Profile Configuration                             |
| ---------------------------------- | ------------------------------------------------- |
| **H2** (Default)                   | `spring.profiles.active=h2,spring-data-jpa`       |
| **HSQLDB** (Alternative In-Memory) | `spring.profiles.active=hsqldb,spring-data-jpa`   |
| **MySQL** (Persistent)             | `spring.profiles.active=mysql,spring-data-jpa`    |
| **PostgreSQL** (Persistent)        | `spring.profiles.active=postgres,spring-data-jpa` |

For more details, see the [Spring Boot documentation](https://docs.spring.io/spring-boot/how-to/properties-and-configuration.html#howto.properties-and-configuration.set-active-spring-profiles).

### **Using H2 (Default)**

- No additional setup is required.
- The database schema and sample data are loaded automatically from `src/main/resources/db/h2/`.
- You can access the **H2 Console** to inspect the database.

### **Accessing the H2 Console**

1. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
2. **Open H2 Console in your browser:**
   - **URL**: http://localhost:9966/petclinic/h2-console
   - **JDBC URL**: `jdbc:h2:mem:petclinic`
   - **Username**: `sa`
   - **Password**: _(leave blank)_

### **Using HSQLDB**

- HSQLDB works similarly to H2 as an **in-memory database**.
- No additional setup is required - schema and sample data are loaded automatically from `src/main/resources/db/hsqldb/`.
- Swtich to **HSQLDB** by modifying `application.properties`:

  ```properties
  spring.profiles.active=hsqldb,spring-data-jpa
  ```

### **Using MySQL**

Modify `application.properties`:

```properties
spring.profiles.active=mysql,spring-data-jpa
```

Start a MySQL database using Docker:

```bash
docker run -e MYSQL_USER=petclinic -e MYSQL_PASSWORD=petclinic -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:8.4
```

### **Using PostgreSQL**

Modify application.properties:

```properties
spring.profiles.active=postgres,spring-data-jpa
```

Start a PostgreSQL database using Docker:

```bash
docker run -e POSTGRES_USER=petclinic -e POSTGRES_PASSWORD=petclinic -e POSTGRES_DB=petclinic -p 5432:5432 postgres:16.3
```

Instead of manually running containers, you can also use `docker-compose.yml`:

```sh
docker-compose --profile mysql up
docker-compose --profile postgres up
```

### **Further Documentation**

- [HSQLDB](http://hsqldb.org/doc/2.0/guide/index.html)
- [MySQL](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/resources/db/mysql/petclinic_db_setup_mysql.txt)
- [PostgreSQL](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/resources/db/postgres/petclinic_db_setup_postgres.txt)

## API First Approach

This API is built following some [API First approach principles](https://swagger.io/resources/articles/adopting-an-api-first-approach/).

It is specified through the [OpenAPI](https://oai.github.io/Documentation/).
It is specified in this [file](./src/main/resources/openapi.yml).

Some of the required classes are generated during the build time.
Here are the generated file types:

- DTOs
- API template interfaces specifying methods to override in the controllers

To see how to get them generated you can read the next chapter.

## Generated code

Some of the required classes are generated during the build time using maven or any IDE (e.g., IntelliJ Idea or Eclipse).

All of these classes are generated into the `target/generated-sources` folder.

Here is a list of the generated packages and the corresponding tooling:

| Package name                                   | Tool                                                                                 |
| ---------------------------------------------- | ------------------------------------------------------------------------------------ |
| org.springframework.samples.petclinic.mapper   | [MapStruct](https://mapstruct.org/)                                                  |
| org.springframework.samples.petclinic.rest.dto | [OpenAPI Generator maven plugin](https://github.com/OpenAPITools/openapi-generator/) |

To get both, you have to run the following command:

```jshelllanguage
mvn clean install
```

## Security configuration

In its default configuration, Petclinic doesn't have authentication and authorization enabled.

### Basic Authentication

In order to use the basic authentication functionality, turn in on from the `application.properties` file

```properties
petclinic.security.enable=true
```

This will secure all APIs and in order to access them, basic authentication is required.
Apart from authentication, APIs also require authorization. This is done via roles that a user can have.
The existing roles are listed below with the corresponding permissions

- `OWNER_ADMIN` -> `OwnerController`, `PetController`, `PetTypeController` (`getAllPetTypes` and `getPetType`), `VisitController`
- `VET_ADMIN` -> `PetTypeController`, `SpecialityController`, `VetController`
- `ADMIN` -> `UserController`

There is an existing user with the username `admin` and password `admin` that has access to all APIs.
In order to add a new user, please make `POST /api/users` request with the following payload:

```json
{
  "username": "secondAdmin",
  "password": "password",
  "enabled": true,
  "roles": [{ "name": "OWNER_ADMIN" }]
}
```

## Working with Petclinic in Eclipse/STS

### prerequisites

The following items should be installed in your system:

- Maven 3 (https://maven.apache.org/install.html)
- git command line tool (https://help.github.com/articles/set-up-git)
- Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/

- Eclipse with the [mapstruct plugin](https://mapstruct.org/documentation/ide-support/) installed.

### Steps:

1. In the command line

```sh
git clone https://github.com/spring-petclinic/spring-petclinic-rest.git
```

2. Inside Eclipse

```
File -> Import -> Maven -> Existing Maven project
```

## Looking for something in particular?

| Layer                | Source                                                                                                                                       |
| -------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| REST API controllers | [REST folder](src/main/java/org/springframework/samples/petclinic/rest)                                                                      |
| Service              | [ClinicServiceImpl.java](src/main/java/org/springframework/samples/petclinic/service/ClinicServiceImpl.java)                                 |
| JDBC                 | [jdbc folder](src/main/java/org/springframework/samples/petclinic/repository/jdbc)                                                           |
| JPA                  | [jpa folder](src/main/java/org/springframework/samples/petclinic/repository/jpa)                                                             |
| Spring Data JPA      | [springdatajpa folder](src/main/java/org/springframework/samples/petclinic/repository/springdatajpa)                                         |
| Tests                | [AbstractClinicServiceTests.java](src/test/java/org/springframework/samples/petclinic/service/clinicService/AbstractClinicServiceTests.java) |

## Publishing a Docker image

This application uses [Google Jib](https://github.com/GoogleContainerTools/jib) to build an optimized Docker image into the [Docker Hub](https://cloud.docker.com/u/springcommunity/repository/docker/springcommunity/spring-petclinic-rest/) repository.
The [pom.xml](pom.xml) has been configured to publish the image with name: `springcommunity/spring-petclinic-rest`

Command line to run:

```sh
mvn compile jib:build -X -DjibSerialize=true -Djib.to.auth.username=xxx -Djib.to.auth.password=xxxxx
```

## Performance Testing

To benchmark the scalability of the PetClinic REST API, a JMeter test plan is available.

- See the [JMeter Performance Test](src/test/jmeter/README.md) for details.
- Run the test using:
  ```sh
  jmeter -n -t src/test/jmeter/petclinic-jmeter-crud-benchmark.jmx \
  -Jthreads=100 -Jduration=600 -Jops=2000 -Jramp_time=120 \
  -l results/petclinic-test-results.jtl
  ```

## API Testing with Postman + Newman

This project contains **non-regression tests** for the Petclinic API, built with **Postman** and executed via **Newman**, with automated **HTML reports** for easy analysis.

- See the [Postman + Newman Test](src/test/postman/README.md) for details.
- You can run the tests with 2 ways:
  I. Giving Execution Permission to the script file:
  `sh
chmod +x postman-tests.sh
./postman-tests.sh
`
  II. Without Permission to the script file:
  `sh
zsh postman-tests.sh
`
  > Note: You can use your currently bash installed. Like: "bash postman-tests.sh"

## Contract Testing with [Specmatic](https://specmatic.io)

This project uses [Specmatic](https://specmatic.io) v2.50.0 with JUnit 5 to contract-test the running API against `src/main/resources/openapi.yml`.

### Running Contract Tests

1. Start the app: `./mvnw spring-boot:run "-Dspring-boot.run.profiles=h2,spring-data-jpa"` (Windows: `mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=h2,spring-data-jpa"`)
2. In a separate terminal, run: `./mvnw test -Dtest=ContractTest` (Windows: `.\mvnw.cmd test -Dtest=ContractTest`)

`ContractTest.java` implements Specmatic's `SpecmaticContractTest` JUnit 5 interface, which reads `specmatic.yaml`, loads the OpenAPI spec, and tests `http://localhost:9966/petclinic/api` directly over HTTP.

### Results

**221 scenarios, 214 passing, 7 failing (~97%)**, measured on a clean DB immediately after startup.
**221 scenarios, 215 passing, 6 failing (~97%)**, measured on a clean DB immediately after startup.

Issues found and fixed:
- Overly-tight `maximum` constraints on response `id` fields
- Status code mismatches (e.g. `POST /visits` returned 201 but was documented as 200)
- Missing `required` fields on `User` (password/roles/enabled)
- Missing `petId` in the `POST /visits` request schema, causing every generated request to fail (fixed via a new request-only `VisitCreate` schema + mapper + controller change)
- A dictionary key mismatch (`Owner`/`Vet` vs the actual schema names `OwnerFields`/`VetFields`) meant generated test data used random strings instead of the intended realistic values; fixing the key names resolved this and, in the process, surfaced and fixed the `POST /visits` status code issue above.
- Declared an `ETag` response header in the spec for several GET operations, but the app never implemented it. Added Spring's built-in `ShallowEtagHeaderFilter` (one new config class, no controller changes) to genuinely support conditional GET/304 responses.

### Remaining 6 failures: root cause

The 6 positive DELETE scenarios (owner, pet type, pet, visit, specialty, vet) all fail for the same reason: their ID parameters have no `minimum`/`maximum` bounds in the spec (unlike sibling GET/PUT operations), so Specmatic generates a random ID that almost never matches a real seeded row, and the app correctly returns 404 instead of the expected 200.

**This isn't a simple schema fix.** Adding proper ID bounds does make Specmatic pick a valid ID - but `ContractTest` runs against a live, already-running app over plain HTTP with no per-scenario DB reset. Once a DELETE actually succeeds, it permanently removes real seed data, which cascades into 20+ unrelated failures later in the same run. This was confirmed across five separate attempts (schema bounds alone; schema bounds plus a named example; dedicated throwaway seed rows; 404 examples for the coverage gap; and a dictionary override for the ID) - every attempt reproduced the same cascade. A related, independent bug also surfaced: `deleteOwner` returns `200` with an empty body, but the spec declares a full `Owner` response schema.

We also investigated the other main source of skipped coverage - the 304 (Not Modified) and 500 (Server Error) responses required for most operations. We fixed the underlying `ETag`/304 support itself (see above), but writing a working 304 example hit the same DB-reset limitation, since the ETag value changes whenever seed data is mutated elsewhere in the run. For 500, the app's existing validation (see `ExceptionControllerAdvice`) correctly converts malformed input into 4xx responses, so a genuine, reproducible 500 could not be triggered without deliberately breaking the app.

Fixing the DELETE/coverage gap properly requires **test isolation** (resetting the DB between scenarios), which is a test-infrastructure change outside this pass's scope. Tracked as follow-up work.

### Examples Validation

`specmatic examples validate` found **23 of 27 example files invalid**:
- **~17 files**: response declared with no body, but the spec expects a full JSON object (same root cause as the DELETE examples above)
- **5 files** (`post_specialty`, `post_vet`, `put_pettype`, `put_specialty`, `put_vet`, `put_visit`): don't match any operation in the current spec, likely stale
- **1 file** (`post_owner`): missing the required `pets` property

Tracked as follow-up work.

### API Coverage

**37% coverage** (7/18 paths, 7/36 operations, 7/159 responses), with 93 scenarios skipped - almost all `T00002: Examples Required` for non-200 codes (304/404/500) that have no example wired up.

Attempted to close this by adding 404 examples for all six `getXById` operations (after correcting several stale `maximum` bounds that didn't match actual seed-data counts). All six examples validated correctly but **failed at runtime** - by the time each ran, an earlier POST scenario had already created a row at that exact 'absent' ID. Same root cause as above: no reliable way to guarantee an ID is absent without a DB reset between scenarios. Changes reverted; repo remains at the clean 221/214/7 baseline.

### Other Notes

- External examples: `src/main/resources/openapi_examples/`
- HTML report: `build/reports/specmatic/test/html/index.html`
- CI: runs via `.github/workflows/specmatic.yml`
- Dictionary: `src/main/resources/openapi_dictionary.yaml` provides realistic values (names, phone numbers, cities) for generated test data instead of random strings
- Docker Compose: run `docker compose --profile specmatic run --rm specmatic` to validate all examples in one command, no local Specmatic install needed

## Interesting Spring Petclinic forks

The Spring Petclinic master branch in the main [spring-projects](https://github.com/spring-projects/spring-petclinic)
GitHub org is the "canonical" implementation, currently based on Spring Boot and Thymeleaf.

This [spring-petclinic-rest](https://github.com/spring-petclinic/spring-petclinic-rest/) project is one of the [several forks](https://spring-petclinic.github.io/docs/forks.html)
hosted in a special GitHub org: [spring-petclinic](https://github.com/spring-petclinic).
If you have a special interest in a different technology stack
that could be used to implement the Pet Clinic then please join the community there.

# Contributing

The [issue tracker](https://github.com/spring-petclinic/spring-petclinic-rest/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

For pull requests, editor preferences are available in the [editor config](https://github.com/spring-petclinic/spring-petclinic-rest/blob/master/.editorconfig) for easy use in common text editors. Read more and download plugins at <http://editorconfig.org>.
