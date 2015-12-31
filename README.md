# Java Client for DB S&S Elevators and Escalators API

This projects provides a Java Client for the Escalators and Elevators API of the DB Station&Service AG, codenamed **dbeac**.

The API is published in the frame of [Aufzugs-API Contest](https://www.mindboxberlin.com/index.php/contest.html).

The original API definition file can be found here:

[SSTBT_REST-API_ADAM_1_contest_alpha.yaml](https://www.mindboxberlin.com/index.php/contest.html?file=files/cto_layout/downloads/opendata/SSTBT_REST-API_ADAM_1_contest_alpha.yaml)

## Usage

### Adding the client to your project

#### Maven

Add the following dependency to your project:

```xml
<dependency>
	<groupId>org.hisrc.dbeac</groupId>
	<artifactId>dbeac-client</artifactId>
	<version>...</version>
</dependency>
```

### Provided operations

#### List all facilities

API invocation:

[`https://adam.noncd.db.de/api/v1.0/facilities`](https://adam.noncd.db.de/api/v1.0/facilities)

Java code:

```java
List<Facility> allFacilities = api.findFacilities(null, null);
```

#### List active elevators

API invocation:

[`https://adam.noncd.db.de/api/v1.0/facilities?type=ELEVATOR&state=ACTIVE`](https://adam.noncd.db.de/api/v1.0/facilities?type=ELEVATOR&state=ACTIVE)

Java code:

```java
List<Facility> findFacilities = api.findFacilities(
	Arrays.asList(Facility.TypeEnum.ELEVATOR.toString()),
	Arrays.asList(Facility.StateEnum.ACTIVE.toString()));
```

#### Get facility by the equipment number

API invocation:

[`https://adam.noncd.db.de/api/v1.0/facilities/10110110`](https://adam.noncd.db.de/api/v1.0/facilities/10110110)

Java code:

```java
Facility facility = api.getFacilityByEquipmentNumber(10110110L);
```

#### Find station by the station number

API invocation:

[`https://adam.noncd.db.de/api/v1.0/stations/3925`](https://adam.noncd.db.de/api/v1.0/stations/3925)

Java code:

```java
Station station = api.findStationByStationNumber(3925L);
```