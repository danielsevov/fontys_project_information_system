# Sales Officer Use Cases

## Use case 1:

#### Name: Create a flight

#### Actor: Sales Officer

#### Description: A sales officer registers an upcoming flight

#### Precondition: None

#### Scenario:

1. Actor chooses to create a new flight
2. System displays flight creation form.
3. Actor fills in departure date and time.
4. System enables fields for arrival date and time.
5. Actor fills in arrival date and time.
6. Actor picks departure and arrival airports.
7. System updates the list of available planes based on the provided data.
8. Actor picks a plane and base price for the flight.
9. Actor confirms selection.
10. System inserts the new entry into the database.

#### Result: The flight has been inserted into the database and is now visible for other users

#### Extension:

9a: Actor chooses not to create flight

1. Actor chooses to cancel flight creation.
2. System closes flight creation form.

#### Exceptions:

3a: The provided departure date and time is not within the constraints

1. System clears actor's departure date and time input. 1.1. Use case ends here.

5a: The provided arrival date and time is earlier than the departure time and date

1. System clears actor's arrival date and time input. 1.1. Use case ends here.

7a: No planes are available for that flight

1. System shows an empty list for plane selection. 1.1. Use case ends here.

8a: The inputted price is less than or equal to 0 or non-numeric

1. System clears the price field and waits for new input. 1.1. Use case ends here.

#### Test Scenarios:

1. Actor chooses to create a new flight
2. System displays flight creation form.
3. Actor fills in "05/05/2021" as departure date and "20:00" as departure time.
4. System enables fields for arrival date and time.
5. Actor fills in "05/05/2021" as arrival date and "21:00" as arrival time.
6. Actor picks "Venlo Airport" as departure and "Hamburg Airport" as arrival airport.
7. System updates the list of available planes based on the provided data.
8. Actor picks plane "XB-HCW".
9. Actor inputs "10" as base price
10. Actor confirms selection.
11. System displays message "Flight created..." and inserts the new entry into the database.

---------------------------------------------------------------------------

1. Actor chooses to create a new flight
2. System displays flight creation form.
3. Actor fills in "05/2021" as departure date and "22" as departure time.
4. System clears input as it does not match the DateTime format.
5. Actor fills in "05/05/2021" as departure date and "22:00" as departure time.
6. System enables fields for arrival date and time.
7. Actor fills in "04/05/2021" as arrival date and "23:00" as arrival time.
8. System clears input as arrival is earlier than departure.
9. Actor fills in "05/05/2021" as arrival date and "21:00" as arrival time.
10. System clears input as arrival is earlier than departure.
11. Actor fills in "05/2021" as arrival date and "23" as arrival time.
12. System clears input as it does not match the DateTime format.
13. Actor fills in "05/05/2021" as arrival date and "23:00" as arrival time.
14. Actor picks "Dubai Airport" as departure and "Dusseldorf Airport" as arrival airport.
15. System does not find any available planes at Dubai Airport.
16. Actor picks "Amsterdam Airport" as departure and "Dusseldorf Airport" as arrival airport.
17. Actor confirms selection.
18. System updates the list of available planes based on the provided data.
19. System message "Flight could not be created".
20. Actor picks plane "FF-NYC".
21. Actor confirms selection.
22. Actor sets "10" as the price
23. System message "Flight created...". System inserts the new entry into the database.

## Use case 2:

#### Name: Check flight details

#### Actor: Sales Officer

#### Description: The Actor views the details of existing flights

#### Precondition: The flight must have been registered first

#### Scenario:
1. Actor chooses to view flight details
2. System display existing flights page
3. Actor selects a flight manually
4. System displays single flight window with all details

#### Result: A flight's details have been successfully evoked

#### Exceptions: None

#### Extensions: none

#### Test Case:
1. Actor chooses to view flight details
2. System displays existing flights page
3. Actor selects the flight from Venlo Airport to Frankfurt Airport on the 20th of September 2021
4. System displays all flight details: Airplane: H3PFH2
                                       Departure Airport: Venlo airport
                                       Arrival Airport: Frankfurt airport
                                       DepartureDateTime: 20.09.2021 23:00
                                       ArrivalDateTime: 21.09.2021 04:00

