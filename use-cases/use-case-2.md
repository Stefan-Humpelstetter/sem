# USE CASE 2: Produce reports about cities.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *member of the organisation* I want *to produce reports about cities* so that *I can have a better overview of our data*.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains cities data and there is a working connection to the database.

### Success End Condition

All the city reports can be generated.

### Failed End Condition

Some or all of the city reports cannot be generated.

### Primary Actor

Organisation member.

### Trigger

A request for cities information is sent to the organisation member.

## MAIN SUCCESS SCENARIO

1. A request for a city report gets sent to an organisation member
2. The organisation member runs the application and finds the correct data
3. A report is generated

## Extensions

None.

#### SUB-VARIATIONS

Reports for the following list:
1. All the cities in the world organised by largest population to smallest.
2. All the cities in a continent organised by largest population to smallest.
3. All the cities in a region organised by largest population to smallest.
4. All the cities in a country organised by largest population to smallest.
5. All the cities in a district organised by largest population to smallest.
6. The top `N` populated cities in the world where `N` is provided by the user.
7. The top `N` populated cities in a continent where `N` is provided by the user.
8. The top `N` populated cities in a region where `N` is provided by the user.
9. The top `N` populated cities in a country where `N` is provided by the user.
10. The top `N` populated cities in a district where `N` is provided by the user.

## SCHEDULE

**DUE DATE**: Release 1.0
