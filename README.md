## Drones Service

## Requirements

* Java 11+
* Maven 2+ (or use maven wrapper)

## Build, Test and Run

1. `mvn clean package`
2. `mvn spring-boot:run`

NOTE: If you don't have maven installed on your computer, you can use maven wrapper. (replace above `mvn` command
with `mvnw`)

## Accessing H2 Database Console

Go to the http://localhost:9000/h2-console

## Accessing OpenAPI3 Swagger Documentation

Go to the http://localhost:9000/swagger-ui.html

1. REGISTER DRONE

    ```bash
    curl -X 'POST' \

    'http://localhost:9000/drone/api/register' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
    "serialNumber": "4587112545",
    "weightLimit": 20,
    "batteryPercentage": 42,
    "model": "LightWeight",
    "state": "IDLE"
    }'
    ```

2. GET ALL DRONES

    ```bash
            curl -X 'GET' \
          'http://localhost:9000/drone/api/getAllDrones' \
          -H 'accept: */*'
    ```

3. GET DRONE BATTERY STATUS
    ```bash
    curl -X 'GET' \
      'http://localhost:9000/drone/api/getDroneBatteryStatus/4587112545' \
      -H 'accept: */*'
    ```

4. Get Drone or Get Drone battery

    ```bash
    curl --location --request GET 'http://localhost:8080/api/drone/1'
    ```
   
5. GET MEDICATION BY DRONE ID
    ```bash
                curl -X 'GET' \
                'http://localhost:9000/drone/api/getMedicationsByDroneID/4587112545' \
                -H 'accept: */*'
    ```

6. ADD MEDICATION TO DRONE
```bash
         curl -X 'POST' \
       'http://localhost:9000/drone/api/addMedication/4587112545' \
      -H 'accept: */*' \
      -H 'Content-Type: application/json' \
       -d '[
             {
               "name": "HEAD",
               "weight": 60,
               "code": "23ed",
               "imageURL": "https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Zm9jdXN8ZW58MHx8MHx8&w=1000&q=80"
            }
           ]'
   ```

[[_TOC_]]

---

:scroll: **START**

### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**.
Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the
drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Task description

We have a fleet of **10 drones**. A drone is capable of carrying devices, other than cameras, and capable of delivering
small loads. For our use case **the load is medications**.

A **Drone** has:

- serial number (100 characters max);
- model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
- weight limit (500gr max);
- battery capacity (percentage);
- state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

Each **Medication** has:

- name (allowed only letters, numbers, ‘-‘, ‘_’);
- weight;
- code (allowed only upper case letters, underscore and numbers);
- image (picture of the medication case).

Develop a service via REST API that allows clients to communicate with the drones (i.e. **dispatch controller**). The
specific communicaiton with the drone is outside the scope of this task.

The service should allow:

- registering a drone;
- loading a drone with medication items;
- checking loaded medication items for a given drone;
- checking available drones for loading;
- check drone battery level for a given drone;

> Feel free to make assumptions for the design approach.

---

### Requirements

While implementing your solution **please take care of the following requirements**:

#### Functional requirements

- There is no need for UI;
- Prevent the drone from being loaded with more weight that it can carry;
- Prevent the drone from being in LOADING state if the battery level is **below 25%**;
- Introduce a periodic task to check drones battery levels and create history/audit event log for this.

---

#### Non-functional requirements

- Input/output data must be in JSON format;
- Your project must be buildable and runnable;
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory,
  via container);
- Required data must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time);
- Advice: Show us how you work through your commit history.

---

:scroll: **END**
