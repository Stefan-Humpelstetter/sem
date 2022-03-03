# USE CASE 15: Produce a report of all the cities in the world organised by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *member of the organisation* I want to produce reports about countries so that I can have a better overview of our data.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains countries data and there is a working connection to the database.

### Success End Condition

All the country reports can be generated.

### Failed End Condition

Some or all of the country reports cannot be generated.

### Primary Actor

Organisation member.

### Trigger

A request for countries information is sent to the organisation member.

## MAIN SUCCESS SCENARIO

1. A request for a country report gets sent to an organisation member
2. The organisation member runs the application and finds the correct data
3. A report is generated

## Extensions

None.

#### SUB-VARIATIONS

Reports for the following list:

1. All the countries in the world organised by largest population to smallest.
2. All the countries in a continent organised by largest population to smallest.
3. All the countries in a region organised by largest population to smallest.
4. The top N populated countries in the world where N is provided by the user.
5. The top N populated countries in a continent where N is provided by the user.
6. The top N populated countries in a region where N is provided by the user.

## SCHEDULE

**DUE DATE**: Release 1.0