Core PolicyInfo Service:

1) Description:

	The Policy Info Service is a standalone microservice responsible for managing policy data within the Alturion Policy Systems. It exposes REST APIs for policy creation, retrieval, and status management, acting as the central source for all policy-related information. It is designed using a layered architecture with standardized API responses and centralized exception handling to ensure maintainability and reliability.


2) Responsibilities  

	• Manage policy data and lifecycle states (creation -> active, expired, terminated)
	
	• Provide policy information to other services for validation and processing
	
	• Support aggregation use cases for dashboards
	
	• Expose paginated and sorted APIs for efficient policy retrieval

3) Tech Stack:

	• Java 17
	
	• Maven
	
	• Spring Boot
	
	• Spring Data JP
	
	• SQL
	
	• REST API
	
	• RestTemplate (inter-service communication)
	
	• Global Exception Handling
	
	• Pagination and Sorting

4) Project Structure:

	• controller → Exposes REST endpoints and handles HTTP requests/responses
	
	• service → Contains core business logic
	
	• repository → Handles database interactions using Spring Data JPA
	
	• domain → Represents JPA entities mapped to database tables
	
	• dto → Defines request and response payloads for APIs
	
	• client → Handles inter-service communication using RestTemplate
	
	• exception → Contains custom exceptions and global exception handling
	
	• config → Includes application-level configurations & interceptor
	

5) API Endpoints:

	• POST /api/policyinfo/create
	
	• GET  /api/policyinfo/{policyNumber}
	
	• GET  /api/policyinfo/policies/owner/{policyOwnerId}
	
	• PATCH  /api/policyinfo/{policyNumber}/cancel
	
	• PATCH  /api/policyinfo/{policyNumber}/renew
	
6) Configuration:

	• Environment-specific properties are managed via application.properties which includes:
	
		• Database configurations
		 
		• Service URLs for inter-service communication
