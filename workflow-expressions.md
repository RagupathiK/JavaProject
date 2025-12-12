# BPMN Workflow Expressions for Teapot

## Package: com.example.user

### Service Task Expressions:

**User Validation:**
- Expression: `#{workflowService.validateUserData('123')}`
- Returns: "VALID" or "INVALID"

**Payment Processing:**
- Expression: `#{workflowService.processPayment('99.99')}`
- Returns: "PAYMENT_SUCCESS" or "PAYMENT_FAILED"

**Send Notification:**
- Expression: `#{workflowService.sendNotification('Order confirmed')}`
- Returns: "NOTIFICATION_SENT"

**Create Order:**
- Expression: `#{orderProcessor.createOrder('PROD123')}`
- Returns: Order ID (e.g., "ORD-1234567890")

**Check Inventory:**
- Expression: `#{orderProcessor.checkInventory('PROD123')}`
- Returns: "AVAILABLE" or "OUT_OF_STOCK"

**Update Order Status:**
- Expression: `#{orderProcessor.updateStatus('ORD123', 'SHIPPED')}`
- Returns: "STATUS_UPDATED"

**User Service Methods:**
- Expression: `#{userService.processUser('1')}`
- Expression: `#{userService.validateUser('test@example.com')}`

**User Delegate:**
- Expression: `#{userDelegate.execute('test input')}`

## How to Use in Teapot BPMN:

1. **Service Task Implementation Type**: Expression
2. **Expression Field**: Copy any expression above
3. **Result Variable**: Set variable name to store return value
4. **Package Import**: com.example.user

## Test Workflow:
1. Start User Service: `mvn spring-boot:run`
2. Service runs on: http://localhost:8081
3. All expressions will log execution details
4. Check console for workflow task logs