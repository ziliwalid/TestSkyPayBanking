# Banking Service Technical Test

## Overview
A simple console-based banking system that implements core banking operations: deposit, withdraw, and print transaction statements.

## Features
- ✅ **Deposit money** with validation
- ✅ **Withdraw money** with insufficient funds checking
- ✅ **Print bank statements** in reverse chronological order
- ✅ **Exception handling** for invalid inputs
- ✅ **Transaction history** stored in memory

## Requirements Met
- Implements the exact `AccountService` interface as specified
- Uses `ArrayList` for transaction storage (no repositories)
- Uses `int` for money amounts (as requested for simplicity)
- Handles all edge cases with proper exception handling
- Console-based output via `printStatement()`

## Quick Start

### Prerequisites
- Java 8 or higher
- No external dependencies required

### Running the Application
```bash
# Compile all Java files
javac *.java

# Run the test
java BankingServiceTest
```

## Project Structure
```
├── AccountService.java    # Interface definition
├── Account.java          # Main implementation
├── Transaction.java      # Transaction data model
├── BankingServiceTest.java # Test runner
└── README.md            # This file
```

## Usage Example

```java
Account account = new Account();

// Make transactions
account.deposit(1000);   // Deposit 1000
account.deposit(2000);   // Deposit 2000  
account.withdraw(500);   // Withdraw 500

// Print statement
account.printStatement();
```

### Expected Output
```
Date || Amount || Balance
24/06/2025 || -500 || 2500
24/06/2025 || 2000 || 3000
24/06/2025 || 1000 || 1000
```

## Test Scenarios

### Acceptance Test
- ✅ Deposit 1000 → Balance: 1000
- ✅ Deposit 2000 → Balance: 3000
- ✅ Withdraw 500 → Balance: 2500
- ✅ Statement shows newest transactions first

### Error Handling
- ❌ Negative deposits rejected
- ❌ Zero amounts rejected
- ❌ Insufficient funds withdrawals rejected
- ❌ Negative withdrawals rejected

## Implementation Details

### Core Classes

**AccountService Interface**
```java
public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
```

**Account Class**
- Maintains current balance
- Stores transaction history in ArrayList
- Validates all inputs
- Prints statements in reverse chronological order

**Transaction Class**
- Immutable transaction record
- Stores date, amount, and balance after transaction

### Design Decisions

1. **Simplicity First**: Clean, straightforward implementation without over-engineering
2. **Validation**: Comprehensive input validation with clear error messages
3. **Performance**: O(1) for deposits/withdrawals, O(n) for statement printing
4. **Memory**: In-memory storage using ArrayList as specified
5. **Date Handling**: Uses `LocalDate.now()` for current timestamps

## Technical Requirements Compliance

- ✅ **Exception Handling**: All invalid inputs properly handled
- ✅ **Performance**: Efficient operations for banking scenarios
- ✅ **Testing**: Comprehensive test coverage included
- ✅ **ArrayList Usage**: No repositories, uses ArrayList as requested
- ✅ **Int for Money**: Uses int amounts as specified for simplicity
- ✅ **Simple Solution**: Follows "when in doubt, go simple" principle

## Banking Software Considerations

This implementation considers real banking requirements:
- **Immutable transaction history** - Once recorded, transactions cannot be modified
- **Balance consistency** - Balance always reflects sum of all transactions
- **Input validation** - Prevents invalid operations that could corrupt data
- **Audit trail** - Complete transaction history with timestamps
- **Error handling** - Graceful handling of edge cases

## Running Tests

The included test class validates:
- Acceptance criteria from the technical specification
- Edge cases and error conditions
- Output format compliance

Run tests with: `java BankingServiceTest`

## Notes

- Dates show current date due to `LocalDate.now()` usage
- Statement format matches specification exactly
- All monetary amounts handled as integers per requirements
- No external dependencies - pure Java implementation