## Use case 3:

#### Name: Edit flights

#### Actor: Sales Officer

#### Description: A Sales Officer edits an existing flight entry

#### Precondition: The flight entry must have been created first

#### Scenario:

1. <u>Actor checks flight details</u>
2. Actor overwrites existing information
3. Actor submits his/her changes to the System
4. System checks if all mandatory text fields have been filled out
5. System checks if the provided information is within the constraints
6. System updates the entry in the database

#### Result: The information of the flight entry has been changed

#### Exceptions:

4a: Not all mandatory info has been provided

1. System informs the user that not all mandatory info has been provided
2. System displays window with option to fill out mandatory information concerning the new entry including the already
   provided information
3. Actor completes the required information
4. Actor submits the entry to the System

5a: The provided information is not within the constraints

1. System informs the user that the provided information is violating the constraints
2. System displays window with option to fill out mandatory information concerning the new entry including the already
   provided information
3. Actor adjusts and/or changes the provided information to be within the constraints
4. Actor submits the entry to the System

#### Extensions: none

#### Test Case:

1. <u>Actor checks flight details</u>
2. Actor clicks on the edit-button under a chosen entry.
3. System displays the entry details
4. Actor changes the Airplane from H3FQ56 to F5NL98
5. Actor clicks the submit-button
6. System checks if all mandatory text fields have been filled out
8. Actor confirms his/her changes by pressing the confirm-button
9. System updates the entry in the database

## Use case 4:

#### Name: Cancel flights

#### Actor: Sales Officer

#### Description: The Actor deletes a flight entry from the database

#### Precondition: The flight entry must have been created first

#### Scenario:

1. <u>Actor checks flight details</u>
2. Actor chooses to cancel a flight
3. System displays option to cancel a flight
4. Actor submits cancellation request
5. System deletes entry from the database

#### Result: The flight entry has successfully been removed from the database

#### Exceptions: none

#### Extensions:

#### Test Case:

1. <u>Actor checks flight details</u>
2. Actor clicks the cancel-button under an entry
3. System deletes entry from the database

## Use case 5:

#### Name: Create discounts

#### Actor: Sales Officer

#### Description: The Actor creates a price discount for one or more flight-tickets

#### Precondition: The flight must have been registered first

#### Scenario:

1. <u>Actor checks flight details</u>
2. Actor chooses to create a price discount
3. System prompts the Actor to select a ticket, for which a discount shall be created
4. Actor selects a ticket
5. System displays option to enter a new price and an expiration date
6. Actor enters the new price and an expiration date for the discount
7. Actor submits his entry to the system.
8. System checks if the entry does not violate the constraints
9. System asks for confirmation
10. Actor confirms
11. System inserts entry into database

#### Result: At least one ticket is now cheaper in price than it originally was

#### Exceptions:

8a: The entered information is not within the guidelines of the constraints

1. System informs Actor that the input is invalid because it violates the constraints
2. System displays option to enter a new price and an expiration date including the already filled out info
3. Actor fixes his/her entry and submits

#### Extensions: none

#### Test Case:

1. <u>Actor checks flight details</u>
2. Actor chooses to create a price discount
3. System prompts the Actor to select a ticket, for which a discount shall be created
4. Actor selects a ticket
5. System displays option to enter a new price and an expiration date
6. Actor enters 100, 250, 650 as the new prices for each class and sets the expiration date to 29/04/2021
7. Actor submits his entry to the system.
8. System checks if the entry does not violate the constraints
9. System asks for confirmation: "Do you want to save this discount?"
10. Actor confirms
11. System inserts entry into database

## Use case 6:

#### Name: Look up an existing Airplane

#### Actor: Sales Officer

#### Description: Actor looks up an existing Airplane

#### Precondition: Airplane exists in the Database

#### Scenario:

1. Actor chooses to view Airplane details
2. System displays existing Airplanes page
3. Actor selects an Airplane manually
4. System displays single Airplane window with all details

#### Result: Airplane details have been successfully evoked

#### Exceptions: None

#### Extensions: none

