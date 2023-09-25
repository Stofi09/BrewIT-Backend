# BrewIT Backend

BrewIT Backend is a backend service for the BrewIT web application, designed to handle order placement requests from the frontend and can be extended to handle more functionalities in the future.

## Current Features
- Receives and handles order placements from the frontend.
- Interacts with the frontend through a defined API.

## Limitations
- Currently, there is no user authentication system.
- There is no error handling for malformed requests.

## Technical Details

### Receiving Orders
The backend service receives orders from the frontend using the following API endpoint:

```java
 @PostMapping("/place-order")
public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderDTO orderDTO) {
        this.orderService.processOrder(orderDTO);
        return ResponseEntity.ok().body(Map.of("message", "Order received"));
}
```
### Receiving Orders
- JPA
- JDBC
- MySQL
## Setup and Running
### How to build
```sh
mvn clean install
```


## Future Improvements

- Implementation of user authentication and authorization.
- Enhanced error handling and logging.
- Adding further endpoints so users can register
