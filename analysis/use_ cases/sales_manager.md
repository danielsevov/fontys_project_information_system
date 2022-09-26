# Sales Manager Use Cases

## Use case 1:

#### Name: Raise notice

#### Actor: Sales Manager

#### Description: Sales Manager raises notice after noticing an issue

#### Precondition: An issue exists (+ dashboard access)

#### Scenario:

1. Actor navigates to dashboard.
2. System lists dashboard with available options and employees.
3. Actor clicks on an employee to raise a notice.
4. System displays option to enter information about the notice.
5. Actor enters information.
6. System acknowledges act of entering information and asks for confirmation.
7. Actor confirms the act of raising a notice.
8. System informs actor about successful action.

#### Result: Sales Manager has raised a notice about an issue and informed an employee

#### Exceptions: none

#### Test input: "Flight to Dubai has no assigned seats", "Airplane 1 is in inspection"

## Use case 2:

#### Name: Check KPI of the company

#### Actor: Sales Manager

#### Description: Sales Manager reviews Key Performance Indicators of the airline company

#### Precondition: Dashboard access

### Scenario:

1. Actor navigates to dashboard.
2. System lists dashboard with available options.
3. Actor requests to view KPI.
4. System acknowledges request and loads information.
5. Actor reviews displayed information.

#### Result: Sales Manager gained access to Key Performance Indicators

#### Exceptions: none

#### Test input: none