#### Test Cases:
1. Actor chooses to view Airplane details
2. System displays existing Airplanes page
3. Actor selects Airplane H3FQ5S
4. System displays all Airplane details: Registration number: H3FQ5S
                                         Maximum Capacity:    120

## Use case 7:

#### Name: Edit an existing Airplane

#### Actor: Sales Officer

#### Description: Actor edits the information of an Airplane

#### Precondition: Airplane exists in the Database

#### Scenario:
1. <u>Actor looks up an existing Airplane</u>
2. Actor enters new registration number
3. System saves the entry locally
4. Actor stores the changes
5. System overwrites the old information in the database with the new one

#### Result: Airplane details have successfully been overwritten

#### Exceptions: None

#### Extensions:
3a. Actor enters new maximum Capacity
3b. System stores the entry locally

#### Test Cases:
1. Actor enters the new registration number: RS5QHF
2. System saves the entry locally
3. Actor stores the changes
4. System overwrites the old information in the database with the new one
---------------------------------------------------------------------------
1. Actor enters the new maximum capacity: 140
2. System saves the entry locally
3. Actor stores the changes
4. System overwrites the old information in the database with the new one
---------------------------------------------------------------------------
1. Actor enters the new registration number: RS5QHF
2. System saves the entry locally
3. Actor enters the new maximum capacity: 140
4. System saves the entry locally
5. Actor stores the changes
6. System overwrites the old information in the database with the new one

## Use case 8:

#### Name: Delete an existing Airplane

#### Actor: Sales Officer

#### Description: Actor deletes an Airplane

#### Precondition: Airplane exists in the Database

#### Scenario:
1. <u>Actor looks up an existing Airplane</u>
2. Actor chooses to delete the current Airplane
3. System deletes entry from the Database

#### Result: Airplane has been deleted

#### Exceptions: None

#### Extensions: none

#### Test Cases: none


## Use case 9:

#### Name: Look up an existing Airport

#### Actor: Sales Officer

#### Description: Actor looks up an existing Airport

#### Precondition: Airport exists in the Database

#### Scenario:

1. Actor chooses to view Airport details
2. System displays existing Airports page
3. Actor selects an Airport manually
4. System displays single Airport window with all details

#### Result: Airport details have been successfully evoked

#### Exceptions: None

#### Extensions: none

#### Test Cases:
1. Actor chooses to view Airport details
2. System displays existing Airports page
3. Actor selects VENLO_Airport to view the details of
4. System displays all Airport details: Airport Name: VENLO_Airport
                                        Location    : Venlo, Netherlands


## Use case 10:

#### Name: Edit an existing Airport

#### Actor: Sales Officer

#### Description: Actor edits the information of an Airport

#### Precondition: Airport exists in the Database

#### Scenario:
1. <u>Actor looks up an existing Airport</u>
2. Actor enters new Airport name
3. System saves the entry locally
4. Actor stores the changes
5. System overwrites the old information in the database with the new one

#### Result: Airport details have successfully been overwritten

#### Exceptions: None

#### Extensions: none
3a. Actor enters new Airport Location
3b. System stores the entry locally

#### Test Cases:
1. Actor enters the new Airport name: FRANKFURT_Airport
2. System saves the entry locally
3. Actor stores the changes
4. System overwrites the old information in the database with the new one
---------------------------------------------------------------------------
1. Actor enters the new Airport location: Frankfurt, Germany
2. System saves the entry locally
3. Actor stores the changes
4. System overwrites the old information in the database with the new one
---------------------------------------------------------------------------
1. Actor enters the new Airport name: FRANKFURT_Airport
2. System saves the entry locally
3. Actor enters the new Airport location: Frankfurt, Germany
4. System saves the entry locally
5. Actor stores the changes
6. System overwrites the old information in the database with the new one

## Use case 11:

#### Name: Delete an existing Airport

#### Actor: Sales Officer

#### Description: Actor deletes an Airport

#### Precondition: Airport exists in the Database

#### Scenario:
1. <u>Actor looks up an existing Airport</u>
2. Actor chooses to delete the current Airport
3. System deletes entry from the Database

#### Result: Airport has been deleted

#### Exceptions: None

#### Extensions: none

#### Test Cases: none
