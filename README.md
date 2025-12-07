# Farmer Data System API

The Climate Smart Irrigated Agriculture Project (CSIAP), in collaboration with the FAO and World Bank, aims to digitize and centralize farmer-level data to support data-driven agricultural planning and policy-making in Sri Lanka. This repository contains the Spring Boot API for the system and is configured to use PostgreSQL for data storage.

## Features

✅ **JWT-based Authentication** - Secure token-based authentication system  
✅ **PostgreSQL Database** - Robust data storage with proper relationships  
✅ **Farmer Management Module** - Complete CRUD operations for farmer data  
✅ **Data Entry Modules** - Manage equipment, home gardens, CSA agriculture, agro wells, and poultry farming  
✅ **Dashboard Summary** - Aggregated statistics and analytics  
✅ **RESTful API** - Clean and well-documented API endpoints  
✅ **Docker Support** - Easy deployment with Docker and Docker Compose  
✅ **Input Validation** - Request validation for data integrity  
✅ **Global Exception Handling** - Consistent error responses  

## Technology Stack

- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database access
- **PostgreSQL** - Database
- **JWT (jjwt 0.12.3)** - Token generation and validation
- **Lombok** - Reduce boilerplate code
- **Maven** - Build and dependency management

## Database Schema

### Tables

1. **farmer_dim** - Master table containing farmer details
   - Primary Key: `farmer_id`
   - Contains: Personal info, contact details, location, land size, experience

2. **equipment_data** - Farm equipment records
   - Foreign Key: `farmer_id` → `farmer_dim(farmer_id)`
   - Contains: Equipment details, purchase info, condition

3. **home_garden_data** - Home garden cultivation records
   - Foreign Key: `farmer_id` → `farmer_dim(farmer_id)`
   - Contains: Crop details, cultivation area, yield data

4. **csa_agriculture_data** - Climate smart agriculture data
   - Foreign Key: `farmer_id` → `farmer_dim(farmer_id)`
   - Contains: Crop info, irrigation, climate practices, costs

5. **agro_well_agriculture_data** - Agro well irrigation data
   - Foreign Key: `farmer_id` → `farmer_dim(farmer_id)`
   - Contains: Well details, pump info, water usage, costs

6. **poultry_farming_data** - Poultry farming records
   - Foreign Key: `farmer_id` → `farmer_dim(farmer_id)`
   - Contains: Bird count, production, health, revenue

7. **users** - Authentication and user management
   - Primary Key: `user_id`
   - Contains: Username, password (encrypted), email, role

## Quick Start

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+
- Docker and Docker Compose (optional)

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/Climate-Smart-Agriculture/Farmer-Data-System-Api.git
cd Farmer-Data-System-Api
```

2. **Configure the database**

Create a PostgreSQL database:
```sql
CREATE DATABASE farmerdb;
```

3. **Set environment variables**

Copy the example environment file:
```bash
cp .env.example .env
```

Edit `.env` and update the values:
```bash
DB_HOST=localhost
DB_PORT=5432
DB_NAME=farmerdb
DB_USERNAME=postgres
DB_PASSWORD=your_password
JWT_SECRET=your-secret-key-at-least-256-bits
```

4. **Build the application**
```bash
mvn clean install
```

5. **Run the application**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080/api`

### Using Docker

1. **Build and run with Docker Compose**
```bash
docker-compose up -d
```

This will start both PostgreSQL and the API service.

2. **Check logs**
```bash
docker-compose logs -f api
```

3. **Stop the services**
```bash
docker-compose down
```

## API Documentation

Comprehensive API documentation is available in [API_DOCUMENTATION.md](./API_DOCUMENTATION.md).

### Quick API Examples

#### Register a User
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123",
    "email": "admin@example.com",
    "fullName": "System Admin",
    "role": "ADMIN"
  }'
```

#### Login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'
```

#### Create a Farmer (requires JWT token)
```bash
curl -X POST http://localhost:8080/api/farmers \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "fullName": "John Silva",
    "nic": "199012345678",
    "contactNumber": "0771234567",
    "email": "john@example.com",
    "address": "123 Main Street, Colombo",
    "district": "Colombo",
    "province": "Western",
    "gnDivision": "GN-001",
    "dsDivision": "DS-001",
    "landSizeHectares": 2.5,
    "farmingExperienceYears": 10
  }'
```

#### Get Dashboard Summary
```bash
curl -X GET http://localhost:8080/api/dashboard/summary \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

## Project Structure

```
Farmer-Data-System-Api/
├── src/
│   ├── main/
│   │   ├── java/lk/csiap/farmerdatasystem/
│   │   │   ├── config/           # Configuration classes
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entity/           # JPA entities
│   │   │   ├── exception/        # Exception handling
│   │   │   ├── repository/       # Data repositories
│   │   │   ├── security/         # Security configuration
│   │   │   └── service/          # Business logic
│   │   └── resources/
│   │       └── application.yml   # Application configuration
│   └── test/                     # Test files
├── pom.xml                       # Maven dependencies
├── Dockerfile                    # Docker configuration
├── docker-compose.yml            # Docker Compose setup
├── API_DOCUMENTATION.md          # Detailed API docs
└── README.md                     # This file
```

## Security

- Passwords are encrypted using BCrypt
- JWT tokens for stateless authentication
- CORS enabled for frontend integration
- Input validation on all endpoints
- Role-based access control (ADMIN, USER, VIEWER)

**Important:** Change the JWT secret key in production!

## Development

### Running Tests
```bash
mvn test
```

### Building for Production
```bash
mvn clean package -DskipTests
java -jar target/farmer-data-system-1.0.0.jar
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

For issues and questions:
- Open an issue on GitHub
- Contact: Climate Smart Agriculture Team

## Acknowledgments

- FAO (Food and Agriculture Organization)
- World Bank
- Climate Smart Irrigated Agriculture Project (CSIAP)
- Government of Sri Lanka
