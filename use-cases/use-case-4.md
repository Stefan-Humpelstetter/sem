# USE CASE 4: Produce reports about population.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *member of the organisation* I want *to produce reports about population* so that *I can have a better overview of our data*.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population data and there is a working connection to the database.

### Success End Condition

All the population reports can be generated.

### Failed End Condition

Some or all of the population reports cannot be generated.

### Primary Actor

Organisation member.

### Trigger

A request for population information is sent to the organisation member.

## MAIN SUCCESS SCENARIO

1. A request for a population report gets sent to an organisation member
2. The organisation member runs the application and finds the correct data
3. A report is generated

## Extensions

None.

#### SUB-VARIATIONS

Reports for the following list:
1. The population of people, people living in cities, and people not living in cities in each continent.
2. The population of people, people living in cities, and people not living in cities in each region.
3. The population of people, people living in cities, and people not living in cities in each country.
4. The population of the world.
5. The population of a continent.
6. The population of a region.
7. The population of a country.
8. The population of a district.
9. The population of a city.

## SCHEDULE

**DUE DATE**: Release 1.0
