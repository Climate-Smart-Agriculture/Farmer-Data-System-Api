# Farmer Data System API Documentation

## Overview
This is a Spring Boot REST API for managing farmer data for the Climate Smart Irrigated Agriculture Project (CSIAP). The API uses JWT for authentication and PostgreSQL for data storage.

## Base URL
```
http://localhost:8080/api
```

## Authentication
All endpoints except `/auth/**` require a valid JWT token in the Authorization header:
```
Authorization: Bearer <your-jwt-token>
```

## API Endpoints

### 1. Authentication Endpoints

#### Register a New User
```http
POST /auth/register
Content-Type: application/json

{
  "username": "admin",
  "password": "password123",
  "email": "admin@example.com",
  "fullName": "System Administrator",
  "role": "ADMIN"
}
```

**Response:**
```json
{
  "success": true,
  "message": "User registered successfully",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "username": "admin",
    "role": "ADMIN",
    "message": "User registered successfully"
  }
}
```

#### Login
```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Login successful",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "username": "admin",
    "role": "ADMIN",
    "message": "Login successful"
  }
}
```

#### Health Check
```http
GET /auth/health
```

**Response:**
```json
{
  "success": true,
  "message": "Service is healthy",
  "data": "OK"
}
```

### 2. Farmer Management Endpoints

#### Get All Farmers
```http
GET /farmers
Authorization: Bearer <token>
```

#### Get Farmer by ID
```http
GET /farmers/{id}
Authorization: Bearer <token>
```

#### Get Farmer by NIC
```http
GET /farmers/nic/{nic}
Authorization: Bearer <token>
```

#### Create New Farmer
```http
POST /farmers
Authorization: Bearer <token>
Content-Type: application/json

{
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
}
```

#### Update Farmer
```http
PUT /farmers/{id}
Authorization: Bearer <token>
Content-Type: application/json

{
  "fullName": "John Silva Updated",
  "contactNumber": "0771234567",
  "email": "john.updated@example.com",
  "address": "456 New Street, Colombo",
  "district": "Colombo",
  "province": "Western",
  "gnDivision": "GN-001",
  "dsDivision": "DS-001",
  "landSizeHectares": 3.0,
  "farmingExperienceYears": 11
}
```

#### Delete Farmer
```http
DELETE /farmers/{id}
Authorization: Bearer <token>
```

### 3. Data Entry Endpoints

#### Equipment Data

##### Get Equipment by Farmer ID
```http
GET /data-entry/equipment/farmer/{farmerId}
Authorization: Bearer <token>
```

##### Create Equipment
```http
POST /data-entry/equipment/farmer/{farmerId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "equipmentType": "Tractor",
  "equipmentName": "John Deere 5055E",
  "brand": "John Deere",
  "model": "5055E",
  "purchaseDate": "2023-01-15T00:00:00",
  "purchasePrice": 2500000.00,
  "conditionStatus": "Good",
  "notes": "Recently serviced"
}
```

##### Update Equipment
```http
PUT /data-entry/equipment/{id}
Authorization: Bearer <token>
Content-Type: application/json
```

##### Delete Equipment
```http
DELETE /data-entry/equipment/{id}
Authorization: Bearer <token>
```

#### Home Garden Data

##### Get Home Gardens by Farmer ID
```http
GET /data-entry/home-garden/farmer/{farmerId}
Authorization: Bearer <token>
```

##### Create Home Garden
```http
POST /data-entry/home-garden/farmer/{farmerId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "cropType": "Vegetables",
  "cropVariety": "Tomato",
  "cultivationAreaSqm": 50.0,
  "plantingDate": "2024-01-01T00:00:00",
  "expectedHarvestDate": "2024-03-01T00:00:00",
  "actualHarvestDate": null,
  "yieldKg": null,
  "irrigationMethod": "Drip Irrigation",
  "fertilizerUsed": "Organic Compost",
  "pesticideUsed": "Neem Oil",
  "notes": "First planting of the season"
}
```

##### Update Home Garden
```http
PUT /data-entry/home-garden/{id}
Authorization: Bearer <token>
Content-Type: application/json
```

##### Delete Home Garden
```http
DELETE /data-entry/home-garden/{id}
Authorization: Bearer <token>
```

#### CSA Agriculture Data

##### Get CSA Agriculture by Farmer ID
```http
GET /data-entry/csa-agriculture/farmer/{farmerId}
Authorization: Bearer <token>
```

##### Create CSA Agriculture
```http
POST /data-entry/csa-agriculture/farmer/{farmerId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "cropType": "Rice",
  "cropVariety": "BG-300",
  "cultivationAreaHectares": 1.5,
  "season": "Maha",
  "plantingDate": "2024-01-15T00:00:00",
  "expectedHarvestDate": "2024-05-15T00:00:00",
  "actualHarvestDate": null,
  "yieldKg": null,
  "irrigationType": "Canal Irrigation",
  "waterSource": "Mahaweli",
  "climateSmartPractices": "System of Rice Intensification (SRI)",
  "fertilizerType": "Urea, TSP",
  "pesticideType": "Minimal pesticide use",
  "productionCost": 50000.00,
  "marketPricePerKg": 80.00,
  "notes": "Using climate smart techniques"
}
```

