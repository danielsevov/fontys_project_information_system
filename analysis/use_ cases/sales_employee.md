# Sales Employee Use Cases
---
## Use case 1:

#### Name: Create booking

#### Actor: Sales Employee

#### Description: Sales Employee creates a booking with at least one ticket for one customer.

#### Precondition: At least one flight, customer and ticket_type exist.

#### Scenario:

1. Actor chooses to create a new booking
2. System displays booking creation form
3. Actor selects a customer, for whom to create the booking
4. Actor chooses to add new ticket(s) to the booking
5. System stores the ticket(s) in the database
6. Actor chooses to store booking
7. System closes the booking creation form

#### Result: New booking created and stored.

#### Exceptions: None

#### Extensions : 

8a. Actor chooses to add another new ticket to the booking
1. System opens ticket creation dialog
2. Actor creates a ticket
3. System stores the ticket in the database


#### Test cases:
1. Actor chooses to create a new booking
2. System displays the booking creation form
3. Actor selects "Ivan Ivanov" as owner of the booking
4. Actor chooses to add new ticket to the booking
5. System opens ticket creation dialog
6. Actor creates a ticket
7. System stores the ticket in the database
8. Actor chooses to store booking
9. System closes the booking creation window
-------------------------------------------------------
1. Actor chooses to create a new booking
2. System displays the booking creation form
3. Actor selects "Ivan Ivanov" as owner of the booking
4. Actor chooses to add new ticket(s) to the booking
5. System opens ticket creation dialog
6. Actor creates a ticket
7. System stores the ticket in the database
8. Actor chooses to add another new ticket to the booking
9. System opens ticket creation dialog
10. Actor creates a ticket
11. System stores the ticket in the database
12. Actor chooses to store booking
13. System closes the booking creation window
-------------------------------------------------------

## Use case 2:

#### Name: Create ticket

#### Actor: Sales Employee

#### Description: Sales Employee creates a ticket in the process of creating a booking.

#### Precondition: At least one flight, customer and ticket_type exist; booking creation is in process.

#### Scenario:

1. Actor chooses to add a new ticket to the booking in creation
2. System displays ticket creation form
3. Actor selects the id of the flight for which the ticket shall be created
4. System updates the list of available ticket types/classes
5. Actor selects the id of the customer for whom to create the ticket
6. Actor selects the type/class of the ticket
7. Actor chooses to store the ticket
8. System stores the ticket in the database
9. System closes the ticket creation form, navigates back to booking creation

#### Result: New ticket created and stored.

#### Exceptions:

8. Missing argument - System message "Could not create ticket!"
  8.1. Use case ends here

#### Extensions :

6a: Actor chooses to add one or more ticket options to the ticket
1. Actor selects one or more of the available ticket options
8a: System stores the booked options and ticket in the database

#### Test cases:
1. Actor chooses to add a new ticket to the booking in creation
2. System displays the ticket creation window
3. Actor chooses flight with id "1"
4. Actor selects customer Ivan Ivanov with id "1"
5. Actor selects ticket type "Business Class"
6. Actor stores ticket
7. System stores the ticket in the database
8. System closes the ticket creation window, navigates back to booking creation
-------------------------------------------------------
1. Actor chooses to add a new ticket to the booking in creation
2. System displays the ticket creation window
3. Actor chooses flight with id "1"
4. Actor selects customer Ivan Ivanov with id "1"
5. Actor selects ticket type "Business Class"
6. Actor selects "Extra leg room" ticket option
7. Actor selects "More luggage" ticket option
8. Actor stores ticket
9. System stores the booked options and ticket in the database
10. System closes the ticket creation window, navigates back to booking creation
-------------------------------------------------------
1. Actor chooses to add a new ticket to the booking in creation
2. System displays the ticket creation window
3. Actor chooses flight with id "1"
4. Actor selects customer Mark Spencer with id "2"
5. Actor stores ticket
6. System message "Could not create ticket!"
-------------------------------------------------------

## Use case 3:

#### Name: Look up an existing booking

