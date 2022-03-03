# USE CASE 3: Produce reports about capital cities.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *member of the organisation* I want *to produce reports about capital cities* so that *I can have a better overview of our data*.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains capital cities data and there is a working connection to the database.

### Success End Condition

All the capital city reports can be generated.

### Failed End Condition

Some or all of the capital city reports cannot be generated.

### Primary Actor

Organisation member.

### Trigger

A request for capital cities information is sent to the organisation member.

## MAIN SUCCESS SCENARIO

1. A request for a capital city report gets sent to an organisation member
2. The organisation member runs the application and finds the correct data
3. A report is generated

## Extensions

None.

#### SUB-VARIATIONS

Reports for the following list:
1. All the capital cities in the world organised by largest population to smallest.
2. All the capital cities in a continent organised by largest population to smallest.
3. All the capital cities in a region organised by largest to smallest.
4. The top `N` populated capital cities in the world where `N` is provided by the user.
5. The top `N` populated capital cities in a continent where `N` is provided by the user.
6. The top `N` populated capital cities in a region where `N` is provided by the user.

## SCHEDULE

**DUE DATE**: Release 1.0
