# Challenge #2: Bootiful Calculator

Bespoke Bitcoin Solutions Ltd. thank you for your work - helping them find out the lowest bitcoin prices. They have now
decided, in a bid to save money, they're going to stop buying calculators for the office and instead, they're going to
use a central web-based calculator.

## Specifications

You must write a web application with 1 endpoint: `/calculate`. This endpoint will accept
a POST request with the following body template:

```json
POST /calculate
{
  "values": [5, 1, 20],
  "operation": "add",
  "type": "integer"
}
```

field | type | description |
------|------|-------------|
values| Array\<Number\> | A list of numbers, can be whole or decimal. |
operation | String | The operation to perform, possible values are: **add**, **sub**, **mul**, **div**. |
type | String | The type of the expected result, possible values are: **integer**, **decimal**, **safe**.  |

### Types

The type field is important, it can be one of three values: **integer**, **decimal**, **safe**. Information about 
them is below:

value | description |
---   |     ---     |
integer | The values will be processed as whole numbers, any decimals passed into **values** should return an error.
decimal | The values will be processed as decimal numbers, 32-bits of precision will suffice.
safe | The values will be processed as safe decimals, you must ensure there are no floating-point precision errors when applying operations to safe decimals.

### Operations

There are 4 operations this program will support:

operation | description | example
---       | ----        | ----  
add       | Will add all the values together | `[5, 10, 2] => 17`
sub       | Will subtract all the values, starting at the left-most value, and ending at the right-most value. | `[10, 2, 2] => 6`
mul       | Will multiply all the values together. | `[5, 5, 2] => 50`
div       | Will divide all the values, starting at the left-most value, and ending at the right-most value. | `[10, 1, 2] => 5`


## Rules

You will be scored on the following criteria:

- Good use of [design patterns](https://sourcemaking.com/design_patterns).
- Unit/Integration testing.
- Code **readability**.
- Code **runnability**.

The code will be pushed to a public git repo.

### Other Rules:

- Please only submit **Java**, **Kotlin** or **Groovy** code.

- Please use **Gradle** or **Maven**, to make it easier for us to run your code.

- Feel free to use any **frameworks/libraries** you like.


Good luck!