##### Update CSA Agriculture
```http
PUT /data-entry/csa-agriculture/{id}
Authorization: Bearer <token>
Content-Type: application/json
```

##### Delete CSA Agriculture
```http
DELETE /data-entry/csa-agriculture/{id}
Authorization: Bearer <token>
```

#### Agro Well Agriculture Data

##### Get Agro Wells by Farmer ID
```http
GET /data-entry/agro-well/farmer/{farmerId}
Authorization: Bearer <token>
```

##### Create Agro Well
```http
POST /data-entry/agro-well/farmer/{farmerId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "wellNumber": "AW-001",
  "wellDepthMeters": 15.0,
  "waterCapacityCubicMeters": 100.0,
  "pumpType": "Submersible",
  "pumpPowerHp": 5.0,
  "irrigatedAreaHectares": 0.5,
  "cropType": "Vegetables",
  "cropVariety": "Cucumber",
  "plantingDate": "2024-02-01T00:00:00",
  "expectedHarvestDate": "2024-04-01T00:00:00",
  "actualHarvestDate": null,
  "yieldKg": null,
  "waterUsageHoursPerDay": 4.0,
  "electricityCost": 2000.00,
  "maintenanceCost": 500.00,
  "notes": "Well functioning properly"
}
```

##### Update Agro Well
```http
PUT /data-entry/agro-well/{id}
Authorization: Bearer <token>
Content-Type: application/json
```

##### Delete Agro Well
```http
DELETE /data-entry/agro-well/{id}
Authorization: Bearer <token>
```

#### Poultry Farming Data

##### Get Poultry by Farmer ID
```http
GET /data-entry/poultry/farmer/{farmerId}
Authorization: Bearer <token>
```

##### Create Poultry
```http
POST /data-entry/poultry/farmer/{farmerId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "poultryType": "Layers",
  "breed": "Rhode Island Red",
  "birdCount": 100,
  "batchDate": "2024-01-01T00:00:00",
  "housingType": "Battery Cage",
  "feedingMethod": "Mixed Feed",
  "feedCostPerMonth": 25000.00,
  "eggProductionPerDay": 85,
  "meatProductionKg": 0.0,
  "mortalityCount": 2,
  "vaccinationStatus": "Up to date",
  "healthIssues": "None",
  "revenuePerMonth": 51000.00,
  "notes": "Good production rate"
}
```

##### Update Poultry
```http
PUT /data-entry/poultry/{id}
Authorization: Bearer <token>
Content-Type: application/json
```

##### Delete Poultry
```http
DELETE /data-entry/poultry/{id}
Authorization: Bearer <token>
```

### 4. Dashboard Endpoints

#### Get Dashboard Summary
```http
GET /dashboard/summary
Authorization: Bearer <token>
```

**Response:**
```json
{
  "success": true,
  "message": "Dashboard summary retrieved successfully",
  "data": {
    "totalFarmers": 150,
    "totalEquipment": 45,
    "totalHomeGardens": 200,
    "totalCsaAgriculture": 120,
    "totalAgroWells": 80,
    "totalPoultryFarms": 60,
    "totalLandArea": 375.5,
    "totalYieldKg": 125000.0
  }
}
```

## Error Responses

All errors follow this format:
```json
{
  "success": false,
  "message": "Error description",
  "data": null
}
```

Common HTTP Status Codes:
- `200 OK` - Success
- `201 Created` - Resource created successfully
- `400 Bad Request` - Invalid request
- `401 Unauthorized` - Authentication failed
- `404 Not Found` - Resource not found
- `500 Internal Server Error` - Server error

## Database Configuration

Set the following environment variables:
```bash
DB_HOST=localhost
DB_PORT=5432
DB_NAME=farmerdb
DB_USERNAME=postgres
DB_PASSWORD=postgres
JWT_SECRET=your-secret-key-at-least-256-bits
JWT_EXPIRATION=86400000
SERVER_PORT=8080
```

## Running the Application

### Using Maven
```bash
mvn spring-boot:run
```

### Using Java
```bash
java -jar target/farmer-data-system-1.0.0.jar
```

### Using Docker (requires Dockerfile)
```bash
docker build -t farmer-data-system .
docker run -p 8080:8080 farmer-data-system
```

## Database Schema

The application automatically creates the following tables:
- `users` - User authentication
- `farmer_dim` - Master farmer information
- `equipment_data` - Farmer equipment records
- `home_garden_data` - Home garden cultivation data
- `csa_agriculture_data` - Climate smart agriculture data
- `agro_well_agriculture_data` - Agro well irrigation data
- `poultry_farming_data` - Poultry farming records

All data tables are linked to `farmer_dim` via `farmer_id` foreign key.

## User Roles

- `ADMIN` - Full access to all endpoints
- `USER` - Standard access for data entry
- `VIEWER` - Read-only access

## Security Features

- JWT-based authentication
- Password encryption using BCrypt
- CORS enabled for cross-origin requests
- Stateless session management
- Input validation
- Global exception handling
