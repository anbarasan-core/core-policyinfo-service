The Policy Info Service is a standalone microservice responsible for managing policy information in Alturion Policy Systems. It provides REST APIs for policy creation, retrieval of policy details, and policy status management. This service acts as the source of truth for policy-related data and ensures that all policy information is maintained consistently within the system. It also provides endpoints that allow other services to retrieve policy data for aggregation and validation purposes. The service follows microservice architecture principles, including layered architecture, standardized API responses, and global exception handling to ensure reliability and maintainability.

The service collaborates with:

->Policy Owner Service to validate the existence of policy owners before creating or retrieving policies

->Agent Service to provide policy information required for agent dashboard aggregation and reporting operations

Responsibilities of this service includes Managing policy information,  Maintaining policy lifecycle states such as active, expired, or terminated,  Providing policy data to other services, Supporting policy aggregation and dashboard operations, Providing paginated and sorted policy retrieval APIs. Service URLs and environment configurations are managed through application.properties

Tech Stack: Java 17, Maven, Spring Boot, Spring Data JPA, SQL, REST API, RestTemplate (inter-service communication), Global Exception Handling, Pagination and Sorting.

Project Structure:

controller   → REST API endpoints

service      → business logic

repository   → database access layer

entity       → JPA entity classes

dto          → request and response models

client       → communication with other microservices

exception    → custom exceptions and global exception handling

config       → application configurations

API Endpoints:

POST  - /create
GET   - /{policyNumber}
GET   - /policies/owner/{policyOwnerId}
PATCH - /{policyNumber}/cancel
PATCH - /{policyNumber}/renew

These endpoints support policy creation, retrieval of policy details, retrieval of policies under specific owners, and aggregated policy retrieval required by the Agent Service.