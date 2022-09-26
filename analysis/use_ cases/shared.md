# Shared Use Cases
---
## Use case 1:

#### Name: Check airport status

#### Actor: Sales Manager or Sales Employee

#### Description: Actor reviews the current status of an airport

#### Precondition: Airport is affiliated with airline company

#### Scenario:

1. Actor chooses to check airport status.
2. System displays search form for an airport.
3. Actor enters name of the airport.
4. System presents information about the selected airport (e.g. number of aircraft, weather, etc.).

#### Result: Actor has gained information about the selected airport

#### Exceptions:

4. System message: "Airport not found". 4.1 Use case ends here.

#### Extensions: none.

#### Test cases:
1. Actor chooses to check airport status.
2. System displays search form for an airport.
3. Actor enters Dubai International Airport.
4. System presents information about Dubai International Airport (e.g. number of aircraft, weather, etc.).
---
1. Actor chooses to check airport status.
2. System displays search form for an airport.
3. Actor enters Maṭār Dubayy al-Duwalī.
4. System presents information about Dubai International Airport (e.g. number of aircraft, weather, etc.).
---
1. Actor chooses to check airport status.
2. System displays search form for an airport.
3. Actor enters Venlo International Airport.
4. System message: "Airport not found".
---
## Use case 2:

#### Name: Check plane status

#### Actor: Sales Manager or Sales Employee

#### Description: Actor reviews the current status of an airplane

#### Precondition: Airplane is affiliated with airline company

#### Scenario:

1. Actor chooses to check airplane status.
2. System displays search form for an airplane.
3. Actor enters name of the airplane.
4. System presents information about the airplane (e.g. number of seats, assembly year, etc.).

#### Result: Actor has gained information about the selected airplane.

#### Exceptions:

4. System message: "Airplane not found". 4.1 Use case ends here.

#### Extensions: none.

#### Test cases:
1. Actor chooses to check airplane status.
2. System displays search form for an airplane.
3. Actor enters registration of the airplane - JA8089.
4. System presents information about the JA8089 Japan Airlines Boeing 747-400 (e.g. number of seats, assembly year, etc.).
---
1. Actor chooses to check airplane status.
2. System displays search form for an airplane.
3. Actor enters registration of the airplane - XXX.
4. System message: "Airplane not found".
---
## Use case 3:

#### Name: Check customer's profile.

#### Actor: Sales Employee, Sales Manager.

#### Description: Actor checks profile of customer.

#### Precondition: Customer has previous or active bookings.

#### Scenario:

1. Actor chooses to check booking history.
2. System displays search form.
3. Actor fills in the form with the email, ID number or phone number of the customer.
4. System presents the profile of the customer with all personal information and booking history.

#### Result: Actor has checked customer's profile.

#### Exceptions:

4. System message : "No customer found". 4.1. Use case ends here.

#### Extentions : none.

#### Test cases :
1. Actor chooses to check booking history.
2. System displays search form.
3. Actor fills in the form with ivan_ivanov@gmail.com.
4. System presents the profile of Ivan Ivanov Ivanov(ivan_ivanov@gmail.com) with all personal information and booking history.
---
1. Actor chooses to check booking history.
2. System displays search form.
3. Actor fills in the form with +359889541759.
4. System presents the profile of Ivan Ivanov Ivanov(+359889541759) with all personal information and booking history.
---
1. Actor chooses to check booking history.
2. System displays search form.
3. Actor fills in the form with Ivan Ivanov Ivanov.
4. System message : "No customer found".
---
## Use case 4:

#### Name: Check flight details.

#### Actor: Sales Employee, Sales Manager, Sales Officer.

#### Description: Actor checks flight details.

#### Precondition: Flight has been created.

#### Scenario:

1. Actor chooses to check flight information.
2. System displays search form.
3. Actor fills in the form with the flight number.
4. System presents the overview of the flight with all flight information.

#### Result: Actor has checked flight details.

#### Exceptions:

4. System message : "No flight found". 4.1. Use case ends here.

#### Extentions :

5a. Link to airplane information. 5b. Link to departure airport status. 5c. Link to arrival airport status. 5d. Link to
route status.

#### Test Cases:
1. Actor chooses to check flight information.
2. System displays search form.
3. Actor fills in the form with the flight number - FR1213.
4. System presents the overview of the FR1213 flight with all flight information.
---
1. Actor chooses to check flight information.
2. System displays search form.
3. Actor fills in the form with the flight number - WH8012.
4. System presents the overview of the WH8012 flight with all flight information.
---
1. Actor chooses to check flight information.
2. System displays search form.
3. Actor fills in the form with the flight number - X1.
4. System message : "No flight found".
---
## Use case 5:

#### Name: Check route status.

#### Actor: Sales Employee, Sales Manager, Sales Officer.

#### Description: Actor checks route status.

#### Precondition: Flight has been created.

#### Scenario:

1. Actor chooses to check route status.
2. System displays search form.
3. Actor fills in the form with the route ID or airports.
4. System presents the overview of the route with all information about it.

#### Result: Actor has checked route status.

#### Exceptions:

4. System message : "No route found". 4.1. Use case ends here.

#### Extentions :

5a. Link to departure airport information. 5b. Link to arrival airport information.

#### Test cases :
1. Actor chooses to check route status.
2. System displays search form.
3. Actor fills in the form with Amsterdam,NL-Eindhoven,NL.
4. System presents the overview of the Amsterdam,NL-Eindhoven,NL route with all information about it.
---
1. Actor chooses to check route status.
2. System displays search form.
3. Actor fills in the form with Paris,FR-Marakesh,MR.
4. System presents the overview of the Paris,FR-Marakesh,MR route with all information about it.
---
1. Actor chooses to check route status.
2. System displays search form.
3. Actor fills in the form with Eindhoven,NL-Eindhoven,NL.
4. System message : "No route found".
---