#### Actor: Sales Employee

#### Description: Actor looks up a booking

#### Precondition: Booking has been created

#### Scenario:

1. Actor chooses to view booking details
2. System displays existing bookings page
3. Actor selects a booking manually
4. System displays single booking window with all details

#### Result: Booking details have been successfully evoked

#### Exceptions: None

#### Extensions: none

#### Test Cases:
1. Actor chooses to view booking details
2. System displays existing bookings page
3. Actor selects the booking of customer "Andre Manson"
4. System displays all booking details: [ID | Flight           | Customer   | Seat | Class  | Price]
                                        [0,  Venlo to Frankfurt, Mary Manson, 1A,    Economy, 50€  ]
                                        [1,  Venlo to Frankfurt,Andre Manson, 1A,    Economy, 50€  ]


## Use case 4:

#### Name: Delete a booking

#### Actor: Sales Employee

#### Description: Sales Employee deletes an existing booking

#### Precondition: Booking exists

#### Scenario:
1. <u>Actor looks up an existing Booking</u>
2. Actor chooses to delete the current Booking
3. System deletes entry from the Database

#### Result: The booking has been deleted

#### Exceptions: None

#### Extensions: None

#### Test Cases: None


## Use case 5:

#### Name: Register a ticket option

#### Actor: Sales Employee

#### Description: Sales Employee creates a bookable upsell for a flight.

#### Precondition: Flight is created

#### Scenario:

1. Actor chooses to register a new ticket option
2. System displays option-registration window
3. Actor gives the ticket-option a Name
4. System saves the entry locally
5. Actor sets the price for the option
6. System saves the entry locally
7. Actor registers the ticket-option
8. System checks if all fields have been filled out
9. System stores the ticket-option in the database
10. System displays message of confirmation

#### Result: A bookable ticket-option has been created

#### Exceptions:
8. Not all fields have been filled out
  8.1. System displays informative message of the error
  8.2. Use case ends here

#### Extension: None

#### Test cases:

1. Actor inputs "Extra Leg space" into the name field
2. System stores the entry in a local variable
3. Actor inputs "10" into the price field
4. System stores the entry in a local variable
5. Actor registers the ticket-option
6. System checks if the local variables are null
7. System stores the ticket-option in the database
8. System displays message: "Created ticket option Extra Leg Space price: 10€"
------------------------------------------------------------------------------
1. Actor inputs "Extra Leg space" into the name field
2. System stores the entry in a local variable
3. Actor registers the ticket-option
4. System checks if the local variables are null
5. System displays message: "Could not create ticket option!"
------------------------------------------------------------------------------
1. Actor inputs "10" into the price field
2. System stores the entry in a local variable
3. Actor registers the ticket-option
4. System checks if the local variables are null
5. System displays message: "Could not create ticket option!"

## Use case 6:

#### Name: Look up an existing ticket-option

#### Actor: Sales Employee

#### Description: Actor looks up an existing ticket-option

#### Precondition: Ticket-option has been created first

#### Scenario:

1. Actor chooses to view Ticket-option details
2. System displays existing Ticket-options page
3. Actor selects a Ticket-option manually
4. System displays single Ticket-option window with all details

#### Result: Ticket-option details have been successfully evoked

#### Exceptions: None

#### Extensions: none

#### Test Cases:
1. Actor chooses to view Ticket-option details
2. System displays existing Ticket-options page
3. Actor selects Ticket_Option "Extra_leg_room"
4. System displays single Ticket-option window with all details: Ticket Option name:  Extra_leg_room
                                                                 Ticket Option price: 10€


## Use case 7:

#### Name: Delete a ticket-option

#### Actor: Sales Employee

#### Description: Sales Employee deletes an existing ticket-option

#### Precondition: Ticket-option exists

#### Scenario:
1. <u>Actor looks up an existing Ticket-option</u>
2. Actor chooses to delete the current ticket-option
3. System deletes entry from the Database

#### Result: The ticket-option has been deleted

#### Exceptions: None

#### Extensions: None

#### Test Cases: None
